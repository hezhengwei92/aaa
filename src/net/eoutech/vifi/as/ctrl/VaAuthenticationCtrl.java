package net.eoutech.vifi.as.ctrl;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.service.VaAuthenticationService;

/**
 * Created by SUU on 2016/5/23.
 */
public class VaAuthenticationCtrl extends VaCtrl {

    @Override
    public int doHandle(VaMsgReq req, VaMsgResp resp) {
        int res = 0;
        VaAuthenticationService service = serviceFactory.createAuthenService(req, resp);
        if (service != null) {
            //执行VswAuthenGSREGService  中的doAuthentication()
            res = service.doAuthentication();
        }
        return res;
    }

}
