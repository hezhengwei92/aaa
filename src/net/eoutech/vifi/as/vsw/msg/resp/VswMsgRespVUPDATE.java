package net.eoutech.vifi.as.vsw.msg.resp;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.vns.msg.resp.UUWiFiLogCfg;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqVUPDATE;

public class VswMsgRespVUPDATE extends VswMsgRespBase {

    private String from;
    private String to;
    private Integer expires;
    
    // 新增日志返回接口
    private UUWiFiLogCfg logCfg;
    private Integer sidExp = 600;

    public VswMsgRespVUPDATE( VaMsgReq req ) {
        super( req );

        this.setExpires( ( ( VswMsgReqVUPDATE ) req ).getExpires() );
        this.setSidExp( 100 );
        this.setProto( ( ( VswMsgReqVUPDATE ) req ).getProto() );
        this.setCseq( ( ( VswMsgReqVUPDATE ) req ).getCseq() );
        this.setDid( -1 );
        this.from = ( ( VswMsgReqVUPDATE ) req ).getFrom();
        this.to = ( ( VswMsgReqVUPDATE ) req ).getTo();
    }

    public void setFrom( String from ) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setTo( String to ) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setExpires( Integer expires ) {
        this.expires = expires;
    }

    public Integer getExpires() {
        return expires;
    }

    public UUWiFiLogCfg getLogCfg() {
		return logCfg;
	}

	public void setLogCfg(UUWiFiLogCfg logCfg) {
		this.logCfg = logCfg;
	}

    public Integer getSidExp() {
        return sidExp;
    }

    public void setSidExp( Integer sidExp ) {
        this.sidExp = sidExp;
    }

    public StringBuilder toJSONString() {
        StringBuilder json = super.toJSONString();
        json = new StringBuilder( json.substring( 0, json.length() - 1 ) ).append( "," )
                .append( toStrJS( "from", from, "," ) )
                .append( toStrJS( "to", to, "," ) )
                .append( toIntJS( "sidexp", sidExp, "," ) );
        if ( logCfg != null ) {
        	json.append( toObjJS( "set", logCfg, "," ) );
        }
        
        json.append( toIntJS( "expires", expires, "}" ) );
        return json;
    }

}
