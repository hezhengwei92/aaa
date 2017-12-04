package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class TbResidualflow {
    private Integer keyId;
    private String idxOrderID;
    private String idxUserID;
    private Double residualflow;
    private String priority;
    private String pkgType;
    private Date effectiveTm;
    private Date crtTm;
    private String status;

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
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

    public Double getResidualflow() {
        return residualflow;
    }

    public void setResidualflow(Double residualflow) {
        this.residualflow = residualflow;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPkgType() {
        return pkgType;
    }

    public void setPkgType(String pkgType) {
        this.pkgType = pkgType;
    }

    public Date getEffectiveTm() {
        return effectiveTm;
    }

    public void setEffectiveTm(Date effectiveTm) {
        this.effectiveTm = effectiveTm;
    }

    public Date getCrtTm() {
        return crtTm;
    }

    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
