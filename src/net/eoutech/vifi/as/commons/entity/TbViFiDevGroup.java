package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbViFiDevGroup {
    private String keyDevGrpID;

    private String name;

    private Date productionDate;

    private String productionNo;

    private String productionVer;

    private String hardwareVer;

    private String firmwareVer;

    private String softwareVer;

    private Integer initNumber;

    private Integer currentNumber;

    private Integer normalNumber;

    private Integer repairTimes;

    private String remark;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    private String tbViFiDevGroupcol;

    public String getKeyDevGrpID() {
        return keyDevGrpID;
    }

    public void setKeyDevGrpID(String keyDevGrpID) {
        this.keyDevGrpID = keyDevGrpID == null ? null : keyDevGrpID.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getProductionNo() {
        return productionNo;
    }

    public void setProductionNo(String productionNo) {
        this.productionNo = productionNo == null ? null : productionNo.trim();
    }

    public String getProductionVer() {
        return productionVer;
    }

    public void setProductionVer(String productionVer) {
        this.productionVer = productionVer == null ? null : productionVer.trim();
    }

    public String getHardwareVer() {
        return hardwareVer;
    }

    public void setHardwareVer(String hardwareVer) {
        this.hardwareVer = hardwareVer == null ? null : hardwareVer.trim();
    }

    public String getFirmwareVer() {
        return firmwareVer;
    }

    public void setFirmwareVer(String firmwareVer) {
        this.firmwareVer = firmwareVer == null ? null : firmwareVer.trim();
    }

    public String getSoftwareVer() {
        return softwareVer;
    }

    public void setSoftwareVer(String softwareVer) {
        this.softwareVer = softwareVer == null ? null : softwareVer.trim();
    }

    public Integer getInitNumber() {
        return initNumber;
    }

    public void setInitNumber(Integer initNumber) {
        this.initNumber = initNumber;
    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Integer getNormalNumber() {
        return normalNumber;
    }

    public void setNormalNumber(Integer normalNumber) {
        this.normalNumber = normalNumber;
    }

    public Integer getRepairTimes() {
        return repairTimes;
    }

    public void setRepairTimes(Integer repairTimes) {
        this.repairTimes = repairTimes;
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

    public String getTbViFiDevGroupcol() {
        return tbViFiDevGroupcol;
    }

    public void setTbViFiDevGroupcol(String tbViFiDevGroupcol) {
        this.tbViFiDevGroupcol = tbViFiDevGroupcol == null ? null : tbViFiDevGroupcol.trim();
    }
}