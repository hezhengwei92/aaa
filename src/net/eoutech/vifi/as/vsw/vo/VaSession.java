package net.eoutech.vifi.as.vsw.vo;

/**
 * Created by SUU on 2016/5/26.
 */
public class VaSession {

    private String id;
    private String type;
    private String idxSUBindID;
    private String uuWiFiCellId;
    private String uuWiFiAreaId;
    private String areaName;
    private Integer expire = 0;
    private Integer status;
    private Long LastUpdateTime;
    // TODO update
    private String ispId = "0";

    private VaVSW vswServer;
    private VaGoIPDevice goIPDev;
    private VaGoIPPort goIPPort;
    private VaSimPDevice simPDev;
    private VaSimPPort simPPort;
    private VaSimCard simCard;
    private VaViFiDevice vifiDevice;

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getIdxSUBindID() {
        return idxSUBindID;
    }

    public void setIdxSUBindID( String idxSUBindID ) {
        this.idxSUBindID = idxSUBindID;
    }

    public String getUuWiFiCellId() {
        return uuWiFiCellId;
    }

    public void setUuWiFiCellId( String uuWiFiCellId ) {
        this.uuWiFiCellId = uuWiFiCellId;
    }

    public String getUuWiFiAreaId() {
        return uuWiFiAreaId;
    }

    public void setUuWiFiAreaId( String uuWiFiAreaId ) {
        this.uuWiFiAreaId = uuWiFiAreaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName( String areaName ) {
        this.areaName = areaName;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire( Integer expire ) {
        this.expire = expire;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    public Long getLastUpdateTime() {
        return LastUpdateTime;
    }

    public void setLastUpdateTime( Long lastUpdateTime ) {
        LastUpdateTime = lastUpdateTime;
    }

    public VaVSW getVswServer() {
        return vswServer;
    }

    public void setVswServer( VaVSW vswServer ) {
        this.vswServer = vswServer;
    }

    public VaGoIPDevice getGoIPDev() {
        return goIPDev;
    }

    public void setGoIPDev( VaGoIPDevice goIPDev ) {
        this.goIPDev = goIPDev;
    }

    public VaGoIPPort getGoIPPort() {
        return goIPPort;
    }

    public void setGoIPPort( VaGoIPPort goIPPort ) {
        this.goIPPort = goIPPort;
    }

    public VaSimPDevice getSimPDev() {
        return simPDev;
    }

    public void setSimPDev( VaSimPDevice simPDev ) {
        this.simPDev = simPDev;
    }

    public VaSimPPort getSimPPort() {
        return simPPort;
    }

    public void setSimPPort( VaSimPPort simPPort ) {
        this.simPPort = simPPort;
    }

    public VaSimCard getSimCard() {
        return simCard;
    }

    public void setSimCard( VaSimCard simCard ) {
        this.simCard = simCard;
    }

    public VaViFiDevice getVifiDevice() {
        return vifiDevice;
    }

    public void setVifiDevice( VaViFiDevice vifiDevice ) {
        this.vifiDevice = vifiDevice;
    }

    public String getIspId() {
        return ispId;
    }

    public void setIspId( String ispId ) {
        this.ispId = ispId;
    }
}
