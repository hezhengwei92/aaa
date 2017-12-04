package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class TbCardStatus {
    private Integer keyId;
    private String idxUserId;
    private String idxVifiId;
    private String status;
    private Date crtTm;
    private Date updateTm;

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getIdxUserId() {
        return idxUserId;
    }

    public void setIdxUserId(String idxUserId) {
        this.idxUserId = idxUserId;
    }

    public String getIdxVifiId() {
        return idxVifiId;
    }

    public void setIdxVifiId(String idxVifiId) {
        this.idxVifiId = idxVifiId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCrtTm() {
        return crtTm;
    }

    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }

    public Date getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(Date updateTm) {
        this.updateTm = updateTm;
    }
}
