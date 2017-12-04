package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbViFiCtrlCmd {
    private String keyCtrlCmdID;

    private String viFiDomain;

    private String idxViFiID;

    private String cmd;

    private String params;

    private Date effectDate;

    private Date ineffectDate;

    private Integer duration;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeyCtrlCmdID() {
        return keyCtrlCmdID;
    }

    public void setKeyCtrlCmdID(String keyCtrlCmdID) {
        this.keyCtrlCmdID = keyCtrlCmdID == null ? null : keyCtrlCmdID.trim();
    }

    public String getViFiDomain() {
        return viFiDomain;
    }

    public void setViFiDomain(String viFiDomain) {
        this.viFiDomain = viFiDomain == null ? null : viFiDomain.trim();
    }

    public String getIdxViFiID() {
        return idxViFiID;
    }

    public void setIdxViFiID(String idxViFiID) {
        this.idxViFiID = idxViFiID == null ? null : idxViFiID.trim();
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd == null ? null : cmd.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getIneffectDate() {
        return ineffectDate;
    }

    public void setIneffectDate(Date ineffectDate) {
        this.ineffectDate = ineffectDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getMdfTm() {
        return mdfTm;
    }

    public void setMdfTm(Date mdfTm) {
        this.mdfTm = mdfTm;
    }

    public String getMdfBy() {
        return mdfBy;
    }

    public void setMdfBy(String mdfBy) {
        this.mdfBy = mdfBy == null ? null : mdfBy.trim();
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