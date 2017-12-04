package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbGUStaticBind {
    private String keyGUBindID;

    private String idxGoIPDevID;

    private Integer idxPortNum;

    private String idxViFiID;

    private Integer status;

    private Integer useTimes;

    private Date lastBindDate;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeyGUBindID() {
        return keyGUBindID;
    }

    public void setKeyGUBindID(String keyGUBindID) {
        this.keyGUBindID = keyGUBindID == null ? null : keyGUBindID.trim();
    }

    public String getIdxGoIPDevID() {
        return idxGoIPDevID;
    }

    public void setIdxGoIPDevID(String idxGoIPDevID) {
        this.idxGoIPDevID = idxGoIPDevID == null ? null : idxGoIPDevID.trim();
    }

    public Integer getIdxPortNum() {
        return idxPortNum;
    }

    public void setIdxPortNum(Integer idxPortNum) {
        this.idxPortNum = idxPortNum;
    }

    public String getIdxViFiID() {
        return idxViFiID;
    }

    public void setIdxViFiID(String idxViFiID) {
        this.idxViFiID = idxViFiID == null ? null : idxViFiID.trim();
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