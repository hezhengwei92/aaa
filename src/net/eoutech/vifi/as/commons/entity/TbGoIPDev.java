package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbGoIPDev {
    private String keyGoIPDevID;

    private String devName;

    private String idxGoIPDevGrpID;

    private String typeName;

    private String username;

    private String password;

    private Integer expire;

    private Date lastUpdate;

    private String sipAccount;

    private String ipaddr;

    private Integer port;

    private Integer status;

    private String ports;

    private String idxVSWID;

    private String sipIP;

    private Integer sipPort;

    private Integer sipRegExp;

    private Date sipRegDate;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeyGoIPDevID() {
        return keyGoIPDevID;
    }

    public void setKeyGoIPDevID(String keyGoIPDevID) {
        this.keyGoIPDevID = keyGoIPDevID == null ? null : keyGoIPDevID.trim();
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName == null ? null : devName.trim();
    }

    public String getIdxGoIPDevGrpID() {
        return idxGoIPDevGrpID;
    }

    public void setIdxGoIPDevGrpID(String idxGoIPDevGrpID) {
        this.idxGoIPDevGrpID = idxGoIPDevGrpID == null ? null : idxGoIPDevGrpID.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(String sipAccount) {
        this.sipAccount = sipAccount == null ? null : sipAccount.trim();
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports == null ? null : ports.trim();
    }

    public String getIdxVSWID() {
        return idxVSWID;
    }

    public void setIdxVSWID(String idxVSWID) {
        this.idxVSWID = idxVSWID == null ? null : idxVSWID.trim();
    }

    public String getSipIP() {
        return sipIP;
    }

    public void setSipIP(String sipIP) {
        this.sipIP = sipIP == null ? null : sipIP.trim();
    }

    public Integer getSipPort() {
        return sipPort;
    }

    public void setSipPort(Integer sipPort) {
        this.sipPort = sipPort;
    }

    public Integer getSipRegExp() {
        return sipRegExp;
    }

    public void setSipRegExp(Integer sipRegExp) {
        this.sipRegExp = sipRegExp;
    }

    public Date getSipRegDate() {
        return sipRegDate;
    }

    public void setSipRegDate(Date sipRegDate) {
        this.sipRegDate = sipRegDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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