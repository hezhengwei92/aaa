package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbSCGroup {
    private String keySCGroupID;

    private String groupName;

    private String idxAgentID;

    private String idxSalerId;

    private String idxUUWiFiAreaId;

    private String areaName;

    private String areaCode;

    private String ispID;

    private String apn;

    private String dialnumber;

    private String dialuid;

    private String dialpwd;

    private String ispName;

    private Integer cardType;

    private Integer cardSize;

    private String monthlyRental;

    private Integer dataUsage;

    private Integer dataPrice;

    private Integer roamSupport;

    private String roamAreaCodes;

    private Integer roamDataPrice;

    private Integer priority;

    private Integer number;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeySCGroupID() {
        return keySCGroupID;
    }

    public void setKeySCGroupID(String keySCGroupID) {
        this.keySCGroupID = keySCGroupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID == null ? null : idxAgentID.trim();
    }

    public String getIdxSalerId() {
        return idxSalerId;
    }

    public void setIdxSalerId(String idxSalerId) {
        this.idxSalerId = idxSalerId == null ? null : idxSalerId.trim();
    }

    public String getIdxUUWiFiAreaId() {
        return idxUUWiFiAreaId;
    }

    public void setIdxUUWiFiAreaId( String idxUUWiFiAreaId ) {
        this.idxUUWiFiAreaId = idxUUWiFiAreaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getIspID() {
        return ispID;
    }

    public void setIspID(String ispID) {
        this.ispID = ispID == null ? null : ispID.trim();
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn == null ? null : apn.trim();
    }

    public String getDialnumber() {
        return dialnumber;
    }

    public void setDialnumber(String dialnumber) {
        this.dialnumber = dialnumber == null ? null : dialnumber.trim();
    }

    public String getDialuid() {
        return dialuid;
    }

    public void setDialuid(String dialuid) {
        this.dialuid = dialuid == null ? null : dialuid.trim();
    }

    public String getDialpwd() {
        return dialpwd;
    }

    public void setDialpwd(String dialpwd) {
        this.dialpwd = dialpwd == null ? null : dialpwd.trim();
    }

    public String getIspName() {
        return ispName;
    }

    public void setIspName(String ispName) {
        this.ispName = ispName == null ? null : ispName.trim();
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getCardSize() {
        return cardSize;
    }

    public void setCardSize(Integer cardSize) {
        this.cardSize = cardSize;
    }

    public String getMonthlyRental() {
        return monthlyRental;
    }

    public void setMonthlyRental(String monthlyRental) {
        this.monthlyRental = monthlyRental == null ? null : monthlyRental.trim();
    }

    public Integer getDataUsage() {
        return dataUsage;
    }

    public void setDataUsage(Integer dataUsage) {
        this.dataUsage = dataUsage;
    }

    public Integer getDataPrice() {
        return dataPrice;
    }

    public void setDataPrice(Integer dataPrice) {
        this.dataPrice = dataPrice;
    }

    public Integer getRoamSupport() {
        return roamSupport;
    }

    public void setRoamSupport(Integer roamSupport) {
        this.roamSupport = roamSupport;
    }

    public String getRoamAreaCodes() {
        return roamAreaCodes;
    }

    public void setRoamAreaCodes(String roamAreaCodes) {
        this.roamAreaCodes = roamAreaCodes == null ? null : roamAreaCodes.trim();
    }

    public Integer getRoamDataPrice() {
        return roamDataPrice;
    }

    public void setRoamDataPrice(Integer roamDataPrice) {
        this.roamDataPrice = roamDataPrice;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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