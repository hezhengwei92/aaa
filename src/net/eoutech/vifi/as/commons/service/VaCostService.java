package net.eoutech.vifi.as.commons.service;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbAgentDao;
import net.eoutech.vifi.as.commons.dao.TbAgentDeductionRcdDao;
import net.eoutech.vifi.as.commons.dao.TbUserDao;
import net.eoutech.vifi.as.commons.dao.TbUserSuiteDao;
import net.eoutech.vifi.as.commons.entity.TbAgent;
import net.eoutech.vifi.as.commons.entity.TbAgentDeductionRcd;
import net.eoutech.vifi.as.commons.entity.TbUser;
import net.eoutech.vifi.as.commons.utils.CommonUtils;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.commons.vo.VaUserSuite;

import java.util.*;


/**
 * Created by SUU on 2016/5/30.
 */
public class VaCostService {

    public static VaCostService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaCostService.class );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbUserDao.class )
    public int userCost ( String userId, int costValue, Object...daos ) {
        TbUserDao dao = ( TbUserDao ) daos[0];
        if ( costValue <= 0 ) {
            return 0;
        }

        TbUser tbUser = dao.selectByPhoneNumber( userId );
        if ( tbUser == null ) {
            return -1;
        }
        int userBalance = tbUser.getUserBalance() - costValue;
        tbUser.setUserBalance( userBalance );

        return dao.updateByPrimaryKeySelective( tbUser );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbUserSuiteDao.class )
    public int userSuiteCost ( List< VaUserSuite > suiteList, Object...daos ) {
        TbUserSuiteDao dao = ( TbUserSuiteDao ) daos[0];
        if ( suiteList == null || suiteList.size() <= 0 ) {
            return 0;
        }
        List< Map< String, Integer > > params = new ArrayList< Map< String, Integer > >();
        for ( VaUserSuite suite : suiteList ) {
            Map< String, Integer > map = new HashMap< String, Integer >();
            map.put( "suiteId", suite.getSuiteId() );
            map.put( "value", suite.getValue() );
            params.add( map );
        }
        return dao.suiteCostBatch( params );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = { TbAgentDao.class, TbAgentDeductionRcdDao.class } )
    public int agentCost ( String agentId, int costValue, String cdrId, Object...daos ) {
        TbAgentDao dao = ( TbAgentDao ) daos[0];
        TbAgentDeductionRcdDao tbAgentDeductionRcd = ( TbAgentDeductionRcdDao ) daos[1];
        if ( costValue <= 0 ) {
            return 0;
        }
        List< String > agentIdList = CommonUtils.domainStringFormat( agentId );
        if ( agentIdList == null ) {
            return 0;
        }
        List< TbAgent > agentList = dao.selectBatch( agentIdList );
        if ( agentList == null ) {
            return -1;
        }
        List<TbAgentDeductionRcd> agentDeductionRcds = new ArrayList<TbAgentDeductionRcd>();
        for ( TbAgent agent : agentList ) {
            //计算代理商的支付价格
            int agentCharge = costValue * agent.getDiscount() / 100;
            agentDeductionRcds.add( createAgentDeductionRcd( agent.getIdxAgentId(), cdrId, agent.getDiscount(), agentCharge, agent.getBalance() ) );
        }

        // 代理商扣费
        Map< String, Object > params = new HashMap< String, Object >();
        params.put( "cost", costValue );
        params.put( "list", agentIdList );
        int result = dao.agentCost( params );
        if ( result > 0 ) {
            tbAgentDeductionRcd.insertBatch( agentDeductionRcds );
        }
        return result;
    }

    private TbAgentDeductionRcd createAgentDeductionRcd ( String agentId, String cdrId, int agentDiscount, int agentCost, int agentBeforeValue ) {
        Date date = new Date();
        TbAgentDeductionRcd tbAgentDeductionRcd = new TbAgentDeductionRcd();
        tbAgentDeductionRcd.setIdxAgentID( agentId );
        tbAgentDeductionRcd.setIdxCDRId( cdrId );
        tbAgentDeductionRcd.setDiscount( agentDiscount );
        tbAgentDeductionRcd.setAmount( agentCost );
        tbAgentDeductionRcd.setBeforeValue( agentBeforeValue );
        tbAgentDeductionRcd.setAfterValue( agentBeforeValue - agentCost );
        tbAgentDeductionRcd.setMdfTm( date );
        tbAgentDeductionRcd.setMdfBy( VaConst.SystemAuthor.AUTHOR );
        tbAgentDeductionRcd.setCrtTm( date );
        tbAgentDeductionRcd.setCrtBy( VaConst.SystemAuthor.AUTHOR );
        return tbAgentDeductionRcd;
    }

}
