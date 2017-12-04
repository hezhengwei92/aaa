package net.eoutech.vifi.as.vsw.service.authorization;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.service.VaAuthorizationService;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqVSWHB;
import net.eoutech.vifi.as.vsw.msg.resp.VswMsgRespVSWHB;
import net.eoutech.vifi.as.vsw.service.utils.VaVSWService;
import net.eoutech.vifi.as.vsw.vo.VaVSW;

/**
 * Created by SUU on 2016/5/24.
 */
public class VswAuthorVSWHBService extends VaAuthorizationService< VswMsgReqVSWHB, VswMsgRespVSWHB > {

    public VswAuthorVSWHBService( VaMsgReq req, VaMsgResp resp ) {
        super( req, resp );
    }

    @Override
    public int doAuthorization() {

        //update
        String state = req.getExpires() > 0 ? VaConst.Tables.TBVSW_STATE_ONLINE : VaConst.Tables.TBVSW_STATE_OFFLINE;
        int updateRes = vswService.updateVSWREG( vswServer.getId(), req.getVswip(), req.getVswport(), state, req.getExpires() );

        myInfo( "vsw reg update res:{0}", updateRes );

        return 0;
    }

}
