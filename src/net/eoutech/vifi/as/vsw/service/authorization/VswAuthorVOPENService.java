package net.eoutech.vifi.as.vsw.service.authorization;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;
import net.eoutech.vifi.as.commons.utils.CommonUtils;
import net.eoutech.vifi.as.commons.vo.VaViFiAction;
import net.eoutech.vifi.as.service.VaAuthorizationService;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqVOPEN;
import net.eoutech.vifi.as.vsw.msg.resp.VswMsgRespVOPEN;
import org.apache.commons.lang.StringUtils;

/**
 * Created by SUU on 2016/5/24.
 */
public class VswAuthorVOPENService extends VaAuthorizationService< VswMsgReqVOPEN, VswMsgRespVOPEN > {

    public VswAuthorVOPENService( VaMsgReq req, VaMsgResp resp ) {
        super( req, resp );
    }

    @Override
    public int doAuthorization() {
        action = new VaViFiAction( req );

        this.sid = req.getSessid();

        action.setSessionId( sid );

        session = sessionService.getSessionBySID( sid );//获取Session

        vifiDevice = session != null ? session.getVifiDevice() : null;//通过Session获取设备对象
        vid = vifiDevice != null ? vifiDevice.getVid() : VaConst.Common.EMPTY;//通过设备对象获取设备号
        uid = vid != null ? cardStatusService.selectByVifiId(vid).getIdxUserId() : VaConst.Common.EMPTY;//通过设备号获取开启设备的用户编号

        action.setVid( vid );
        action.setUid( uid );

        if ( !sessionService.checkSession( session ,cardStatusService.selectByVifiId(vid).getStatus() ) ) {//检查Session和设备是否处于允许上卡的状态
            myInfo( "VOPEN:check session fail." );
            if ( session != null && !simCardService.checkSimCardStatus( session.getSimCard() ) ) {//判断SIM卡的状态是否正常(用于checkSession失败后判断是否是因为SIM卡的状态的问题)
                myInfo( "VOPEN:check simCard status fail.set expires = 0" );
                resp.setSidExp( 0 );
            }
            int closeSessionRes = sessionService.closeSession( sid, true );//关闭Session
            if ( session.getStatus().equals("13") ) {//["11","使用中"],["12","待释放"],["13","已释放"]
                cardStatusService.updateCardStatus( vid );
            }
            myInfo( "VOPEN:close session.close res:{0}", closeSessionRes );
            return this.resp.setSipCode( SipCodeEunm.SIP_403_FORBIDDEN );
        }

        agentId = StringUtils.isEmpty( vifiDevice.getAgentId() ) ? configUtils.getCfgStr( "server.default.agentId" ) : vifiDevice.getAgentId();

        user = userService.queryUserByUserID( uid, session.getUuWiFiAreaId(), VaConst.Tables.TBUSERSUITE_SUITETYPE_LOCAL_DATA, vid );//查询相关用户
        if ( user == null || cardStatusService.selectByVifiId(vid).getStatus().equals("1") ) {
            myInfo( "VOPEN:vifi device not found user.vid:{0},uid:{1}", vifiDevice.getVid(), uid );
            return this.resp.setSipCode( SipCodeEunm.SIP_404_DEVICE_NOT_BIND_USER );
        } else if ( user.outMaxTodayData() ) {
            myInfo( "VOPEN:user outOf today Max data.uid:{0},todayData:{1},todayMaxData:{2}", uid, user.getTodayUUWiFiData(), user.getTodayMaxData() );
            return this.resp.setSipCode( SipCodeEunm.SIP_403_USER_OUTOF_MAXDATA );
        } else if ( user.outMaxMonthData() ) {
            myInfo( "VOPEN:user outOf this month max data.uid:{0},monthData:{1},monthMaxData:{2}", uid, user.getMonthUUWiFiData(), user.getMonthMaxData() );
            return this.resp.setSipCode( SipCodeEunm.SIP_403_USER_OUTOF_MAXDATA );
        }

//        // 计费授权
//        if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_SIMPOOL.equals( session.getType() ) ) {
//
//            if ( user.getDailyRentalID() == 0 && user.getTotalSuiteValue() <= 0 ) {
//                rate = rateService.getRateByAreaId( session.getSimCard().getAreaId(), agentId );
//                if ( rate == null ) {
//                    myInfo( "VOPEN:not found rate.areaId:{0},agentId:{1}", session.getSimCard().getAreaId(), agentId );
//                    return this.resp.setSipCode( SipCodeEunm.SIP_403_FORBIDDEN );
//                }
//                if ( user.getBalance() < rate.getPrice() ) {
//                    myInfo( "VOPEN:user payment not enough.userId:{0},userSuiteValue:{1},userBalance:{2},rateId:{3},ratePrice:{4}", user.getUid(), user.getTotalSuiteValue(), user.getBalance(), rate.getRateId(), rate.getPrice() );
//                    return this.resp.setSipCode( SipCodeEunm.SIP_402_USER_PAYMENT_NOT_ENOUGH );
//                }
//            }
//
//        }

        //设置正确OPEN返回参数
        resp.setSimpname( session.getSimPDev().getUsername() );
        resp.setGoipname( session.getGoIPDev().getUserName() );
        resp.setGoip_slot( session.getGoIPPort().getSlotNum() );
        resp.setSim_slot( session.getSimPPort().getSlotNum() );
        resp.setExp( session.getExpire() );
        resp.setSidExp( session.getExpire() );

        if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_SIMPOOL.equals( session.getType() ) ) {
            resp.setIp( session.getSimPDev().getIp() );
            resp.setPort( session.getSimPDev().getPort() );
            resp.setGoipns( VaConst.Common.EMPTY );
            resp.setSimpns( session.getSimPDev().getUsername() + "." + CommonUtils.nsFormat( session.getSimPPort().getSlotNum(), String.valueOf( session.getSimPDev().getPorts() ).length() ) );
        } else {
            resp.setIp( session.getGoIPDev().getIp() );
            resp.setPort( session.getGoIPDev().getPort() );
            resp.setGoipns( session.getGoIPDev().getUserName() + "." + CommonUtils.nsFormat( session.getGoIPPort().getSlotNum(), session.getGoIPDev().getPorts().length() ) );
            resp.setSimpns( VaConst.Common.EMPTY );
            resp.setHot_num( CommonUtils.hostNumberFormat( session.getVifiDevice().getUserId() ) );
        }

        // 如果session的状态为临时关闭状态,需要修改为激活状态
        int status = VaConst.Tables.TBUUWIFISESSION_STATUS_OFFLINE_TEMP == session.getStatus() ? VaConst.Tables.TBUUWIFISESSION_STATUS_ONLINE : 0;
        sessionService.updateSession( sid, status );
        //修改设备最后在线信息
        vifiDeviceService.updateDeviceLastOnlineInfo( vid, null, null );

        return 0;
    }

}
