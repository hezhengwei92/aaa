package net.eoutech.vifi.as.commons.vo;

import net.eoutech.vifi.as.commons.utils.ConfigUtils;
import net.eoutech.vifi.as.commons.utils.EuList;
import net.eoutech.vifi.as.commons.utils.LogUtils;

import java.text.MessageFormat;

/**
 * Created by SUU on 2016/5/25.
 */
public abstract class VaObj {

    //配置
    protected ConfigUtils configUtils = ConfigUtils.getInstance();

    /**
     * **********************vsw日志**************
     */
    protected void myInfo( String pattern, Object... args ) {
        LogUtils.log( LogUtils.INFO, LogUtils.INFO, buildLogParams( pattern, args ) );
    }

    protected void myDbg( String pattern, Object... args ) {
        LogUtils.log( LogUtils.DBG, LogUtils.DBG, buildLogParams( pattern, args ) );
    }

    protected void myWarn ( String pattern, Object... args ) {
        LogUtils.log( LogUtils.WARN, LogUtils.WARN, buildLogParams( pattern, args ) );
    }

    protected void myErr( String pattern, Object... args ) {
        LogUtils.log( LogUtils.ERR, LogUtils.ERR, buildLogParams( pattern, args ) );
    }

    protected void myLog( int logEv, String pattern, Object... args ) {
        LogUtils.log( logEv, logEv, buildLogParams( pattern, args ) );
    }

    private String[] buildLogParams ( String pattern, Object... args ) {

        return new String[]{ MessageFormat.format( pattern, args ) };
    }

}
