package net.eoutech.vifi.as.ctrl;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.service.VaUserService;
import net.eoutech.vifi.as.commons.vo.VaCount;
import net.eoutech.vifi.as.commons.vo.VaViFiAction;
import net.eoutech.vifi.as.service.VaStatisticService;

/**
 * Created by SUU on 2016/5/24.
 */
public class VaStatisticCtrl extends VaCtrl {

    /**
     * TODO count、action
     * 1.设备每日用量统计
     * 2.用户每日用量统计
     * 3.action
     *
     * @param req
     * @param resp
     * @return
     */
    @Override
    public int doHandle(VaMsgReq req, VaMsgResp resp) {

        VaStatisticService service = serviceFactory.createStatisticService(req, resp);
        if (service != null) {

            myInfo("do viFi device action");
            service.doViFiAction();

            myInfo("do viFi count");
            service.doViFiCount();

        }

        return 0;
    }
}
