package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbViFiCtrlRcd {
    private Integer keyCtrlRcdID;

    private String idxCtrlCmdID;

    private String idxViFiID;

    private String cmdState;

    private Integer respCode;

    private String respDetail;

    private Date reqDate;

    private Date updateDate;

    public Integer getKeyCtrlRcdID() {
        return keyCtrlRcdID;
    }

    public void setKeyCtrlRcdID(Integer keyCtrlRcdID) {
        this.keyCtrlRcdID = keyCtrlRcdID;
    }

    public String getIdxCtrlCmdID() {
        return idxCtrlCmdID;
    }

    public void setIdxCtrlCmdID(String idxCtrlCmdID) {
        this.idxCtrlCmdID = idxCtrlCmdID == null ? null : idxCtrlCmdID.trim();
    }

    public String getIdxViFiID() {
        return idxViFiID;
    }

    public void setIdxViFiID(String idxViFiID) {
        this.idxViFiID = idxViFiID == null ? null : idxViFiID.trim();
    }

    public String getCmdState() {
        return cmdState;
    }

    public void setCmdState(String cmdState) {
        this.cmdState = cmdState == null ? null : cmdState.trim();
    }

    public Integer getRespCode() {
        return respCode;
    }

    public void setRespCode(Integer respCode) {
        this.respCode = respCode;
    }

    public String getRespDetail() {
        return respDetail;
    }

    public void setRespDetail(String respDetail) {
        this.respDetail = respDetail == null ? null : respDetail.trim();
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}