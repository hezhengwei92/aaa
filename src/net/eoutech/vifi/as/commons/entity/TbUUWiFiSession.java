package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbUUWiFiSession {
    private String keySessID;

    private String sessType;

    private String idxSUBindID;

    private String idxVifiID;

    private String idxUUWiFiCellID;

    private String idxUUWiFiAreaId;

    private String idxSimCIccId;

    private String idxSimPPortId;

    private String idxSimPDevID;

    private String idxGoipDevID;

    private Integer idxGoipPortID;

    private String idxVSWID;

    private Integer status;

    private Integer expire;

    private Date lastUpdate;

    private String userAct;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeySessID() {
        return keySessID;
    }

    public void setKeySessID(String keySessID) {
        this.keySessID = keySessID == null ? null : keySessID.trim();
    }

    public String getSessType() {
        return sessType;
    }

    public void setSessType(String sessType) {
        this.sessType = sessType == null ? null : sessType.trim();
    }

    public String getIdxSUBindID() {
        return idxSUBindID;
    }

    public void setIdxSUBindID( String idxSUBindID ) {
        this.idxSUBindID = idxSUBindID;
    }

    public String getIdxVifiID() {
        return idxVifiID;
    }

    public void setIdxVifiID(String idxVifiID) {
        this.idxVifiID = idxVifiID == null ? null : idxVifiID.trim();
    }

    public String getIdxSimCIccId() {
        return idxSimCIccId;
    }

    public void setIdxSimCIccId(String idxSimCIccId) {
        this.idxSimCIccId = idxSimCIccId == null ? null : idxSimCIccId.trim();
    }

    public String getIdxSimPPortId() {
        return idxSimPPortId;
    }

    public void setIdxSimPPortId(String idxSimPPortId) {
        this.idxSimPPortId = idxSimPPortId == null ? null : idxSimPPortId.trim();
    }

    public String getIdxSimPDevID() {
        return idxSimPDevID;
    }

    public void setIdxSimPDevID(String idxSimPDevID) {
        this.idxSimPDevID = idxSimPDevID == null ? null : idxSimPDevID.trim();
    }

    public String getIdxGoipDevID() {
        return idxGoipDevID;
    }

    public void setIdxGoipDevID(String idxGoipDevID) {
        this.idxGoipDevID = idxGoipDevID == null ? null : idxGoipDevID.trim();
    }

    public Integer getIdxGoipPortID() {
        return idxGoipPortID;
    }

    public void setIdxGoipPortID(Integer idxGoipPortID) {
        this.idxGoipPortID = idxGoipPortID;
    }

    public String getIdxVSWID() {
        return idxVSWID;
    }

    public void setIdxVSWID(String idxVSWID) {
        this.idxVSWID = idxVSWID == null ? null : idxVSWID.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getUserAct() {
        return userAct;
    }

    public void setUserAct(String userAct) {
        this.userAct = userAct == null ? null : userAct.trim();
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

    public String getIdxUUWiFiCellID() {
        return idxUUWiFiCellID;
    }

    public void setIdxUUWiFiCellID( String idxUUWiFiCellID ) {
        this.idxUUWiFiCellID = idxUUWiFiCellID;
    }

    public String getIdxUUWiFiAreaId() {
        return idxUUWiFiAreaId;
    }

    public void setIdxUUWiFiAreaId( String idxUUWiFiAreaId ) {
        this.idxUUWiFiAreaId = idxUUWiFiAreaId;
    }
}