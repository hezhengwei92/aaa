package net.eoutech.vifi.as.commons.base;

import net.eoutech.vifi.as.vns.msg.resp.VnsMsgRespGET;
import net.eoutech.vifi.as.vsw.msg.resp.*;

public class VaRespMsgFactory
{
    private static VaRespMsgFactory instance;

    private VaRespMsgFactory() {
    } //EMPTY

    public static VaRespMsgFactory getInstance() {
        if ( instance == null ) {
            instance = new VaRespMsgFactory();
        }
        return instance;
    }

    public VaMsgResp creator( VaMsgReq req) {
        VaMsgResp msgResp = null;
        switch ( req.getMsgType() ) {
            // VSW= GSREG, VOPEN, VUPDATE, VCLOSE , SPUBLISH,
            //对应的请求 返回 对应的内容
            case GSREG:
                msgResp = new VswMsgRespGSREG(req);
                break;
            case VOPEN:
                msgResp = new VswMsgRespVOPEN(req);
                break;
            case VUPDATE:
                msgResp = new VswMsgRespVUPDATE(req);
                break;
            case VCLOSE:
                msgResp = new VswMsgRespVCLOSE(req);
                break;
            case SPUBLISH:
                msgResp = new VswMsgRespSPUBLISH(req);
                break;
            case VSWHB :
                msgResp = new VswMsgRespVSWHB(req);
                break;
            ///////////////////////////////////////////////
            case GET :
                msgResp = new VnsMsgRespGET(req);
                break;
            default:
        }
        return msgResp;
    }

}
