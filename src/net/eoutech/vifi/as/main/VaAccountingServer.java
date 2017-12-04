package net.eoutech.vifi.as.main;


import net.eoutech.vifi.as.commons.base.*;
import net.eoutech.vifi.as.commons.utils.CommonUtils;
import net.eoutech.vifi.as.commons.utils.ConfigUtils;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.ctrl.VaAccountingCtrl;
import net.eoutech.vifi.as.ctrl.VaAuthenticationCtrl;
import net.eoutech.vifi.as.ctrl.VaAuthorizationCtrl;
import net.eoutech.vifi.as.ctrl.VaStatisticCtrl;
import net.eoutech.vifi.as.service.VaService;

/**
 * Created by SUU on 2016/5/19.
 */
public class VaAccountingServer {
    //
    private static VaAccountingServer instance = null;

    private VaAccountingServer() {
    }

    public static VaAccountingServer getInstance() {
        if (instance == null) {
            instance = new VaAccountingServer();
        }
        return instance;
    }

    private ConfigUtils configUtils = ConfigUtils.getInstance();
    private VaMsgQueue msgQueue = VaMsgQueue.getInstance();
    private VaAuthenticationCtrl authenCtrl = new VaAuthenticationCtrl();//认证
    private VaAuthorizationCtrl authorCtrl = new VaAuthorizationCtrl();//授权计费
    private VaAccountingCtrl accountCtrl = new VaAccountingCtrl();//记账
    private VaStatisticCtrl statistic = new VaStatisticCtrl();//统计
//    private VaService service = new VaService();

    private boolean aDone = false;
    private int exitCode = 1;
    private int recvWaitTime = 100; //ms

    private String vifiUTIP = "0.0.0.0";
    private int vifiUPPort = 5080;


    public int init() {
        vifiUTIP = configUtils.getCfgStr("server.addr");
        vifiUPPort = configUtils.getCfgInt("server.port");

        return msgQueue.init(vifiUPPort);
    }

    public void exit(int exitCode) {
        this.exitCode = exitCode;
        aDone = true;
    }

    public int getExitCode() {
        return exitCode;
    }
//    public void destrory() {
//        msgQueue.stop();
//        LogUtils.dbg( "Server destroy success" );
//    }

    public VaMsgResp run(String message) {

        LogUtils.dbg("enter message handle loop ....");
//        while (!aDone) {
        int tid = 0;
        try {
            Long beginTime = System.currentTimeMillis();
            VaMsgReq req = msgQueue.recvMsg(message);
            if (req == null || !req.checkReqData()) {
//                    continue;
            }
            //  req.setReqBeginTime(beginTime);
            VaMsgResp resp = msgQueue.createResp(req);
            // 清除结果集
            VaService.clean();
            //认证
//                authenCtrl.doHandle(req, resp);
            //授权   设备上线 卡池上卡
            authorCtrl.doHandle(req, resp);
            //记账
//                accountCtrl.doHandle(req, resp);
            Long endTime = System.currentTimeMillis();
            resp.setRespEndTime(endTime);
            //统计
//                statistic.doHandle(req, resp);
//                int sendRes = msgQueue.sendMsg( req.getTID(), VaService.pushUserId, resp );
//                LogUtils.info( "RespMsg({0}):{1}|tid:{4}|sendMsgRes:{3};==>time cost:{2}", req.getMsgType().toString(), resp.toJSONString().toString(), System.currentTimeMillis() - beginTime, sendRes, req.getTID() );
            return resp;
        } catch (Exception e) {
            CommonUtils.sleep(500);
            LogUtils.error(CommonUtils.myExceptionString(e));
            e.printStackTrace();
//                msgQueue.sendErrorMsg(tid);
            return null;
        }
//        }
    }
}
