package net.eoutech.vifi.as.vsw.service.accounting;

import net.eoutech.vifi.as.commons.base.VaMsgReq;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.enums.SipCodeEunm;
import net.eoutech.vifi.as.commons.service.VaCDRService;
import net.eoutech.vifi.as.commons.service.VaCostService;
import net.eoutech.vifi.as.commons.vo.VaCDR;
import net.eoutech.vifi.as.service.VaAccountingService;
import net.eoutech.vifi.as.vsw.msg.req.VswMsgReqVUPDATE;
import net.eoutech.vifi.as.vsw.msg.resp.VswMsgRespVUPDATE;
import org.apache.commons.lang.StringUtils;

/**
 * Created by SUU on 2016/5/24.
 */
public class VswAccVUPDATEService extends VaAccountingService< VswMsgReqVUPDATE, VswMsgRespVUPDATE > {

    public VswAccVUPDATEService( VaMsgReq req, VaMsgResp resp ) {
        super( req, resp );
    }

    @Override
    public int doAccounting() {

        // 写CDR
        if ( cdr != null ) {
            int insertCdrRes = cdrService.addCDR( cdr );
            myInfo( "VUPDATE:accounting insert cdr result:{0}", insertCdrRes );
        } else {
            myInfo( "VUPDATE:accounting no cdr,sid:{0},up:{1},down:{2}", req.getSessid(), req.getUp(), req.getDown() );
        }

        if ( cost != null ) {
            int userCostRes = costService.userCost( cost.getUserId(), cost.getBalanceCost() );
            int suiteCostRes = costService.userSuiteCost( cost.getSuiteCosts() );
            String cdrId = cdr == null ? "0" : String.valueOf( cdr.getKeyCDRID() );
            int agentCostRes = costService.agentCost( agentId, cost.getBalanceCost(), cdrId );

            myInfo( "VUPDATE:accounting cost|userCostRes:{0}|suiteCostRes:{1}|agentCostRes:{2}", userCostRes, suiteCostRes, agentCostRes );
            if ( userCostRes < 0 || suiteCostRes < 0 || agentCostRes < 0 ) {
                myWarn( "VUPDATE:accounting cost exception." );
                return this.resp.setSipCode( SipCodeEunm.SIP_500_INTERNAL_SERVER_ERROR );
            }

        } else {
            myInfo( "VUPDATE:no accounting,cost is NULL" );
        }

        return 0;

    }
}