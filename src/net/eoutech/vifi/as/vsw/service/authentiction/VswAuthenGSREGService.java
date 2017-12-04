package net.eoutech.vifi.as.vsw.service.authentiction;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;
import net.eoutech.vifi.as.commons.utils.DateUtils;
import net.eoutech.vifi.as.service.VaAuthenticationService;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqGSREG;
import net.eoutech.vifi.as.vsw.msg.resp.VswMsgRespGSREG;
import net.eoutech.vifi.as.vsw.service.utils.VaGoIPDeviceService;
import net.eoutech.vifi.as.vsw.vo.VaSimPDevice;

/**
 * GSREG
 * 1.设备注册，更新注册时间（必须）
 * 2.端口状态更新（更新状态有变化的端口）
 *
 * Created by SUU on 2016/5/24.
 */
public class VswAuthenGSREGService extends VaAuthenticationService< VswMsgReqGSREG, VswMsgRespGSREG > {

    public VswAuthenGSREGService( VaMsgReq req, VaMsgResp resp ) {
        super( req, resp );
    }
    //认证  0代表找到了
    @Override
    public int doAuthentication() {
        // 查找gs设备
        if ( VaConst.Request.GSREG_TYPE_SIMP.equals( "S" ) ) {
            //if ( VaConst.Request.GSREG_TYPE_SIMP.equals( req.getType() ) ) {
            //查询数据库  getSimPDeviceByUserName
            simPDevice = simPDeviceService.getSimPDeviceByUserName( req.getUsername() );

            if ( simPDevice == null ) {
               // myInfo( "GSREG:not found simp device,request type:{0},username:{1}", req.getType(), req.getUsername() );
                return this.resp.setSipCode( SipCodeEunm.SIP_404_NOT_FOUND );
            }
            //检查IP是否改变，或者是设备掉线（超时）
            if ( !req.getIp().equals( simPDevice.getIp() ) || VaConst.Tables.TBSIMPDEV_STATUS_ONLINE != simPDevice.getStatus() || DateUtils.isTimeout( simPDevice.getExpire(), VaConst.Expire.TIMEOUT_DELAY, simPDevice.getLastUpdateTime() ) ) {
                //TODO 调用commonUtils中的加密算法验证请求中的nonce...参数,如果验证失败返回错误码
                myInfo( "check device pass." );
            }
        //goip
        } else {
            goIPDevice = goIPDeviceService.getGoIPDeviceByUserName( req.getUsername() );
            if ( goIPDevice == null ) {
                myInfo( "GSREG:not found goip device,request type:{0},username:{1}", req.getType(), req.getUsername() );
                return this.resp.setSipCode( SipCodeEunm.SIP_404_NOT_FOUND );
            }
            //检查IP是否改变，或者是设备掉线（超时）
            if ( !req.getIp().equals( goIPDevice.getIp() ) || VaConst.Tables.TBGOIPDEV_STATUS_ONLINE != goIPDevice.getStatus() || DateUtils.isTimeout( goIPDevice.getExpire(), VaConst.Expire.TIMEOUT_DELAY, goIPDevice.getLastUpdateTime() ) ) {
                //TODO 调用commonUtils中的加密算法验证请求中的nonce...参数,goIPDevice
                myInfo( "check device pass." );
            }
        }
        return 0;
    }

}
