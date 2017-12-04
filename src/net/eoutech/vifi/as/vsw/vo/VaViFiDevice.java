package net.eoutech.vifi.as.vsw.vo;

import net.eoutech.vifi.as.commons.entity.TbViFiDevice;

/**
 * Created by SUU on 2016/6/16.
 */
public class VaViFiDevice extends VaDevice {

    private String vid;
    private String groupId;
    private String vnsId;
    private Integer lastUUWiFiData;
    private String lastUUWiFiSessId;
    private Long lastConnectTime;
    private String lastConnectIP;
    private String userId;
    private String devState;
    private String agentId;
    private Integer debugIdt;
    private Double deviceFlow;
    public VaViFiDevice( String id ) {
        this.id = id;
    }

    public VaViFiDevice( TbViFiDevice device ) {
        this.id = device.getKeyDevID();
        this.vid = device.getIdxViFiID();
//        this.pass = device.getPwd();
//        this.expire = device.getExpire();
//        this.lastUpdateTime = device.getLastUpdateDate().getTime();
//        this.groupId = device.getIdxDevGrpID();
//        this.vnsId = device.getIdxVNSID();
//        this.lastConnectIP = device.getLastConnectIP();
//        this.lastConnectTime = device.getLastConnectTime().getTime();
//        this.userId = device.getIdxUserID();
//        this.devState = device.getDevState();
//        this.agentId = device.getIdxAgentID();
//        this.debugIdt = device.getDebugIdt().intValue();
//        this.lastUUWiFiData = device.getLastUUWiFiData();
//        this.lastUUWiFiSessId = device.getLastUUWiFiSessId();
        this.deviceFlow=device.getDeviceFlow();
    }

    public String getVid() {
        return vid;
    }

    public void setVid( String vid ) {
        this.vid = vid;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId( String groupId ) {
        this.groupId = groupId;
    }

    public String getVnsId() {
        return vnsId;
    }

    public void setVnsId( String vnsId ) {
        this.vnsId = vnsId;
    }

    public Integer getLastUUWiFiData() {
        return lastUUWiFiData;
    }

    public void setLastUUWiFiData( Integer lastUUWiFiData ) {
        this.lastUUWiFiData = lastUUWiFiData;
    }

    public String getLastUUWiFiSessId() {
        return lastUUWiFiSessId;
    }

    public void setLastUUWiFiSessId( String lastUUWiFiSessId ) {
        this.lastUUWiFiSessId = lastUUWiFiSessId;
    }

    public Long getLastConnectTime() {
        return lastConnectTime;
    }

    public void setLastConnectTime( Long lastConnectTime ) {
        this.lastConnectTime = lastConnectTime;
    }

    public String getLastConnectIP() {
        return lastConnectIP;
    }

    public void setLastConnectIP( String lastConnectIP ) {
        this.lastConnectIP = lastConnectIP;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId ) {
        this.userId = userId;
    }

    public String getDevState() {
        return devState;
    }

    public void setDevState( String devState ) {
        this.devState = devState;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId( String agentId ) {
        this.agentId = agentId;
    }

    public Integer getDebugIdt() {
        return debugIdt;
    }

    public void setDebugIdt( Integer debugIdt ) {
        this.debugIdt = debugIdt;
    }

    public Double getDeviceFlow() {
        return deviceFlow;
    }

    public void setDeviceFlow(Double deviceFlow) {
        this.deviceFlow = deviceFlow;
    }
}
