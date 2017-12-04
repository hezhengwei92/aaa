package net.eoutech.vifi.as.ctrl;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.service.VaAccountingService;

/**
 * Created by SUU on 2016/5/23.
 */
public class VaAccountingCtrl extends VaCtrl {

    @Override
    public int doHandle(VaMsgReq req, VaMsgResp resp) {
        int accRes = 0;
        //创建service
        VaAccountingService service = serviceFactory.createAccService(req, resp);

        //执行service
        if (service != null) {
            accRes = service.doAccounting();
        }

        return accRes;
    }

}
