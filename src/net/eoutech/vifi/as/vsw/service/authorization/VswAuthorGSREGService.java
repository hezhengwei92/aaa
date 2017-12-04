package net.eoutech.vifi.as.vsw.service.authorization;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;
import net.eoutech.vifi.as.service.VaAuthorizationService;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqGSREG;
import net.eoutech.vifi.as.vsw.msg.resp.VswMsgRespGSREG;

/**
 * Created by SUU on 2016/5/24.
 */
public class VswAuthorGSREGService extends VaAuthorizationService< VswMsgReqGSREG, VswMsgRespGSREG > {

    public VswAuthorGSREGService( VaMsgReq req, VaMsgResp resp ) {
        super( req, resp );
    }
    //授权计费
    @Override
    public int doAuthorization() {
//        if ( VaConst.Request.GSREG_TYPE_SIMP.equals( "S") ) {
            /**
             * 0 卡池正常
             * 1 卡池故障 或是需要重置卡池
             */
            if(req.getStatus().equals(1)){
                //重置卡池 移除卡槽上的sim卡
                simPDeviceService.resetSimPDevice(req.getUsername() );
            }else if(req.getStatus().equals(0)){
                //添加卡池 并做批量卡槽添加
                int simPDeviceRegRes = simPDeviceService.doSimPDeviceSIPReg( req.getUsername(), req.getIp(), req.getPort(), req.getStatus(), 180 , req.getPorts(),req.getServeIp(),req.getServePort());
                simPPortService.newupdateSimPPortBatch (req.getUsername(),req.getPorts(),req.getStatus() );
            }


        return 0;
    }

}
