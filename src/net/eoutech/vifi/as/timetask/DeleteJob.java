package net.eoutech.vifi.as.timetask;

import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.vsw.service.utils.VaResidualflowService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DeleteJob implements Job {

    private VaResidualflowService residualflowService = VaResidualflowService.getInstance();

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        // 当前时间大于有效时间时 删除流量订单
        LogUtils.info("执行定时删除任务" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        residualflowService.deleteOverdue();
    }

}
