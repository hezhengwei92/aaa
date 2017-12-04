package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbChinaCity {
    private String keyAreaId;

    private String region;

    private String city;

    private Date crtTm;

    private String crtBy;

    public String getKeyAreaId() {
        return keyAreaId;
    }

    public void setKeyAreaId(String keyAreaId) {
        this.keyAreaId = keyAreaId == null ? null : keyAreaId.trim();
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