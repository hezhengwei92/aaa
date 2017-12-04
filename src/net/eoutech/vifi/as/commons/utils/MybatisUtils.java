package net.eoutech.vifi.as.commons.utils;


import com.mysql.jdbc.SQLError;
import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;

//Mybatis
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //创建SqlSessionFactory
            Reader reader = Resources.getResourceAsReader( "mybatis-config.xml" );
            sqlSessionFactory = new SqlSessionFactoryBuilder().build( reader );
            reader.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Session
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static SqlSession getSqlSession( boolean way ) {
        return sqlSessionFactory.openSession( way );
    }

    public static < T > T sqlProxyInstance( Class< T > targetCls ) {
        return new CglibProxy().getInstance( targetCls );
    }


    public static boolean testConnection() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        if ( sqlSession == null ) {
            return false;
        }

        if ( sqlSession.getConnection() == null ) {
            LogUtils.dbg( SQLError.SQL_STATE_CONNECTION_FAILURE );
            sqlSession.close();
            return false;
        }
        sqlSession.close();
        return true;
    }


}


/**
 * 自动管理,mybatis 的SqlSession 打开关闭.事务管理,映射dao
 * MyQuery 注解标注: 被代理的方法最后一个参数需是:Object... daos
 * 例:
 *
 * @MyQuery( qryClass = {UserDao.class} )
 * public void queryUser( VaMsg msg, Object... daos ){
 * UserDao userDao = (UserDao)daos[0];
 * }
 * Created by leijianjun 2015-8-22 15:57:48
 */
class CglibProxy implements MethodInterceptor {

    /**
     * 创建代理对象方法
     *
     * @param targetCls 代理对象的class
     * @param <T>       <泛型方法>
     * @return 返回跟代理对象类型
     */
    public < T > T getInstance( Class< T > targetCls ) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass( targetCls );
        enhancer.setCallback( this );
        return ( T ) enhancer.create();
    }
           /* 通过代理类调用父类（委托类）中的方法
            * obj: 父类   args:父类中方法的参数集
            * method：父类的方法
            * result：父类方法的返回值
            * proxy:代理类
            */

    @Override
    public Object intercept( Object object, Method method, Object[] parems, MethodProxy methodProxy ) throws Throwable {
        MyQuery queryType = method.getAnnotation( MyQuery.class );

        if ( queryType == null ) {
            return methodProxy.invokeSuper( object, parems );
        } else { // sql 查询方法
            SqlSession session = MybatisUtils.getSqlSession();
            Object result = null;
            try {
                Class[] daoClas = queryType.qryClass(); // 从注解里获得要映射dao 的class,用于 mybatis 映射 取得dao
                // dao 参数处理
                Object[] paramDaos = new Object[daoClas.length];
                for ( int i = 0; i < daoClas.length; i++ ) {
                    paramDaos[i] = session.getMapper( daoClas[i] );
                }
                parems[parems.length - 1] = paramDaos;// 放入方法参数,方便方法直接从参数拿到
                result = methodProxy.invokeSuper( object, parems );
                // 更新类型提交
                if ( queryType.qryType() == MyQuery.MODIFY ) {
                    session.commit();
                }
            } catch ( Exception e ) {
                session.rollback(); // 出现异常回滚
                LogUtils.error( CommonUtils.myExceptionString( e ) );
                throw e;
            } finally {
                session.close();
            }
            return result;
        }
    }
}
