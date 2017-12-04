package net.eoutech.vifi.as.vns.msg.resp;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.enums.AsCodeEnum;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;

/**
 * Created by SUU on 2016/7/6.
 */
public class VnsMsgRespBase extends VaMsgResp {

    public VnsMsgRespBase( VaMsgReq req ) {
        super( req );
        this.sc = AsCodeEnum.AS_SUCCESS.code;
        this.sr = AsCodeEnum.AS_SUCCESS.desc;
    }

    @Override
    public StringBuilder toJSONString() {
        StringBuilder json = new StringBuilder( "{" )
                .append( toStrJS( "msg", msg, "," ))
                .append( toIntJS("code", sc, ","))
                .append(toStrJS("decs", sr, "}"));
        return json;
    }

    @Override
    public int setSipCode( SipCodeEunm sipCode ) {
        this.sc = sipCode.code;
        this.sr = sipCode.toString();
        return sc;
    }
}
