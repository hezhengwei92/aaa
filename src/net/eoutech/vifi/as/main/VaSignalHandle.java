package net.eoutech.vifi.as.main;

import net.eoutech.vifi.as.commons.utils.LogUtils;
import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * as 信号处理,自动注入,自动初始化处理
 */
public class VaSignalHandle {
    //kill -2 (ctrl-c)  for exit process
    public static void setupSIGINT() {
        // 设置INT信号(Ctrl+C中断执行)交给指定的信号处理器处理，废掉系统自带的功能
        Signal.handle(new Signal("INT"), new IntSignalHandler());
    }

    static class IntSignalHandler implements SignalHandler {
        @Override
        public void handle(Signal signal) {
            LogUtils.dbg("Recv Usr1 signal Ctrl+C (kill -2 )");
            VaAccountingServer server = VaAccountingServer.getInstance();
            server.exit(0);
        }
    }

    //kill -10  for reload process
    public static void setupSIGUSR1() {
        //   	Signal.handle( new Signal( "USR1" ), new Usr1SignalHandler() );  // set SIGUSR1 (kill -10 ***.jar)
    }

    static class Usr1SignalHandler implements SignalHandler {
        @Override
        public void handle(Signal signal) {
//            LogUtils.dbg( "Recv Usr1 signal(kill -10 )");
//            VaAccountingServer vaas = VaAccountingServer.getInstance();
//            vaas.reload();
        }
    }


}
