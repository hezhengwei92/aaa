package net.eoutech.vifi.as.vsw.vo;

/**
 * Created by SUU on 2016/5/27.
 */
public class VaPort {

    protected Integer id;
    protected String deviceId;
    protected Integer slotNum;
    protected Integer status;
    protected String vid;
    protected String iccid;
    protected Integer duration;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId( String deviceId ) {
        this.deviceId = deviceId;
    }

    public Integer getSlotNum() {
        return slotNum;
    }

    public void setSlotNum( Integer slotNum ) {
        this.slotNum = slotNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    public String getVid() {
        return vid;
    }

    public void setVid( String vid ) {
        this.vid = vid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid( String iccid ) {
        this.iccid = iccid;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration( Integer duration ) {
        this.duration = duration;
    }
}
