package net.eoutech.vifi.as.vsw.vo;

import net.eoutech.vifi.as.commons.entity.TbGoIPDev;

/**
 * Created by SUU on 2016/6/16.
 */
public class VaGoIPDevice extends VaDevice {

    private String userName;
    private String groupId;
    private String ip;
    private Integer port;
    private String ports;
    private String vswId;
    private Integer status;

    private String sipIp;
    private Integer sipPort;
    private Integer sipExpire;
    private Long sipRegLastUpdateTime;

    // 更新的端口状态
    private String portStatus;

    public VaGoIPDevice( String id ) {
        this.id = id;
    }

    public VaGoIPDevice( TbGoIPDev device ) {
        this.id = device.getKeyGoIPDevID();
        this.userName = device.getUsername();
        this.pass = device.getPassword();
        this.groupId = device.getIdxGoIPDevGrpID();
        this.expire = device.getExpire();
        this.lastUpdateTime = device.getLastUpdate().getTime();
        this.status = device.getStatus();
        this.ip = device.getIpaddr();
        this.port = device.getPort();
        this.ports = device.getPorts();
        this.vswId = device.getIdxVSWID();
        this.sipIp = device.getSipIP();
        this.sipPort = device.getSipPort();
        this.sipExpire = device.getSipRegExp();
        this.sipRegLastUpdateTime = device.getSipRegDate().getTime();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId( String groupId ) {
        this.groupId = groupId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp( String ip ) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort( Integer port ) {
        this.port = port;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts( String ports ) {
        this.ports = ports;
    }

    public String getPortStatus() {
        return portStatus;
    }

    public void setPortStatus( String portStatus ) {
        this.portStatus = portStatus;
    }

    public String getVswId() {
        return vswId;
    }

    public void setVswId( String vswId ) {
        this.vswId = vswId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    public String getSipIp() {
        return sipIp;
    }

    public void setSipIp( String sipIp ) {
        this.sipIp = sipIp;
    }

    public Integer getSipPort() {
        return sipPort;
    }

    public void setSipPort( Integer sipPort ) {
        this.sipPort = sipPort;
    }

    public Integer getSipExpire() {
        return sipExpire;
    }

    public void setSipExpire( Integer sipExpire ) {
        this.sipExpire = sipExpire;
    }

    public Long getSipRegLastUpdateTime() {
        return sipRegLastUpdateTime;
    }

    public void setSipRegLastUpdateTime( Long sipRegLastUpdateTime ) {
        this.sipRegLastUpdateTime = sipRegLastUpdateTime;
    }
}
