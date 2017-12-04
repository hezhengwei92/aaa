package net.eoutech.vifi.as.commons.service;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbUUMsgQueueDao;
import net.eoutech.vifi.as.commons.dao.TbUUMsgTmplDao;
import net.eoutech.vifi.as.commons.entity.TbUUMsgQueue;
import net.eoutech.vifi.as.commons.entity.TbUUMsgTmpl;
import net.eoutech.vifi.as.commons.utils.ConfigUtils;
import net.eoutech.vifi.as.commons.utils.MyMatcherUtils;
import net.eoutech.vifi.as.commons.utils.MyUDPClient;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by SUU on 2016/7/29.
 */
public class VaPushService {

    public static VaPushService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaPushService.class );
    }

    private MyUDPClient udpClient = MyUDPClient.getInstance();
    private ConfigUtils configUtils = ConfigUtils.getInstance();

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = { TbUUMsgQueueDao.class, TbUUMsgTmplDao.class } )
    public int push ( String uid, String agentId, String appDevInfo, String ip, Map< String, String > msgInfo, Object...daos ) {
        TbUUMsgQueueDao queueDao = ( TbUUMsgQueueDao ) daos[0];
        TbUUMsgTmplDao tmplDao = ( TbUUMsgTmplDao ) daos[1];

        String name = VaConst.Tables.TBUUMSGTMPL_NAME_CALLPUSH;
//        if ( appDevInfo.startsWith( VaConst.Push.HW_PUSH_PREFIX ) ) {
//            name = VaConst.Push.HW_PUSH_PREFIX + "_" + name;
//        } else if ( appDevInfo.startsWith( VaConst.Push.XM_PUSH_PREFIX ) ) {
//            name = VaConst.Push.XM_PUSH_PREFIX + "_" + name;
//        } else if ( appDevInfo.startsWith( VaConst.Push.GT_PUSH_PREFIX ) ) {
//            name = VaConst.Push.GT_PUSH_PREFIX + "_" + name;
//        } else if ( appDevInfo.startsWith( VaConst.Push.SIP_PUSH_PREFIX ) ) {
//            name = VaConst.Push.SIP_PUSH_PREFIX + "_" + name;
//        }

        TbUUMsgTmpl tbUUMsgTmpl = tmplDao.selectByNameLang( name, VaConst.Tables.TBUUMSGTMPL_LANG_CALL_PUSH );
        String message = VaConst.Tables.TBUUMSGQUEUE_PUSHMSG_DEFAULT;
        int tmplId = 0;
        if ( tbUUMsgTmpl != null ) {
            message = tbUUMsgTmpl.getMsgTmpl();
            tmplId = tbUUMsgTmpl.getKeyTmplId();
        }
        message = MyMatcherUtils.getInstance().doMatcherReplace( message, msgInfo );
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        calendar.add( Calendar.MINUTE, 5 );

        // 添加UUMsgQueue
        TbUUMsgQueue tbUUMsgQueue = new TbUUMsgQueue();
        tbUUMsgQueue.setMsgType( VaConst.Tables.TBUUMSGQUEUE_MSGTYPE_COMMAND );
        tbUUMsgQueue.setSender( VaConst.SystemAuthor.AUTHOR );
        tbUUMsgQueue.setReceiver( uid );
        tbUUMsgQueue.setIdxUUWiFiAreaId( VaConst.Common.UUWIFI_FIRST_AREAID );
        tbUUMsgQueue.setMessage( message );
        tbUUMsgQueue.setState( VaConst.Tables.TBUUMSGQUEUE_STATE_WAIT );
        tbUUMsgQueue.setSendTime( date );
        tbUUMsgQueue.setExpiryTime( calendar.getTime() );

        tbUUMsgQueue.setRetry( 0 );
        tbUUMsgQueue.setMaxRetry( 5 );
        tbUUMsgQueue.setPri( 0 );
        tbUUMsgQueue.setIdxExternalID( 0 );

        tbUUMsgQueue.setIpaddr( ip );

        tbUUMsgQueue.setMsgTmplId( tmplId );
        tbUUMsgQueue.setIdxAgentID( agentId );
        tbUUMsgQueue.setUpdateBy( VaConst.SystemAuthor.AUTHOR );
        tbUUMsgQueue.setUpdateTime( date );
        tbUUMsgQueue.setCreatedBy( VaConst.SystemAuthor.AUTHOR );
        tbUUMsgQueue.setCreatedTime( date );

        int result = queueDao.insertSelective( tbUUMsgQueue );

        // 发送推送信号
        udpClient.sendMsg( configUtils.getCfgStr( "push.server.send.msg" ) );

        return result;
    }

}
