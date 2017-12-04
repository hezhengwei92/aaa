package net.eoutech.vifi.as.commons.base;

import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.eoutech.vifi.as.commons.enums.VaMsgType;
import net.eoutech.vifi.as.commons.utils.CommonUtils;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.vns.msg.req.VnsMsgReqGET;
import net.eoutech.vifi.as.vsw.msg.req.*;

public class VaReqMsgFactory {
    private static VaReqMsgFactory instance;

    private VaReqMsgFactory() {
    } //EMPTY

    public static VaReqMsgFactory getInstance() {
        if ( instance == null ) {
            instance = new VaReqMsgFactory();
        }
        return instance;
    }


    public VaMsgReq creator( String jsonmsg) {
        VaMsgReq msgReq = null;
        VaMsgType vaMsgType = parseMsgType( jsonmsg );
       // String dataJSON = CommonUtils.getDataStr( jsonmsg );
        try {
            switch ( vaMsgType ) {
                // VSW= GSREG, VOPEN, VUPDATE, VCLOSE , SPUBLISH,
                case GSREG:
                    msgReq = JSON.parseObject( jsonmsg, VswMsgReqGSREG.class );
                    LogUtils.info("---------"+msgReq.toString());
                    break;
                case VOPEN:
                    msgReq = JSON.parseObject( jsonmsg, VswMsgReqVOPEN.class );
                    break;
                case VUPDATE:
                    msgReq = JSON.parseObject( jsonmsg, VswMsgReqVUPDATE.class );
                    break;
                case VCLOSE:
                    msgReq = JSON.parseObject( jsonmsg, VswMsgReqVCLOSE.class );
                    break;
                case SPUBLISH:
                    msgReq = JSON.parseObject( jsonmsg, VswMsgReqSPUBLISH.class );
                    break;
                case VSWHB :
                    msgReq = JSON.parseObject( jsonmsg, VswMsgReqVSWHB.class );
                    break;
                case GET:
                    msgReq = JSON.parseObject( jsonmsg,VnsMsgReqGET.class );
                    break;
                default:
            }

        } catch(Exception e) {
            LogUtils.error( "JSON parse exception:" + CommonUtils.myExceptionString( e ) );
            return null;
        }

        if ( msgReq == null ) {
            LogUtils.warn( "RecvMsg(NOSUPPORT):" +" // "+ jsonmsg );
        } else {
            LogUtils.info( "RecvMsg({0}):sc={2},sr={3},reqData={1}",
                    vaMsgType.toString(), jsonmsg, msgReq.getSc(), msgReq.getSr() );
          //  msgReq.setTID( CommonUtils.getDataInt( jsonmsg, "TID" ) );
          // msgReq.setFIP( String.valueOf( CommonUtils.getFIPStr( jsonmsg ) ) );
        }
        return msgReq;
    }

    public VaMsgType parseMsgType( String jsonmsg ) {
        String msgType = CommonUtils.getStrData( jsonmsg, "msg" );
        VaMsgType vaType = VaMsgType.msgValueOf( msgType );
        if (vaType == VaMsgType.UNKNOWN) {
            LogUtils.error(" bad msg({0}) ",jsonmsg);
        }
        return vaType;
    }
}
