package net.eoutech.vifi.as.vns.msg.req;

import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.enums.VaMsgType;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqBase;
import org.apache.commons.lang.StringUtils;

/**
 * Created by SUU on 2016/3/8.
 */
public class VnsMsgReqGET extends VswMsgReqBase {

    private String msg;
    private int seq;
    private String tgt;
    private String vid;
    private String sid;
    private Integer opi = 0;
    private String iccid = "";
    private String imsi = "";
    private String rsp;

    // 新增
    private Integer mcc = 0;
    private Integer mnc = 0;
    private Integer cellid = 0;
    private Integer lac = 0;

    private Integer lfc = 0;

    @Override
    public VaMsgType getMsgType() {
        return VaMsgType.msgValueOf(msg);
    }

    @Override
    public boolean checkReqData() {
        if ( StringUtils.isBlank( vid ) || StringUtils.isBlank( tgt ) || StringUtils.isBlank( getFIP() ) ) {
            return false;
        }
        if ( VaConst.Request.GET_SESSTYPE_MOD.equals( tgt ) ) {
            this.tgt = VaConst.Request.GET_SESSTYPE_GOIP;
        }
        if ( !VaConst.Request.GET_SESSTYPE_GOIP.equals( tgt ) && !VaConst.Request.GET_SESSTYPE_SIMP.equals( tgt ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg( String msg ) {
        this.msg = msg;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq( int seq ) {
        this.seq = seq;
    }

    public String getTgt() {
        return tgt;
    }

    public void setTgt( String tgt ) {
        this.tgt = tgt;
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

    public Integer getOpi() {
        return opi;
    }

    public void setOpi( Integer opi ) {
        this.opi = opi;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid( String iccid ) {
        this.iccid = iccid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi( String imsi ) {
        this.imsi = imsi;
    }

    public String getRsp() {
        return rsp;
    }

    public void setRsp( String rsp ) {
        this.rsp = rsp;
    }

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc( Integer mcc ) {
        this.mcc = mcc;
    }

    public Integer getMnc() {
        return mnc;
    }

    public void setMnc( Integer mnc ) {
        this.mnc = mnc;
    }

    public Integer getCellid() {
        return cellid;
    }

    public void setCellid( Integer cellid ) {
        this.cellid = cellid;
    }

    public Integer getLac() {
        return lac;
    }

    public void setLac( Integer lac ) {
        this.lac = lac;
    }

    public Integer getLfc() {
        return lfc;
    }

    public void setLfc( Integer lfc ) {
        this.lfc = lfc;
    }
}
