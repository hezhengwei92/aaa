package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbAgent {
    private String idxAgentId;

    private String idxParentsId;

    private String idxAgentName;

    private Integer agentLevel;

    private String name;

    private String phoneNumber;

    private Integer balance;

    private Integer credit;

    private Integer discount;

    private String remark;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getIdxAgentId() {
        return idxAgentId;
    }

    public void setIdxAgentId(String idxAgentId) {
        this.idxAgentId = idxAgentId == null ? null : idxAgentId.trim();
    }

    public String getIdxParentsId() {
        return idxParentsId;
    }

    public void setIdxParentsId(String idxParentsId) {
        this.idxParentsId = idxParentsId == null ? null : idxParentsId.trim();
    }

    public String getIdxAgentName() {
        return idxAgentName;
    }

    public void setIdxAgentName(String idxAgentName) {
        this.idxAgentName = idxAgentName == null ? null : idxAgentName.trim();
    }

    public Integer getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(Integer agentLevel) {
        this.agentLevel = agentLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
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