package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbSimPDev {
    private String keySimPDevID;

    private String devName;

    private Integer idxSimPDevGrpID;

    private String typeName;

    private String username;

    private String password;

    private Integer expire;

    private Date lastUpdate;

    private String ipaddr;

    private Integer port;

    private Integer status;

    private Integer ports;

    private String idxVSWID;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    private String serveIp;

    private int servePort;

    private String idxAgentID;

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID;
    }

    public String getServeIp(){
        return serveIp;
    }
    public void setServeIp(String serveIp){
        this.serveIp=serveIp;
    }

    public int getServePort(){
        return servePort;
    }
    public void setServePort(int servePort){
        this.servePort=servePort;
    }


    public String getKeySimPDevID() {
        return keySimPDevID;
    }

    public void setKeySimPDevID(String keySimPDevID) {
        this.keySimPDevID = keySimPDevID == null ? null : keySimPDevID.trim();
        this.keySimPDevID = keySimPDevID;

    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName == null ? null : devName.trim();
    }

    public Integer getIdxSimPDevGrpID() {
        return idxSimPDevGrpID;
    }

    public void setIdxSimPDevGrpID(Integer idxSimPDevGrpID) {
        this.idxSimPDevGrpID = idxSimPDevGrpID;
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

    public Integer getPorts() {
        return ports;
    }

    public void setPorts(Integer ports) {
        this.ports = ports;
    }

    public String getIdxVSWID() {
        return idxVSWID;
    }

    public void setIdxVSWID(String idxVSWID) {
        this.idxVSWID = idxVSWID == null ? null : idxVSWID.trim();
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