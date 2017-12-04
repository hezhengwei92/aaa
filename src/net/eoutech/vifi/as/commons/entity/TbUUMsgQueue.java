package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbUUMsgQueue {
    private Integer keyUUMsgId;

    private String msgType;

    private String sender;

    private String receiver;

    private String idxUUWiFiAreaId;

    private String message;

    private String state;

    private Date sendTime;

    private Date expiryTime;

    private String msgChannelId;

    private Integer retry;

    private Integer maxRetry;

    private Integer pri;

    private Integer idxExternalID;

    private String respMsgId;

    private String respCode;

    private String respDesc;

    private String ipaddr;

    private Integer timeUsed;

    private Integer msgTmplId;

    private String idxAgentID;

    private String updateBy;

    private Date updateTime;

    private String createdBy;

    private Date createdTime;

    public Integer getKeyUUMsgId() {
        return keyUUMsgId;
    }

    public void setKeyUUMsgId(Integer keyUUMsgId) {
        this.keyUUMsgId = keyUUMsgId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getIdxUUWiFiAreaId() {
        return idxUUWiFiAreaId;
    }

    public void setIdxUUWiFiAreaId(String idxUUWiFiAreaId) {
        this.idxUUWiFiAreaId = idxUUWiFiAreaId == null ? null : idxUUWiFiAreaId.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getMsgChannelId() {
        return msgChannelId;
    }

    public void setMsgChannelId(String msgChannelId) {
        this.msgChannelId = msgChannelId == null ? null : msgChannelId.trim();
    }

    public Integer getRetry() {
        return retry;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
    }

    public Integer getMaxRetry() {
        return maxRetry;
    }

    public void setMaxRetry(Integer maxRetry) {
        this.maxRetry = maxRetry;
    }

    public Integer getPri() {
        return pri;
    }

    public void setPri(Integer pri) {
        this.pri = pri;
    }

    public Integer getIdxExternalID() {
        return idxExternalID;
    }

    public void setIdxExternalID(Integer idxExternalID) {
        this.idxExternalID = idxExternalID;
    }

    public String getRespMsgId() {
        return respMsgId;
    }

    public void setRespMsgId(String respMsgId) {
        this.respMsgId = respMsgId == null ? null : respMsgId.trim();
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode == null ? null : respCode.trim();
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc == null ? null : respDesc.trim();
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    public Integer getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(Integer timeUsed) {
        this.timeUsed = timeUsed;
    }

    public Integer getMsgTmplId() {
        return msgTmplId;
    }

    public void setMsgTmplId(Integer msgTmplId) {
        this.msgTmplId = msgTmplId;
    }

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID == null ? null : idxAgentID.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}