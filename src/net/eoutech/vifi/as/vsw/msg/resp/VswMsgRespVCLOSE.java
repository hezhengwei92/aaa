package net.eoutech.vifi.as.vsw.msg.resp;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqVCLOSE;

public class VswMsgRespVCLOSE extends VswMsgRespBase {

    private String from;
    private String to;
    private Integer chn_id;
    private String goip_slot;
    private String sim_status;
    private Integer block_time;
    private String led_action;

    public VswMsgRespVCLOSE( VaMsgReq req ) {
        super( req );

        // TODO

        this.setDid( 0 );
        this.setProto( ( ( VswMsgReqVCLOSE ) req ).getProto() );
        this.setCseq( ( ( VswMsgReqVCLOSE ) req ).getCseq() );

        this.from = ( ( VswMsgReqVCLOSE ) req ).getFrom();
        this.setTo( ( ( VswMsgReqVCLOSE ) req ).getTo() );
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

    public void setChn_id( Integer chn_id ) {
        this.chn_id = chn_id;
    }

    public Integer getChn_id() {
        return chn_id;
    }

    public void setGoip_slot( String goip_slot ) {
        this.goip_slot = goip_slot;
    }

    public String getGoip_slot() {
        return goip_slot;
    }

    public void setSim_status( String sim_status ) {
        this.sim_status = sim_status;
    }

    public String getSim_status() {
        return sim_status;
    }

    public void setBlock_time( Integer block_time ) {
        this.block_time = block_time;
    }

    public Integer getBlock_time() {
        return block_time;
    }

    public void setLed_action( String led_action ) {
        this.led_action = led_action;
    }

    public String getLed_action() {
        return led_action;
    }

    public StringBuilder toJSONString() {
        StringBuilder json = super.toJSONString();
        json = new StringBuilder( json.substring( 0, json.length() - 1 ) ).append( "," )
                .append( toStrJS( "from", from, "," ) )
                .append( toStrJS( "to", to, "," ) )
                .append( toIntJS( "chn_id", chn_id, "," ) )
                .append( toStrJS( "goip_slot", goip_slot, "," ) )
                .append( toStrJS( "sim_status", sim_status, "," ) )
                .append( toIntJS( "block_time", block_time, "," ) )
                .append( toStrJS( "led_action", led_action, "}" ) );
        return json;
    }


}
