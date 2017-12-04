package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbGoIPPort {
    private Integer keyID;

    private String idxGoIPDevID;

    private Integer idxportNum;

    private Integer status;

    private String bindType;

    private String idxViFiID;

    private String uuIccid;

    private String uuImsi;

    private String userAct;

    private Integer usage;

    private Integer duration;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public Integer getKeyID() {
        return keyID;
    }

    public void setKeyID(Integer keyID) {
        this.keyID = keyID;
    }

    public String getIdxGoIPDevID() {
        return idxGoIPDevID;
    }

    public void setIdxGoIPDevID(String idxGoIPDevID) {
        this.idxGoIPDevID = idxGoIPDevID == null ? null : idxGoIPDevID.trim();
    }

    public Integer getIdxportNum() {
        return idxportNum;
    }

    public void setIdxportNum(Integer idxportNum) {
        this.idxportNum = idxportNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBindType() {
        return bindType;
    }

    public void setBindType(String bindType) {
        this.bindType = bindType == null ? null : bindType.trim();
    }

    public String getIdxViFiID() {
        return idxViFiID;
    }

    public void setIdxViFiID(String idxViFiID) {
        this.idxViFiID = idxViFiID == null ? null : idxViFiID.trim();
    }

    public String getUuIccid() {
        return uuIccid;
    }

    public void setUuIccid(String uuIccid) {
        this.uuIccid = uuIccid == null ? null : uuIccid.trim();
    }

    public String getUuImsi() {
        return uuImsi;
    }

    public void setUuImsi(String uuImsi) {
        this.uuImsi = uuImsi == null ? null : uuImsi.trim();
    }

    public String getUserAct() {
        return userAct;
    }

    public void setUserAct(String userAct) {
        this.userAct = userAct == null ? null : userAct.trim();
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