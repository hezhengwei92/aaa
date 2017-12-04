package net.eoutech.vifi.as.service;

import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.service.*;
import net.eoutech.vifi.as.commons.utils.EuIPUtils;
import net.eoutech.vifi.as.commons.utils.EuList;
import net.eoutech.vifi.as.commons.vo.*;
import net.eoutech.vifi.as.vsw.service.utils.*;
import net.eoutech.vifi.as.vsw.vo.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by SUU on 2016/5/25.
 */
public class VaService extends VaObj {

    public static String pushUserId = VaConst.Common.EMPTY;

    protected static Map<String, Integer> debugIdts = new ConcurrentHashMap<String, Integer>();

    protected static EuList portStatusList = new EuList();
    protected static EuList accountList = new EuList();

    protected static String uid = VaConst.Common.EMPTY;
    protected static String agentId = VaConst.Common.EMPTY;
    protected static VaUser user;
    protected static VaAgent agent;
    protected static String vid = VaConst.Common.EMPTY;

    protected static VaViFiDevice vifiDevice;
    protected static VaSimPDevice simPDevice;
    protected static VaGoIPDevice goIPDevice;
    protected static VaVSW vswServer;
    protected static VaSession session;
    protected static String sid = VaConst.Common.EMPTY;
    protected static VaRate rate;

    protected static VaCost cost;
    protected static VaCDR cdr;
    protected static VaUseFlowRcd useFlowRcd;
    protected static String callId = VaConst.Common.EMPTY;
    protected static VaViFiAction action;
    protected static VaCount count;

    protected VaCostService costService = VaCostService.getInstance();
    protected VaCDRService cdrService = VaCDRService.getInstance();
    protected VaUseFlowRcdService useFlowRcdService = VaUseFlowRcdService.getInstance();
    protected VaUserService userService = VaUserService.getInstance();
    protected VaAgentService agentService = VaAgentService.getInstance();

    protected VaSessionService sessionService = VaSessionService.getInstance();
    protected VaGoIPPortService goIPPortService = VaGoIPPortService.getInstance();
    protected VaSimPPortService simPPortService = VaSimPPortService.getInstance();
    protected VaViFiDeviceService vifiDeviceService = VaViFiDeviceService.getInstance();
    protected VaSimPDeviceService simPDeviceService = VaSimPDeviceService.getInstance();
    protected VaGoIPDeviceService goIPDeviceService = VaGoIPDeviceService.getInstance();
    protected VaVSWService vswService = VaVSWService.getInstance();
    protected VaSimCardService simCardService = VaSimCardService.getInstance();

    protected VaConfigureService configureService = VaConfigureService.getInstance();
    protected VaResidualflowService residualflowService = VaResidualflowService.getInstance();
    protected VaCardStatusService cardStatusService = VaCardStatusService.getInstance();

    protected VaRateService rateService = VaRateService.getInstance();
    protected EuIPUtils ipUtils = EuIPUtils.getInstance();
    protected VaCellService cellService = VaCellService.getInstance();

    public static void clean() {
        uid = VaConst.Common.EMPTY;
        agentId = VaConst.Common.EMPTY;
        user = null;
        agent = null;
        vid = VaConst.Common.EMPTY;
        vifiDevice = null;
        simPDevice = null;
        goIPDevice = null;
        vswServer = null;
        session = null;
        sid = VaConst.Common.EMPTY;
        rate = null;
        cost = null;
        cdr = null;
        callId = VaConst.Common.EMPTY;
        action = null;
        count = null;
        pushUserId = VaConst.Common.EMPTY;
    }

}
