package net.eoutech.vifi.as.vsw.vo;

import net.eoutech.vifi.as.commons.entity.TbVSW;

/**
 * Created by SUU on 2016/5/26.
 */
public class VaVSW {

    private String id;
    private String hostname;
    private String pass;
    private Integer expire;
    private Long lastUpdate;
    private String state;
    private String ip;
    private Integer port;
    private String pro;
    private String countryCode;

    public VaVSW( String id ) {
        this.id = id;
    }

    public VaVSW( String id, String hostname, String pass, Integer expire, Long lastUpdate, String state, String ip, Integer port, String countryCode ) {
        this.id = id;
        this.hostname = hostname;
        this.pass = pass;
        this.expire = expire;
        this.lastUpdate = lastUpdate;
        this.state = state;
        this.ip = ip;
        this.port = port;
        this.countryCode = countryCode;
    }

    public VaVSW( TbVSW vsw ) {
        this.id = vsw.getKeyVSWID();
        this.hostname = vsw.getHostname();
        this.pass = vsw.getVswpwd();
        this.expire = vsw.getExpire();
        this.lastUpdate = vsw.getLastHBTime().getTime();
        this.state = vsw.getState();
        this.ip = vsw.getPublicIP();
        this.port = vsw.getPublicPort();
        this.pro = vsw.getVswProtocol();
        this.countryCode = vsw.getCountryCode();
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname( String hostname ) {
        this.hostname = hostname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass( String pass ) {
        this.pass = pass;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire( Integer expire ) {
        this.expire = expire;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate( Long lastUpdate ) {
        this.lastUpdate = lastUpdate;
    }

    public String getState() {
        return state;
    }

    public void setState( String state ) {
        this.state = state;
    }

    public String getIp() {
        return ip;
    }

    public void setIp( String ip ) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort( Integer port ) {
        this.port = port;
    }

    public String getPro() {
        return pro;
    }

    public void setPro( String pro ) {
        this.pro = pro;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode( String countryCode ) {
        this.countryCode = countryCode;
    }
}
