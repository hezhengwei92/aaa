package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbSUStaticBind {
    private String keySUBindID;

    private String idxSCGroupID;

    private String idxDevGrpID;

    private Integer status;

    private Integer useTimes;

    private Date lastBindDate;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeySUBindID() {
        return keySUBindID;
    }

    public void setKeySUBindID(String keySUBindID) {
        this.keySUBindID = keySUBindID == null ? null : keySUBindID.trim();
    }

    public String getIdxSCGroupID() {
        return idxSCGroupID;
    }

    public void setIdxSCGroupID( String idxSCGroupID ) {
        this.idxSCGroupID = idxSCGroupID;
    }

    public String getIdxDevGrpID() {
        return idxDevGrpID;
    }

    public void setIdxDevGrpID( String idxDevGrpID ) {
        this.idxDevGrpID = idxDevGrpID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Integer useTimes) {
        this.useTimes = useTimes;
    }

    public Date getLastBindDate() {
        return lastBindDate;
    }

    public void setLastBindDate(Date lastBindDate) {
        this.lastBindDate = lastBindDate;
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