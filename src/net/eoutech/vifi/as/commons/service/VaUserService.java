package net.eoutech.vifi.as.commons.service;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.*;
import net.eoutech.vifi.as.commons.entity.*;
import net.eoutech.vifi.as.commons.utils.CommonUtils;
import net.eoutech.vifi.as.commons.utils.ConfigUtils;
import net.eoutech.vifi.as.commons.utils.DateUtils;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.commons.vo.VaAgent;
import net.eoutech.vifi.as.commons.vo.VaUser;
import net.eoutech.vifi.as.commons.vo.VaUserSuite;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SUU on 2016/5/31.
 */
public class VaUserService {

    public static VaUserService getInstance() {
        return MybatisUtils.sqlProxyInstance( VaUserService.class );
    }

    @MyQuery( qryClass = TbUserDao.class )
    public String getUserCallDomainByUId( String uid, Object... daos ) {
        TbUserDao dao = ( TbUserDao ) daos[ 0 ];
        TbUser tbUser = dao.selectByPhoneNumber( uid );
        if ( tbUser == null ) {
            return "";
        }
        return tbUser.getLastAPPPublicIP() + VaConst.Symbol.COLON + tbUser.getLastAPPPublicPort();
    }

    @MyQuery( qryClass = TbUserDao.class )
    public boolean isUUWiFiUser ( String uid, Object...daos ) {
        TbUserDao dao = ( TbUserDao ) daos[0];
        return dao.fuzzyQueryUserByUId( uid ) != null;
    }

    @MyQuery( qryType = MyQuery.QUERY, qryClass = { TbUserSuiteDao.class, TbUUWiFiAreaDao.class } )
    public void setUserVoiceSuite ( String calleeNum, String suiteType, VaUser user, Object...daos ) {
        TbUserSuiteDao dao = ( TbUserSuiteDao ) daos[0];
        TbUUWiFiAreaDao areaDao = ( TbUUWiFiAreaDao ) daos[1];
        // 去掉被叫号码前面的00
        calleeNum = calleeNum.trim();
        calleeNum = calleeNum.replaceFirst( "^0*", VaConst.Common.EMPTY );

        int totalSuiteValue = 0;
        List< VaUserSuite > userSuiteList = null;

        List< TbUserSuite > tbUserSuiteList = dao.selectByUserIdSuiteType( user.getUid(), suiteType, null );
        if ( tbUserSuiteList != null && tbUserSuiteList.size() > 0 ) {
            userSuiteList = new ArrayList< VaUserSuite >();
            for ( TbUserSuite tbUserSuite : tbUserSuiteList ) {

                if ( VaConst.Common.UUWIFI_FIRST_AREAID.equals( tbUserSuite.getIdxUUWiFiAreaId() ) ) {
                    totalSuiteValue += tbUserSuite.getRemainValue();
                    userSuiteList.add( new VaUserSuite( tbUserSuite ) );
                } else {
                    String idxCode = areaDao.getIdxCode( tbUserSuite.getIdxUUWiFiAreaId() );
                    if ( !StringUtils.isEmpty( idxCode ) && calleeNum.startsWith( idxCode ) ) {
                        totalSuiteValue += tbUserSuite.getRemainValue();
                        userSuiteList.add( new VaUserSuite( tbUserSuite ) );
                    }
                }
            }
        }

        user.setTotalSuiteValue( totalSuiteValue < 0 ? 0 : totalSuiteValue );
        user.setUserSuites( userSuiteList );
    }

    @MyQuery( qryType = MyQuery.QUERY, qryClass = { TbUserSuiteDao.class, TbDailyRentalDao.class } )
    public void setUserDataSuite ( String areaId, String suiteType, String vid, VaUser user, Object...daos ) {
        TbUserSuiteDao userSuiteDao = ( TbUserSuiteDao ) daos[0];
        TbDailyRentalDao dailyRentalDao = ( TbDailyRentalDao ) daos[1];

        int totalSuiteValue = 0;
        List< VaUserSuite > userSuiteList = null;

        List< String > areaIdList = CommonUtils.domainStringFormat( areaId );
        if ( areaIdList == null && VaConst.Common.UUWIFI_FIRST_AREAID.equals( areaId ) ) {
            areaIdList = new ArrayList< String >();
        }

        if ( areaIdList != null ) {
            areaIdList.add( VaConst.Common.UUWIFI_FIRST_AREAID );

            List< TbUserSuite > tbUserSuites = userSuiteDao.selectByUserIdSuiteType( user.getUid(), suiteType, areaIdList );
            if ( tbUserSuites != null && tbUserSuites.size() > 0 ) {
                for ( TbUserSuite tbUserSuite : tbUserSuites ) {
                    totalSuiteValue += tbUserSuite.getRemainValue();
                    userSuiteList.add( new VaUserSuite( tbUserSuite ) );
                }
            }

            List< TbDailyRental > dailyRentalList = dailyRentalDao.selectByUserId( user.getUid(), vid );
            if ( dailyRentalList != null && dailyRentalList.size() > 0 ) {
                for ( TbDailyRental dailyRental : dailyRentalList ) {
                    String areaCodes = dailyRental.getAreaCodes();
                    boolean isFind = false;
                    if ( !StringUtils.isEmpty( areaCodes ) ) {
                        for ( String areaCode : areaCodes.split( "," ) ) {   // areaCodes => "u.cn.sz,u.cn.xt" | areaId => u.cn.sz.dx
                            if ( areaCode.indexOf( areaId ) != -1 ) {
                                isFind = true;
                                break;
                            }
                        }
                    }
                    if ( isFind ) {
                        user.setDailyRentalID( dailyRental.getKeyID() );
                        break;
                    }
                }
            }

        }
        user.setTotalSuiteValue( totalSuiteValue < 0 ? 0 : totalSuiteValue );
        user.setUserSuites( userSuiteList );
    }

