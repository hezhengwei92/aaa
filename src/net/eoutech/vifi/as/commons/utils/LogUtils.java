package net.eoutech.vifi.as.commons.utils;

import org.apache.log4j.Logger;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志
 * Created by Administrator on 2015/8/13.
 */
public class LogUtils {
    // log level
    public static final int NONE = 0;
    public static final int EVENT = 1;
    public static final int CRIT = 2;
    public static final int ERR = 3;
    public static final int WARN = 4;
    public static final int INFO = 5;
    public static final int DBG3 = 6;
    public static final int DBG2 = 7;
    public static final int DBG1 = 8;
    public static final int DBG = 8;
    public static final int TRACE = 9;

    private static String modName = "ViFiAS";
    private static int logCodeMask = 98000;

    private static int minLevel2Console = TRACE;
    private static int minLevel2File = TRACE;
    private static int minLevel2DB = NONE;

    private static int logConsoleSeq = 0;
    private static int logFileSeq = 0;
    private static int logServerSeq = 0;
    private static String logIndex;

    private static Logger logger = Logger.getLogger( "net.eoutech" );
    private static SimpleDateFormat dateformat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" );

    static {
        StringBuilder init = new StringBuilder( "==========logger level====minLevel2Console : " )
                .append( minLevel2Console ).append( "-----minLevel2File : " ).append( minLevel2File )
                .append( "-------minLevel2DB : " ).append( minLevel2DB );
        dbg( init.toString() );
    }




    /**
     * 字符串模板日志, 例子 : my name:{0}, age:{1}
     * @param pattern my name:{0}, age:{1}
     * @param args  "lehman",23
     */
    public static void error( String pattern, Object... args ) {
        if ( args.length > 0 ) {
            log( ERR, ERR, new String[]{MessageFormat.format( pattern,args )} );
        } else {
            log( ERR, ERR, new String[]{pattern} );
        }
    }



    public static void info( String pattern, Object... args ) {
        if ( args.length > 0 ) {
            log( INFO, INFO, new String[]{MessageFormat.format( pattern,args )} );
        } else {
            log( INFO, INFO, new String[]{pattern} );
        }
    }


    /**
     * 字符串模板日志, 例子 : my name:{0}, age:{1}
     * @param pattern my name:{0}, age:{1}
     * @param args  "lehman",23
     */
    public static void dbg( String pattern, Object... args ) {
        if ( args.length > 0 ) {
            log( DBG, DBG, new String[]{MessageFormat.format( pattern, args )} );
        } else {
            log( DBG, DBG, new String[]{pattern } );
        }
    }

    /**
     * 字符串模板日志, 例子 : my name:{0}, age:{1}
     * @param pattern my name:{0}, age:{1}
     * @param args  "lehman",23
     */
    public static void warn( String pattern, Object... args ) {
        if ( args.length > 0 ) {
            log( WARN, WARN, new String[]{MessageFormat.format( pattern, args )} );
        } else {
            log( WARN, WARN, new String[]{pattern } );
        }
    }

    /**
     * 日志包装,变参说明
     *
     * @param msgs
     *
     */
    public static void log( int logLevel, int logCode, String[] msgs, Object... args ) {
        if ( minLevel2Console < logLevel && minLevel2File < logLevel
                && minLevel2DB < logLevel ) {
            return;
        }

        StringBuilder msgvalues = new StringBuilder();
        for ( Object arg : args ) {
            msgvalues.append( ", " ).append( arg );
        }
        if ( msgvalues.length() > 1 ) {
            msgvalues.insert( 0, ":" );
        }

        // methodName ,取得上上级的堆栈  方法名...
        StringBuilder methodName = null;
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        if ( stacks.length > 0 ) {
            String className = stacks[2].getClassName();
            int lastidx = stacks[2].getClassName().lastIndexOf( '.' );
            if ( lastidx > 0 ) {
                className = className.substring( lastidx + 1 );
            }
            methodName = new StringBuilder( className ).append( ":" ).append( stacks[2].getMethodName() ).append( "():" ).append( stacks[2].getLineNumber() );
        }

        // 日志内容
        StringBuilder strLog = new StringBuilder()
                .append( "|" ).append( logConsoleSeq )
                .append( "|" ).append( modName )
                .append( "|" ).append( methodName )
                .append( "|" ).append( logLevelStr( logLevel ) );

        for ( String msg : msgs ) {
            strLog.append( "|" ).append( msg );
        }
        strLog.append( msgvalues );

        int myLogCode = logCodeMask + logCode;
        if ( logLevel <= minLevel2Console ) {
            // 控制台要自己维护时间显示...
            strLog.insert( 0, "|" ).insert( 0, dateformat.format( new Date() ) );
            log2Console( strLog.toString() );
        }

        if ( logLevel <= minLevel2File ) {
            log2File( logLevel, strLog.toString() );
        }

    }


