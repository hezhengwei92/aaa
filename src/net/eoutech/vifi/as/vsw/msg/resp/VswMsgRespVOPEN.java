package net.eoutech.vifi.as.vsw.msg.resp;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqVOPEN;

public class VswMsgRespVOPEN extends VswMsgRespBase {

    private String sessid;
    private String simpname = "NUL";
    private String from;
    private String to;
    private Integer sim_slot = 0;
    private String ip;
    private int port;
    private int exp;
    private String goipname = "NUL";
    private int goip_slot = 0;
    private String goipns = "NUL";
    private String simpns = "NUL";

    //新增
    private String hot_num = "NUL";
    private int sidExp = 600;

    public VswMsgRespVOPEN( VaMsgReq req ) {

        super( req );

        this.setProto( ( ( VswMsgReqVOPEN ) req ).getProto() );
        this.setCseq( ( ( VswMsgReqVOPEN ) req ).getCseq() );
        this.from = ( ( VswMsgReqVOPEN ) req ).getFrom();
        this.to = ( ( VswMsgReqVOPEN ) req ).getTo();
        this.sessid = ( ( VswMsgReqVOPEN ) req ).getSessid();
    }

    public String getSessid() {
        return sessid;
    }

    public void setSessid( String sessid ) {
        this.sessid = sessid;
    }

    public String getSimpname() {
        return simpname;
    }

    public void setSimpname( String simpname ) {
        this.simpname = simpname;
    }

    public void setFrom( String from ) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setTo( String to ) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setSim_slot( Integer sim_slot ) {
        this.sim_slot = sim_slot;
    }

    public Integer getSim_slot() {
        return sim_slot;
    }

    public String getIp() {
        return ip;
    }

    public void setIp( String ip ) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort( int port ) {
        this.port = port;
    }

    public int getExp() {
        return exp;
    }

    public void setExp( int exp ) {
        this.exp = exp;
    }

    public String getGoipname() {
        return goipname;
    }

    public void setGoipname( String goipname ) {
        this.goipname = goipname;
    }

    public int getGoip_slot() {
        return goip_slot;
    }

    public void setGoip_slot( int goip_slot ) {
        this.goip_slot = goip_slot;
    }


    public String getGoipns() {
        return goipns;
    }

    public void setGoipns( String goipns ) {
        this.goipns = goipns;
    }

    public String getSimpns() {
        return simpns;
    }

    public void setSimpns( String simpns ) {
        this.simpns = simpns;
    }

    public String getHot_num() {
        return hot_num;
    }


    public void setHot_num( String hot_num ) {
        this.hot_num = hot_num;
    }

    public int getSidExp() {
        return sidExp;
    }

    public void setSidExp( int sidExp ) {
        this.sidExp = sidExp;
    }

    public StringBuilder toJSONString() {
        StringBuilder json = super.toJSONString();
        json = new StringBuilder( json.substring( 0, json.length() - 1 ) ).append( "," )
                .append( toStrJS( "from", from, "," ) )
                .append( toStrJS( "to", to, "," ) )
                .append( toStrJS( "sessid", sessid, "," ) )
                .append( toStrJS( "simpname", simpname, "," ) )
                .append( toStrJS( "ip", ip, "," ) )
                .append( toIntJS( "port", port, "," ) )
                .append( toIntJS( "expires", exp, "," ) )
                .append( toStrJS( "goipname", goipname, "," ) )
                .append( toIntJS( "goip_slot", goip_slot, "," ) )
                .append( toStrJS( "goipns", goipns, "," ) )
                .append( toStrJS( "simpns", simpns, "," ) )
                .append( toIntJS( "sim_slot", sim_slot, "," ) )
                .append( toIntJS( "sidexp", sidExp, "," ) )
                .append( toStrJS( "hot_num", hot_num, "}" ) );
        return json;
    }

}
