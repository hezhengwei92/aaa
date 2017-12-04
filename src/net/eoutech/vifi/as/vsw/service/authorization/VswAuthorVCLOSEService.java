package net.eoutech.vifi.as.vsw.service.authorization;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.vo.VaViFiAction;
import net.eoutech.vifi.as.service.VaAuthorizationService;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqVCLOSE;
import net.eoutech.vifi.as.vsw.msg.resp.VswMsgRespVCLOSE;

/**
 * Created by SUU on 2016/5/24.
 */
public class VswAuthorVCLOSEService extends VaAuthorizationService< VswMsgReqVCLOSE, VswMsgRespVCLOSE > {

    public VswAuthorVCLOSEService( VaMsgReq req, VaMsgResp resp ) {
        super( req, resp );
    }

    @Override
    public int doAuthorization() {

        action = new VaViFiAction( req );
        this.sid = req.getSessid();

        action.setSessionId( sid );

        session = sessionService.getSessionBySID( sid );

        vifiDevice = session != null ? session.getVifiDevice() : null;
        vid = vifiDevice != null ? vifiDevice.getVid() : VaConst.Common.EMPTY;
        uid = vid != null ? cardStatusService.selectByVifiId(vid).getIdxUserId() : VaConst.Common.EMPTY;

        action.setVid( vid );
        action.setUid( uid );

        sessionService.closeSession( req.getSessid(), !sessionService.checkSession( session ,cardStatusService.selectByVifiId(vid).getStatus() ) );

        //修改设备最后在线信息
        vifiDeviceService.updateDeviceLastOnlineInfo( vid, null, null );


        return 0;
    }

}
