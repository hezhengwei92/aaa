package net.eoutech.vifi.as.vsw.vo;

import net.eoutech.vifi.as.commons.entity.TbSimPPort;

/**
 * Created by SUU on 2016/6/17.
 */
public class VaSimPPort extends VaPort {

    public VaSimPPort( int id, int slotNum ) {
        this.id = id;
        this.slotNum = slotNum;
    }

    public VaSimPPort( TbSimPPort port ) {
        this.id = port.getKeyID();
        this.deviceId = port.getIdxSimPDevID();
        this.slotNum = port.getIdxSlotNum();
        this.status = port.getStatus();
        this.vid = port.getIdxViFiId();
        this.iccid = port.getIdxIccid();
        this.duration = port.getDuration();
    }
}
