
package net.eoutech.vifi.as.vsw.msg.req;

import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.enums.VaMsgType;
import org.apache.commons.lang.StringUtils;

public class VswMsgReqGSREG extends VswMsgReqBase {

	private Integer did;
	private Integer cseq;
	private String username;
	private Integer SimPDevGrpID;
	private Integer expires;
	private String name;
	private Integer max_ports;
	private String mac;
	private String ip;
	private Integer port;
	private String type;
	private String version;
//	private String status;
	private Integer status;
	private String nonce;
	private Integer nc;
	private String response;
	private Integer ports;
	private String serveIp;
	private int servePort;

	public Integer getSimPDevGrpID() {
		return SimPDevGrpID;
	}

	public void setSimPDevGrpID(Integer simPDevGrpID) {
		SimPDevGrpID = simPDevGrpID;
	}

	public void setServeIp(String serveIp) {
		this.serveIp=serveIp;
	}

	public String getServeIp() {
		return serveIp;
	}

	public void setServePort(int servePort) {
		this.servePort=servePort;
	}

	public int getServePort() {
		return servePort;
	}


	public void setPorts(Integer ports) {
		this.ports = ports;
	}

	public Integer getPorts() {
		return ports;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getDid() {
		return did;
	}

	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}

	public Integer getCseq() {
		return cseq;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setExpires(Integer expires) {
		this.expires = expires;
	}

	public Integer getExpires() {
		return expires;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setMax_ports(Integer max_ports) {
		this.max_ports = max_ports;
	}

	public Integer getMax_ports() {
		return max_ports;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getMac() {
		return mac;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNc(Integer nc) {
		this.nc = nc;
	}

	public Integer getNc() {
		return nc;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public VaMsgType getMsgType() {
		return VaMsgType.GSREG;
	}

	@Override
	public boolean checkReqData() {
		//isBlank 判断字符串是否为空 或长度为0 或由 空白符构成  | 或
		if ( StringUtils.isBlank( nonce ) || StringUtils.isBlank( response ) || StringUtils.isBlank( type )
				|| StringUtils.isBlank( ip ) || StringUtils.isBlank( username ) ) {
			return false;
		}

		if ( !VaConst.Request.GSREG_TYPE_SIMP.equals( type ) && !VaConst.Request.GSREG_TYPE_GOIP.equals( type ) ) {
			return false;
		}
		return true;
	}

}
