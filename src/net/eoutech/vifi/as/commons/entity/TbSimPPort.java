package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbSimPPort {
    private Integer keyID;

    private String idxSimPDevID;

    private Integer idxSlotNum;

    private Integer status;

    private String idxIccid;

    private String idxViFiId;

    private Integer usage;

    private Integer duration;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    private String idxAgentID;

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID;
    }


    public Integer getKeyID() {
        return keyID;
    }

    public void setKeyID(Integer keyID) {
        this.keyID = keyID;
    }

    public String getIdxSimPDevID() {
        return idxSimPDevID;
    }

    public void setIdxSimPDevID(String idxSimPDevID) {
        this.idxSimPDevID = idxSimPDevID == null ? null : idxSimPDevID.trim();
    }

    public Integer getIdxSlotNum() {
        return idxSlotNum;
    }

    public void setIdxSlotNum(Integer idxSlotNum) {
        this.idxSlotNum = idxSlotNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIdxIccid() {
        return idxIccid;
    }

    public void setIdxIccid(String idxIccid) {
        this.idxIccid = idxIccid == null ? null : idxIccid.trim();
    }

    public String getIdxViFiId() {
        return idxViFiId;
    }

    public void setIdxViFiId(String idxViFiId) {
        this.idxViFiId = idxViFiId == null ? null : idxViFiId.trim();
    }

    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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