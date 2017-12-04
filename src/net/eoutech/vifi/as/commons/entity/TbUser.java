package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbUser {
    private String keyUserID;

    private String idxAppId;

    private String idxSIPUId;

    private String idxPhoneNumber;

    private String idxAreaCode;

    private String password;

    private String language;

    private String roamAreaCode;

    private Integer roamTimeZone;

    private String idxDomain;

    private String displayNumber;

    private String accountState;

    private Integer appState;

    private Integer vifiState;

    private String idxViFiID;

    private String idxVPXID;

    private String idxVSWID;

    private String idxGoIPPortID;

    private String idxSimpPortID;

    private String idxSimCardID;

    private Integer userBalance;

    private Integer voiceBalance;

    private Integer dataBalance;

    private Integer credit;

    private String idxAgentID;

    private Integer sipExpire;

    private Integer todayMaxData;

    private Integer todayUUWiFiData;

    private Integer monthMaxData;

    private Integer monthUUWiFiData;

    private Date lastUUWiFiDate;

    private Date lastAPPOnlineDate;

    private String lastAPPPublicIP;

    private Integer lastAPPPublicPort;

    private String lastAPPDevInfo;

    private String pushToken;

    private String lastAPPVer;

    private Date lastViFiDate;

    private String lastViFiID;

    private String lastViFiPublicIP;

    private Integer userType;

    private String idxWechatId;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeyUserID() {
        return keyUserID;
    }

    public void setKeyUserID(String keyUserID) {
        this.keyUserID = keyUserID == null ? null : keyUserID.trim();
    }

    public String getIdxAppId() {
        return idxAppId;
    }

    public void setIdxAppId(String idxAppId) {
        this.idxAppId = idxAppId == null ? null : idxAppId.trim();
    }

    public String getIdxSIPUId() {
        return idxSIPUId;
    }

    public void setIdxSIPUId(String idxSIPUId) {
        this.idxSIPUId = idxSIPUId == null ? null : idxSIPUId.trim();
    }

    public String getIdxPhoneNumber() {
        return idxPhoneNumber;
    }

    public void setIdxPhoneNumber(String idxPhoneNumber) {
        this.idxPhoneNumber = idxPhoneNumber == null ? null : idxPhoneNumber.trim();
    }

    public String getIdxAreaCode() {
        return idxAreaCode;
    }

    public void setIdxAreaCode(String idxAreaCode) {
        this.idxAreaCode = idxAreaCode == null ? null : idxAreaCode.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getRoamAreaCode() {
        return roamAreaCode;
    }

    public void setRoamAreaCode(String roamAreaCode) {
        this.roamAreaCode = roamAreaCode == null ? null : roamAreaCode.trim();
    }

    public Integer getRoamTimeZone() {
        return roamTimeZone;
    }

    public void setRoamTimeZone(Integer roamTimeZone) {
        this.roamTimeZone = roamTimeZone;
    }

    public String getIdxDomain() {
        return idxDomain;
    }

    public void setIdxDomain(String idxDomain) {
        this.idxDomain = idxDomain == null ? null : idxDomain.trim();
    }

    public String getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber == null ? null : displayNumber.trim();
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState == null ? null : accountState.trim();
    }

    public Integer getAppState() {
        return appState;
    }

    public void setAppState(Integer appState) {
        this.appState = appState;
    }

    public Integer getVifiState() {
        return vifiState;
    }

    public void setVifiState(Integer vifiState) {
        this.vifiState = vifiState;
    }

    public String getIdxViFiID() {
        return idxViFiID;
    }

    public void setIdxViFiID(String idxViFiID) {
        this.idxViFiID = idxViFiID == null ? null : idxViFiID.trim();
    }

    public String getIdxVPXID() {
        return idxVPXID;
    }

    public void setIdxVPXID(String idxVPXID) {
        this.idxVPXID = idxVPXID == null ? null : idxVPXID.trim();
    }

    public String getIdxVSWID() {
        return idxVSWID;
    }

    public void setIdxVSWID(String idxVSWID) {
        this.idxVSWID = idxVSWID == null ? null : idxVSWID.trim();
    }

    public String getIdxGoIPPortID() {
        return idxGoIPPortID;
    }

    public void setIdxGoIPPortID(String idxGoIPPortID) {
        this.idxGoIPPortID = idxGoIPPortID == null ? null : idxGoIPPortID.trim();
    }

    public String getIdxSimpPortID() {
        return idxSimpPortID;
    }

    public void setIdxSimpPortID(String idxSimpPortID) {
        this.idxSimpPortID = idxSimpPortID == null ? null : idxSimpPortID.trim();
    }

    public String getIdxSimCardID() {
        return idxSimCardID;
    }

    public void setIdxSimCardID(String idxSimCardID) {
        this.idxSimCardID = idxSimCardID == null ? null : idxSimCardID.trim();
    }

    public Integer getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Integer userBalance) {
        this.userBalance = userBalance;
    }

    public Integer getVoiceBalance() {
        return voiceBalance;
    }

    public void setVoiceBalance(Integer voiceBalance) {
        this.voiceBalance = voiceBalance;
    }

    public Integer getDataBalance() {
        return dataBalance;
    }

    public void setDataBalance(Integer dataBalance) {
        this.dataBalance = dataBalance;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID == null ? null : idxAgentID.trim();
    }

    public Integer getSipExpire() {
        return sipExpire;
    }

    public void setSipExpire(Integer sipExpire) {
        this.sipExpire = sipExpire;
    }

    public Integer getTodayMaxData() {
        return todayMaxData;
    }

    public void setTodayMaxData( Integer todayMaxData ) {
        this.todayMaxData = todayMaxData;
    }

    public Integer getMonthUUWiFiData() {
        return monthUUWiFiData;
    }

    public void setMonthUUWiFiData( Integer monthUUWiFiData ) {
        this.monthUUWiFiData = monthUUWiFiData;
    }

    public Integer getMonthMaxData() {
        return monthMaxData;
    }

    public void setMonthMaxData( Integer monthMaxData ) {
        this.monthMaxData = monthMaxData;
    }

    public Integer getTodayUUWiFiData() {
        return todayUUWiFiData;
    }

    public void setTodayUUWiFiData(Integer todayUUWiFiData) {
        this.todayUUWiFiData = todayUUWiFiData;
    }

    public Date getLastUUWiFiDate() {
        return lastUUWiFiDate;
    }

    public void setLastUUWiFiDate(Date lastUUWiFiDate) {
        this.lastUUWiFiDate = lastUUWiFiDate;
    }

    public Date getLastAPPOnlineDate() {
        return lastAPPOnlineDate;
    }

    public void setLastAPPOnlineDate(Date lastAPPOnlineDate) {
        this.lastAPPOnlineDate = lastAPPOnlineDate;
    }

    public String getLastAPPPublicIP() {
        return lastAPPPublicIP;
    }

    public void setLastAPPPublicIP(String lastAPPPublicIP) {
        this.lastAPPPublicIP = lastAPPPublicIP == null ? null : lastAPPPublicIP.trim();
    }

    public Integer getLastAPPPublicPort() {
        return lastAPPPublicPort;
    }

    public void setLastAPPPublicPort(Integer lastAPPPublicPort) {
        this.lastAPPPublicPort = lastAPPPublicPort;
    }

    public String getLastAPPDevInfo() {
        return lastAPPDevInfo;
    }

    public void setLastAPPDevInfo(String lastAPPDevInfo) {
        this.lastAPPDevInfo = lastAPPDevInfo == null ? null : lastAPPDevInfo.trim();
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken( String pushToken ) {
        this.pushToken = pushToken;
    }

    public String getLastAPPVer() {
        return lastAPPVer;
    }

    public void setLastAPPVer(String lastAPPVer) {
        this.lastAPPVer = lastAPPVer == null ? null : lastAPPVer.trim();
    }

    public Date getLastViFiDate() {
        return lastViFiDate;
    }

    public void setLastViFiDate(Date lastViFiDate) {
        this.lastViFiDate = lastViFiDate;
    }

    public String getLastViFiID() {
        return lastViFiID;
    }

    public void setLastViFiID(String lastViFiID) {
        this.lastViFiID = lastViFiID == null ? null : lastViFiID.trim();
    }

    public String getLastViFiPublicIP() {
        return lastViFiPublicIP;
    }

    public void setLastViFiPublicIP(String lastViFiPublicIP) {
        this.lastViFiPublicIP = lastViFiPublicIP == null ? null : lastViFiPublicIP.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getIdxWechatId() {
        return idxWechatId;
    }

    public void setIdxWechatId(String idxWechatId) {
        this.idxWechatId = idxWechatId == null ? null : idxWechatId.trim();
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