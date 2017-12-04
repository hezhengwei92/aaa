package net.eoutech.vifi.as.commons.vo;

import net.eoutech.vifi.as.commons.base.VaMsgResp;

/**
 * Created by SUU on 2016/7/29.
 */
public class VaHoldResp {

    private int tid;
    private long holdTime;
    private VaMsgResp respMsg;

    public VaHoldResp( int tid, long holdTime, VaMsgResp respMsg ) {
        this.tid = tid;
        this.holdTime = holdTime;
        this.respMsg = respMsg;
    }

    public int getTid() {
        return tid;
    }

    public void setTid( int tid ) {
        this.tid = tid;
    }

    public long getHoldTime() {
        return holdTime;
    }

    public void setHoldTime( long holdTime ) {
        this.holdTime = holdTime;
    }

    public VaMsgResp getRespMsg() {
        return respMsg;
    }

    public void setRespMsg( VaMsgResp respMsg ) {
        this.respMsg = respMsg;
    }
}
