package net.eoutech.vifi.as.service;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;

/**
 * 扣费流程
 * 1、
 * Created by SUU on 2016/5/24.
 */
public abstract class VaAccountingService<Q extends VaMsgReq, P extends VaMsgResp> extends VaService {

    protected Q req;
    protected P resp;

    public VaAccountingService(VaMsgReq req, VaMsgResp resp) {
        this.req = (Q) req;
        this.resp = (P) resp;
    }

    public abstract int doAccounting();

}
