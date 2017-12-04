package net.eoutech.vifi.as.commons.constant;

import net.eoutech.vifi.as.vns.msg.resp.UUWiFiLogCfg;

/**
 * Created by SUU on 2016/5/19.
 */
public interface VaConst {

    class Common {
        public static final String EMPTY = "";

        public static int UU_SESSION_ID = 0;

        public static int nBad = 0;
        public static int nReq = 0;
        public static int nResp = 0;

        public static final String SIMP_PORT_TYPE = "S";
        public static final String GOIP_PORT_TYPE = "G";

        public final static String CALL_TYPE_VMO = "VMO";
        public final static String CALL_TYPE_GMO = "GMO";
        public final static String CALL_TYPE_MM = "MM";
        public final static String CALL_TYPE_MT = "MT";

        public final static int DEFAULT_DATA_M = 1024;
        public final static int MINUTE_TO_SECOND = 60;

        public final static String VERSION = "UUWIFIAAA-V2423";
        public final static String SERVER_RUN_MODAL_TEST = "test";

        public final static int COUNT_CALL = 1;
        public final static int COUNT_DATA = 2;
        public final static int COUNT_SMS = 3;

        public final static int GOIP_SMS_SEND = 1;
        public final static int GOIP_SMS_RECEIVE = 2;

        public final static String COUNTRY_CODE_CHINA = "86";

        public final static String UUWIFI_AREAID_PREFIX = "u.cn";

        public final static String UUWIFI_FIRST_AREAID = "u";
    }

    class Push {

        public static final String HW_PUSH_PREFIX = "HW";
        public static final String XM_PUSH_PREFIX = "XM";
        public static final String GT_PUSH_PREFIX = "GT";
        public static final String SIP_PUSH_PREFIX = "SIP";

    }

    class Tables {

        public static final String TBUUWIFISESSION_SESSIONTYPE_SIMPOOL = "S";
        public static final String TBUUWIFISESSION_SESSIONTYPE_GOIP = "G";
        public static final int TBUUWIFISESSION_STATUS_OFFLINE = 13;
        public static final int TBUUWIFISESSION_STATUS_OFFLINE_TEMP = 12;
        public static final int TBUUWIFISESSION_STATUS_ONLINE = 11;
        public static final String TBUUWIFISESSION_STATICBINDID_DEFAULT = "0";

        public static final String TBGOIPPORT_BINDTYPE_D = "D";
        public static final String TBGOIPPORT_BINDTYPE_S = "S";
        //数据业务
        public static final String TBVSW_STATE_ONLINE = "R";
        public static final String TBVSW_STATE_OFFLINE = "S";
        //sim卡是否 激活
        public static final int TBSIMCARD_STATUS_ENABLE = 0;
        public static final int TBSIMCARD_STATUS_DISABLE = 1;
        //默认初始剩余流量（卡入库时赋默认值）    M
        public static final int RESTNETDATA = 40*1024*1024;
        //有无 SIM卡
        public static final int TBSIMPPORT_STATUS_HASSIM = 1;
        public static final int TBSIMPPORT_STATUS_NOSIM = 0;
        //sim设备 状态
        public static final int TBSIMPDEV_STATUS_ONLINE = 0;
        public static final int TBSIMPDEV_STATUS_OFFLINE = 1;
        //goip设备状态
        public static final int TBGOIPDEV_STATUS_ONLINE = 0;
        public static final int TBGOIPDEV_STATUS_OFFLINE = 1;
        //vifi 设备状态
        public static final String TBVIFIDEVICE_DEVSTATE_ENABLE = "E";

        public static final String TBRATE_RATEMODE_CALL = "C";
        public static final String TBRATE_RATEMODE_DATA = "T";
        public static final String TBRATE_RATEMODE_DATA_DAILY = "D";
        public static final String TBRATE_RATEMODE_SMS = "S";

        public static final String TBUSERSUITE_SUITETYPE_LOCAL_CALL = "V";
        public static final String TBUSERSUITE_SUITETYPE_LOCAL_DATA = "D";

        public static final int TBVIFIACTION_ACTIONTYPE_UUWIFI = 2;

