package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbAgentDeductionRcd {
    private Integer keyID;

    private String idxAgentID;

    private String idxCDRId;

    private Integer discount;

    private Integer amount;

    private Integer beforeValue;

    private Integer afterValue;

    private String remark;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public Integer getKeyID() {
        return keyID;
    }

    public void setKeyID(Integer keyID) {
        this.keyID = keyID;
    }

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID == null ? null : idxAgentID.trim();
    }

    public String getIdxCDRId() {
        return idxCDRId;
    }

    public void setIdxCDRId(String idxCDRId) {
        this.idxCDRId = idxCDRId == null ? null : idxCDRId.trim();
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getBeforeValue() {
        return beforeValue;
    }

    public void setBeforeValue(Integer beforeValue) {
        this.beforeValue = beforeValue;
    }

    public Integer getAfterValue() {
        return afterValue;
    }

    public void setAfterValue(Integer afterValue) {
        this.afterValue = afterValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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