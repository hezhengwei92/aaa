package net.eoutech.vifi.as.commons.vo;

import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.entity.TbCDR;

import java.util.Date;

/**
 * Created by SUU on 2016/5/31.
 */
public class VaCDR {
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

    /**
     * CALL CDR....
     */
    public VaCDR( String idxUserId, String idxDeductUserId, String cdrType, String direction, String distance, Integer idxRateId, String suiteRateIds, Integer dailyRentalID, String dnis, String caller, String callee, Date startTime, Date answerTime, Date stopTime, Integer callDuration, Integer costCash, Integer costReward, Integer bonus, String idxSupplierId, Integer supplierDiscount, String idxAgentID, Integer agentDiscount, String idxCallID, String idxVPXID, String idxTrunkID, Integer hangupPart, String hangupReason, String idxGoIPID, String idxVAPPID, String countryCode, String pubIP, String area, Date crtTm, String crtBy ) {
        this.idxUserId = idxUserId;
        this.idxDeductUserId = idxDeductUserId;
        this.cdrType = cdrType;
        this.direction = direction;
        this.distance = distance;
        this.idxRateId = idxRateId;
        this.suiteRateIds = suiteRateIds;
        this.dailyRentalID = dailyRentalID;
        this.dnis = dnis;
        this.caller = caller;
        this.callee = callee;
        this.startTime = startTime;
        this.answerTime = answerTime;
        this.stopTime = stopTime;
        this.callDuration = callDuration;
        this.costCash = costCash;
        this.costReward = costReward;
        this.bonus = bonus;
        this.idxSupplierId = idxSupplierId;
        this.supplierDiscount = supplierDiscount;
        this.idxAgentID = idxAgentID;
        this.agentDiscount = agentDiscount;
        this.idxCallID = idxCallID;
        this.idxVPXID = idxVPXID;
        this.idxTrunkID = idxTrunkID;
        this.hangupPart = hangupPart;
        this.hangupReason = hangupReason;
        this.idxGoIPID = idxGoIPID;
        this.idxVAPPID = idxVAPPID;
        this.countryCode = countryCode;
        this.pubIP = pubIP;
        this.area = area;
        this.crtTm = crtTm;
        this.crtBy = crtBy;
    }

    /**
     * call cdr
     * @param cdr
     */
    public VaCDR( TbCDR cdr ) {
        this.keyCDRID = cdr.getKeyCDRID();
        this.idxUserId = cdr.getIdxUserId();
        this.idxDeductUserId = cdr.getIdxDeductUserId();
        this.cdrType = cdr.getCdrType();
        this.direction = cdr.getDirection();
        this.distance = cdr.getDistance();
        this.idxRateId = cdr.getIdxRateId();
        this.suiteRateIds = cdr.getSuiteRateIds();
        this.dailyRentalID = cdr.getDailyRentalID();
        this.dnis = cdr.getDnis();
        this.caller = cdr.getCaller();
        this.callee = cdr.getCallee();
        this.startTime = cdr.getStartTime();
        this.answerTime = cdr.getAnswerTime();
        this.stopTime = cdr.getStopTime();
        this.callDuration = cdr.getCallDuration();
        this.costCash = cdr.getCostCash();
        this.costReward = cdr.getCostReward();
        this.bonus = cdr.getBonus();
        this.idxSupplierId = cdr.getIdxSupplierId();
        this.supplierDiscount = cdr.getSupplierDiscount();
        this.idxAgentID = cdr.getIdxAgentID();
        this.agentDiscount = cdr.getAgentDiscount();
        this.idxCallID = cdr.getIdxCallID();
        this.idxVPXID = cdr.getIdxVPXID();
        this.idxTrunkID = cdr.getIdxTrunkID();
        this.hangupPart = cdr.getHangupPart();
        this.hangupReason = cdr.getHangupReason();
        this.idxGoIPID = cdr.getIdxGoIPID();
        this.idxVAPPID = cdr.getIdxVAPPID();
        this.countryCode = cdr.getCountryCode();
        this.pubIP = cdr.getPubIP();
        this.area = cdr.getArea();
        this.crtTm = cdr.getCrtTm();
        this.crtBy = cdr.getCrtBy();
        this.uuwifiDataDown=cdr.getUuwifiDataDown();
        this.uuwifiDataUp=cdr.getUuwifiDataUp();
    }

