package net.eoutech.vifi.as.main;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.base.VaReqMsgFactory;
import net.eoutech.vifi.as.commons.base.VaRespMsgFactory;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.nettyserver.Server;
import net.eoutech.vifi.as.commons.utils.ConfigUtils;
import net.eoutech.vifi.as.commons.utils.EuList;
import net.eoutech.vifi.as.commons.utils.LogUtils;

/**
 * Created by SUU on 2016/5/24.
 */
public class VaMsgQueue {

    private VaReqMsgFactory reqMsgFactory = VaReqMsgFactory.getInstance();
    private VaRespMsgFactory respMsgFactory = VaRespMsgFactory.getInstance();

    private ConfigUtils configUtils = ConfigUtils.getInstance();
    private static EuList holdMsgList = new EuList();
    private static long lastCheckTime = System.currentTimeMillis();
    private int holdRespExpire;
    private int timeout;


    private static VaMsgQueue instance = null;

    private VaMsgQueue() {
        holdRespExpire = configUtils.getCfgInt("server.holdResp.expire");
        timeout = configUtils.getCfgInt("server.holdResp.timeout");
    }

    public static VaMsgQueue getInstance() {
        if (instance == null) {
            instance = new VaMsgQueue();
        }
        return instance;
    }

    public int init(int port) {
        int initRes = Server.createServer(port);
        return initRes;
    }

    public VaMsgReq recvMsg(String message) {

        if (message.length() < 10) {
            if (message.length() > 0) VaConst.Common.nBad++;
            return null;
        }
        LogUtils.dbg("//RecvMsg:" + message);
        //得到了对应的请求对象
        VaMsgReq req = reqMsgFactory.creator(message);
        return req;
    }

    public VaMsgResp createResp(VaMsgReq req) {
        VaMsgResp resp = respMsgFactory.creator(req);

        return resp;
    }

    /*public int sendMsg( int tid, String uid, VaMsgResp resp ) {
        long nowTime = System.currentTimeMillis();
        int sendRes = -1;
        if ( resp.getSc() >= 0 ) {
            sendRes = viFiUT.sendRespMsg( tid, 200, resp.toJSONString().toString() );
        } else {
            LogUtils.info( "call_APP hold on..." );
            holdMsgList.put( uid, new VaHoldResp( tid, nowTime, resp ) );
        }

        return sendRes;
    }

    public int sendErrorMsg( int tid ) {
        int sendRes = viFiUT.sendRespMsg( tid, 200, "{\"code\":500,\"sc\":500,\"rc\":\"Unknown Error\"}" );
        return sendRes;
    }

    public void stop() {
        viFiUT.destroyServer();
        viFiUT = null;
    }*/

}
