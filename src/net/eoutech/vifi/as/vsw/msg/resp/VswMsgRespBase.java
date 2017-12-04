package net.eoutech.vifi.as.vsw.msg.resp;

import com.alibaba.fastjson.annotation.JSONField;
import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;

public class VswMsgRespBase extends VaMsgResp {

    private String proto;
    private Integer cseq;
    private Integer did = -1;

    public VswMsgRespBase( VaMsgReq req ) {
        super( req );
    }
    
    @JSONField( name = "PROTO" )
    public void setProto( String proto ) {
        this.proto = proto;
    }
    @JSONField( name = "PROTO" )
    public String getProto() {
        return proto;
    }

    public void setCseq( Integer cseq ) {
        this.cseq = cseq;
    }

    public Integer getCseq() {
        return cseq;
    }

    public void setDid( Integer did ) {
        this.did = did;
    }

    public Integer getDid() {
        return did;
    }

    public StringBuilder toJSONString() {

        StringBuilder json = new StringBuilder( "{" );
//                .append( toStrJS( "cardid", "80", "," ) );
//        if (did != -1) {
//        	json.append( toIntJS( "did", did, "," ) );
//        }
        json.append( toStrJS( "code", sc, "}" ) );
//        json.append( toStrJS( "cmd", "0x07", "}" ) );

        return json;
    }

    @Override
    public int setSipCode( SipCodeEunm sipCode ) {
        this.sc = sipCode.code;
        this.sr = sipCode.toString();
        return sc;
    }


}
