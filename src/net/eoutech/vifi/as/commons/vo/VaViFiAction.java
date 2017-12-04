package net.eoutech.vifi.as.commons.vo;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.constant.VaConst;
/**
 * Created by SUU on 2016/6/1.
 */
public class VaViFiAction {

    private Integer actionType;
    private String vid;
    private String uid;
    private String reqAct;
    private String reqIP;
    private Integer respCode;
    private String respReason;
    private String sessionId;
    private String version;
    private Integer handTime;

    public VaViFiAction( VaMsgReq req ) {
        this.actionType = VaConst.Tables.TBVIFIACTION_ACTIONTYPE_UUWIFI;
        this.reqAct = req.getMsgType().toString();
        this.reqIP = req.getFIP();
        this.version = VaConst.Common.VERSION;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType( Integer actionType ) {
        this.actionType = actionType;
    }

    public String getVid() {
        return vid;
    }

    public void setVid( String vid ) {
        this.vid = vid;
    }


    public String getUid() {
        return uid;
    }

    public void setUid( String uid ) {
        this.uid = uid;
    }

    public String getReqAct() {
        return reqAct;
    }

    public void setReqAct( String reqAct ) {
        this.reqAct = reqAct;
    }

    public String getReqIP() {
        return reqIP;
    }

    public void setReqIP( String reqIP ) {
        this.reqIP = reqIP;
    }

    public Integer getRespCode() {
        return respCode;
    }

    public void setRespCode( Integer respCode ) {
        this.respCode = respCode;
    }

    public String getRespReason() {
        return respReason;
    }

    public void setRespReason( String respReason ) {
        this.respReason = respReason;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId( String sessionId ) {
        this.sessionId = sessionId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion( String version ) {
        this.version = version;
    }

    public Integer getHandTime() {
        return handTime;
    }

    public void setHandTime( Integer handTime ) {
        this.handTime = handTime;
    }
}
