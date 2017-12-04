package net.eoutech.vifi.as.commons.vo;

import net.eoutech.vifi.as.commons.entity.TbUseFlowRcd;

import java.util.Date;

/**
 * Created by admin on 2017/7/7.
 */
public class VaUseFlowRcd {
    private String keyId;
    private String idxUserId;
    private String idxVifiId;
    private String idxIccid;
    private Integer idxSlotNum;
    private String idxSimPDevID;
    private String mac;
    private Integer upFlow;
    private Integer downFlow;
    private String online;
    private Date crtTm;
    private String crtBy;
    public VaUseFlowRcd(TbUseFlowRcd tbUseFlowRcd){
        this.keyId=tbUseFlowRcd.getKeyId();
        this.idxUserId=tbUseFlowRcd.getIdxUserId();
        this.idxVifiId=tbUseFlowRcd.getIdxVifiId();
        this.idxIccid=tbUseFlowRcd.getIdxIccid();
        this.idxSlotNum=tbUseFlowRcd.getIdxSlotNum();
        this.idxSimPDevID=tbUseFlowRcd.getIdxSimPDevID();
        this.mac=tbUseFlowRcd.getMac();
        this.upFlow=tbUseFlowRcd.getUpFlow();
        this.downFlow=tbUseFlowRcd.getDownFlow();
        this.online=tbUseFlowRcd.getOnline();
        this.crtTm=tbUseFlowRcd.getCrtTm();
        this.crtBy=tbUseFlowRcd.getCrtBy();
    }

    public VaUseFlowRcd() {
        super();
    }

    public String getCrtBy() {
        return crtBy;
    }

    public void setCrtBy(String crtBy) {
        this.crtBy = crtBy;
    }

    public Date getCrtTm() {
        return crtTm;
    }

    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }

    public Integer getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(Integer downFlow) {
        this.downFlow = downFlow;
    }

    public String getIdxIccid() {
        return idxIccid;
    }

    public void setIdxIccid(String idxIccid) {
        this.idxIccid = idxIccid;
    }

    public String getIdxSimPDevID() {
        return idxSimPDevID;
    }

    public void setIdxSimPDevID(String idxSimPDevID) {
        this.idxSimPDevID = idxSimPDevID;
    }

    public Integer getIdxSlotNum() {
        return idxSlotNum;
    }

    public void setIdxSlotNum(Integer idxSlotNum) {
        this.idxSlotNum = idxSlotNum;
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

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public Integer getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(Integer upFlow) {
        this.upFlow = upFlow;
    }
}
