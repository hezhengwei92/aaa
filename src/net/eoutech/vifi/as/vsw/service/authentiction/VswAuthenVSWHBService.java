package net.eoutech.vifi.as.vsw.service.authentiction;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;
import net.eoutech.vifi.as.commons.utils.DateUtils;
import net.eoutech.vifi.as.service.VaAuthenticationService;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqVSWHB;
import net.eoutech.vifi.as.vsw.msg.resp.VswMsgRespVSWHB;
import net.eoutech.vifi.as.vsw.service.utils.VaVSWService;
import net.eoutech.vifi.as.vsw.vo.VaVSW;

/**
 * Created by SUU on 2016/5/24.
 */
public class VswAuthenVSWHBService extends VaAuthenticationService< VswMsgReqVSWHB, VswMsgRespVSWHB > {

    public VswAuthenVSWHBService( VaMsgReq req, VaMsgResp resp ) {
        super( req, resp );
    }
    //认证   查询 数据库中是否已有 这个 用户
    @Override
    public int doAuthentication() {

        vswServer = vswService.queryVSWByHostName( req.getVswname() );
        if ( vswServer == null ) {
            myInfo( "not found vsw server.vswname:{0}", req.getVswname() );
            return this.resp.setSipCode( SipCodeEunm.SIP_404_NOT_FOUND );
        }

        if ( !VaConst.Tables.TBVSW_STATE_ONLINE.equals( vswServer.getState() ) || DateUtils.isTimeout( vswServer.getExpire(), VaConst.Expire.TIMEOUT_DELAY, vswServer.getLastUpdate() ) || !vswServer.getIp().equals( req.getVswip() )) {
            myInfo( "check vsw server pass." );
        }

        return 0;
    }


}