        public static final int TBVIFIDEVICE_DEBUGIDT_OPEN = 1;

        public static final String TBCDR_CDRTYPE_DATA = "V";
        public static final String TBCDR_CDRTYPE_CALL_ONLINE = "N";
        public static final String TBCDR_CDRTYPE_CALL_VOIP = "C";
        public static final String TBCDR_CDRTYPE_CALL_GOIP = "G";
        public static final String TBCDR_CDRTYPE_UNKNOWN = "U";

        public static final String TBCDR_DIRECTION_IN = "I";
        public static final String TBCDR_DIRECTION_OUT = "O";
        public static final String TBCDR_DIRECTION_UNKNOWN = "U";
        public static final String TBCDR_DISTANCE_UNKNOWN = "U";
        public static final String TBCDR_DISTANCE_LOCAL = "L";
        public static final String TBCDR_DISTANCE_INTERNATIONAL = "I";

        public static final int TBUSER_APPSTATE_ONLINE_2G = 12;
        public static final int TBUSER_APPSTATE_ONLINE_3G = 13;
        public static final int TBUSER_APPSTATE_ONLINE_4G = 14;
        public static final int TBUSER_APPSTATE_ONLINE_WIFI = 19;
        public static final int TBUSER_APPSTATE_ONLINE_VIFI = 21;
        public static final int TBUSER_APPSTATE_ONLINE_UNKNOWN = 11;
        public static final int TBUSER_APPSTATE_OFFLINE = 10;

        public static final int TBSUSTATICBIND_STATUS_ENABLE = 1;

        public static final int TBGUSTATICBIND_STATUS_ENABLE = 1;

        public static final String TBSIMCARD_BINDTYPE_S = "S";
        public static final String TBSIMCARD_BINDTYPE_D = "D";

        public static final String TBUUMSGQUEUE_MSGTYPE_COMMAND = "M";
        public static final String TBUUMSGQUEUE_STATE_WAIT = "W";
        public static final String TBUUMSGQUEUE_PUSHMSG_DEFAULT = "{\"callId\":\"${callId}\",\"caller\":\"${caller}\",\"callee\":\"${callee}\",\"callDate\":\"${callDate}\",\"callTimes\":${callTimes}}";

        public static final String TBUUMSGTMPL_NAME_CALLPUSH = "CALL_PUSH";
        public static final String TBUUMSGTMPL_LANG_CALL_PUSH = "en_US";
    }

    class Expire {

        public static final int DEVICE_EXPIRE = 120;
        public static final int TIMEOUT_DELAY = 120;

    }

    class Request {

        public static final int SPUBLISH_HASSIM_PUT = 1;
        public static final String GSREG_TYPE_GOIP = "G";
        public static final String GSREG_TYPE_SIMP = "S";

        public static final String GET_SESSTYPE_SIMP = "SIM";
        public static final String GET_SESSTYPE_GOIP = "GOIP";
        public static final String GET_SESSTYPE_MOD = "MOD";

    }

    class Symbol {

        public static final String COMMA = ",";
        public static final String COLON = ":";
        public static final String POINT = ".";
        public static final String PLUS = "+";
        public static final String ASTERISK = "*";

    }

    class SystemAuthor {
        public static final String AUTHOR = "_EUROOT";
    }

    class SystemVariate {
        public static final String DNIS = "dnis";
        public static final String CALLEE = "callee";
        public static final String CALLTYPE = "callType";
        public static final String CDRTYPE = "cdrType";
        public static final String DIRECTION = "direction";
        public static final String ALG = "alg";
        public static final String LOCALCALL = "localCall";
        public static final String TRUE = "Y";
        public static final String FALSE = "N";
    }

    class Configure {

        public static UUWiFiLogCfg UUWIFI_LOG_CONFIGURE = null;
        public static final Integer UUWIFI_LOG_IDT = 7;
        public static final String UUWIFI_LOG_IP = "UUWIFI_LOG_IP";
        public static final String UUWIFI_LOG_PORT = "UUWIFI_LOG_PORT";
        public static final String UUWIFI_LOG_ID = "";
        public static final String UUWIFI_LOG_PRO = "UDP";

    }

}
