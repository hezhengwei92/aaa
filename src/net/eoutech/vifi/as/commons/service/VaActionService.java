package net.eoutech.vifi.as.commons.service;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.dao.TbViFiActionDao;
import net.eoutech.vifi.as.commons.entity.TbViFiAction;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.commons.vo.VaViFiAction;

import java.util.Date;

/**
 * Created by SUU on 2016/6/27.
 */
public class VaActionService {

    public static VaActionService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaActionService.class );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbViFiActionDao.class )
    public int doViFiActionRecord ( VaViFiAction action, Object...daos ) {
        TbViFiActionDao dao = ( TbViFiActionDao ) daos[0];
        if ( action == null ) {
            return 0;
        }

        Date date = new Date();
        TbViFiAction tbViFiAction = new TbViFiAction();
        tbViFiAction.setActionType( action.getActionType() );
        tbViFiAction.setIdxViFiID( action.getVid() );

        tbViFiAction.setIdxUserId( action.getUid() );
        tbViFiAction.setReqAct( action.getReqAct() );
        tbViFiAction.setReqIP( action.getReqIP() );
        tbViFiAction.setRespCode( action.getRespCode() );
        tbViFiAction.setRespReason( action.getRespReason() );
        tbViFiAction.setSessionId( action.getSessionId() );
        tbViFiAction.setReqDate( date );
        tbViFiAction.setHandTime( action.getHandTime() );

        return dao.insertSelective( tbViFiAction );
    }

}
