package net.eoutech.vifi.as.vsw.msg.resp;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqSPUBLISH;

public class VswMsgRespSPUBLISH extends VswMsgRespBase {

    private Integer tid;

    public VswMsgRespSPUBLISH( VaMsgReq req ) {
        super( req );
        this.setDid( 0 );
        this.setProto( ( ( VswMsgReqSPUBLISH ) req ).getProto() );
        this.setCseq( ( ( VswMsgReqSPUBLISH ) req ).getCseq() );
        this.tid = ( ( VswMsgReqSPUBLISH ) req ).getTid();
    }

    public void setTid( Integer tid ) {
        this.tid = tid;
    }

    public Integer getTid() {
        return tid;
    }

    public StringBuilder toJSONString() {
        StringBuilder json = super.toJSONString();
        json = new StringBuilder( json.substring( 0, json.length() - 1 ) ).append( "}" );

        return json;
    }

}