    private static void log2Console( String message ) {
        logConsoleSeq++;
    }

    private static void log2File( int logLevel, String message ) {
        if ( logger == null ) {
            return;
        }
        logFileSeq++;
        switch ( logLevel ) {
            case LogUtils.EVENT:
                logger.info( message );
                break;
            case LogUtils.CRIT:
                logger.fatal( message );
                break;
            case LogUtils.ERR:
                logger.error( message );
                break;
            case LogUtils.WARN:
                logger.warn( message );
                break;
            case LogUtils.INFO:
                logger.info( message );
                break;
            case LogUtils.DBG3:
            case LogUtils.DBG2:
            case LogUtils.DBG1:
            default:
                logger.debug( message );
        }
    }

    private static void log2Databse( int logLevel, int logCode, String src, String idx,
                                     String msg, String msgvalues ) {
        /*
        String sql = "insert into tbCfrmLog(idxDateTime, idxCode, idxLevel, idxMsgId, idxUserId, idxResourceId, Srcfile,Message) values(?,?,?,?,?,?,?,?)";

		Object[] args = new Object[8];
		args[0] = new Date();
		args[1] = logCode;
		args[2] = logLevelStr(logLevel);
		args[3] = idx;
		args[4] = idx;
		args[5] = "";
		args[6] = src;
		args[7] = msg + msgvalues;

		jdbcTemplate.update(sql, args);*/
    }

    private static String logLevelStr( int level ) {
        switch ( level ) {
            case LogUtils.NONE:
                return "NONE ";
            case LogUtils.EVENT:
                return "EVENT";
            case LogUtils.CRIT:
                return "CRIT ";
            case LogUtils.ERR:
                return "ERROR";
            case LogUtils.WARN:
                return "WARN ";
            case LogUtils.INFO:
                return "INFO ";
            case LogUtils.DBG3:
                return "DBG3 ";
            case LogUtils.DBG2:
                return "DBG2 ";
            case LogUtils.DBG1:
                return "DBG1 ";
            case LogUtils.TRACE:
                return "TRACE";
            default:
                return "     ";
        }
    }

    private static int parseLogLevel( String level ) {
        if ( level.equals( "NONE" ) ) {
            return NONE;
        } else if ( level.equals( "EVENT" ) ) {
            return EVENT;
        } else if ( level.equals( "CRIT" ) ) {
            return CRIT;
        } else if ( level.equals( "ERR" ) ) {
            return ERR;
        } else if ( level.equals( "WARN" ) ) {
            return WARN;
        } else if ( level.equals( "INFO" ) ) {
            return INFO;
        } else if ( level.equals( "DBG3" ) ) {
            return DBG3;
        } else if ( level.equals( "DBG2" ) ) {
            return DBG2;
        } else if ( level.equals( "DBG1" ) ) {
            return DBG1;
        } else if ( level.equals( "DBG" ) ) {
            return DBG;
        } else if ( level.equals( "TRACE" ) ) {
            return TRACE;
        } else {
            return TRACE;
        }
    }

}
