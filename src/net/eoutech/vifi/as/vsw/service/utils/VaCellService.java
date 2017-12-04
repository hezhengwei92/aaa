package net.eoutech.vifi.as.vsw.service.utils;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbChinaCityDao;
import net.eoutech.vifi.as.commons.dao.TbISPDao;
import net.eoutech.vifi.as.commons.dao.TbUUWiFiAreaDao;
import net.eoutech.vifi.as.commons.entity.TbISP;
import net.eoutech.vifi.as.commons.entity.TbUUWiFiArea;
import net.eoutech.vifi.as.commons.utils.EuIPUtils;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by SUU on 2016/6/21.
 */
public class VaCellService {

    public static VaCellService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaCellService.class );
    }

    @MyQuery( qryClass = TbISPDao.class )
    public TbISP getAreaCodeByMCC ( int mcc, Object...daos ) {
        TbISPDao dao = ( TbISPDao ) daos[0];
        TbISP tbISP = dao.selectByMCC( mcc );
        return tbISP;
    }

    @MyQuery( qryClass = TbChinaCityDao.class )
    public String getAreaIdByName ( String name, Object...daos ) {
        TbChinaCityDao dao = ( TbChinaCityDao ) daos[0];

        if ( StringUtils.isEmpty( name ) ) {
            return VaConst.Common.UUWIFI_AREAID_PREFIX;
        }

        String areaId = dao.selectByRegionCity( name );
        if ( StringUtils.isEmpty( areaId ) ) {
            areaId = dao.selectByRegion( name );
        }
        return StringUtils.isEmpty( areaId ) ? VaConst.Common.UUWIFI_AREAID_PREFIX : VaConst.Common.UUWIFI_AREAID_PREFIX + VaConst.Symbol.POINT + areaId;
    }

    @MyQuery( qryClass = { TbUUWiFiAreaDao.class } )
    public TbUUWiFiArea getAreaByMcc ( int mcc, Object...daos ) {
        TbUUWiFiAreaDao dao = ( TbUUWiFiAreaDao ) daos[0];
        return dao.selectByMcc( mcc );
    }

    public String getAreaIdByMcc ( int mcc, String ip, Object...daos ) {
        String areaId = "";
        // 根据基站信息,判断是否为国内基站

//        TbISP tbISP = getAreaCodeByMCC( mcc );
//        if ( tbISP == null || StringUtils.isEmpty( tbISP.getAreaCode() ) ) {
//            return null;
//        }
//        areaId = tbISP.getIdxUUWiFiAreaId();

        TbUUWiFiArea tbUUWiFiArea = getAreaByMcc( mcc );
        if ( tbUUWiFiArea == null ) {
            return null;
        }
        areaId = tbUUWiFiArea.getKeyAreaId();

        if ( VaConst.Common.COUNTRY_CODE_CHINA.equals( tbUUWiFiArea.getIdxCode() ) ) { // 国内
            String areaName = EuIPUtils.getInstance().getName( ip );
            // 根据地区名获取areaId
            areaId = getAreaIdByName( areaName );
        }
        return areaId;
    }

}
