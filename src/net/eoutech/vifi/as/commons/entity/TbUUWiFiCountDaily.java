package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbUUWiFiCountDaily {
    private String keyUUWiFiCDID;

    private String idxViFiID;

    private Integer numTotalMTGoip = 0;

    private Integer numTotalMOGoip = 0;

    private Integer numTotalMOGoipCb = 0;

    private Integer numFailedMTGoip = 0;

    private Integer numFailedMOGoip = 0;

    private Integer numFailedMOGoipCb = 0;

    private Integer numShortMTGoip = 0;

    private Integer numShortMOGoip = 0;

    private Integer numShortMOGoipCb = 0;

    private Integer durMTGoip = 0;

    private Integer durMOGoip = 0;

    private Integer durMOGoipCb = 0;

    private Integer numSMSRecv = 0;

    private Integer numSMSSend = 0;

    private Integer cntDataDown = 0;

    private Integer cntDataUp = 0;

    private Integer cntDataSum = 0;

    private Integer cost = 0;

    private Integer deviceDur = 0;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeyUUWiFiCDID() {
        return keyUUWiFiCDID;
    }

    public void setKeyUUWiFiCDID(String keyUUWiFiCDID) {
        this.keyUUWiFiCDID = keyUUWiFiCDID == null ? null : keyUUWiFiCDID.trim();
    }

    public String getIdxViFiID() {
        return idxViFiID;
    }

    public void setIdxViFiID(String idxViFiID) {
        this.idxViFiID = idxViFiID == null ? null : idxViFiID.trim();
    }

    public Integer getNumTotalMTGoip() {
        return numTotalMTGoip;
    }

    public void setNumTotalMTGoip(Integer numTotalMTGoip) {
        this.numTotalMTGoip = numTotalMTGoip;
    }

    public Integer getNumTotalMOGoip() {
        return numTotalMOGoip;
    }

    public void setNumTotalMOGoip(Integer numTotalMOGoip) {
        this.numTotalMOGoip = numTotalMOGoip;
    }

    public Integer getNumTotalMOGoipCb() {
        return numTotalMOGoipCb;
    }

    public void setNumTotalMOGoipCb(Integer numTotalMOGoipCb) {
        this.numTotalMOGoipCb = numTotalMOGoipCb;
    }

    public Integer getNumFailedMTGoip() {
        return numFailedMTGoip;
    }

    public void setNumFailedMTGoip(Integer numFailedMTGoip) {
        this.numFailedMTGoip = numFailedMTGoip;
    }

    public Integer getNumFailedMOGoip() {
        return numFailedMOGoip;
    }

    public void setNumFailedMOGoip(Integer numFailedMOGoip) {
        this.numFailedMOGoip = numFailedMOGoip;
    }

    public Integer getNumFailedMOGoipCb() {
        return numFailedMOGoipCb;
    }

    public void setNumFailedMOGoipCb(Integer numFailedMOGoipCb) {
        this.numFailedMOGoipCb = numFailedMOGoipCb;
    }

    public Integer getNumShortMTGoip() {
        return numShortMTGoip;
    }

    public void setNumShortMTGoip(Integer numShortMTGoip) {
        this.numShortMTGoip = numShortMTGoip;
    }

    public Integer getNumShortMOGoip() {
        return numShortMOGoip;
    }

    public void setNumShortMOGoip(Integer numShortMOGoip) {
        this.numShortMOGoip = numShortMOGoip;
    }

    public Integer getNumShortMOGoipCb() {
        return numShortMOGoipCb;
    }

    public void setNumShortMOGoipCb(Integer numShortMOGoipCb) {
        this.numShortMOGoipCb = numShortMOGoipCb;
    }

    public Integer getDurMTGoip() {
        return durMTGoip;
    }

    public void setDurMTGoip(Integer durMTGoip) {
        this.durMTGoip = durMTGoip;
    }

    public Integer getDurMOGoip() {
        return durMOGoip;
    }

    public void setDurMOGoip(Integer durMOGoip) {
        this.durMOGoip = durMOGoip;
    }

    public Integer getDurMOGoipCb() {
        return durMOGoipCb;
    }

    public void setDurMOGoipCb(Integer durMOGoipCb) {
        this.durMOGoipCb = durMOGoipCb;
    }

    public Integer getNumSMSRecv() {
        return numSMSRecv;
    }

    public void setNumSMSRecv(Integer numSMSRecv) {
        this.numSMSRecv = numSMSRecv;
    }

    public Integer getNumSMSSend() {
        return numSMSSend;
    }

    public void setNumSMSSend(Integer numSMSSend) {
        this.numSMSSend = numSMSSend;
    }

    public Integer getCntDataDown() {
        return cntDataDown;
    }

    public void setCntDataDown(Integer cntDataDown) {
        this.cntDataDown = cntDataDown;
    }

    public Integer getCntDataUp() {
        return cntDataUp;
    }

    public void setCntDataUp(Integer cntDataUp) {
        this.cntDataUp = cntDataUp;
    }

    public Integer getCntDataSum() {
        return cntDataSum;
    }

    public void setCntDataSum(Integer cntDataSum) {
        this.cntDataSum = cntDataSum;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDeviceDur() {
        return deviceDur;
    }

    public void setDeviceDur(Integer deviceDur) {
        this.deviceDur = deviceDur;
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