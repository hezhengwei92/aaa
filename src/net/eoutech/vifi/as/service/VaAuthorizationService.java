package net.eoutech.vifi.as.service;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.service.VaCostService;

/**
 * Created by SUU on 2016/5/24.
 */
public abstract class VaAuthorizationService<Q extends VaMsgReq, P extends VaMsgResp> extends VaService {

    protected Q req;
    protected P resp;

    public VaAuthorizationService(VaMsgReq req, VaMsgResp resp) {
        this.req = (Q) req;
        this.resp = (P) resp;
    }

    public int doAuthorizationService() {

        int doAuthorizationRes = doAuthorization();
        return doAuthorizationRes;

    }

    public abstract int doAuthorization();


}