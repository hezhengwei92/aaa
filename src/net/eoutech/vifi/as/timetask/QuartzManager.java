package net.eoutech.vifi.as.timetask;

import net.eoutech.vifi.as.commons.utils.LogUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.util.Date;

public class QuartzManager {
    private static SchedulerFactory sf = new StdSchedulerFactory();
    private static String JOB_GROUP_NAME = Scheduler.DEFAULT_GROUP;
    private static String TRIGGER_GROUP_NAME = "trigger1";


    public static void taskJob(String jobName, Job job, String time) throws SchedulerException, ParseException {
        Date now = new Date();
        Scheduler sched = sf.getScheduler();
        JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, job.getClass());
        CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);
        trigger.setCronExpression(time);
        sched.scheduleJob(jobDetail, trigger);

        if (!sched.isShutdown())
            LogUtils.info("||TimeTask start :", now);
        sched.start();
    }


    public static void modifyJobTime(String triggerName, String time) throws SchedulerException, ParseException {
        Scheduler sched = sf.getScheduler();
        Trigger trigger = sched.getTrigger(triggerName, TRIGGER_GROUP_NAME);

        if (trigger != null) {
            CronTrigger ctTrigger = (CronTrigger) trigger;
            ctTrigger.setCronExpression(time);
            sched.resumeTrigger(triggerName, TRIGGER_GROUP_NAME);
        }
    }

    public static void removeJob(String jobName) throws SchedulerException {
        Scheduler sched = sf.getScheduler();
        sched.pauseTrigger(jobName, TRIGGER_GROUP_NAME);
        sched.unscheduleJob(jobName, TRIGGER_GROUP_NAME);
        sched.deleteJob(jobName, JOB_GROUP_NAME);
    }


}
