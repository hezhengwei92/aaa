
package net.eoutech.vifi.as.vsw.msg.req;

import net.eoutech.vifi.as.commons.enums.VaMsgType;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class VswMsgReqVUPDATE extends VswMsgReqBase {
    private Integer cseq;
    private String from;
    private String to;
    private List<String> orderList;

    private String goip_slot;
    private String sim_slot;
    private String type;
    private Integer expires;
    private String mod_type;
    private String mod_ver;
    private String imei;
    private String iccid;
    private String imsi;
    private String provider;
    private String sim_num;
    private String sim_status;
    private Integer sim_sig;
    private String sim_bal;
    private String sessid;
    private String ifid = "";

    //新增
    private Integer up;
    private Integer down;

    public List<String> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<String> orderList) {
        this.orderList = orderList;
    }

    public Integer getCseq() {
        return cseq;
    }

    public void setCseq( Integer cseq ) {
        this.cseq = cseq;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom( String from ) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo( String to ) {
        this.to = to;
    }

    public String getGoip_slot() {
        return goip_slot;
    }

    public void setGoip_slot( String goip_slot ) {
        this.goip_slot = goip_slot;
    }

    public String getSim_slot() {
        return sim_slot;
    }

    public void setSim_slot( String sim_slot ) {
        this.sim_slot = sim_slot;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public Integer getExpires() {
        return expires;
    }

    public void setExpires( Integer expires ) {
        this.expires = expires;
    }

    public String getMod_type() {
        return mod_type;
    }

    public void setMod_type( String mod_type ) {
        this.mod_type = mod_type;
    }

    public String getMod_ver() {
        return mod_ver;
    }

    public void setMod_ver( String mod_ver ) {
        this.mod_ver = mod_ver;
    }

    public String getImei() {
        return imei;
    }

    public void setImei( String imei ) {
        this.imei = imei;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid( String iccid ) {
        this.iccid = iccid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi( String imsi ) {
        this.imsi = imsi;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider( String provider ) {
        this.provider = provider;
    }

    public String getSim_num() {
        return sim_num;
    }

    public void setSim_num( String sim_num ) {
        this.sim_num = sim_num;
    }

    public String getSim_status() {
        return sim_status;
    }

    public void setSim_status( String sim_status ) {
        this.sim_status = sim_status;
    }

    public Integer getSim_sig() {
        return sim_sig;
    }

    public void setSim_sig( Integer sim_sig ) {
        this.sim_sig = sim_sig;
    }

    public String getSim_bal() {
        return sim_bal;
    }

    public void setSim_bal( String sim_bal ) {
        this.sim_bal = sim_bal;
    }

    public String getSessid() {
        return sessid;
    }

    public void setSessid( String sessid ) {
        this.sessid = sessid;
    }

    public Integer getUp() {
		return up;
	}

	public void setUp(Integer up) {
		this.up = up;
	}

	public Integer getDown() {
		return down;
	}

	public void setDown(Integer down) {
		this.down = down;
	}

	public String getIfid() {
		return ifid;
	}

	public void setIfid(String ifid) {
		this.ifid = ifid;
	}

	@Override
    public VaMsgType getMsgType() {
        return VaMsgType.VUPDATE;
    }

    @Override
    public boolean checkReqData() {
        if ( StringUtils.isEmpty( sessid ) ) {
            return false;
        }
        return true;
    }
}
