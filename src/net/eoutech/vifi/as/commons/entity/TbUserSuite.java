package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbUserSuite {
    private Integer keyID;

    private String idxPhoneNumber;

    private String suiteType;

    private Integer remainValue;

    private String idxUUWiFiAreaId;

    private Date effectDate;

    private Date invalidDate;

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

    public String getIdxPhoneNumber() {
        return idxPhoneNumber;
    }

    public void setIdxPhoneNumber(String idxPhoneNumber) {
        this.idxPhoneNumber = idxPhoneNumber == null ? null : idxPhoneNumber.trim();
    }

    public String getSuiteType() {
        return suiteType;
    }

    public void setSuiteType(String suiteType) {
        this.suiteType = suiteType == null ? null : suiteType.trim();
    }

    public Integer getRemainValue() {
        return remainValue;
    }

    public void setRemainValue(Integer remainValue) {
        this.remainValue = remainValue;
    }

    public String getIdxUUWiFiAreaId() {
        return idxUUWiFiAreaId;
    }

    public void setIdxUUWiFiAreaId( String idxUUWiFiAreaId ) {
        this.idxUUWiFiAreaId = idxUUWiFiAreaId;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
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