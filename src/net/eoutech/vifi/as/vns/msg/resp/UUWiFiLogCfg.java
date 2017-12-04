package net.eoutech.vifi.as.vns.msg.resp;

/**
 * Created by SUU on 2016/7/20.
 */
public class UUWiFiLogCfg {

    private Integer log;
    private String log_ip;
    private Integer log_port;
    private String log_id;
    private String log_pro;

    public UUWiFiLogCfg( String log_ip, Integer log_port, String log_pro ) {
        this.log_ip = log_ip;
        this.log_port = log_port;
        this.log_pro = log_pro;
    }

    public Integer getLog() {
        return log;
    }

    public void setLog( Integer log ) {
        this.log = log;
    }

    public String getLog_ip() {
        return log_ip;
    }

    public void setLog_ip( String log_ip ) {
        this.log_ip = log_ip;
    }

    public Integer getLog_port() {
        return log_port;
    }

    public void setLog_port( Integer log_port ) {
        this.log_port = log_port;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id( String log_id ) {
        this.log_id = log_id;
    }

    public String getLog_pro() {
        return log_pro;
    }

    public void setLog_pro( String log_pro ) {
        this.log_pro = log_pro;
    }
}
