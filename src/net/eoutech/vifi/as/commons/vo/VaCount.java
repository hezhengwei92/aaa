package net.eoutech.vifi.as.commons.vo;

/**
 * Created by SUU on 2016/6/1.
 */
public class VaCount {

    private Integer countType;
    private String userId;
    private String deviceId;
    private Integer cost;

    //call
    private String callType;
    private boolean isFailedCall = true;
    private boolean isShortCall;
    private int callDuration;

    //data
    private Integer dataUp;
    private Integer dataDown;
    private Integer data;
    private Integer deviceDur;

    //sms
    private Integer smsMode;

    public Integer getCountType() {
        return countType;
    }

    public void setCountType( Integer countType ) {
        this.countType = countType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId ) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId( String deviceId ) {
        this.deviceId = deviceId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost( Integer cost ) {
        this.cost = cost;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType( String callType ) {
        this.callType = callType;
    }

    public boolean isFailedCall() {
        return isFailedCall;
    }

    public void setFailedCall( boolean failedCall ) {
        isFailedCall = failedCall;
    }

    public boolean isShortCall() {
        return isShortCall;
    }

    public void setShortCall( boolean shortCall ) {
        isShortCall = shortCall;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration( int callDuration ) {
        this.callDuration = callDuration;
    }

    public Integer getDataUp() {
        return dataUp;
    }

    public void setDataUp( Integer dataUp ) {
        this.dataUp = dataUp;
    }

    public Integer getDataDown() {
        return dataDown;
    }

    public void setDataDown( Integer dataDown ) {
        this.dataDown = dataDown;
    }

    public Integer getData() {
        return data;
    }

    public void setData( Integer data ) {
        this.data = data;
    }

    public Integer getDeviceDur() {
        return deviceDur;
    }

    public void setDeviceDur( Integer deviceDur ) {
        this.deviceDur = deviceDur;
    }

    public Integer getSmsMode() {
        return smsMode;
    }

    public void setSmsMode( Integer smsMode ) {
        this.smsMode = smsMode;
    }
}
