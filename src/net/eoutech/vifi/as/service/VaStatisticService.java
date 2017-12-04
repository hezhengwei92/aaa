package net.eoutech.vifi.as.service;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.service.VaActionService;
import net.eoutech.vifi.as.commons.service.VaCountService;

/**
 * Created by SUU on 2016/6/1.
 */
public class VaStatisticService extends VaService {

    private VaMsgReq req;
    private VaMsgResp resp;

    private VaActionService actionService = VaActionService.getInstance();
    private VaCountService countService = VaCountService.getInstance();

    public VaStatisticService(VaMsgReq req, VaMsgResp resp) {
        this.req = req;
        this.resp = resp;
    }

    public int doViFiAction() {

        if (action != null) {
            action.setRespCode(resp.getSc());
            action.setRespReason(resp.getSr());
            Long handTime = resp.getRespEndTime() - req.getReqBeginTime();
            action.setHandTime(handTime.intValue());
            if (action.getReqAct().equals("VCLOSE") && action.getRespCode() == 200) {
                cardStatusService.updateCardStatus(action.getVid());
            }

            int doViFiActionRes = actionService.doViFiActionRecord(action);
            myInfo("do vifi action res:{0}", doViFiActionRes);
        } else {
            myInfo("{0},action is null", req.getMsgType().toString());
        }

        return 0;
    }

    public int doViFiCount() {

        if (count != null) {
            int doUserCountDailyRes = countService.doUserCountDaily(count);
            int doViFiCountDailyRes = countService.doDeviceCountDaily(count);
            myInfo("do count:userRes:{0},device:{1}", doUserCountDailyRes, doViFiCountDailyRes);
        } else {
            myInfo("{0},count is null", req.getMsgType().toString());
        }

        return 0;
    }

    public VaMsgReq getReq() {
        return req;
    }

    public void setReq(VaMsgReq req) {
        this.req = req;
    }

    public VaMsgResp getResp() {
        return resp;
    }

    public void setResp(VaMsgResp resp) {
        this.resp = resp;
    }

}
