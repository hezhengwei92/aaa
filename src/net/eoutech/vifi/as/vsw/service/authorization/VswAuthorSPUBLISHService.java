package net.eoutech.vifi.as.vsw.service.authorization;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.entity.TbSimPPort;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;
import net.eoutech.vifi.as.service.VaAuthorizationService;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqSPUBLISH;
import net.eoutech.vifi.as.vsw.msg.resp.VswMsgRespSPUBLISH;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by SUU on 2016/5/24.
 */
public class VswAuthorSPUBLISHService extends VaAuthorizationService< VswMsgReqSPUBLISH, VswMsgRespSPUBLISH >{
    public VswAuthorSPUBLISHService( VaMsgReq req, VaMsgResp resp ) {
        super( req, resp );
    }
    //定义一个存储队列用来接收收到的入库数据，满200条后执行插入操作
    private Queue<VswMsgReqSPUBLISH> queue = new ArrayBlockingQueue(1);

    @Override
    public int doAuthorization() {
        /**
         *  sim卡的状态      卡槽状态即sim卡状态
         *  [["0","空闲"],["1","使用中"],["2","无卡"],["3","SIM卡故障"]]
         *
         */

//        queue.offer(req);
//        if (!queue.isEmpty()){
//            VswMsgReqSPUBLISH req=queue.poll();

            simPDevice = simPDeviceService.getSimPDeviceByUserName(req.getUsername());
            if (null == simPDevice) {
                myInfo("not found simPDevice.username:{0},type:S", req.getUsername());
                return this.resp.setSipCode(SipCodeEunm.SIP_404_NOT_FOUND);
            }

            int[] intByte = req.getCardATR();
            if (intByte != null) {
                byte ATR[] = new byte[intByte.length];
                myDbg(req.getIccid()+" -------------------- ATR.length:"+req.getCardATR().length);
                for (int i = 0; i < intByte.length; i++) {
                    ATR[i] = (byte) intByte[i];
                }
                //添加SIM卡  新卡添加 旧卡更新   SimCardCopy：备份sim卡 计算单张流量
                simCardService.addSimCardCopy(req.getUsername(),req.getIccid(), req.getImsi(), ATR, req.getStatus());
                simCardService.addSimCard(req.getIccid(), req.getImsi(), ATR, req.getStatus());

                myDbg("------- > > > add new card");
                TbSimPPort tbSimPPort = simPPortService.getSimByIccid(req.getIccid());
                if (null == tbSimPPort) {
                    if (req.getStatus() == 0) {
                        // 0  卡池上卡
                        simPPortService.portPublish(req.getUsername(), req.getSim_slot(), req.getIccid(), req.getStatus());
                        myDbg("------- > > > insert card into DevPort ok");
                    } else {
                        myDbg("------- > > >", "error:no fund card!");
                    }
                }
                if(null != tbSimPPort){
                    simPPortService.portPublish(req.getUsername(), req.getSim_slot(), req.getIccid(), req.getStatus());
                    myDbg("------- > > > update card status:"+req.getStatus());
                }

            } else {
                //sim卡 故障或是被拔出
                if (req.getStatus() == 2) {
                    //拔卡  先改变SIM卡的状态,再拔卡
                    int changeSimCard = simCardService.changeSimCard(req.getUsername(), req.getSim_slot(), req.getStatus());
                    if (changeSimCard==1){
                        myDbg("卡槽上没有sim卡");
                    }else if(changeSimCard==0){
                        int portPullRes = simPPortService.pullPublish(req.getUsername(), req.getSim_slot(), req.getStatus());
                        myDbg("------- > > >  remove card from dev SUCCESS ！"+req.getUsername());
                    }
                }
                if(req.getStatus()==3){
                    //3 卡故障
                    int changeSimCard = simCardService.changeSimCard(req.getUsername(), req.getSim_slot(), req.getStatus());
                    if (changeSimCard==1){
                        myDbg("卡槽上没有sim卡");
                    }else if(changeSimCard==0){
                        int portPullRes = simPPortService.pullPublish(req.getUsername(), req.getSim_slot(), req.getStatus());
                        myDbg("------- > > > update card trouble！status:"+req.getStatus());                    }
//                    simPPortService.portPublish(req.getUsername(), req.getSim_slot(), req.getIccid(), req.getStatus());
                }
            }
//        }
        return 0;
    }


}
