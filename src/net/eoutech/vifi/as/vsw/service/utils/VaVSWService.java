package net.eoutech.vifi.as.vsw.service.utils;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.dao.TbVSWDao;
import net.eoutech.vifi.as.commons.entity.TbVSW;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.vsw.vo.VaVSW;
import org.apache.commons.lang.StringUtils;

/**
 * Created by SUU on 2016/5/27.
 */
public class VaVSWService {

    public static VaVSWService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaVSWService.class );
    }

    @MyQuery( qryType = MyQuery.QUERY, qryClass = TbVSWDao.class )
    public VaVSW queryVSWByHostName ( String hostname, Object...daos ) {
        TbVSWDao dao = ( TbVSWDao ) daos[0];
        if ( StringUtils.isEmpty( hostname ) ) {
            return null;
        }
        TbVSW tbVSW = dao.selectByHostName( hostname );
        if ( tbVSW == null ) {
            return null;
        }

        return new VaVSW( tbVSW );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbVSWDao.class )
    public int updateVSWREG ( String keyVswID, String ip, int port, String state, int expire, Object...daos ) {
        TbVSWDao dao = ( TbVSWDao ) daos[0];
        return dao.updateVSWREG( keyVswID, ip, port, state, expire );
    }

    @MyQuery( qryClass = TbVSWDao.class )
    public VaVSW getVSWServerById ( String vswId, Object...daos ) {
        TbVSWDao dao = ( TbVSWDao ) daos[0];
        if ( StringUtils.isEmpty( vswId ) ) {
            return null;
        }
        TbVSW tbVSW = dao.selectByPrimaryKey( vswId );
        if ( tbVSW == null ) {
            return null;
        }
        return new VaVSW( tbVSW );
    }

}
