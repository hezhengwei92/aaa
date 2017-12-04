package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbUUWiFiCell {
    private String keyUUWiFiCellID;

    private Integer mcc;

    private Integer mnc;

    private Integer cellid;

    private Integer lac;

    private Integer type;

    private Double longitide;

    private Double latitude;

    private String pubIP;

    private String country;

    private String region;

    private String city;

    private String county;

    private String street;

    private String street_number;

    private Integer accuracy;

    private String uuwifiAreaId;

    private String remark;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeyUUWiFiCellID() {
        return keyUUWiFiCellID;
    }

    public void setKeyUUWiFiCellID(String keyUUWiFiCellID) {
        this.keyUUWiFiCellID = keyUUWiFiCellID == null ? null : keyUUWiFiCellID.trim();
    }

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc(Integer mcc) {
        this.mcc = mcc;
    }

    public Integer getMnc() {
        return mnc;
    }

    public void setMnc(Integer mnc) {
        this.mnc = mnc;
    }

    public Integer getCellid() {
        return cellid;
    }

    public void setCellid(Integer cellid) {
        this.cellid = cellid;
    }

    public Integer getLac() {
        return lac;
    }

    public void setLac(Integer lac) {
        this.lac = lac;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getLongitide() {
        return longitide;
    }

    public void setLongitide(Double longitide) {
        this.longitide = longitide;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getPubIP() {
        return pubIP;
    }

    public void setPubIP(String pubIP) {
        this.pubIP = pubIP == null ? null : pubIP.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number == null ? null : street_number.trim();
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public String getUuwifiAreaId() {
        return uuwifiAreaId;
    }

    public void setUuwifiAreaId(String uuwifiAreaId) {
        this.uuwifiAreaId = uuwifiAreaId == null ? null : uuwifiAreaId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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