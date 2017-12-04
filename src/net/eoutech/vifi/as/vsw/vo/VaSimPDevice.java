package net.eoutech.vifi.as.vsw.vo;

import net.eoutech.vifi.as.commons.entity.TbSimPDev;

/**
 * Created by SUU on 2016/6/16.
 */
public class VaSimPDevice extends VaDevice {

    private Integer groupId;
    private String username;
    private String ip;
    private Integer port;
    private Integer ports;
    private String vswId;
    private Integer status;

    public VaSimPDevice( String id ) {
        this.id = id;
    }

    public VaSimPDevice( TbSimPDev device ) {
        this.id = device.getKeySimPDevID();
        this.pass = device.getPassword();
        this.expire = device.getExpire();
        this.lastUpdateTime = device.getLastUpdate().getTime();
        this.status = device.getStatus();
        this.groupId = device.getIdxSimPDevGrpID();
        this.username = device.getUsername();
        this.ip = device.getIpaddr();
        this.port = device.getPort();
        this.ports = device.getPorts();
        this.vswId = device.getIdxVSWID();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId( Integer groupId ) {
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
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

    public Integer  getPorts() {
        return ports;
    }

    public void setPorts( Integer ports ) {
        this.ports = ports;
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
}
