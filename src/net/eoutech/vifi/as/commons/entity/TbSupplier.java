package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbSupplier {
    private String idxSupplierId;

    private String name;

    private String phoneNumber;

    private Integer supplierLevel;

    private Integer status;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public String getIdxSupplierId() {
        return idxSupplierId;
    }

    public void setIdxSupplierId(String idxSupplierId) {
        this.idxSupplierId = idxSupplierId == null ? null : idxSupplierId.trim();
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

    public Integer getSupplierLevel() {
        return supplierLevel;
    }

    public void setSupplierLevel(Integer supplierLevel) {
        this.supplierLevel = supplierLevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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