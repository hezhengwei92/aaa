package net.eoutech.vifi.as.ctrl;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.enums.AsCodeEnum;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;
import net.eoutech.vifi.as.service.VaAuthorizationService;

/**
 * Created by SUU on 2016/5/23.
 */
public class VaAuthorizationCtrl extends VaCtrl {

    @Override
    public int doHandle(VaMsgReq req, VaMsgResp resp) {
        int res = 0;
        //检查resp是否合法
        // if ( resp.getSc() != SipCodeEunm.SIP_200_OK.code && resp.getSc() != AsCodeEnum.AS_SUCCESS.code ) {
        //   myInfo( "authorization fail" );
        //} else {
        VaAuthorizationService service = serviceFactory.createAuthorService(req, resp);
        if (service != null) {

            res = service.doAuthorizationService();
            //  }
        }

        return res;
    }

}
