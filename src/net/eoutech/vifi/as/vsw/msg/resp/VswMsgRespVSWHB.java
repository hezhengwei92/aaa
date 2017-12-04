package net.eoutech.vifi.as.vsw.msg.resp;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqVSWHB;

public class VswMsgRespVSWHB extends VswMsgRespBase {

    private Integer expires;

    public VswMsgRespVSWHB( VaMsgReq req ) {
        super( req );
        this.expires = ( ( VswMsgReqVSWHB ) req ).getExpires();
        this.setDid( -1 );
        this.setProto( ( ( VswMsgReqVSWHB ) req ).getProto() );
    }

    public Integer getExpires() {
        return expires;
    }

    public void setExpires( Integer expires ) {
        this.expires = expires;
    }

    public StringBuilder toJSONString() {
        StringBuilder json = super.toJSONString();
        json = new StringBuilder( json.substring( 0, json.length() - 1 ) ).append( "," )
                .append( toIntJS( "expires", expires, "}" ) );
        return json;
    }

}
