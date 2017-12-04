package net.eoutech.vifi.as.vns.msg.resp;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.vns.msg.req.VnsMsgReqGET;
import net.eoutech.vifi.as.vsw.msg.resp.VswMsgRespBase;

import java.util.List;
import java.util.Map;

/**
 * Created by SUU on 2016/3/8.
 */
public class VnsMsgRespGET extends VnsMsgRespBase {

    private int seq;
    private String vid;
    private String sid;
    private int exp;
    private String vsw_ip;
    private int vsw_port;
    private String vsw_pro;
    private int ven;
    private String apn;
    private String num;
    private String usr;
    private String pwd;
    private String actions = VaConst.Common.EMPTY;
    private List< Map< String, String > > cmd;

    // 新增日志返回接口
    private UUWiFiLogCfg logCfg;

    public VnsMsgRespGET( VaMsgReq req ) {
        super( req );
        this.seq = ((VnsMsgReqGET ) req).getSeq();
        this.vid = ((VnsMsgReqGET ) req).getVid();
        this.ven = 1;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq( int seq ) {
        this.seq = seq;
    }

    public String getVid() {
        return vid;
    }

    public void setVid( String vid ) {
        this.vid = vid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid( String sid ) {
        this.sid = sid;
    }

    public int getExp() {
        return exp;
    }

    public void setExp( int exp ) {
        this.exp = exp;
    }

    public String getVsw_ip() {
        return vsw_ip;
    }

    public void setVsw_ip( String vsw_ip ) {
        this.vsw_ip = vsw_ip;
    }

    public int getVsw_port() {
        return vsw_port;
    }

    public void setVsw_port( int vsw_port ) {
        this.vsw_port = vsw_port;
    }

    public String getVsw_pro() {
        return vsw_pro;
    }

    public void setVsw_pro( String vsw_pro ) {
        this.vsw_pro = vsw_pro;
    }

    public int getVen() {
        return ven;
    }

    public void setVen( int ven ) {
        this.ven = ven;
    }

    public String getApn() {
        return apn;
    }

    public void setApn( String apn ) {
        this.apn = apn;
    }

    public String getNum() {
        return num;
    }

    public void setNum( String num ) {
        this.num = num;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr( String usr ) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd( String pwd ) {
        this.pwd = pwd;
    }

    public String getActions() {
        return actions;
    }

    public void setActions( String actions ) {
        this.actions = actions;
    }

    public List< Map< String, String > > getCmd() {
        return cmd;
    }

    public void setCmd( List< Map< String, String > > cmd ) {
        this.cmd = cmd;
    }

    public UUWiFiLogCfg getLogCfg() {
        return logCfg;
    }

    public void setLogCfg( UUWiFiLogCfg logCfg ) {
        this.logCfg = logCfg;
    }

    public StringBuilder toJSONString() {
        StringBuilder json = super.toJSONString();
        json = new StringBuilder(json.substring(0, json.length() - 1)).append(",").append(toIntJS("seq", seq, ","))
                .append(toStrJS("vid", vid, ",")).append(toStrJS("sid", sid, ",")).append(toIntJS("exp", exp, ","))
                .append(toIntJS("ven", ven, ",")).append(toStrJS("dp_apn", apn, ","))
                .append(toStrJS("dp_num", num, ",")).append(toStrJS("dp_usr", usr, ","))
                .append(toStrJS("dp_pwd", pwd, ",")).append(toStrJS("action", actions, ","));

        if ( cmd != null && cmd.size() != 0 ) {
            for (Map<String, String> map : cmd) {

                for ( Map.Entry< String, String > entry : map.entrySet() ) {
                    json.append( toStrJS( entry.getKey(), entry.getValue(), "" ) );
                }

            }
        }

        if ( logCfg == null ) {
        	logCfg = new UUWiFiLogCfg( VaConst.Common.EMPTY, 0, VaConst.Common.EMPTY );
        	logCfg.setLog( 0 );
        	logCfg.setLog_id( "" );
            json.append( toObjJS( "set", logCfg , "," ) );
        } else {
            json.append( toObjJS( "set", logCfg, "," ) );
        }

        json.append( toStrJS( "vsw_pro", vsw_pro, "," ) ).append(toStrJS("vsw_ip", vsw_ip, ",")).append(toIntJS("vsw_port", vsw_port, "}"));
        return json;
    }
}
