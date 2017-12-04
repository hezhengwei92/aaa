package net.eoutech.vifi.as.commons.base;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import net.eoutech.vifi.as.commons.enums.VaMsgType;

public abstract class VaMsgReq {
    protected int MTP;    // 消息类型 1:req  2:resp  0:tm
    protected int TID;    // 事务ID
    protected int STA;    // 状态
    protected String FIP;    // 来源的IP地址
    protected int FPT;    // 来源的IP号
    protected int sc;    // code
    protected String sr;    // 原因

    protected JSONObject DATA;

    private long reqBeginTime;

    @JSONField( serialize = false )
    public abstract VaMsgType getMsgType();
    @JSONField( serialize = false )
    public abstract boolean checkReqData();


    public int getMTP() {
        return MTP;
    }

    public void setMTP( int MTP ) {
        this.MTP = MTP;
    }

    public int getTID() {
        return TID;
    }

    public void setTID( int TID ) {
        this.TID = TID;
    }

    public int getSTA() {
        return STA;
    }

    public void setSTA( int STA ) {
        this.STA = STA;
    }

    public String getFIP() {
        return FIP;
    }

    public void setFIP( String FIP ) {
        this.FIP = FIP;
    }

    public int getFPT() {
        return FPT;
    }

    public void setFPT( int FPT ) {
        this.FPT = FPT;
    }

    @JSONField( name = "DATA" )
    public JSONObject getDATA() {
        return DATA;
    }

    @JSONField( name = "DATA" )
    public void setDATA( JSONObject DATA ) {
        this.DATA = DATA;
    }

    public int getSc() {
        return sc;
    }

    public void setSc( int sc ) {
        this.sc = sc;
    }

    public String getSr() {
        return sr;
    }

    public void setSr( String sr ) {
        this.sr = sr;
    }

    public long getReqBeginTime() {
        return reqBeginTime;
    }

    public void setReqBeginTime( long reqBeginTime ) {
        this.reqBeginTime = reqBeginTime;
    }
}
