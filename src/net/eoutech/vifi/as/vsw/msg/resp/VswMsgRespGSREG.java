package net.eoutech.vifi.as.vsw.msg.resp;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqGSREG;

public class VswMsgRespGSREG extends VswMsgRespBase {
    public String nonce;
    public int expires;

    public VswMsgRespGSREG( VaMsgReq req ) {
        super( req );
       // this.expires = ( ( VswMsgReqGSREG ) req ).getExpires();
      //  this.nonce = ( ( VswMsgReqGSREG ) req ).getNonce();
        this.setProto( ( ( VswMsgReqGSREG ) req ).getProto() );
       // this.setDid( ( ( VswMsgReqGSREG ) req ).getDid() );
      //  this.setCseq( ( ( VswMsgReqGSREG ) req ).getCseq() );
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce( String nonce ) {
        this.nonce = nonce;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires( int expires ) {
        this.expires = expires;
    }

    public StringBuilder toJSONString() {
        StringBuilder json = super.toJSONString();
        json = new StringBuilder( json.substring( 0, json.length() - 1 ) ).append( "}" );
        return json;
    }
}
