package net.eoutech.vifi.as.ctrl;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.base.VaServiceFactory;
import net.eoutech.vifi.as.commons.vo.VaObj;

/**
 * Created by SUU on 2016/5/25.
 */
public abstract class VaCtrl extends VaObj {

    protected VaServiceFactory serviceFactory = VaServiceFactory.getInstance();

    protected abstract int doHandle(VaMsgReq req, VaMsgResp resp);
}
