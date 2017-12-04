package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbSimCard {
    private String keySimCardID;

    private String idxSCGroupID;

    private String idxIccid;

    private String imsi;

    private String imei;

    private Integer ssId;

    private Integer status;

    private String bindType;

    private String number;

    private Integer balance;

    private Integer restNetData;

    private Integer restCallDur;

    private Integer restSMSNum;

    private Integer onlineTime;

    private Integer outCalls;

    private Integer outCallDuration;

    private Integer inCalls;

    private Integer inCallDuration;

    private Integer successCalls;

    private Integer failedCalls;

    private Integer shortCalls;

    private Integer contFailedCalls;

    private Integer totalSuccess;

    private Integer totalFailed;

    private Integer contFailed;

    private Integer totalData;

    private Date lastIdleTime;

    private String exActions;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    private byte[] cardATR;

    private String idxAgentID;

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID;
    }
    public String getKeySimCardID() {
        return keySimCardID;
    }

    public void setKeySimCardID(String keySimCardID) {
        this.keySimCardID = keySimCardID == null ? null : keySimCardID.trim();
    }

    public String getIdxSCGroupID() {
        return idxSCGroupID;
    }

    public void setIdxSCGroupID(String idxSCGroupID) {
        this.idxSCGroupID = idxSCGroupID == null ? null : idxSCGroupID.trim();
    }

    public String getIdxIccid() {
        return idxIccid;
    }

    public void setIdxIccid(String idxIccid) {
        this.idxIccid = idxIccid == null ? null : idxIccid.trim();
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi == null ? null : imsi.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public Integer getSsId() {
        return ssId;
    }

    public void setSsId(Integer ssId) {
        this.ssId = ssId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBindType() {
        return bindType;
    }

    public void setBindType(String bindType) {
        this.bindType = bindType == null ? null : bindType.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getRestNetData() {
        return restNetData;
    }

    public void setRestNetData(Integer restNetData) {
        this.restNetData = restNetData;
    }

    public Integer getRestCallDur() {
        return restCallDur;
    }

    public void setRestCallDur(Integer restCallDur) {
        this.restCallDur = restCallDur;
    }

    public Integer getRestSMSNum() {
        return restSMSNum;
    }

    public void setRestSMSNum(Integer restSMSNum) {
        this.restSMSNum = restSMSNum;
    }

    public Integer getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Integer onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Integer getOutCalls() {
        return outCalls;
    }

    public void setOutCalls(Integer outCalls) {
        this.outCalls = outCalls;
    }

    public Integer getOutCallDuration() {
        return outCallDuration;
    }

    public void setOutCallDuration(Integer outCallDuration) {
        this.outCallDuration = outCallDuration;
    }

    public Integer getInCalls() {
        return inCalls;
    }

    public void setInCalls(Integer inCalls) {
        this.inCalls = inCalls;
    }

    public Integer getInCallDuration() {
        return inCallDuration;
    }

    public void setInCallDuration(Integer inCallDuration) {
        this.inCallDuration = inCallDuration;
    }

    public Integer getSuccessCalls() {
        return successCalls;
    }

    public void setSuccessCalls(Integer successCalls) {
        this.successCalls = successCalls;
    }

    public Integer getFailedCalls() {
        return failedCalls;
    }

    public void setFailedCalls(Integer failedCalls) {
        this.failedCalls = failedCalls;
    }

    public Integer getShortCalls() {
        return shortCalls;
    }

    public void setShortCalls(Integer shortCalls) {
        this.shortCalls = shortCalls;
    }

    public Integer getContFailedCalls() {
        return contFailedCalls;
    }

    public void setContFailedCalls(Integer contFailedCalls) {
        this.contFailedCalls = contFailedCalls;
    }

    public Integer getTotalSuccess() {
        return totalSuccess;
    }

    public void setTotalSuccess(Integer totalSuccess) {
        this.totalSuccess = totalSuccess;
    }

    public Integer getTotalFailed() {
        return totalFailed;
    }

    public void setTotalFailed(Integer totalFailed) {
        this.totalFailed = totalFailed;
    }

    public Integer getContFailed() {
        return contFailed;
    }

    public void setContFailed(Integer contFailed) {
        this.contFailed = contFailed;
    }

    public Integer getTotalData() {
        return totalData;
    }

    public void setTotalData(Integer totalData) {
        this.totalData = totalData;
    }

    public Date getLastIdleTime() {
        return lastIdleTime;
    }

    public void setLastIdleTime(Date lastIdleTime) {
        this.lastIdleTime = lastIdleTime;
    }

    public String getExActions() {
        return exActions;
    }

    public void setExActions(String exActions) {
        this.exActions = exActions == null ? null : exActions.trim();
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

    public byte[] getCardATR() {
        return cardATR;
    }
    public void setCardATR(byte[] cardATR) {
        this.cardATR = cardATR;
    }
}