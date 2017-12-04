package net.eoutech.vifi.as.commons.entity;

public class TbIPAddress {
    private Integer id;

    private Integer startIP;

    private Integer endIP;

    private String country;

    private String operators;

    private String idxUUWiFiAreaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartIP() {
        return startIP;
    }

    public void setStartIP(Integer startIP) {
        this.startIP = startIP;
    }

    public Integer getEndIP() {
        return endIP;
    }

    public void setEndIP(Integer endIP) {
        this.endIP = endIP;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators == null ? null : operators.trim();
    }

    public String getIdxUUWiFiAreaId() {
        return idxUUWiFiAreaId;
    }

    public void setIdxUUWiFiAreaId(String idxUUWiFiAreaId) {
        this.idxUUWiFiAreaId = idxUUWiFiAreaId == null ? null : idxUUWiFiAreaId.trim();
    }
}