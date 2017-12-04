package net.eoutech.vifi.as.vsw.msg.req;


import com.alibaba.fastjson.annotation.JSONField;
import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.enums.VaMsgType;

public abstract class VswMsgReqBase extends VaMsgReq {
    private String proto;
    private String msg;


    @JSONField( serialize = false )
    public abstract VaMsgType getMsgType();

    @JSONField( name = "PROTO" )
    public String getProto() {
        return proto;
    }

    @JSONField( name = "PROTO" )
    public void setProto( String proto ) {
        this.proto = proto;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg( String msg ) {
        this.msg = msg;
    }
}
