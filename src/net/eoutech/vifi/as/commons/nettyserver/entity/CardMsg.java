package net.eoutech.vifi.as.commons.nettyserver.entity;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public class CardMsg {

    private String vid;
    private String iccid;
    private int slotNum;
    private String simPDevID;
    private String ipaddr;
    private int port;
    private int ports;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPorts() {
        return ports;
    }

    public void setPorts(int ports) {
        this.ports = ports;
    }

    public String getSimPDevID() {
        return simPDevID;
    }

    public void setSimPDevID(String simPDevID) {
        this.simPDevID = simPDevID;
    }

    public int getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }
}
