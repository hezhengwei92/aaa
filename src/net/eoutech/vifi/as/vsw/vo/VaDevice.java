package net.eoutech.vifi.as.vsw.vo;

/**
 * Created by SUU on 2016/6/16.
 */
public class VaDevice {

    protected String id;
    protected String pass;
    protected Integer expire;
    protected Long lastUpdateTime;

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
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

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime( Long lastUpdateTime ) {
        this.lastUpdateTime = lastUpdateTime;
    }

}
