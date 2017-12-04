package net.eoutech.vifi.as.timetask;

import net.eoutech.vifi.as.commons.entity.TbResidualflow;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.vsw.service.utils.VaResidualflowService;
import net.eoutech.vifi.as.vsw.service.utils.VaSimCardService;
import net.eoutech.vifi.as.vsw.service.utils.VaUserTopupRcdService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wei on 2017/10/10.
 */
public class TaskTimeJob2 implements Job {
    private VaSimCardService vaSimCardService = VaSimCardService.getInstance();
    private VaResidualflowService vaResidualflowService = VaResidualflowService.getInstance();

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        LogUtils.info("执行定时更新SIM卡任务" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        //每月重置卡的流量   流量的值在 Tbconfigure中配置 REST_NET_DATA
        try {
            vaSimCardService.updateNetData();
        } catch (Exception e) {
            LogUtils.error("执行定时更新SIM卡任务异常" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        }

        List<TbResidualflow> tbResidualflowList = vaResidualflowService.queryBystatus();
        if (null != tbResidualflowList && tbResidualflowList.size() > 0) {
            for (TbResidualflow tbresidualflow : tbResidualflowList) {
                vaResidualflowService.deleteByKey(tbresidualflow.getKeyId());
                LogUtils.info("删除订单ID：" + tbresidualflow.getKeyId());
            }
        }


    }
}
