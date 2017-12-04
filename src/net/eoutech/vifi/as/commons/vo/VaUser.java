package net.eoutech.vifi.as.commons.vo;

import java.util.List;

/**
 * Created by SUU on 2016/5/26.
 */
public class VaUser {

    private String uid;
    private String pass;
    private String countryCode;
    private Integer balance;
    private Integer expire;
    private Integer appState;
    private String lastOnlineIP;
    private Integer lastOnlinePort;
    private String lastAppDevInfo;
    private String pushToken;
    private Long lastOnlineTime;
    private String vpxId;
    private String firstAgentId;
    private String lastAgentId;
    private Integer lastAgentDiscount;

    private Integer dailyRentalID = 0;
    private Integer todayMaxData;
    private Integer monthMaxData;
    private Integer monthUUWiFiData = 0;
    private Integer todayUUWiFiData = 0;
    private Integer totalSuiteValue = 0;
    private List< VaUserSuite > userSuites;

    public boolean outMaxTodayData () {
        return todayMaxData != null && todayMaxData != 0 && todayUUWiFiData >= todayMaxData;
    }

    public boolean outMaxMonthData () {
        return monthMaxData != null && monthMaxData != 0 && monthUUWiFiData >= monthMaxData;
    }

    public String getUid() {
        return uid;
    }

    public void setUid( String uid ) {
        this.uid = uid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass( String pass ) {
        this.pass = pass;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode( String countryCode ) {
        this.countryCode = countryCode;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance( Integer balance ) {
        this.balance = balance;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire( Integer expire ) {
        this.expire = expire;
    }

    public Integer getAppState() {
        return appState;
    }

    public void setAppState( Integer appState ) {
        this.appState = appState;
    }

    public String getLastOnlineIP() {
        return lastOnlineIP;
    }

    public void setLastOnlineIP( String lastOnlineIP ) {
        this.lastOnlineIP = lastOnlineIP;
    }

    public Integer getLastOnlinePort() {
        return lastOnlinePort;
    }

    public void setLastOnlinePort( Integer lastOnlinePort ) {
        this.lastOnlinePort = lastOnlinePort;
    }

    public String getLastAppDevInfo() {
        return lastAppDevInfo;
    }

    public void setLastAppDevInfo( String lastAppDevInfo ) {
        this.lastAppDevInfo = lastAppDevInfo;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken( String pushToken ) {
        this.pushToken = pushToken;
    }

    public Long getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime( Long lastOnlineTime ) {
        this.lastOnlineTime = lastOnlineTime;
    }

    public String getVpxId() {
        return vpxId;
    }

    public void setVpxId( String vpxId ) {
        this.vpxId = vpxId;
    }

    public String getFirstAgentId() {
        return firstAgentId;
    }

    public void setFirstAgentId( String firstAgentId ) {
        this.firstAgentId = firstAgentId;
    }

    public String getLastAgentId() {
        return lastAgentId;
    }

    public void setLastAgentId( String lastAgentId ) {
        this.lastAgentId = lastAgentId;
    }

    public Integer getLastAgentDiscount() {
        return lastAgentDiscount;
    }

    public void setLastAgentDiscount( Integer lastAgentDiscount ) {
        this.lastAgentDiscount = lastAgentDiscount;
    }

    public Integer getDailyRentalID() {
        return dailyRentalID;
    }

    public void setDailyRentalID( Integer dailyRentalID ) {
        this.dailyRentalID = dailyRentalID;
    }

    public Integer getTodayUUWiFiData() {
        return todayUUWiFiData;
    }

    public void setTodayUUWiFiData( Integer todayUUWiFiData ) {
        this.todayUUWiFiData = todayUUWiFiData;
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

    public Integer getTotalSuiteValue() {
        return totalSuiteValue;
    }

    public void setTotalSuiteValue( Integer totalSuiteValue ) {
        this.totalSuiteValue = totalSuiteValue;
    }

    public List< VaUserSuite > getUserSuites() {
        return userSuites;
    }

    public void setUserSuites( List< VaUserSuite > userSuites ) {
        this.userSuites = userSuites;
    }

    public Integer getMonthMaxData() {
        return monthMaxData;
    }

    public void setMonthMaxData( Integer monthMaxData ) {
        this.monthMaxData = monthMaxData;
    }
}
