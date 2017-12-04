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

public class TaskTimeJob implements Job {

    private VaResidualflowService residualflowService = VaResidualflowService.getInstance();
    private VaUserTopupRcdService userTopupRcdService = VaUserTopupRcdService.getInstance();

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        // TODO Auto-generated method stub
        LogUtils.info("执行定时更新任务" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        residualflowService.updateLock();//把下个月生效的流量订单 状态更为有效
        List<TbResidualflow> list = residualflowService.query();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                userTopupRcdService.updateStatus(list.get(i).getIdxOrderID());//把用户表中的生效订单 状态置为0
            }
        } else {
            LogUtils.info("***********   NOT FOUND TbResidualflow   **************");
        }
    }

}
