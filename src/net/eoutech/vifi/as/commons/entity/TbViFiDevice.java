package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbViFiDevice {
    private String keyDevID;

    private String idxViFiID;

    private String pwd;

    private String alaisName;

    private String idxDevGrpID;

    private String idxVNSID;

    private String devState;

    private String cos;

    private String idxUserID;

    private String idxAgentID;

    private Integer redirectTimes;

    private Date lastRedirectDate;

    private Integer expire;

    private String lastDomain;

    private Byte debugIdt;

    private Byte updateIdt;

    private String hardwareVer;

    private String firmwareVer;

    private String softwareVer;

    private Date lastUpdateDate;

    private Date lastConnectTime;

    private String lastConnectIP;

    private String lastUUWiFiAreaId;

    private Integer lastUUWiFiData;

    private String lastUUWiFiSessId;

    private String remark;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    private Double deviceFlow;

    public Double getDeviceFlow() {
        return deviceFlow;
    }

    public void setDeviceFlow(Double deviceFlow) {
        this.deviceFlow = deviceFlow;
    }

    public String getKeyDevID() {
        return keyDevID;
    }

    public void setKeyDevID(String keyDevID) {
        this.keyDevID = keyDevID == null ? null : keyDevID.trim();
    }

    public String getIdxViFiID() {
        return idxViFiID;
    }

    public void setIdxViFiID(String idxViFiID) {
        this.idxViFiID = idxViFiID == null ? null : idxViFiID.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getAlaisName() {
        return alaisName;
    }

    public void setAlaisName(String alaisName) {
        this.alaisName = alaisName == null ? null : alaisName.trim();
    }

    public String getIdxDevGrpID() {
        return idxDevGrpID;
    }

    public void setIdxDevGrpID(String idxDevGrpID) {
        this.idxDevGrpID = idxDevGrpID == null ? null : idxDevGrpID.trim();
    }

    public String getIdxVNSID() {
        return idxVNSID;
    }

    public void setIdxVNSID(String idxVNSID) {
        this.idxVNSID = idxVNSID == null ? null : idxVNSID.trim();
    }

    public String getDevState() {
        return devState;
    }

    public void setDevState(String devState) {
        this.devState = devState == null ? null : devState.trim();
    }

    public String getCos() {
        return cos;
    }

    public void setCos(String cos) {
        this.cos = cos == null ? null : cos.trim();
    }

    public String getIdxUserID() {
        return idxUserID;
    }

    public void setIdxUserID(String idxUserID) {
        this.idxUserID = idxUserID == null ? null : idxUserID.trim();
    }

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID == null ? null : idxAgentID.trim();
    }

    public Integer getRedirectTimes() {
        return redirectTimes;
    }

    public void setRedirectTimes(Integer redirectTimes) {
        this.redirectTimes = redirectTimes;
    }

    public Date getLastRedirectDate() {
        return lastRedirectDate;
    }

    public void setLastRedirectDate(Date lastRedirectDate) {
        this.lastRedirectDate = lastRedirectDate;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public String getLastDomain() {
        return lastDomain;
    }

    public void setLastDomain(String lastDomain) {
        this.lastDomain = lastDomain == null ? null : lastDomain.trim();
    }

    public Byte getDebugIdt() {
        return debugIdt;
    }

    public void setDebugIdt(Byte debugIdt) {
        this.debugIdt = debugIdt;
    }

    public Byte getUpdateIdt() {
        return updateIdt;
    }

    public void setUpdateIdt(Byte updateIdt) {
        this.updateIdt = updateIdt;
    }

    public String getHardwareVer() {
        return hardwareVer;
    }

    public void setHardwareVer(String hardwareVer) {
        this.hardwareVer = hardwareVer == null ? null : hardwareVer.trim();
    }

    public String getFirmwareVer() {
        return firmwareVer;
    }

    public void setFirmwareVer(String firmwareVer) {
        this.firmwareVer = firmwareVer == null ? null : firmwareVer.trim();
    }

    public String getSoftwareVer() {
        return softwareVer;
    }

    public void setSoftwareVer(String softwareVer) {
        this.softwareVer = softwareVer == null ? null : softwareVer.trim();
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastConnectTime() {
        return lastConnectTime;
    }

    public void setLastConnectTime(Date lastConnectTime) {
        this.lastConnectTime = lastConnectTime;
    }

    public String getLastConnectIP() {
        return lastConnectIP;
    }

    public void setLastConnectIP(String lastConnectIP) {
        this.lastConnectIP = lastConnectIP == null ? null : lastConnectIP.trim();
    }

    public String getLastUUWiFiAreaId() {
        return lastUUWiFiAreaId;
    }

    public void setLastUUWiFiAreaId( String lastUUWiFiAreaId ) {
        this.lastUUWiFiAreaId = lastUUWiFiAreaId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getMdfTm() {
        return mdfTm;
    }

    public void setMdfTm(Date mdfTm) {
        this.mdfTm = mdfTm;
    }

    public String getMdfBy() {
        return mdfBy;
    }

    public void setMdfBy(String mdfBy) {
        this.mdfBy = mdfBy == null ? null : mdfBy.trim();
    }

    public Date getCrtTm() {
        return crtTm;
    }

    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }

    public String getCrtBy() {
        return crtBy;
    }

    public void setCrtBy(String crtBy) {
        this.crtBy = crtBy == null ? null : crtBy.trim();
    }
}