package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbISP {
    private Integer keyISPID;

    private Integer mcc;

    private String ispName;

    private String areaCode;

    private String idxUUWiFiAreaId;

    private String remark;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public Integer getKeyISPID() {
        return keyISPID;
    }

    public void setKeyISPID(Integer keyISPID) {
        this.keyISPID = keyISPID;
    }

    public String getIspName() {
        return ispName;
    }

    public void setIspName(String ispName) {
        this.ispName = ispName == null ? null : ispName.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
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

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc( Integer mcc ) {
        this.mcc = mcc;
    }

    public String getIdxUUWiFiAreaId() {
        return idxUUWiFiAreaId;
    }

    public void setIdxUUWiFiAreaId( String idxUUWiFiAreaId ) {
        this.idxUUWiFiAreaId = idxUUWiFiAreaId;
    }
}