    /**
     * DATA CDR.....
     */
    public VaCDR( String idxUserId, String idxDeductUserId, String cdrType, Integer idxRateId, String suiteRateIds, Integer dailyRentalID, Integer dataTraffic, Integer uuwifiDataUp, Integer uuwifiDataDown, String uuwifiSessId, Integer costCash, Integer costReward, Integer bonus, String idxSupplierId, Integer supplierDiscount, String idxAgentID, Integer agentDiscount, String idxVSWID, String idxSimPID, String idxSimCardID, String idxVAPPID, String idxViFiID, String ispID, String cellId, String countryCode, String pubIP, String area, Double longitude, Double latitude, Date crtTm, String crtBy ) {
        this.idxUserId = idxUserId;
        this.idxDeductUserId = idxDeductUserId;
        this.cdrType = cdrType;
        this.idxRateId = idxRateId;
        this.suiteRateIds = suiteRateIds;
        this.dailyRentalID = dailyRentalID;
        this.dataTraffic = dataTraffic;
        this.uuwifiDataUp = uuwifiDataUp;
        this.uuwifiDataDown = uuwifiDataDown;
        this.uuwifiSessId = uuwifiSessId;
        this.costCash = costCash;
        this.costReward = costReward;
        this.bonus = bonus;
        this.idxSupplierId = idxSupplierId;
        this.supplierDiscount = supplierDiscount;
        this.idxAgentID = idxAgentID;
        this.agentDiscount = agentDiscount;
        this.idxVSWID = idxVSWID;
        this.idxSimPID = idxSimPID;
        this.idxSimCardID = idxSimCardID;
        this.idxVAPPID = idxVAPPID;
        this.idxViFiID = idxViFiID;
        this.ispID = ispID;
        this.cellId = cellId;
        this.countryCode = countryCode;
        this.pubIP = pubIP;
        this.area = area;
        this.longitude = longitude;
        this.latitude = latitude;
        this.crtTm = crtTm;
        this.crtBy = crtBy;
        this.direction = VaConst.Tables.TBCDR_DIRECTION_UNKNOWN;
    }

    public VaCDR( String idxUserId, String idxDeductUserId, String cdrType, Integer idxRateId, String suiteRateIds, Integer dailyRentalID, Integer costCash, Integer costReward, Integer bonus, String idxSupplierId, Integer supplierDiscount, String idxAgentID, Integer agentDiscount, String idxSMSGate, String idxVAPPID, String countryCode, String pubIP, String area, Date crtTm, String crtBy ) {
        this.idxUserId = idxUserId;
        this.idxDeductUserId = idxDeductUserId;
        this.cdrType = cdrType;
        this.idxRateId = idxRateId;
        this.suiteRateIds = suiteRateIds;
        this.dailyRentalID = dailyRentalID;
        this.costCash = costCash;
        this.costReward = costReward;
        this.bonus = bonus;
        this.idxSupplierId = idxSupplierId;
        this.supplierDiscount = supplierDiscount;
        this.idxAgentID = idxAgentID;
        this.agentDiscount = agentDiscount;
        this.idxSMSGate = idxSMSGate;
        this.idxVAPPID = idxVAPPID;
        this.countryCode = countryCode;
        this.pubIP = pubIP;
        this.area = area;
        this.crtTm = crtTm;
        this.crtBy = crtBy;
    }

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

    public String getCellId() {
        return cellId;
    }

    public void setCellId( String cellId ) {
        this.cellId = cellId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude( Double longitude ) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude( Double latitude ) {
        this.latitude = latitude;
    }
}
