package net.eoutech.vifi.as.commons.base;

import com.alibaba.fastjson.JSON;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;
import net.eoutech.vifi.as.commons.vo.VaCDR;
import net.eoutech.vifi.as.commons.vo.VaCost;
import net.eoutech.vifi.as.commons.vo.VaCount;
import net.eoutech.vifi.as.commons.vo.VaViFiAction;
import net.eoutech.vifi.as.vsw.vo.VaVSW;

public abstract class VaMsgResp {

    protected String msg;
    protected Integer sc = SipCodeEunm.SIP_200_OK.code;
    protected String sr = SipCodeEunm.SIP_200_OK.desc;

    private long respEndTime;

    public VaMsgResp( VaMsgReq req ) {
        this.msg = req.getMsgType().toString();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg( String msg ) {
        this.msg = msg;
    }

    public Integer getSc() {
        return sc;
    }

    public void setSc( Integer sc ) {
        this.sc = sc;
    }

    public String getSr() {
        return sr;
    }

    public void setSr( String sr ) {
        this.sr = sr;
    }

    public long getRespEndTime() {
        return respEndTime;
    }

    public void setRespEndTime( long respEndTime ) {
        this.respEndTime = respEndTime;
    }

    protected StringBuilder toStrJS( String name, Object value, String ending ) {
        if ( value == null ) {
            value = "";
        }
        return new StringBuilder( "\"" ).append( name ).append( "\":\"" ).append( value ).append( "\"" ).append( ending );
    }

    protected StringBuilder toIntJS( String name, Object value, String ending ) {
        if ( value == null ) {
            value = "0";
        }
        return new StringBuilder( "\"" ).append( name ).append( "\":" ).append( value ).append( ending );
    }

    protected StringBuilder toObjJS ( String name, Object value, String ending ) {
        return new StringBuilder( "\"" ).append( name ).append( "\":" ).append( JSON.toJSONString( value ) ).append( ending );
    }

    /**
     * 自己拼合response json
     */
    public abstract StringBuilder toJSONString();

    public abstract int setSipCode( SipCodeEunm sipCode );


}
