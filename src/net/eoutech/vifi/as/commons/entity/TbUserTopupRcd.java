package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class TbUserTopupRcd {
    private Integer keyID;
    private String idxOrderID;
    private String idxUserID;
    private String topupType;
    private String idxExID;
    private String idxAgentID;
    private String goodsID;
    private String pkgType;
    private String pkgInfo;
    private String uuwifiAreaId;
    private Integer amount;
    private String ipAddr;
    private String status;
    private String remark;
    private Date mdfTm;
    private String mdfBy;
    private Date crtTm;
    private String crtBy;
    private Integer flow;

    public Integer getKeyID() {
        return keyID;
    }

    public void setKeyID(Integer keyID) {
        this.keyID = keyID;
    }

    public String getIdxOrderID() {
        return idxOrderID;
    }

    public void setIdxOrderID(String idxOrderID) {
        this.idxOrderID = idxOrderID;
    }

    public String getIdxUserID() {
        return idxUserID;
    }

    public void setIdxUserID(String idxUserID) {
        this.idxUserID = idxUserID;
    }

    public String getTopupType() {
        return topupType;
    }

    public void setTopupType(String topupType) {
        this.topupType = topupType;
    }

    public String getIdxExID() {
        return idxExID;
    }

    public void setIdxExID(String idxExID) {
        this.idxExID = idxExID;
    }

    public String getIdxAgentID() {
        return idxAgentID;
    }

    public void setIdxAgentID(String idxAgentID) {
        this.idxAgentID = idxAgentID;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getPkgType() {
        return pkgType;
    }

    public void setPkgType(String pkgType) {
        this.pkgType = pkgType;
    }

    public String getPkgInfo() {
        return pkgInfo;
    }

    public void setPkgInfo(String pkgInfo) {
        this.pkgInfo = pkgInfo;
    }

    public String getUuwifiAreaId() {
        return uuwifiAreaId;
    }

    public void setUuwifiAreaId(String uuwifiAreaId) {
        this.uuwifiAreaId = uuwifiAreaId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        this.mdfBy = mdfBy;
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
        this.crtBy = crtBy;
    }

    public Integer getFlow() {
        return flow;
    }

    public void setFlow(Integer flow) {
        this.flow = flow;
    }
}
