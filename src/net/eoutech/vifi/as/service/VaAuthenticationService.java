package net.eoutech.vifi.as.service;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;

/**
 * Created by SUU on 2016/5/24.
 */
public abstract class VaAuthenticationService<Q extends VaMsgReq, P extends VaMsgResp> extends VaService {

    protected Q req;
    protected P resp;

    public VaAuthenticationService(VaMsgReq req, VaMsgResp resp) {
        this.req = (Q) req;
        this.resp = (P) resp;
    }

    public abstract int doAuthentication();

}
