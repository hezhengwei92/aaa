package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbCDR {
    private Integer keyCDRID;

    private String idxUserId;

    private String idxDeductUserId;

    private String cdrType;

    private String direction;

    private String distance;

    private Integer idxRateId;

    private String suiteRateIds;

    private Integer dailyRentalID;

    private String dnis;

    private String caller;

    private String callee;

    private Date startTime;

    private Date answerTime;

    private Date stopTime;

    private Integer callDuration;

    private Integer dataTraffic;

    private Integer uuwifiDataUp;

    private Integer uuwifiDataDown;

    private String uuwifiSessId;

    private Integer costCash;

    private Integer costReward;

    private Integer bonus;

    private String idxSupplierId;

    private Integer supplierDiscount;

    private String idxAgentID;

    private Integer agentDiscount;

    private String idxCallID;

    private String idxVPXID;

    private String idxTrunkID;

    private Integer hangupPart;

    private String hangupReason;

    private String idxVSWID;

    private String idxGoIPID;

    private String idxSimPID;

    private String idxSimCardID;

    private String idxSMSGate;

    private String idxVAPPID;

    private String idxViFiID;

    private String ispID;

    private String cellId;

    private String countryCode;

    private String pubIP;

    private String area;

    private Double longitude;

    private Double latitude;

    private Date crtTm;

    private String crtBy;

    public Integer getKeyCDRID() {
        return keyCDRID;
    }

    public void setKeyCDRID(Integer keyCDRID) {
        this.keyCDRID = keyCDRID;
    }

    public String getIdxUserId() {
        return idxUserId;
    }

    public void setIdxUserId(String idxUserId) {
        this.idxUserId = idxUserId == null ? null : idxUserId.trim();
    }

    public String getIdxDeductUserId() {
        return idxDeductUserId;
    }

    public void setIdxDeductUserId(String idxDeductUserId) {
        this.idxDeductUserId = idxDeductUserId == null ? null : idxDeductUserId.trim();
    }

    public String getCdrType() {
        return cdrType;
    }

    public void setCdrType(String cdrType) {
        this.cdrType = cdrType == null ? null : cdrType.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    public Integer getIdxRateId() {
        return idxRateId;
    }

    public void setIdxRateId(Integer idxRateId) {
        this.idxRateId = idxRateId;
    }

    public String getSuiteRateIds() {
        return suiteRateIds;
    }

    public void setSuiteRateIds(String suiteRateIds) {
        this.suiteRateIds = suiteRateIds == null ? null : suiteRateIds.trim();
    }

    public Integer getDailyRentalID() {
        return dailyRentalID;
    }

    public void setDailyRentalID(Integer dailyRentalID) {
        this.dailyRentalID = dailyRentalID;
    }

    public String getDnis() {
        return dnis;
    }

    public void setDnis(String dnis) {
        this.dnis = dnis == null ? null : dnis.trim();
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller == null ? null : caller.trim();
    }

    public String getCallee() {
        return callee;
    }

    public void setCallee(String callee) {
        this.callee = callee == null ? null : callee.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Integer callDuration) {
        this.callDuration = callDuration;
    }

    public Integer getDataTraffic() {
        return dataTraffic;
    }

    public void setDataTraffic(Integer dataTraffic) {
        this.dataTraffic = dataTraffic;
    }

    public Integer getUuwifiDataUp() {
        return uuwifiDataUp;
    }

    public void setUuwifiDataUp(Integer uuwifiDataUp) {
        this.uuwifiDataUp = uuwifiDataUp;
    }

    public Integer getUuwifiDataDown() {
        return uuwifiDataDown;
    }

    public void setUuwifiDataDown(Integer uuwifiDataDown) {
        this.uuwifiDataDown = uuwifiDataDown;
    }

    public String getUuwifiSessId() {
        return uuwifiSessId;
    }

    public void setUuwifiSessId(String uuwifiSessId) {
        this.uuwifiSessId = uuwifiSessId == null ? null : uuwifiSessId.trim();
    }

    public Integer getCostCash() {
        return costCash;
    }

    public void setCostCash(Integer costCash) {
        this.costCash = costCash;
    }

    public Integer getCostReward() {
        return costReward;
    }

    public void setCostReward(Integer costReward) {
        this.costReward = costReward;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public String getIdxSupplierId() {
        return idxSupplierId;
    }

    public void setIdxSupplierId(String idxSupplierId) {
        this.idxSupplierId = idxSupplierId == null ? null : idxSupplierId.trim();
    }

    public Integer getSupplierDiscount() {
        return supplierDiscount;
    }

    public void setSupplierDiscount(Integer supplierDiscount) {
        this.supplierDiscount = supplierDiscount;
    }

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID == null ? null : idxAgentID.trim();
    }

    public Integer getAgentDiscount() {
        return agentDiscount;
    }

    public void setAgentDiscount(Integer agentDiscount) {
        this.agentDiscount = agentDiscount;
    }

    public String getIdxCallID() {
        return idxCallID;
    }

    public void setIdxCallID(String idxCallID) {
        this.idxCallID = idxCallID == null ? null : idxCallID.trim();
    }

    public String getIdxVPXID() {
        return idxVPXID;
    }

    public void setIdxVPXID(String idxVPXID) {
        this.idxVPXID = idxVPXID == null ? null : idxVPXID.trim();
    }

    public String getIdxTrunkID() {
        return idxTrunkID;
    }

    public void setIdxTrunkID(String idxTrunkID) {
        this.idxTrunkID = idxTrunkID == null ? null : idxTrunkID.trim();
    }

    public Integer getHangupPart() {
        return hangupPart;
    }

    public void setHangupPart(Integer hangupPart) {
        this.hangupPart = hangupPart;
    }

    public String getHangupReason() {
        return hangupReason;
    }

    public void setHangupReason(String hangupReason) {
        this.hangupReason = hangupReason == null ? null : hangupReason.trim();
    }

    public String getIdxVSWID() {
        return idxVSWID;
    }

    public void setIdxVSWID(String idxVSWID) {
        this.idxVSWID = idxVSWID == null ? null : idxVSWID.trim();
    }

    public String getIdxGoIPID() {
        return idxGoIPID;
    }

    public void setIdxGoIPID(String idxGoIPID) {
        this.idxGoIPID = idxGoIPID == null ? null : idxGoIPID.trim();
    }

    public String getIdxSimPID() {
        return idxSimPID;
    }

    public void setIdxSimPID(String idxSimPID) {
        this.idxSimPID = idxSimPID == null ? null : idxSimPID.trim();
    }

    public String getIdxSimCardID() {
        return idxSimCardID;
    }

    public void setIdxSimCardID(String idxSimCardID) {
        this.idxSimCardID = idxSimCardID == null ? null : idxSimCardID.trim();
    }

    public String getIdxSMSGate() {
        return idxSMSGate;
    }

    public void setIdxSMSGate(String idxSMSGate) {
        this.idxSMSGate = idxSMSGate == null ? null : idxSMSGate.trim();
    }

    public String getIdxVAPPID() {
        return idxVAPPID;
    }

    public void setIdxVAPPID(String idxVAPPID) {
        this.idxVAPPID = idxVAPPID == null ? null : idxVAPPID.trim();
    }

    public String getIdxViFiID() {
        return idxViFiID;
    }

    public void setIdxViFiID(String idxViFiID) {
        this.idxViFiID = idxViFiID == null ? null : idxViFiID.trim();
    }

    public String getIspID() {
        return ispID;
    }

    public void setIspID(String ispID) {
        this.ispID = ispID == null ? null : ispID.trim();
    }

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId == null ? null : cellId.trim();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getPubIP() {
        return pubIP;
    }

    public void setPubIP(String pubIP) {
        this.pubIP = pubIP == null ? null : pubIP.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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
