package net.eoutech.vifi.as.commons.service;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbCountDailyDao;
import net.eoutech.vifi.as.commons.dao.TbUUWiFiCountDailyDao;
import net.eoutech.vifi.as.commons.entity.TbCountDaily;
import net.eoutech.vifi.as.commons.entity.TbUUWiFiCountDaily;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.commons.vo.VaCount;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SUU on 2016/6/27.
 */
public class VaCountService {

    private SimpleDateFormat sf = new SimpleDateFormat( "yyyyMMdd" );

    public static VaCountService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaCountService.class );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbUUWiFiCountDailyDao.class )
    public int doDeviceCountDaily ( VaCount count, Object...daos ) {
        TbUUWiFiCountDailyDao dao = ( TbUUWiFiCountDailyDao ) daos[0];
        if ( count == null || StringUtils.isEmpty( count.getDeviceId() ) ) {
            return 0;
        }

        int result = 0;
        Date date = new Date();
        String keyUUWiFiCDID = getCountDailyID( count.getDeviceId() );
        TbUUWiFiCountDaily tbUUWiFiCountDaily = dao.selectByPrimaryKey( keyUUWiFiCDID );

        if ( tbUUWiFiCountDaily == null ) {
            tbUUWiFiCountDaily = new TbUUWiFiCountDaily();
            tbUUWiFiCountDaily.setKeyUUWiFiCDID( keyUUWiFiCDID );
            tbUUWiFiCountDaily.setIdxViFiID( count.getDeviceId() );

            if ( VaConst.Common.COUNT_CALL == count.getCountType() ) {  //通话统计
                if ( VaConst.Common.CALL_TYPE_GMO.equals( count.getCallType() ) ) {
                    tbUUWiFiCountDaily.setNumTotalMOGoip( 1 );

                    if ( count.isFailedCall() ) {
                        tbUUWiFiCountDaily.setNumFailedMOGoip( 1 );
                    } else if ( count.isShortCall() ) {
                        tbUUWiFiCountDaily.setNumShortMOGoip( 1 );
                    }

                    tbUUWiFiCountDaily.setDurMOGoip( count.getCallDuration() );
                } else if ( VaConst.Common.CALL_TYPE_MT.equals( count.getCallType() ) ) {
                    tbUUWiFiCountDaily.setNumTotalMTGoip( 1 );

                    if ( count.isFailedCall() ) {
                        tbUUWiFiCountDaily.setNumFailedMTGoip( 1 );
                    } else if ( count.isShortCall() ) {
                        tbUUWiFiCountDaily.setNumShortMTGoip( 1 );
                    }
                }

            } else if ( VaConst.Common.COUNT_DATA == count.getCountType() ) {  //流量统计
                tbUUWiFiCountDaily.setCntDataDown( count.getDataDown() );
                tbUUWiFiCountDaily.setCntDataUp( count.getDataUp() );
                tbUUWiFiCountDaily.setCntDataSum( count.getData() );
                tbUUWiFiCountDaily.setDeviceDur( count.getDeviceDur() );
            } else if ( VaConst.Common.COUNT_SMS == count.getCountType() ) {  //短信统计

                if ( VaConst.Common.GOIP_SMS_RECEIVE == count.getSmsMode() ) {
                    tbUUWiFiCountDaily.setNumSMSRecv( 1 );
                } else if ( VaConst.Common.GOIP_SMS_SEND == count.getSmsMode() ) {
                    tbUUWiFiCountDaily.setNumSMSSend( 1 );
                }

            }

            tbUUWiFiCountDaily.setCost( count.getCost() );

            tbUUWiFiCountDaily.setMdfTm( date );
            tbUUWiFiCountDaily.setMdfBy( VaConst.SystemAuthor.AUTHOR );
            tbUUWiFiCountDaily.setCrtBy( VaConst.SystemAuthor.AUTHOR );
            tbUUWiFiCountDaily.setCrtTm( date );

            result = dao.insertSelective( tbUUWiFiCountDaily );
        } else {

            if ( VaConst.Common.COUNT_CALL == count.getCountType() ) {  //通话统计

                if ( VaConst.Common.CALL_TYPE_GMO.equals( count.getCallType() ) ) {   //GoIP外呼
                    tbUUWiFiCountDaily.setNumTotalMOGoip( tbUUWiFiCountDaily.getNumTotalMOGoip() + 1 );

                    if ( count.isFailedCall() ) {
                        tbUUWiFiCountDaily.setNumFailedMOGoip( tbUUWiFiCountDaily.getNumFailedMOGoip() + 1 );
                    } else if ( count.isShortCall() ) {
                        tbUUWiFiCountDaily.setNumShortMOGoip( tbUUWiFiCountDaily.getNumShortMOGoip() + 1 );
                    }

                    tbUUWiFiCountDaily.setDurMOGoip( tbUUWiFiCountDaily.getDurMOGoip() + count.getCallDuration() );
                } else if ( VaConst.Common.CALL_TYPE_MT.equals( count.getCallType() ) ) {  //GoIP呼入
                    tbUUWiFiCountDaily.setNumTotalMTGoip( tbUUWiFiCountDaily.getNumTotalMTGoip() + 1 );

                    if ( count.isFailedCall() ) {
                        tbUUWiFiCountDaily.setNumFailedMTGoip( tbUUWiFiCountDaily.getNumFailedMTGoip() + 1 );
                    } else if ( count.isShortCall() ) {
                        tbUUWiFiCountDaily.setNumShortMTGoip( tbUUWiFiCountDaily.getNumShortMTGoip() + 1 );
                    }

                    tbUUWiFiCountDaily.setDurMTGoip( tbUUWiFiCountDaily.getDurMTGoip() + count.getCallDuration() );
                }

            } else if ( VaConst.Common.COUNT_DATA == count.getCountType() ) {   //流量统计

                tbUUWiFiCountDaily.setCntDataDown( tbUUWiFiCountDaily.getCntDataDown() + count.getDataDown() );
                tbUUWiFiCountDaily.setCntDataUp( tbUUWiFiCountDaily.getCntDataUp() + count.getDataUp() );
                tbUUWiFiCountDaily.setCntDataSum( tbUUWiFiCountDaily.getCntDataSum() + count.getData() );
                tbUUWiFiCountDaily.setDeviceDur( tbUUWiFiCountDaily.getDeviceDur() + count.getDeviceDur() );

            } else if ( VaConst.Common.COUNT_SMS == count.getCountType() ) {    //短信统计

                if ( VaConst.Common.GOIP_SMS_RECEIVE == count.getSmsMode() ) {
                    tbUUWiFiCountDaily.setNumSMSRecv( tbUUWiFiCountDaily.getNumSMSRecv() + 1 );
                } else if ( VaConst.Common.GOIP_SMS_SEND == count.getSmsMode() ) {
                    tbUUWiFiCountDaily.setNumSMSSend( tbUUWiFiCountDaily.getNumSMSSend() + 1 );
                }

            }

            tbUUWiFiCountDaily.setCost( tbUUWiFiCountDaily.getCost() + count.getCost() );

            tbUUWiFiCountDaily.setMdfTm( date );

            result = dao.updateByPrimaryKeySelective( tbUUWiFiCountDaily );
        }

        return result;
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbCountDailyDao.class )
    public int doUserCountDaily ( VaCount count, Object...daos ) {
        TbCountDailyDao dao = ( TbCountDailyDao ) daos[0];
        if ( count == null || StringUtils.isEmpty( count.getUserId() ) ) {
            return 0;
        }

        int result = 0;
        Date date = new Date();
        String keyCDID = getCountDailyID( count.getUserId() );
        TbCountDaily tbCountDaily = dao.selectByPrimaryKey( keyCDID );
        if ( tbCountDaily == null ) {
            tbCountDaily = new TbCountDaily();
            tbCountDaily.setKeyCDID( keyCDID );
            tbCountDaily.setIdxUserId( count.getUserId() );

            if ( VaConst.Common.COUNT_CALL == count.getCountType() ) {  //通话统计

                if ( VaConst.Common.CALL_TYPE_GMO.equals( count.getCallType() ) ) {
                    tbCountDaily.setNumTotalMOGoip( 1 );

                    if ( count.isFailedCall() ) {
                        tbCountDaily.setNumFailedMOGoip( 1 );
                    } else if ( count.isShortCall() ) {
                        tbCountDaily.setNumShortMOGoip( 1 );
                    }

                    tbCountDaily.setDurMOGoip( count.getCallDuration() );
                } else if ( VaConst.Common.CALL_TYPE_MT.equals( count.getCallType() ) ) {
                    tbCountDaily.setNumTotalMTGoip( 1 );

                    if ( count.isFailedCall() ) {
                        tbCountDaily.setNumFailedMTGoip( 1 );
                    } else if ( count.isShortCall() ) {
                        tbCountDaily.setNumShortMTGoip( 1 );
                    }

                    tbCountDaily.setDurMTGoip( count.getCallDuration() );
                } else if ( VaConst.Common.CALL_TYPE_VMO.equals( count.getCallType() ) ) {
                    tbCountDaily.setNumTotalMO( 1 );

                    if ( count.isFailedCall() ) {
                        tbCountDaily.setNumFailedMO( 1 );
                    } else if ( count.isShortCall() ) {
                        tbCountDaily.setNumShortMO( 1 );
                    }

                    tbCountDaily.setDurMO( count.getCallDuration() );
                } else if ( VaConst.Common.CALL_TYPE_MM.equals( count.getCallType() ) ) {
                    tbCountDaily.setNumTotalMMOut( 1 );

                    if ( count.isFailedCall() ) {
                        tbCountDaily.setNumFailedMMOut( 1 );
                    } else if ( count.isShortCall() ) {
                        tbCountDaily.setNumShortMMOut( 1 );
                    }

                    tbCountDaily.setDurMMOut( count.getCallDuration() );
                }

                tbCountDaily.setCallCost( count.getCost() );
            } else if ( VaConst.Common.COUNT_DATA == count.getCountType() ) {
                tbCountDaily.setCntDataDown( count.getDataDown() );
                tbCountDaily.setCntDataUp( count.getDataUp() );
                tbCountDaily.setCntDataSum( count.getData() );
                tbCountDaily.setDataCost( count.getCost() );
            } else if ( VaConst.Common.COUNT_SMS == count.getCountType() ) {
                if ( VaConst.Common.GOIP_SMS_SEND == count.getSmsMode() ) {
                    tbCountDaily.setNumSMSSend( 1 );
                } else if ( VaConst.Common.GOIP_SMS_RECEIVE == count.getSmsMode() ) {
                    tbCountDaily.setNumSMSRecv( 1 );
                }
                tbCountDaily.setSmsCost( count.getCost() );
            }

            tbCountDaily.setCost( count.getCost() );

            tbCountDaily.setMdfTm( date );
            tbCountDaily.setMdfBy( VaConst.SystemAuthor.AUTHOR );
            tbCountDaily.setCrtTm( date );
            tbCountDaily.setCrtBy( VaConst.SystemAuthor.AUTHOR );

            result = dao.insertSelective( tbCountDaily );
        } else {

            if ( VaConst.Common.COUNT_CALL == count.getCountType() ) {

                if ( VaConst.Common.CALL_TYPE_GMO.equals( count.getCallType() ) ) {
                    tbCountDaily.setNumTotalMOGoip( tbCountDaily.getNumTotalMOGoip() + 1 );
                    if ( count.isFailedCall() ) {
                        tbCountDaily.setNumFailedMOGoip( tbCountDaily.getNumFailedMOGoip() + 1 );
                    } else if ( count.isShortCall() ) {
                        tbCountDaily.setNumShortMOGoip( tbCountDaily.getNumShortMOGoip() + 1 );
                    }
                    tbCountDaily.setDurMOGoip( tbCountDaily.getDurMOGoip() + count.getCallDuration() );
                } else if ( VaConst.Common.CALL_TYPE_MM.equals( count.getCallType() ) ) {
                    tbCountDaily.setNumTotalMMOut( tbCountDaily.getNumTotalMMOut() + 1 );
                    if ( count.isFailedCall() ) {
                        tbCountDaily.setNumFailedMMOut( tbCountDaily.getNumFailedMMOut() + 1 );
                    } else if ( count.isShortCall() ) {
                        tbCountDaily.setNumShortMMOut( tbCountDaily.getNumShortMMOut() + 1 );
                    }
                    tbCountDaily.setDurMMOut( tbCountDaily.getDurMMOut() + count.getCallDuration() );
                } else if ( VaConst.Common.CALL_TYPE_MT.equals( count.getCallType() ) ) {
                    tbCountDaily.setNumTotalMTGoip( tbCountDaily.getNumTotalMTGoip() + 1 );
                    if ( count.isFailedCall() ) {
                        tbCountDaily.setNumFailedMTGoip( tbCountDaily.getNumFailedMTGoip() + 1 );
                    } else if ( count.isShortCall() ) {
                        tbCountDaily.setNumShortMTGoip( tbCountDaily.getNumShortMTGoip() + 1 );
                    }
                    tbCountDaily.setDurMTGoip( tbCountDaily.getDurMTGoip() + count.getCallDuration() );
                } else if ( VaConst.Common.CALL_TYPE_VMO.equals( count.getCallType() ) ) {
                    tbCountDaily.setNumTotalMO( tbCountDaily.getNumTotalMO() + 1 );
                    if ( count.isFailedCall() ) {
                        tbCountDaily.setNumFailedMO( tbCountDaily.getNumFailedMO() + 1 );
                    } else if ( count.isShortCall() ) {
                        tbCountDaily.setNumShortMO( tbCountDaily.getNumShortMO() + 1 );
                    }
                    tbCountDaily.setDurMO( tbCountDaily.getDurMO() + count.getCallDuration() );
                }

                tbCountDaily.setCallCost( tbCountDaily.getCallCost() + count.getCost() );
            } else if ( VaConst.Common.COUNT_DATA == count.getCountType() ) {
                tbCountDaily.setCntDataDown( tbCountDaily.getCntDataDown() + count.getDataDown() );
                tbCountDaily.setCntDataUp( tbCountDaily.getCntDataUp() + count.getDataUp() );
                tbCountDaily.setCntDataSum( tbCountDaily.getCntDataSum() + count.getData() );
                tbCountDaily.setDataCost( tbCountDaily.getDataCost() + count.getCost() );
            } else if ( VaConst.Common.COUNT_SMS == count.getCountType() ) {
                if ( VaConst.Common.GOIP_SMS_RECEIVE == count.getSmsMode() ) {
                    tbCountDaily.setNumSMSRecv( tbCountDaily.getNumSMSRecv() + 1 );
                } else if ( VaConst.Common.GOIP_SMS_SEND == count.getSmsMode() ) {
                    tbCountDaily.setNumSMSSend( tbCountDaily.getNumSMSSend() + 1 );
                }
                tbCountDaily.setSmsCost( tbCountDaily.getSmsCost() + count.getCost() );
            }

            tbCountDaily.setCost( tbCountDaily.getCost() + count.getCost() );

            tbCountDaily.setMdfTm( date );

            result = dao.updateByPrimaryKeySelective( tbCountDaily );
        }


        return result;
    }

    private String getCountDailyID ( String uvId ) {
        return sf.format( new Date() ) + uvId;
    }

}
