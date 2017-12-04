
package net.eoutech.vifi.as.vsw.msg.req;

import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.enums.VaMsgType;
import org.apache.commons.lang.StringUtils;

public class VswMsgReqSPUBLISH extends VswMsgReqBase {


    private Integer cseq;
    private String username;
    private Integer sim_slot;
    private Integer has_sim;
    private String iccid = "";
    private String imsi = "";
    private String content_encoding;
    private String content_type;
    private String content_length;
    private Integer tid;
    private Integer status;
//    private byte[] cardATR;
    private int[] cardATR;
    public void setStatus(Integer status){
        this.status=status;
    }

    public Integer getStatus(){
        return status;
    }

    public void setCseq( Integer cseq ) {
        this.cseq = cseq;
    }
    public Integer getCseq() {
        return cseq;
    }

    public void setUsername( String username ) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setSim_slot( int sim_slot ) {
        this.sim_slot = sim_slot;
    }
    public int getSim_slot() {
        return sim_slot;
    }

    public void setHas_sim( Integer has_sim ) {
        this.has_sim = has_sim;
    }
    public Integer getHas_sim() {
        return has_sim;
    }

    public void setIccid( String iccid ) {
        this.iccid = iccid;
    }
    public String getIccid() {
        return iccid;
    }

    public void setImsi( String imsi ) {
        this.imsi = imsi;
    }
    public String getImsi() {
        return imsi;
    }

    public void setContent_encoding( String content_encoding ) {
        this.content_encoding = content_encoding;
    }
    public String getContent_encoding() {
        return content_encoding;
    }

    public void setContent_type( String content_type ) {
        this.content_type = content_type;
    }
    public String getContent_type() {
        return content_type;
    }

    public void setContent_length( String content_length ) {
        this.content_length = content_length;
    }
    public String getContent_length() {
        return content_length;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid( Integer tid ) {
        this.tid = tid;
    }

//    public byte[] getCardATR() {
//        return cardATR;
//    }
//
//    public void setCardATR( byte[] cardATR ) {
//        this.cardATR = cardATR;
//    }
    public int[] getCardATR() {
            return cardATR;
        }

        public void setCardATR( int[] cardATR ) {
            this.cardATR = cardATR;
        }
    @Override
    public VaMsgType getMsgType() {
        return VaMsgType.SPUBLISH;
    }

    @Override
    public boolean checkReqData() {
//        || ( StringUtils.isBlank( iccid ) && VaConst.Request.SPUBLISH_HASSIM_PUT == has_sim )
        if ( StringUtils.isEmpty( username ) || sim_slot == null ) {
            return false;
        }
        return true;
    }
}
