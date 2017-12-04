package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbCountMonthly {
    private String keyCMID;

    private String idxUserId;

    private Date idxCountDate;

    private Integer numTotalMMIn;

    private Integer numTotalMMOut;

    private Integer numTotalMO;

    private Integer numTotalMOCb;

    private Integer numTotalMTGoip;

    private Integer numTotalMOGoip;

    private Integer numFailedMMIn;

    private Integer numTotalMOGoipCb;

    private Integer numFailedMMOut;

    private Integer numFailedMO;

    private Integer numFailedMOCb;

    private Integer numFailedMTGoip;

    private Integer numFailedMOGoip;

    private Integer numFailedMOGoipCb;

    private Integer numShortMMIn;

    private Integer numShortMMOut;

    private Integer numShortMO;

    private Integer numShortMOCb;

    private Integer numShortMTGoip;

    private Integer numShortMOGoip;

    private Integer numShortMOGoipCb;

    private Integer durMMIn;

    private Integer durMMOut;

    private Integer durMO;

    private Integer durMOCb;

    private Integer durMTGoip;

    private Integer durMOGoip;

    private Integer durMOGoipCb;

    private Integer numSMSRecv;

    private Integer numSMSSend;

    private Integer cntDataDown;

    private Integer cntDataUp;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getKeyCMID() {
        return keyCMID;
    }

    public void setKeyCMID(String keyCMID) {
        this.keyCMID = keyCMID == null ? null : keyCMID.trim();
    }

    public String getIdxUserId() {
        return idxUserId;
    }

    public void setIdxUserId(String idxUserId) {
        this.idxUserId = idxUserId == null ? null : idxUserId.trim();
    }

    public Date getIdxCountDate() {
        return idxCountDate;
    }

    public void setIdxCountDate(Date idxCountDate) {
        this.idxCountDate = idxCountDate;
    }

    public Integer getNumTotalMMIn() {
        return numTotalMMIn;
    }

    public void setNumTotalMMIn(Integer numTotalMMIn) {
        this.numTotalMMIn = numTotalMMIn;
    }

    public Integer getNumTotalMMOut() {
        return numTotalMMOut;
    }

    public void setNumTotalMMOut(Integer numTotalMMOut) {
        this.numTotalMMOut = numTotalMMOut;
    }

    public Integer getNumTotalMO() {
        return numTotalMO;
    }

    public void setNumTotalMO(Integer numTotalMO) {
        this.numTotalMO = numTotalMO;
    }

    public Integer getNumTotalMOCb() {
        return numTotalMOCb;
    }

    public void setNumTotalMOCb(Integer numTotalMOCb) {
        this.numTotalMOCb = numTotalMOCb;
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

    public Integer getNumFailedMMIn() {
        return numFailedMMIn;
    }

    public void setNumFailedMMIn(Integer numFailedMMIn) {
        this.numFailedMMIn = numFailedMMIn;
    }

    public Integer getNumTotalMOGoipCb() {
        return numTotalMOGoipCb;
    }

    public void setNumTotalMOGoipCb(Integer numTotalMOGoipCb) {
        this.numTotalMOGoipCb = numTotalMOGoipCb;
    }

    public Integer getNumFailedMMOut() {
        return numFailedMMOut;
    }

    public void setNumFailedMMOut(Integer numFailedMMOut) {
        this.numFailedMMOut = numFailedMMOut;
    }

    public Integer getNumFailedMO() {
        return numFailedMO;
    }

    public void setNumFailedMO(Integer numFailedMO) {
        this.numFailedMO = numFailedMO;
    }

    public Integer getNumFailedMOCb() {
        return numFailedMOCb;
    }

    public void setNumFailedMOCb(Integer numFailedMOCb) {
        this.numFailedMOCb = numFailedMOCb;
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

    public Integer getNumShortMMIn() {
        return numShortMMIn;
    }

    public void setNumShortMMIn(Integer numShortMMIn) {
        this.numShortMMIn = numShortMMIn;
    }

    public Integer getNumShortMMOut() {
        return numShortMMOut;
    }

    public void setNumShortMMOut(Integer numShortMMOut) {
        this.numShortMMOut = numShortMMOut;
    }

    public Integer getNumShortMO() {
        return numShortMO;
    }

    public void setNumShortMO(Integer numShortMO) {
        this.numShortMO = numShortMO;
    }

    public Integer getNumShortMOCb() {
        return numShortMOCb;
    }

    public void setNumShortMOCb(Integer numShortMOCb) {
        this.numShortMOCb = numShortMOCb;
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

    public Integer getDurMMIn() {
        return durMMIn;
    }

    public void setDurMMIn(Integer durMMIn) {
        this.durMMIn = durMMIn;
    }

    public Integer getDurMMOut() {
        return durMMOut;
    }

    public void setDurMMOut(Integer durMMOut) {
        this.durMMOut = durMMOut;
    }

    public Integer getDurMO() {
        return durMO;
    }

    public void setDurMO(Integer durMO) {
        this.durMO = durMO;
    }

    public Integer getDurMOCb() {
        return durMOCb;
    }

    public void setDurMOCb(Integer durMOCb) {
        this.durMOCb = durMOCb;
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