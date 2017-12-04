package net.eoutech.vifi.as.vsw.vo;

import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.entity.TbSCGroup;
import net.eoutech.vifi.as.commons.entity.TbSimCard;

/**
 * Created by SUU on 2016/5/27.
 */
public class VaSimCard {

    private String id;
    private String iccid;
    private String imsi;
    private String scGroupId;
    private String areaId;
    private String countryCode;
    private Integer status;
    private Integer balance = 0;
    private Integer restNetData = 0;
    private String bindType;
    private String idxSUBindId = VaConst.Tables.TBUUWIFISESSION_STATICBINDID_DEFAULT;
    private String exActions;
    private String salerID;
    private Integer salerDiscount = 100;
    private String ispId;
    private String apn;
    private String dialnumber;
    private String dialuid;
    private String dialpwd;

    public VaSimCard( String iccid, String imsi ) {
        this.iccid = iccid;
        this.imsi = imsi;
    }

    public VaSimCard() {
    }

    public VaSimCard( TbSimCard simCard, TbSCGroup scGroup ) {
        this.id = simCard.getKeySimCardID();
        this.iccid = simCard.getIdxIccid();
        this.imsi = simCard.getImsi();
        this.scGroupId = simCard.getIdxSCGroupID();
        this.status = simCard.getStatus();
        this.balance = simCard.getBalance();
        this.restNetData = simCard.getRestNetData();
        this.bindType = simCard.getBindType();
        this.exActions = simCard.getExActions();
        if ( scGroup == null ) {
            this.status = VaConst.Tables.TBSIMCARD_STATUS_DISABLE;
            this.scGroupId = "0";
            this.countryCode = "0";
        } else {
            this.salerID = scGroup.getIdxSalerId();
            this.ispId = scGroup.getIspID();
            this.apn = scGroup.getApn();
            this.dialnumber = scGroup.getDialnumber();
            this.dialuid = scGroup.getDialuid();
            this.dialpwd = scGroup.getDialpwd();
            this.countryCode = scGroup.getAreaCode();
            this.areaId = scGroup.getIdxUUWiFiAreaId();
        }
    }

    public VaSimCard( String id, String iccid, String imsi, String scGroupId, String countryCode, Integer status, Integer balance, Integer restNetData, String bindType, String exActions, String salerID, String ispId, String apn, String dialnumber, String dialuid, String dialpwd ) {
        this.id = id;
        this.iccid = iccid;
        this.imsi = imsi;
        this.scGroupId = scGroupId;
        this.countryCode = countryCode;
        this.status = status;
        this.balance = balance;
        this.restNetData = restNetData;
        this.bindType = bindType;
        this.exActions = exActions;
        this.salerID = salerID;
        this.ispId = ispId;
        this.apn = apn;
        this.dialnumber = dialnumber;
        this.dialuid = dialuid;
        this.dialpwd = dialpwd;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid( String iccid ) {
        this.iccid = iccid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi( String imsi ) {
        this.imsi = imsi;
    }

    public String getScGroupId() {
        return scGroupId;
    }

    public void setScGroupId( String scGroupId ) {
        this.scGroupId = scGroupId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId( String areaId ) {
        this.areaId = areaId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode( String countryCode ) {
        this.countryCode = countryCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance( Integer balance ) {
        this.balance = balance;
    }

    public Integer getRestNetData() {
        return restNetData;
    }

    public void setRestNetData( Integer restNetData ) {
        this.restNetData = restNetData;
    }

    public String getBindType() {
        return bindType;
    }

    public void setBindType( String bindType ) {
        this.bindType = bindType;
    }

    public String getExActions() {
        return exActions;
    }

    public void setExActions( String exActions ) {
        this.exActions = exActions;
    }

    public String getSalerID() {
        return salerID;
    }

    public void setSalerID( String salerID ) {
        this.salerID = salerID;
    }

    public String getIspId() {
        return ispId;
    }

    public void setIspId( String ispId ) {
        this.ispId = ispId;
    }

    public String getApn() {
        return apn;
    }

    public void setApn( String apn ) {
        this.apn = apn;
    }

    public String getDialnumber() {
        return dialnumber;
    }

    public void setDialnumber( String dialnumber ) {
        this.dialnumber = dialnumber;
    }

    public String getDialuid() {
        return dialuid;
    }

    public void setDialuid( String dialuid ) {
        this.dialuid = dialuid;
    }

    public String getDialpwd() {
        return dialpwd;
    }

    public void setDialpwd( String dialpwd ) {
        this.dialpwd = dialpwd;
    }

    public Integer getSalerDiscount() {
        return salerDiscount;
    }

    public void setSalerDiscount( Integer salerDiscount ) {
        this.salerDiscount = salerDiscount;
    }

    public String getIdxSUBindId() {
        return idxSUBindId;
    }

    public void setIdxSUBindId( String idxSUBindId ) {
        this.idxSUBindId = idxSUBindId;
    }
}
