package net.eoutech.vifi.as.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mybatis 自动管理Service  ,sql 方法的 Dao 创建, session 的管理
 * Created by Administrator on 2015/8/22.
 */
@Retention( RetentionPolicy.RUNTIME ) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target( {ElementType.FIELD, ElementType.METHOD, ElementType.TYPE} )
public @interface MyQuery {
    int QUERY = 1;
    int MODIFY = 2;

    int qryType() default QUERY; // 标示是查询还是修改类型,  (更新类型会开启事务)

    Class[] qryClass();// 根据class 获得 实体dao,到方法中使用.

}
