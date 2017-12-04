package net.eoutech.vifi.as.commons.enums;

import net.eoutech.vifi.as.commons.utils.LogUtils;

/**
 * Created by Administrator on 2015/9/18.
 */
public enum VaMsgType {
    // VPX
    AUTH, SETUP, ANSWER, CUPDATE, RELEASE,
    // VSW
    GSREG, VOPEN, VUPDATE, VCLOSE, SPUBLISH, VSWHB,
    //VNS
    GET,
    // Common
    NOSUPPORT,
    UNKNOWN;



    public static VaMsgType msgValueOf( String type ) {
        try {
            return VaMsgType.valueOf( type );
        } catch ( Exception e ) {
            LogUtils.error( "parse msg type error {0}",type );
            return UNKNOWN;
        }
    }
}