    @MyQuery( qryType = MyQuery.QUERY, qryClass = { TbUserDao.class } )
    public VaUser queryUserByUserID( String userId, String qryParam, String suiteType, String vid, Object... daos ) {
        TbUserDao userDao = ( TbUserDao ) daos[ 0 ];

        TbUser tbUser = userDao.selectByPhoneNumber( userId );
        if ( tbUser == null ) {
            return null;
        }

        VaUser user = new VaUser();
        user.setUid( userId );
        user.setPass( tbUser.getPassword() );
        user.setCountryCode( tbUser.getIdxAreaCode() );
        user.setAppState( tbUser.getAppState() );
        user.setExpire( tbUser.getSipExpire() );
        user.setBalance( tbUser.getUserBalance() );
        user.setVpxId( tbUser.getIdxVPXID() );
        user.setLastOnlineIP( tbUser.getLastAPPPublicIP() );
        user.setLastOnlinePort( tbUser.getLastAPPPublicPort() );
        user.setLastAppDevInfo( tbUser.getLastAPPDevInfo() );
        user.setPushToken( tbUser.getPushToken() );
        user.setLastOnlineTime( tbUser.getLastAPPOnlineDate().getTime() );

        user.setTodayUUWiFiData( tbUser.getTodayUUWiFiData() == null ? 0 : tbUser.getTodayUUWiFiData() );
        user.setTodayMaxData( tbUser.getTodayMaxData() );
        user.setMonthUUWiFiData( tbUser.getMonthUUWiFiData() == null ? 0 : tbUser.getMonthUUWiFiData() );
        user.setMonthMaxData( tbUser.getMonthMaxData() );

        String firstAgentId = tbUser.getIdxAgentID();
        user.setFirstAgentId( StringUtils.isEmpty( firstAgentId ) ? ConfigUtils.getInstance().getCfgStr( "server.default.agentId" ) : firstAgentId );



        // 语音包查询
        if ( VaConst.Tables.TBUSERSUITE_SUITETYPE_LOCAL_CALL.equals( suiteType ) && !StringUtils.isEmpty( qryParam ) ) {
            setUserVoiceSuite( qryParam, suiteType, user );
        }

        // 流量包,日租查询
        if ( VaConst.Tables.TBUSERSUITE_SUITETYPE_LOCAL_DATA.equals( suiteType ) ) {
            setUserDataSuite( qryParam, suiteType, vid, user );
        }

        return user;
    }

    /**
     * 唤醒APP,让用户在线
     *
     * @return
     */
    private boolean awakenCalling() {
        return false;
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbUserDao.class )
    public int updateUserUUWiFiInfo( String userId, int data, Object... daos ) {
        TbUserDao dao = ( TbUserDao ) daos[ 0 ];
        TbUser tbUser = dao.selectByPhoneNumber( userId );
        if ( tbUser == null ) {
            return -1;
        }
        Date now = new Date();
        int todayUUWiFiData = tbUser.getTodayUUWiFiData() == null ? 0 : tbUser.getTodayUUWiFiData();
        int monthUUWiFiData = tbUser.getMonthUUWiFiData() == null ? 0 : tbUser.getMonthUUWiFiData();

        if ( DateUtils.isSameDate( tbUser.getLastUUWiFiDate(), now ) ) {
            todayUUWiFiData += data;
        } else {
            todayUUWiFiData = data;
        }

        if ( DateUtils.isSameMonth( tbUser.getLastUUWiFiDate(), now ) ) {
            monthUUWiFiData += data;
        } else {
            monthUUWiFiData = data;
        }

        tbUser.setLastUUWiFiDate( now );
        tbUser.setTodayUUWiFiData( todayUUWiFiData );
        tbUser.setMonthUUWiFiData( monthUUWiFiData );

        return dao.updateByPrimaryKeySelective( tbUser );
    }

}
