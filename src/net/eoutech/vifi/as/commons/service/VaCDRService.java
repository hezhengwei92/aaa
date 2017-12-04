package net.eoutech.vifi.as.commons.service;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbCDRDao;
import net.eoutech.vifi.as.commons.entity.TbCDR;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.commons.vo.VaCDR;

import java.util.Date;

/**
 * Created by SUU on 2016/6/2.
 */
public class VaCDRService {

    public static VaCDRService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaCDRService.class );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbCDRDao.class )
    public int addCDR ( VaCDR cdr, Object...daos ) {
        TbCDRDao dao = ( TbCDRDao ) daos[0];

        if ( cdr == null ) {
            return -1;
        }

        TbCDR tbCDR = new TbCDR();
        tbCDR.setIdxUserId( cdr.getIdxUserId() );
        tbCDR.setIdxDeductUserId( cdr.getIdxDeductUserId() );
        tbCDR.setCdrType( cdr.getCdrType() );
        tbCDR.setDirection( cdr.getDirection() );
        tbCDR.setDistance( cdr.getDistance() );
        tbCDR.setIdxRateId( cdr.getIdxRateId() );
        tbCDR.setSuiteRateIds( cdr.getSuiteRateIds() );
        tbCDR.setDailyRentalID( cdr.getDailyRentalID() );
        tbCDR.setDnis( cdr.getDnis() );
        tbCDR.setCaller( cdr.getCaller() );
        tbCDR.setCallee( cdr.getCallee() );
        tbCDR.setStartTime( cdr.getStartTime() );
        tbCDR.setAnswerTime( cdr.getAnswerTime() );
        tbCDR.setStopTime( cdr.getStopTime() );
        tbCDR.setCallDuration( cdr.getCallDuration() );
        tbCDR.setDataTraffic( cdr.getDataTraffic() );
        tbCDR.setUuwifiDataUp( cdr.getUuwifiDataUp() );
        tbCDR.setUuwifiDataDown( cdr.getUuwifiDataDown() );
        tbCDR.setUuwifiSessId( cdr.getUuwifiSessId() );
        tbCDR.setCostCash( cdr.getCostCash() );
        tbCDR.setCostReward( cdr.getCostReward() );
        tbCDR.setBonus( cdr.getBonus() );
        tbCDR.setIdxSupplierId( cdr.getIdxSupplierId() );
        tbCDR.setSupplierDiscount( cdr.getSupplierDiscount() );
        tbCDR.setIdxAgentID( cdr.getIdxAgentID() );
        tbCDR.setAgentDiscount( cdr.getAgentDiscount() );
        tbCDR.setIdxCallID( cdr.getIdxCallID() );
        tbCDR.setIdxVPXID( cdr.getIdxVPXID() );
        tbCDR.setIdxTrunkID( cdr.getIdxTrunkID() );
        tbCDR.setHangupPart( cdr.getHangupPart() );
        tbCDR.setHangupReason( cdr.getHangupReason() );
        tbCDR.setIdxVSWID( cdr.getIdxVSWID() );
        tbCDR.setIdxGoIPID( cdr.getIdxGoIPID() );
        tbCDR.setIdxSimPID( cdr.getIdxSimPID() );
        tbCDR.setIdxSimCardID( cdr.getIdxSimCardID() );
        tbCDR.setIdxSMSGate( cdr.getIdxSMSGate() );
        tbCDR.setIdxVAPPID( cdr.getIdxVAPPID() );
        tbCDR.setIdxViFiID( cdr.getIdxViFiID() );
        tbCDR.setIspID( cdr.getIspID() );
        tbCDR.setCountryCode( cdr.getCountryCode() );
        tbCDR.setPubIP( cdr.getPubIP() );
        tbCDR.setArea( cdr.getArea() );
        tbCDR.setCrtTm( new Date() );
        tbCDR.setCrtBy( VaConst.SystemAuthor.AUTHOR );

        int addRes = dao.insertSelective( tbCDR );
        cdr.setKeyCDRID( tbCDR.getKeyCDRID() );
        return addRes;
    }

    @MyQuery( qryClass = TbCDRDao.class )
    public VaCDR getCDRByCallId ( String callId, Object...daos ) {
        TbCDRDao dao = ( TbCDRDao ) daos[0];
        TbCDR tbCDR = dao.selectByCallId( callId );
        if ( tbCDR == null ) {
            return null;
        }
        return new VaCDR( tbCDR );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbCDRDao.class )
    public int updateCDR ( VaCDR cdr, Object...daos ) {
        TbCDRDao dao = ( TbCDRDao ) daos[0];
        if ( cdr == null ) {
            return -1;
        }

        TbCDR tbCDR = dao.selectByCallId( cdr.getIdxCallID() );
        tbCDR.setIdxUserId( cdr.getIdxUserId() );
        tbCDR.setIdxDeductUserId( cdr.getIdxDeductUserId() );
        tbCDR.setCdrType( cdr.getCdrType() );
        tbCDR.setDirection( cdr.getDirection() );
        tbCDR.setDistance( cdr.getDistance() );
        tbCDR.setIdxRateId( cdr.getIdxRateId() );
        tbCDR.setSuiteRateIds( cdr.getSuiteRateIds() );
        tbCDR.setDailyRentalID( cdr.getDailyRentalID() );
        tbCDR.setDnis( cdr.getDnis() );
        tbCDR.setCaller( cdr.getCaller() );
        tbCDR.setCallee( cdr.getCallee() );
        tbCDR.setStartTime( cdr.getStartTime() );
        tbCDR.setAnswerTime( cdr.getAnswerTime() );
        tbCDR.setStopTime( cdr.getStopTime() );
        tbCDR.setCallDuration( cdr.getCallDuration() );
        tbCDR.setDataTraffic( cdr.getDataTraffic() );
        tbCDR.setUuwifiDataUp( cdr.getUuwifiDataUp() );
        tbCDR.setUuwifiDataDown( cdr.getUuwifiDataDown() );
        tbCDR.setUuwifiSessId( cdr.getUuwifiSessId() );
        tbCDR.setCostCash( cdr.getCostCash() );
        tbCDR.setCostReward( cdr.getCostReward() );
        tbCDR.setBonus( cdr.getBonus() );
        tbCDR.setIdxSupplierId( cdr.getIdxSupplierId() );
        tbCDR.setSupplierDiscount( cdr.getSupplierDiscount() );
        tbCDR.setIdxAgentID( cdr.getIdxAgentID() );
        tbCDR.setAgentDiscount( cdr.getAgentDiscount() );
        tbCDR.setIdxCallID( cdr.getIdxCallID() );
        tbCDR.setIdxVPXID( cdr.getIdxVPXID() );
        tbCDR.setIdxTrunkID( cdr.getIdxTrunkID() );
        tbCDR.setHangupPart( cdr.getHangupPart() );
        tbCDR.setHangupReason( cdr.getHangupReason() );
        tbCDR.setIdxVSWID( cdr.getIdxVSWID() );
        tbCDR.setIdxGoIPID( cdr.getIdxGoIPID() );
        tbCDR.setIdxSimPID( cdr.getIdxSimPID() );
        tbCDR.setIdxSimCardID( cdr.getIdxSimCardID() );
        tbCDR.setIdxSMSGate( cdr.getIdxSMSGate() );
        tbCDR.setIdxVAPPID( cdr.getIdxVAPPID() );
        tbCDR.setIdxViFiID( cdr.getIdxViFiID() );
        tbCDR.setIspID( cdr.getIspID() );
        tbCDR.setCountryCode( cdr.getCountryCode() );
        tbCDR.setPubIP( cdr.getPubIP() );
        tbCDR.setArea( cdr.getArea() );

        return dao.updateByPrimaryKeySelective( tbCDR );
    }

    @MyQuery( qryClass = TbCDRDao.class )
    public VaCDR getCDRByCrtTm ( String uid, Object...daos ) {
        TbCDRDao dao = ( TbCDRDao ) daos[0];
        TbCDR tbCDR = dao.selectCrtTm( uid );
        if ( tbCDR == null ) {
            return null;
        }
        return new VaCDR( tbCDR );
    }
    @MyQuery( qryClass = TbCDRDao.class )
    public VaCDR getCDRByUserId ( String uid, Object...daos ) {
        TbCDRDao dao = ( TbCDRDao ) daos[0];
        TbCDR tbCDR = dao.selectByUserId( uid );
        if ( tbCDR == null ) {
            return null;
        }
        return new VaCDR( tbCDR );
    }
}
