package net.eoutech.vifi.as.commons.service;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbRateDao;
import net.eoutech.vifi.as.commons.entity.TbRate;
import net.eoutech.vifi.as.commons.utils.CommonUtils;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.commons.vo.VaRate;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SUU on 2016/6/21.
 */
public class VaRateService {

    public static VaRateService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaRateService.class );
    }

    @MyQuery( qryClass = TbRateDao.class )
    public VaRate getRateByAreaId ( String idxUUWiFiAreaId, String agentId, Object...daos ) {
        TbRateDao dao = ( TbRateDao ) daos[0];

        List< String > areaIdList = CommonUtils.domainStringFormat( idxUUWiFiAreaId );
        if ( areaIdList == null ) {
            if ( VaConst.Common.UUWIFI_FIRST_AREAID.equals( idxUUWiFiAreaId ) ) {
                areaIdList = new ArrayList< String >();
            } else {
                return null;
            }
        }
        areaIdList.add( VaConst.Common.UUWIFI_FIRST_AREAID );

        Map< String, Object > params = new HashMap< String, Object >();
        params.put( "areaIdList", areaIdList );
        params.put( "agentId", agentId );

        TbRate tbRate = dao.queryDataRate( params );
        if ( tbRate == null ) {
            return null;
        }
        return new VaRate( tbRate, null );
    }

    @MyQuery( qryClass = TbRateDao.class )
    public VaRate getRateByCalleeNumber ( String calleeNumber, String agentId, String callType, Object...daos ) {
        TbRateDao dao = ( TbRateDao ) daos[0];
        String phonePrefix[] = CommonUtils.getPhonePrefixs( calleeNumber );
        if ( phonePrefix == null ) {
            return null;
        }
        Map< String, Object > params = new HashMap< String, Object >();
        params.put( "array", phonePrefix );
        params.put( "agentId", agentId );
        TbRate tbRate = dao.queryCallRate( params );
        if ( tbRate == null ) {
            return null;
        }
        return new VaRate( tbRate, callType );
    }

    @MyQuery( qryClass = TbRateDao.class )
    public VaRate getRateById ( int rateId, String callType, Object...daos ) {
        TbRateDao dao = ( TbRateDao ) daos[0];
        TbRate tbRate = dao.selectByPrimaryKey( rateId );
        if ( tbRate == null ) {
            return null;
        }
        return new VaRate( tbRate, callType );
    }

}
