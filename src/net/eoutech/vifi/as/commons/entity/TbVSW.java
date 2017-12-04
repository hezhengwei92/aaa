package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbVSW {
    private String keyVSWID;

    private String hostname;

    private String vswpwd;

    private Integer expire;

    private Date lastHBTime;

    private String state;

    private String vswProtocol;

    private String publicIP;

    private Integer publicPort;

    private String idxUUWiFiAreaId;

    private String location;

    private String countryCode;

    private String ISPName;

    private Integer bandwidth;

    private Integer star;

    private String esxiHost;

    private String CPU;

    private Integer MEM;

    private Integer HARDDISK;

    private Integer diskUsage;

    private Date powerDate;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeyVSWID() {
        return keyVSWID;
    }

    public void setKeyVSWID(String keyVSWID) {
        this.keyVSWID = keyVSWID == null ? null : keyVSWID.trim();
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname == null ? null : hostname.trim();
    }

    public String getVswpwd() {
        return vswpwd;
    }

    public void setVswpwd(String vswpwd) {
        this.vswpwd = vswpwd == null ? null : vswpwd.trim();
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public Date getLastHBTime() {
        return lastHBTime;
    }

    public void setLastHBTime(Date lastHBTime) {
        this.lastHBTime = lastHBTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getVswProtocol() {
        return vswProtocol;
    }

    public void setVswProtocol( String vswProtocol ) {
        this.vswProtocol = vswProtocol;
    }

    public String getPublicIP() {
        return publicIP;
    }

    public void setPublicIP(String publicIP) {
        this.publicIP = publicIP == null ? null : publicIP.trim();
    }

    public Integer getPublicPort() {
        return publicPort;
    }

    public void setPublicPort(Integer publicPort) {
        this.publicPort = publicPort;
    }

    public String getIdxUUWiFiAreaId() {
        return idxUUWiFiAreaId;
    }

    public void setIdxUUWiFiAreaId( String idxUUWiFiAreaId ) {
        this.idxUUWiFiAreaId = idxUUWiFiAreaId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getISPName() {
        return ISPName;
    }

    public void setISPName(String ISPName) {
        this.ISPName = ISPName == null ? null : ISPName.trim();
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getEsxiHost() {
        return esxiHost;
    }

    public void setEsxiHost(String esxiHost) {
        this.esxiHost = esxiHost == null ? null : esxiHost.trim();
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU == null ? null : CPU.trim();
    }

    public Integer getMEM() {
        return MEM;
    }

    public void setMEM(Integer MEM) {
        this.MEM = MEM;
    }

    public Integer getHARDDISK() {
        return HARDDISK;
    }

    public void setHARDDISK(Integer HARDDISK) {
        this.HARDDISK = HARDDISK;
    }

    public Integer getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(Integer diskUsage) {
        this.diskUsage = diskUsage;
    }

    public Date getPowerDate() {
        return powerDate;
    }

    public void setPowerDate(Date powerDate) {
        this.powerDate = powerDate;
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