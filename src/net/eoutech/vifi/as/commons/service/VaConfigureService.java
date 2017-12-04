package net.eoutech.vifi.as.commons.service;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbConfigureDao;
import net.eoutech.vifi.as.commons.entity.TbConfigure;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.vns.msg.resp.UUWiFiLogCfg;

/**
 * Created by SUU on 2016/7/20.
 */
public class VaConfigureService {

    public static VaConfigureService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaConfigureService.class );
    }

    @MyQuery( qryClass = TbConfigureDao.class )
    public UUWiFiLogCfg getUUWiFiLogCfg ( int log_idt, String logId, Object...daos ) {
        TbConfigureDao dao = ( TbConfigureDao ) daos[0];
        UUWiFiLogCfg logCfg = VaConst.Configure.UUWIFI_LOG_CONFIGURE;
        if ( logCfg == null ) {
            TbConfigure tbConfigure = dao.selectByName( VaConst.Configure.UUWIFI_LOG_IP );
            if ( tbConfigure == null ) {
                return null;
            }
            String uuwifiLogIP = tbConfigure.getValue();

            tbConfigure = dao.selectByName( VaConst.Configure.UUWIFI_LOG_PORT );
            if ( tbConfigure == null ) {
                return null;
            }

            Integer uuwifiLogPort = Integer.parseInt( tbConfigure.getValue() );

            logCfg = new UUWiFiLogCfg( uuwifiLogIP, uuwifiLogPort, VaConst.Configure.UUWIFI_LOG_PRO );

            VaConst.Configure.UUWIFI_LOG_CONFIGURE = logCfg;
        }
        logCfg.setLog( log_idt );
        logCfg.setLog_id( logId );
        return logCfg;
    }

}
