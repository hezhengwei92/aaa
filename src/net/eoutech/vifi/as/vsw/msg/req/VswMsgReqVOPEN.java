
package net.eoutech.vifi.as.vsw.msg.req;

import net.eoutech.vifi.as.commons.enums.VaMsgType;
import org.apache.commons.lang.StringUtils;

public class VswMsgReqVOPEN extends VswMsgReqBase {

    private Integer cseq;
    private String from;
    private String to;
    private String sessid;

    public void setCseq( Integer cseq ) {
        this.cseq = cseq;
    }
    public Integer getCseq() {
        return cseq;
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

    public void setSessid( String sessid ) {
        this.sessid = sessid;
    }
    public String getSessid() {
        return sessid;
    }

    @Override
    public VaMsgType getMsgType() {
        return VaMsgType.VOPEN;
    }

    @Override
    public boolean checkReqData() {
        if ( StringUtils.isBlank( from ) || StringUtils.isBlank( sessid ) ) {
            return false;
        }
        return true;
    }
}
