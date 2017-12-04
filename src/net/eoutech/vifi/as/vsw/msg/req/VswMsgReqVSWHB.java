package net.eoutech.vifi.as.vsw.msg.req;

import net.eoutech.vifi.as.commons.enums.VaMsgType;
import org.apache.commons.lang.StringUtils;

public class VswMsgReqVSWHB extends VswMsgReqBase {

	private Integer expires;
	private String vswname;
	private String vswpwd;
	private String vswip;
	private Integer vswport;
	
	public Integer getExpires() {
		return expires;
	}

	public void setExpires(Integer expires) {
		this.expires = expires;
	}

	public String getVswname() {
		return vswname;
	}

	public void setVswname(String vswname) {
		this.vswname = vswname;
	}

	public String getVswpwd() {
		return vswpwd;
	}

	public void setVswpwd(String vswpwd) {
		this.vswpwd = vswpwd;
	}

	public String getVswip() {
		return vswip;
	}

	public void setVswip(String vswip) {
		this.vswip = vswip;
	}

	public Integer getVswport() {
		return vswport;
	}

	public void setVswport(Integer vswport) {
		this.vswport = vswport;
	}

	@Override
	public VaMsgType getMsgType() {
		return VaMsgType.VSWHB;
	}

	@Override
	public boolean checkReqData() {
		if ( StringUtils.isEmpty( vswname ) || StringUtils.isEmpty( vswip ) || null == vswport ) {
			return false;
		}
		return true;
	}

}
