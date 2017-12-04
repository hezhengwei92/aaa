package net.eoutech.vifi.as.vsw.service.utils;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbGoIPDevDao;
import net.eoutech.vifi.as.commons.dao.TbSimPDevDao;
import net.eoutech.vifi.as.commons.entity.TbGoIPDev;
import net.eoutech.vifi.as.commons.entity.TbSimPDev;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.vsw.vo.VaGoIPDevice;
import org.apache.commons.lang.StringUtils;

/**
 * Created by SUU on 2016/5/27.
 */
public class VaGoIPDeviceService {

    public static VaGoIPDeviceService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaGoIPDeviceService.class );
    }

    @MyQuery( qryClass = TbGoIPDevDao.class )
    public VaGoIPDevice getGoIPDeviceById ( String id, Object...daos ) {
        TbGoIPDevDao dao = ( TbGoIPDevDao ) daos[0];
        if ( StringUtils.isEmpty( id ) ) {
            return null;
        }
        TbGoIPDev tbGoIPDev = dao.selectByPrimaryKey( id );
        if ( tbGoIPDev == null ) {
            return null;
        }
        return new VaGoIPDevice( tbGoIPDev );
    }

    @MyQuery( qryClass = TbGoIPDevDao.class )
    public VaGoIPDevice getGoIPDeviceByUserName ( String userName, Object...daos ) {
        TbGoIPDevDao dao = ( TbGoIPDevDao ) daos[0];
        TbGoIPDev tbGoIPDev = dao.selectByUserName( userName );
        if ( tbGoIPDev == null ) {
            return null;
        }
        return new VaGoIPDevice( tbGoIPDev );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbGoIPDevDao.class )
    public int doGoIPDeviceReg ( String goIPDeviceId, String ip, int port, int status, int expire, Object...daos ) {
        TbGoIPDevDao dao = ( TbGoIPDevDao ) daos[0];
        return dao.updateGoIPReg( goIPDeviceId, ip, port, status, expire );
    }

}
