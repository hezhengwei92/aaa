package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbDailyRental {
    private Integer keyID;

    private String idxViFiID;

    private String idxPhoneNumber;

    private Date startDate;

    private Date endDate;

    private Integer maxData;

    private Integer rateLimit;

    private Integer price;

    private String areaCodes;

    private Integer todayUsage;

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

    public String getIdxViFiID() {
        return idxViFiID;
    }

    public void setIdxViFiID(String idxViFiID) {
        this.idxViFiID = idxViFiID == null ? null : idxViFiID.trim();
    }

    public String getIdxPhoneNumber() {
        return idxPhoneNumber;
    }

    public void setIdxPhoneNumber(String idxPhoneNumber) {
        this.idxPhoneNumber = idxPhoneNumber == null ? null : idxPhoneNumber.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMaxData() {
        return maxData;
    }

    public void setMaxData(Integer maxData) {
        this.maxData = maxData;
    }

    public Integer getRateLimit() {
        return rateLimit;
    }

    public void setRateLimit(Integer rateLimit) {
        this.rateLimit = rateLimit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAreaCodes() {
        return areaCodes;
    }

    public void setAreaCodes(String areaCodes) {
        this.areaCodes = areaCodes == null ? null : areaCodes.trim();
    }

    public Integer getTodayUsage() {
        return todayUsage;
    }

    public void setTodayUsage(Integer todayUsage) {
        this.todayUsage = todayUsage;
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