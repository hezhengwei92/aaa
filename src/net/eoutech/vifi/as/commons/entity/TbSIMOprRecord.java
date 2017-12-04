package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbSIMOprRecord {
    private Integer keyID;

    private String idxICCID;

    private String action;

    private String req;

    private Integer result;

    private String resp;

    private String IP;

    private String remark;

    private Date crtTm;

    private String crtBy;

    public Integer getKeyID() {
        return keyID;
    }

    public void setKeyID(Integer keyID) {
        this.keyID = keyID;
    }

    public String getIdxICCID() {
        return idxICCID;
    }

    public void setIdxICCID(String idxICCID) {
        this.idxICCID = idxICCID == null ? null : idxICCID.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req == null ? null : req.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp == null ? null : resp.trim();
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP == null ? null : IP.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCrtTm() {
        return crtTm;
    }

    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }

    public String getCrtBy() {
        return crtBy;
    }

    public void setCrtBy(String crtBy) {
        this.crtBy = crtBy == null ? null : crtBy.trim();
    }
}