package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbRate {
    private Integer keyRateID;

    private String rateMode;

    private String idxAgentID;

    private Integer direction;

    private String idxCallPrefix;

    private String idxUUWiFiAreaId;

    private String countryCode;

    private String country;

    private Integer priceCallOnline;

    private Integer priceCallOffline;

    private Integer priceCallbackOff;

    private Integer priceCallGoIP;

    private Integer priceCallbackGoIP;

    private Integer priceSMS;

    private Integer priceNET;

    private Integer dayDataPrice;

    private Integer dayDataLimit;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public Integer getKeyRateID() {
        return keyRateID;
    }

    public void setKeyRateID(Integer keyRateID) {
        this.keyRateID = keyRateID;
    }

    public String getRateMode() {
        return rateMode;
    }

    public void setRateMode(String rateMode) {
        this.rateMode = rateMode == null ? null : rateMode.trim();
    }

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID == null ? null : idxAgentID.trim();
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getIdxCallPrefix() {
        return idxCallPrefix;
    }

    public void setIdxCallPrefix(String idxCallPrefix) {
        this.idxCallPrefix = idxCallPrefix == null ? null : idxCallPrefix.trim();
    }

    public String getIdxUUWiFiAreaId() {
        return idxUUWiFiAreaId;
    }

    public void setIdxUUWiFiAreaId( String idxUUWiFiAreaId ) {
        this.idxUUWiFiAreaId = idxUUWiFiAreaId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Integer getPriceCallOnline() {
        return priceCallOnline;
    }

    public void setPriceCallOnline(Integer priceCallOnline) {
        this.priceCallOnline = priceCallOnline;
    }

    public Integer getPriceCallOffline() {
        return priceCallOffline;
    }

    public void setPriceCallOffline(Integer priceCallOffline) {
        this.priceCallOffline = priceCallOffline;
    }

    public Integer getPriceCallbackOff() {
        return priceCallbackOff;
    }

    public void setPriceCallbackOff(Integer priceCallbackOff) {
        this.priceCallbackOff = priceCallbackOff;
    }

    public Integer getPriceCallGoIP() {
        return priceCallGoIP;
    }

    public void setPriceCallGoIP(Integer priceCallGoIP) {
        this.priceCallGoIP = priceCallGoIP;
    }

    public Integer getPriceCallbackGoIP() {
        return priceCallbackGoIP;
    }

    public void setPriceCallbackGoIP(Integer priceCallbackGoIP) {
        this.priceCallbackGoIP = priceCallbackGoIP;
    }

    public Integer getPriceSMS() {
        return priceSMS;
    }

    public void setPriceSMS(Integer priceSMS) {
        this.priceSMS = priceSMS;
    }

    public Integer getPriceNET() {
        return priceNET;
    }

    public void setPriceNET(Integer priceNET) {
        this.priceNET = priceNET;
    }

    public Integer getDayDataPrice() {
        return dayDataPrice;
    }

    public void setDayDataPrice(Integer dayDataPrice) {
        this.dayDataPrice = dayDataPrice;
    }

    public Integer getDayDataLimit() {
        return dayDataLimit;
    }

    public void setDayDataLimit(Integer dayDataLimit) {
        this.dayDataLimit = dayDataLimit;
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