package net.eoutech.vifi.as.vsw.service.authorization;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.entity.TbResidualflow;
import net.eoutech.vifi.as.commons.entity.TbViFiDevice;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.service.VaAuthorizationService;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqVUPDATE;
import net.eoutech.vifi.as.vsw.msg.resp.VswMsgRespVUPDATE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 创建cdr、cost
 * Created by SUU on 2016/5/24.
 */
public class VswAuthorVUPDATEService extends VaAuthorizationService<VswMsgReqVUPDATE, VswMsgRespVUPDATE> {

    public VswAuthorVUPDATEService(VaMsgReq req, VaMsgResp resp) {
        super(req, resp);
    }

    @Override
    public int doAuthorization() {
//        simCardService.

        List<String> listKey = req.getOrderList();
        String keyId;
        for (int i = 0; i < listKey.size(); i++) {
            keyId = listKey.get(i);
            useFlowRcd = useFlowRcdService.getUseFlowByKey(keyId);
            //1G=1024M 1M=1024k  1k=1024bit
            int dataDown = useFlowRcd.getUpFlow();//  单位:bit  上行流量 与 下行流量
            int dataUp = useFlowRcd.getDownFlow();
            double total = (dataUp + dataDown) / 1024;//total K
            //对copy的simcard表操作  减去simcard上的流量
            String iccid = useFlowRcd.getIdxIccid();
            //扣除sim卡流量
            simCardService.resetNetData(iccid, total / 1024);//M


            List<TbResidualflow> list = residualflowService.queryList(useFlowRcd.getIdxUserId());
            //当剩余流量表中无此用户数据时，则是可直接使用的设备 只扣设备上的流量 没有扣用户上的流量
            if (list.size() == 0 && useFlowRcd.getIdxUserId().equals(useFlowRcd.getIdxVifiId())) {
                vifiDevice = vifiDeviceService.queryByUidAndVid(useFlowRcd.getIdxUserId(), useFlowRcd.getIdxVifiId());

                if (null != vifiDevice && (vifiDevice.getDeviceFlow() >= total/1024)) {

                    int statuss = vifiDeviceService.updateDeviceInfo(useFlowRcd.getIdxVifiId(), vifiDevice.getDeviceFlow() - total/1024);
                    LogUtils.info("VifiDevice update status:" + statuss);

                } else if (null != vifiDevice && (vifiDevice.getDeviceFlow() < total/1024)) {
                    LogUtils.info("flow lack");
                } else {
                    LogUtils.info("VifiDevice didn't find");
                }
            }


            TbResidualflow tbResidualflow = null;
            double residualflow = 0;
            double newResidualFlow = 0;
            for (int j = 0; j < list.size(); j++) {
                tbResidualflow = list.get(j);
                LogUtils.info("需要扣除的流量订单号：" + tbResidualflow.getIdxOrderID());
                residualflow = tbResidualflow.getResidualflow();//residualflow   单位M
                LogUtils.info("订单剩余流量:" + residualflow + "M  本次计费流量:" + total / 1024 + "M");
                newResidualFlow = (residualflow * 1024 - total) / 1024;
                if (newResidualFlow <= 0) {
                    total = total - residualflow * 1024;//K
                    //把没有流量的订单状态置为1
                    residualflowService.updateResidualStatus(tbResidualflow.getKeyId());
                    LogUtils.info("删除的订单ID:" + tbResidualflow.getKeyId() + "  剩余还需扣除的流量：" + total);
                } else if (newResidualFlow > 0) {
                    residualflowService.updateFlow(newResidualFlow, useFlowRcd.getIdxUserId(), tbResidualflow.getKeyId());
                    break;
                }
            }
        }

        return 0;
    }

    public int dataCost(List<TbResidualflow> list, double dataTraffic) {
        double resultFlow = -1;
        for (int i = 0; i < list.size(); i++) {
            TbResidualflow flow = list.get(i);
            double residualflow = flow.getResidualflow();
            resultFlow = residualflow - dataTraffic;
            if (resultFlow > 0 && resultFlow < flow.getResidualflow()) {
                residualflowService.updateFlow(resultFlow, uid, flow.getKeyId());
                break;
            } else {
                if (resultFlow == 0) {
                    residualflowService.delete(uid, flow.getKeyId());
                    break;
                } else if (resultFlow < 0) {
                    dataTraffic = dataTraffic - residualflow;
                    residualflowService.delete(uid, flow.getKeyId());
                    myInfo("delete residualflow,uid:{0},keyid:{1},", uid, flow.getKeyId());
                }
            }
        }
        if (resultFlow < 0) {
            TbResidualflow tbResi = new TbResidualflow();
            Date now = new Date();
            tbResi.setIdxOrderID(createOrderID());
            tbResi.setIdxUserID(uid);
            tbResi.setResidualflow(resultFlow);
            tbResi.setPriority(list.get(0).getPriority());
            tbResi.setPkgType(list.get(0).getPkgType());
            tbResi.setEffectiveTm(getTime());
            tbResi.setCrtTm(now);
            tbResi.setStatus("2");
            residualflowService.insertFlow(tbResi, 0);
            myInfo("VUPDATE1:user1 payment1 not1 enough1.uid1:{0},residualflow:{1}", uid, resultFlow);
            return this.resp.setSipCode(SipCodeEunm.SIP_402_USER_PAYMENT_NOT_ENOUGH);
        }
        return 0;
    }

    public Date getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse("2999-12-31 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private String createOrderID() {
        StringBuffer sb = new StringBuffer("AYB");
        SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmssSSS");
        sb.append(sf.format(new Date()));
        sb.append(buildRandomStr(4));
        return sb.toString();
    }

    public static String buildRandomStr(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
