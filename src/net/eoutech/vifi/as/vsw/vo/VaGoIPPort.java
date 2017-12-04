package net.eoutech.vifi.as.vsw.vo;

import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.entity.TbGoIPPort;

/**
 * Created by SUU on 2016/6/17.
 */
public class VaGoIPPort extends VaPort {

    private String bindType;
    private String idxGUStaticBindId = VaConst.Tables.TBUUWIFISESSION_STATICBINDID_DEFAULT;
    private String imsi;
    private String userAct;

    public VaGoIPPort( int id, int slotNum ) {
        this.id = id;
        this.slotNum = slotNum;
    }

    public VaGoIPPort( TbGoIPPort port ) {
        this.id = port.getKeyID();
        this.deviceId = port.getIdxGoIPDevID();
        this.slotNum = port.getIdxportNum();
        this.status = port.getStatus();
        this.vid = port.getIdxViFiID();
        this.iccid = port.getUuIccid();
        this.duration = port.getDuration();
        this.bindType = port.getBindType();
        this.imsi = port.getUuImsi();
        this.userAct = port.getUserAct();
    }

    public String getBindType() {
        return bindType;
    }

    public void setBindType( String bindType ) {
        this.bindType = bindType;
    }

    public String getIdxGUStaticBindId() {
        return idxGUStaticBindId;
    }

    public void setIdxGUStaticBindId( String idxGUStaticBindId ) {
        this.idxGUStaticBindId = idxGUStaticBindId;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi( String imsi ) {
        this.imsi = imsi;
    }

    public String getUserAct() {
        return userAct;
    }

    public void setUserAct( String userAct ) {
        this.userAct = userAct;
    }
}
