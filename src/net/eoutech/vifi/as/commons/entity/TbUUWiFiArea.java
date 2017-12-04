package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbUUWiFiArea {
    private String keyAreaId;

    private String idxContinent;

    private String idxCountry;

    private String idxRegion;

    private String idxCity;

    private String idxCode;

    private String cos;

    private Integer timeZone;

    private String language;

    private String currency;

    private Integer totalNumber;

    private Integer mcc;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeyAreaId() {
        return keyAreaId;
    }

    public void setKeyAreaId(String keyAreaId) {
        this.keyAreaId = keyAreaId == null ? null : keyAreaId.trim();
    }

    public String getIdxContinent() {
        return idxContinent;
    }

    public void setIdxContinent(String idxContinent) {
        this.idxContinent = idxContinent == null ? null : idxContinent.trim();
    }

    public String getIdxCountry() {
        return idxCountry;
    }

    public void setIdxCountry(String idxCountry) {
        this.idxCountry = idxCountry == null ? null : idxCountry.trim();
    }

    public String getIdxRegion() {
        return idxRegion;
    }

    public void setIdxRegion(String idxRegion) {
        this.idxRegion = idxRegion == null ? null : idxRegion.trim();
    }

    public String getIdxCity() {
        return idxCity;
    }

    public void setIdxCity(String idxCity) {
        this.idxCity = idxCity == null ? null : idxCity.trim();
    }

    public String getIdxCode() {
        return idxCode;
    }

    public void setIdxCode(String idxCode) {
        this.idxCode = idxCode == null ? null : idxCode.trim();
    }

    public String getCos() {
        return cos;
    }

    public void setCos(String cos) {
        this.cos = cos == null ? null : cos.trim();
    }

    public Integer getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Integer timeZone) {
        this.timeZone = timeZone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc(Integer mcc) {
        this.mcc = mcc;
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