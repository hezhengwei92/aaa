package net.eoutech.vifi.as.main;

import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.timetask.DeleteJob;
import net.eoutech.vifi.as.timetask.QuartzManager;
import net.eoutech.vifi.as.timetask.TaskTimeJob;
import net.eoutech.vifi.as.timetask.TaskTimeJob2;
import org.quartz.SchedulerException;

import java.text.ParseException;

/**
 * Created by SUU on 2016/5/19.
 */
public class MainRun {

    public static void main(String args[]) throws SchedulerException, ParseException, InterruptedException {
        TaskTimeJob taskTimeJob = new TaskTimeJob();
        TaskTimeJob2 taskTimeJob2 = new TaskTimeJob2();
        DeleteJob deleteJob = new DeleteJob();


        QuartzManager.taskJob("taskJob", taskTimeJob, "0 0 0 1 * ?");//每月一号 00:00:00 执行用户流量的更新
        QuartzManager.taskJob("taskJob2", taskTimeJob2, "0 0 0 1 * ?");//每月一号 0:0:0 充值SIM卡流量
        QuartzManager.taskJob("deleteJob", deleteJob, "0 0 0 * * ?");//每天 00:00:00 执行删除无用订单

        // 初始化log
//        LogUtils.info("UUWIFIAAA Service Starting... VER:{0}", VaConst.Common.VERSION);

        // 注册信号(exit/reload)
//        VaSignalHandle.setupSIGINT();  //ctrl-c   for exit+

        VaAccountingServer server = VaAccountingServer.getInstance();
        if (server.init() == 0) {
            LogUtils.info("UUWIFIAAA Service Start Success.");
//
//            LogUtils.info("ViFi AS Service Exit.");
//            server.destrory();

        }

        LogUtils.info("UUWIFIAAA AS Process Exit.");
//        System.exit( server.getExitCode() );

    }

}
