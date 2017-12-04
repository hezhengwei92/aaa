package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbSimSales {
    private Integer keySimSalesID;

    private String idxSCGroupID;

    private String idxAreaId;

    private Integer dataPrice;

    private Integer maxDaily;

    private Integer maxMonthly;

    private String limitUUWiFi;

    private String limitAgent;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public Integer getKeySimSalesID() {
        return keySimSalesID;
    }

    public void setKeySimSalesID(Integer keySimSalesID) {
        this.keySimSalesID = keySimSalesID;
    }

    public String getIdxSCGroupID() {
        return idxSCGroupID;
    }

    public void setIdxSCGroupID(String idxSCGroupID) {
        this.idxSCGroupID = idxSCGroupID;
    }

    public String getIdxAreaId() {
        return idxAreaId;
    }

    public void setIdxAreaId(String idxAreaId) {
        this.idxAreaId = idxAreaId == null ? null : idxAreaId.trim();
    }

    public Integer getDataPrice() {
        return dataPrice;
    }

    public void setDataPrice(Integer dataPrice) {
        this.dataPrice = dataPrice;
    }

    public Integer getMaxDaily() {
        return maxDaily;
    }

    public void setMaxDaily(Integer maxDaily) {
        this.maxDaily = maxDaily;
    }

    public Integer getMaxMonthly() {
        return maxMonthly;
    }

    public void setMaxMonthly(Integer maxMonthly) {
        this.maxMonthly = maxMonthly;
    }

    public String getLimitUUWiFi() {
        return limitUUWiFi;
    }

    public void setLimitUUWiFi(String limitUUWiFi) {
        this.limitUUWiFi = limitUUWiFi == null ? null : limitUUWiFi.trim();
    }

    public String getLimitAgent() {
        return limitAgent;
    }

    public void setLimitAgent(String limitAgent) {
        this.limitAgent = limitAgent == null ? null : limitAgent.trim();
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