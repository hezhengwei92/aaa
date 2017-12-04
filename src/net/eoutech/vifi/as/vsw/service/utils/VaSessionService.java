package net.eoutech.vifi.as.vsw.service.utils;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbGoIPPortDao;
import net.eoutech.vifi.as.commons.dao.TbSimPPortDao;
import net.eoutech.vifi.as.commons.dao.TbUUWiFiSessionDao;
import net.eoutech.vifi.as.commons.entity.TbGoIPPort;
import net.eoutech.vifi.as.commons.entity.TbSimPPort;
import net.eoutech.vifi.as.commons.entity.TbUUWiFiSession;
import net.eoutech.vifi.as.commons.utils.*;
import net.eoutech.vifi.as.vsw.vo.*;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by SUU on 2016/5/30.
 */
public class VaSessionService {

    private EuIPUtils ipUtils = EuIPUtils.getInstance();
    private ConfigUtils configUtils = ConfigUtils.getInstance();
    private VaVSWService vswService = VaVSWService.getInstance();
    private VaGoIPDeviceService goIPDeviceService = VaGoIPDeviceService.getInstance();
    private VaGoIPPortService goIPPortService = VaGoIPPortService.getInstance();
    private VaSimPDeviceService simPDeviceService = VaSimPDeviceService.getInstance();
    private VaSimPPortService simPPortService = VaSimPPortService.getInstance();
    private VaSimCardService simCardService = VaSimCardService.getInstance();
    private VaViFiDeviceService viFiDeviceService = VaViFiDeviceService.getInstance();
    private VaCellService cellService = VaCellService.getInstance();
    private VaCardStatusService cardStatusService = VaCardStatusService.getInstance();

    public static VaSessionService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaSessionService.class );
    }

    @MyQuery( qryType = MyQuery.QUERY, qryClass = TbUUWiFiSessionDao.class )
    public String getSessionId ( String vid, String type, Object...daos ) {
        TbUUWiFiSessionDao dao = ( TbUUWiFiSessionDao ) daos[0];

        if ( VaConst.Request.GET_SESSTYPE_SIMP.equals( type ) ) {
            type = VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_SIMPOOL;
        } else if ( VaConst.Request.GET_SESSTYPE_GOIP.equals( type ) ) {
            type = VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_GOIP;
        }

        TbUUWiFiSession tbUUWiFiSession = dao.selectByVidAndType( vid, type );
        return tbUUWiFiSession == null ? VaConst.Common.EMPTY : tbUUWiFiSession.getKeySessID();
    }

    @MyQuery( qryClass = TbUUWiFiSessionDao.class )
    public VaSession getSessionBySID ( String sid, Object...daos ) {
        TbUUWiFiSessionDao dao = ( TbUUWiFiSessionDao ) daos[0];

        if ( StringUtils.isEmpty( sid ) ) {
            return null;
        }

        TbUUWiFiSession tbUUWiFiSession = dao.selectByPrimaryKey( sid );

        if ( tbUUWiFiSession == null ) {
            return null;
        }

        VaSession session = new VaSession();
        session.setId( sid );
        session.setType( tbUUWiFiSession.getSessType() );
        session.setUuWiFiCellId( tbUUWiFiSession.getIdxUUWiFiCellID() );
        session.setUuWiFiAreaId( tbUUWiFiSession.getIdxUUWiFiAreaId() );
        session.setExpire( tbUUWiFiSession.getExpire() );
        session.setStatus( tbUUWiFiSession.getStatus() );
        session.setLastUpdateTime( tbUUWiFiSession.getLastUpdate().getTime() );

        VaVSW vswServer = vswService.getVSWServerById( tbUUWiFiSession.getIdxVSWID() );
        session.setVswServer( vswServer );

        if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_GOIP.equals( tbUUWiFiSession.getSessType() ) ) {

            VaGoIPDevice goIPDevice = goIPDeviceService.getGoIPDeviceById( tbUUWiFiSession.getIdxGoipDevID() );
            session.setGoIPDev( goIPDevice );

            VaGoIPPort goIPPort = goIPPortService.getGoIPPortById( tbUUWiFiSession.getIdxGoipPortID() );
            // 做一个处理,检查端口状态
            if ( goIPPort != null && !tbUUWiFiSession.getIdxVifiID().equals( goIPPort.getVid() ) ) {
                goIPPort.setVid( VaConst.Common.EMPTY );
            }
            session.setGoIPPort( goIPPort );

            VaSimCard simCard = new VaSimCard();
            simCard.setIccid( tbUUWiFiSession.getIdxSimCIccId() );
            session.setSimCard( simCard );

            session.setSimPDev( new VaSimPDevice( tbUUWiFiSession.getIdxSimPDevID() ) );
            session.setSimPPort( new VaSimPPort( 1, 1 ) );

        } else if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_SIMPOOL.equals( tbUUWiFiSession.getSessType() ) ) {

            VaSimPDevice simPDevice = simPDeviceService.getSimPDeviceById( tbUUWiFiSession.getIdxSimPDevID() );
            session.setSimPDev( simPDevice );

            VaSimPPort simPPort = simPPortService.getSimPPortById( Integer.parseInt( tbUUWiFiSession.getIdxSimPPortId() ) );
            // 检查端口
            if ( simPPort != null && !tbUUWiFiSession.getIdxVifiID().equals( simPPort.getVid() ) ) {
                simPPort.setVid( VaConst.Common.EMPTY );
            }
            session.setSimPPort( simPPort );

            VaSimCard simCard = simCardService.getSimCardByIccid( tbUUWiFiSession.getIdxSimCIccId() );
            session.setSimCard( simCard );

            session.setGoIPDev( new VaGoIPDevice( tbUUWiFiSession.getIdxGoipDevID() ) );
            session.setGoIPPort( new VaGoIPPort( 1, 1 ) );

        } else {
            return null;
        }

        VaViFiDevice viFiDevice = viFiDeviceService.queryByVID( tbUUWiFiSession.getIdxVifiID() );
        session.setVifiDevice( viFiDevice );

        return session;
    }

    public boolean checkSession ( VaSession session ,String status) {

        if ( session == null ) {
            return false;
        }

        if ( VaConst.Tables.TBUUWIFISESSION_STATUS_OFFLINE == session.getStatus() || status.equals("1") ) {
            LogUtils.dbg( "check session fail:session is closed.sid:{0}", session.getId() );
            return false;
        }
        if ( DateUtils.isTimeout( session.getExpire(), VaConst.Expire.TIMEOUT_DELAY, session.getLastUpdateTime() ) ) {
            LogUtils.dbg( "check session fail:session is timeout.sid:{0}", session.getId() );
            return false;
        }

        VaVSW vsw = session.getVswServer();
        if ( vsw == null ) {
            LogUtils.dbg( "check session fail:vsw server not found,sid:{0}", session.getId() );
            return false;
        }
        if ( !VaConst.Tables.TBVSW_STATE_ONLINE.equals( vsw.getState() ) || DateUtils.isTimeout( vsw.getExpire(), VaConst.Expire.TIMEOUT_DELAY, vsw.getLastUpdate() ) ) {
            LogUtils.dbg( "check session fail:vsw server offline,vswId:{0}", vsw.getId() );
            return false;
        }

        if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_SIMPOOL.equals( session.getType() ) ) {
            VaSimPDevice simPDevice = session.getSimPDev();
            if ( simPDevice == null ) {
                LogUtils.dbg( "check session fail:simp device not found,sid:{0}", session.getId() );
                return false;
            }
            if ( VaConst.Tables.TBSIMPDEV_STATUS_ONLINE != simPDevice.getStatus() || DateUtils.isTimeout( simPDevice.getExpire(), VaConst.Expire.TIMEOUT_DELAY, simPDevice.getLastUpdateTime() ) ) {
                LogUtils.dbg( "check session fail:simp device offline,simPDevId:{0}", simPDevice.getId() );
                return false;
            }

            VaSimPPort simPPort = session.getSimPPort();
            if ( simPPort == null ) {
                LogUtils.dbg( "check session fail:simp port not found,sid:{0}", session.getId() );
                return false;
            }
            if ( VaConst.Tables.TBSIMPPORT_STATUS_HASSIM != simPPort.getStatus() || StringUtils.isEmpty( simPPort.getIccid() ) ) {
                LogUtils.dbg( "check session fail:simp port no sim card,simPPortId:{0}", simPPort.getId() );
                return false;
            }
            if ( StringUtils.isEmpty( simPPort.getVid() ) ) {
                LogUtils.dbg( "check session fail:simp port not bind vifi device,simPPortId:{0}", simPPort.getId() );
                return false;
            }

            VaSimCard simCard = session.getSimCard();
            if ( simCard == null ) {
                LogUtils.dbg( "check session fail:sim card not found.sid:{0}", session.getId() );
                return false;
            }
            if ( VaConst.Tables.TBSIMCARD_STATUS_ENABLE != simCard.getStatus() ) {
                LogUtils.dbg( "check session fail:sim card status disable.simCardId:{0}", simCard.getIccid() );
                return false;
            }
            if ( simCard.getRestNetData() <= 0 ) {
                LogUtils.dbg( "check session fail:sim card rest netData not enough.simCardId:{0}", simCard.getIccid() );
                return false;
            }
        } else if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_GOIP.equals( session.getType() ) ) {
            VaGoIPDevice goIPDevice = session.getGoIPDev();
            if ( goIPDevice == null ) {
                LogUtils.dbg( "check session fail:goip device not found,sid:{0}", session.getId() );
                return false;
            }
            if ( VaConst.Tables.TBGOIPDEV_STATUS_ONLINE != goIPDevice.getStatus() || DateUtils.isTimeout( goIPDevice.getExpire(), VaConst.Expire.TIMEOUT_DELAY, goIPDevice.getLastUpdateTime() )) {
                LogUtils.dbg( "check session fail:goip device offline,goIPDevId:{0}", goIPDevice.getId() );
                return false;
            }

            VaGoIPPort goIPPort = session.getGoIPPort();
            if ( goIPPort == null ) {
                LogUtils.dbg( "check session fail:goip port not found,sid:{0}", session.getId() );
                return false;
            }

            if ( StringUtils.isEmpty( goIPPort.getVid() ) ) {
                LogUtils.dbg( "check session fail:goip port-vid is empty.sid:{0},portId:{1}", session.getId(), goIPPort.getId() );
                return false;
            }
        }

        VaViFiDevice viFiDevice = session.getVifiDevice();
        if ( viFiDevice == null ) {
            LogUtils.dbg( "check session fail:vifi device not found,sid:{0}", session.getId() );
            return false;
        }
        if ( !VaConst.Tables.TBVIFIDEVICE_DEVSTATE_ENABLE.equals( viFiDevice.getDevState() ) ) {
            LogUtils.dbg( "check session fail:vifi device state disable,vid:{0}", viFiDevice.getVid() );
            return false;
        }
        return true;
    }


    /**
     * @param sid sessionId
     * @param isOver 是否要彻底关闭
     * @param daos
     * @return
     */
    @MyQuery( qryType = MyQuery.MODIFY, qryClass = { TbUUWiFiSessionDao.class, TbSimPPortDao.class, TbGoIPPortDao.class } )
    public int closeSession ( String sid, boolean isOver, Object...daos ) {
        TbUUWiFiSessionDao tbUUWiFiSessionDao = ( TbUUWiFiSessionDao ) daos[0];
        TbSimPPortDao tbSimPPortDao = ( TbSimPPortDao ) daos[1];
        TbGoIPPortDao tbGoIPPortDao = ( TbGoIPPortDao ) daos[2];

        TbUUWiFiSession tbUUWiFiSession = tbUUWiFiSessionDao.selectByPrimaryKey( sid );
        if ( tbUUWiFiSession == null ) {
            return -1;
        }

        int result = 0;
        Date date = new Date();
        tbUUWiFiSession.setLastUpdate( date );
        tbUUWiFiSession.setMdfTm( date );
        /*if ( !isOver && !DateUtils.isTimeout( tbUUWiFiSession.getExpire(), VaConst.Expire.TIMEOUT_DELAY, tbUUWiFiSession.getLastUpdate().getTime() ) ) {
            tbUUWiFiSession.setStatus( VaConst.Tables.TBUUWIFISESSION_STATUS_OFFLINE_TEMP );
        } else {*/
            tbUUWiFiSession.setStatus( VaConst.Tables.TBUUWIFISESSION_STATUS_OFFLINE );

            if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_GOIP.equals( tbUUWiFiSession.getSessType() ) ) {
                TbGoIPPort tbGoIPPort = tbGoIPPortDao.selectByPrimaryKey( tbUUWiFiSession.getIdxGoipPortID() );
                if ( tbGoIPPort != null ) {
                    tbGoIPPort.setIdxViFiID( VaConst.Common.EMPTY );
                    tbGoIPPort.setUuIccid( VaConst.Common.EMPTY );
                    tbGoIPPort.setUuImsi( VaConst.Common.EMPTY );
                    tbGoIPPort.setUserAct( VaConst.Common.EMPTY );
                    tbGoIPPort.setMdfTm( date );
                    result += tbGoIPPortDao.updateByPrimaryKeySelective( tbGoIPPort );
                }
            } else if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_SIMPOOL.equals( tbUUWiFiSession.getSessType() ) ) {
                TbSimPPort tbSimPPort = tbSimPPortDao.selectByPrimaryKey( Integer.parseInt( tbUUWiFiSession.getIdxSimPPortId() ) );
                if ( tbSimPPort != null ) {
                    tbSimPPort.setIdxViFiId( VaConst.Common.EMPTY );
                    tbSimPPort.setMdfTm( date );
                    result += tbSimPPortDao.updateByPrimaryKeySelective( tbSimPPort );
                }
            }
        //}

        result += tbUUWiFiSessionDao.updateByPrimaryKeySelective( tbUUWiFiSession );

        return result;
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbUUWiFiSessionDao.class )
    public int updateSession ( String sid, Integer status, Object...daos ) {
        TbUUWiFiSessionDao dao = ( TbUUWiFiSessionDao ) daos[0];
        Date date = new Date();
        TbUUWiFiSession tbUUWiFiSession = dao.selectByPrimaryKey( sid );
        if ( tbUUWiFiSession == null ) {
            return 0;
        }
        tbUUWiFiSession.setMdfTm( date );
        tbUUWiFiSession.setLastUpdate( date );
        if ( status != 0 ) {
            tbUUWiFiSession.setStatus( status );
        }
        return dao.updateByPrimaryKeySelective( tbUUWiFiSession );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = { TbUUWiFiSessionDao.class } )
    public int redistributionSession ( VaSession session, Object...daos ) {
        TbUUWiFiSessionDao dao = ( TbUUWiFiSessionDao ) daos[0];
        if ( session == null ) {
            return -1;
        }
        TbUUWiFiSession tbUUWiFiSession = dao.selectByPrimaryKey( session.getId() );
        tbUUWiFiSession.setStatus( VaConst.Tables.TBUUWIFISESSION_STATUS_OFFLINE );
        dao.updateByPrimaryKeySelective( tbUUWiFiSession );

        Date date = new Date();
        String sid = createSessionId( tbUUWiFiSession.getSessType() );
        tbUUWiFiSession.setKeySessID( sid );
        tbUUWiFiSession.setIdxSimCIccId( session.getSimCard().getIccid() );
        tbUUWiFiSession.setStatus( VaConst.Tables.TBUUWIFISESSION_STATUS_ONLINE );
        tbUUWiFiSession.setLastUpdate( date );
        tbUUWiFiSession.setMdfTm( date );
        tbUUWiFiSession.setCrtTm( date );

        session.setId( sid );
        return dao.insertSelective( tbUUWiFiSession );
    }

    private String createSessionId(String sessType) {

        String type = "1";
        if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_SIMPOOL.equals( sessType ) || VaConst.Request.GET_SESSTYPE_SIMP.equals( sessType ) ) {
            type = "2";
        }

        StringBuilder sb = new StringBuilder().append(type);
        SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmssSSS");
        sb.append(sf.format(new Date()));

        String nStr = String.valueOf(VaConst.Common.UU_SESSION_ID);
        int length = nStr.length();
        for (int i = 0; i < 6 - length; i++) {
            nStr = "0" + nStr;
        }
        sb.append(nStr);
        VaConst.Common.UU_SESSION_ID++;

        return sb.toString();

    }

    @MyQuery( qryClass = { TbUUWiFiSessionDao.class } )
    public String getUUWiFiDeviceLastSimCardIccid ( String vid, Object...daos ) {
        TbUUWiFiSessionDao dao = ( TbUUWiFiSessionDao ) daos[0];
        return dao.selectUUWiFiLastSimCardIccid( vid );
    }

    public List< String > getUUWiFiDeviceLastSimCardGroupIdList ( String vid, int lfc ) {
        List< String > lastSimCardGroupIdList = null;
        if ( configUtils.getCfgInt( "server.get.last.fail.code" ) != lfc ) {
            String lastSimCardIccid = getUUWiFiDeviceLastSimCardIccid( vid );

            VaSimCard simCard = simCardService.getSimCardByIccid( lastSimCardIccid );
            if ( simCard != null ) {
                // 判断是否有其他的运营商的卡组
                Integer count = simCardService.countSimCardGroupByAreaCodeAndISP( simCard.getCountryCode(), simCard.getIspId() );
                if ( count != null && count > 0 ) {
                    lastSimCardGroupIdList = new ArrayList<>();
                    lastSimCardGroupIdList.add( simCard.getScGroupId() );
                }
            }

        }
        return lastSimCardGroupIdList;
    }

    /**
     * * 重新分配新的session
     * 0.根据vid判断是否存在有效的静态绑定
     * 1.根据基站信息判断是否为国外，是则取areaId，否则就根据IP地址获取所在地址
     * 2.根据取得的areaId获取策略卡
     * 3.根据获取的card获取session
     * @param vid
     * @param tgt
     * @return {"errorCode":0,"session":xxx} ...{"errorCode":1,"session":null}
     *
     * errorCode:
     * 1:没有找到合适的卡资源
     * 0:成功
     * -1:不支持的国家和地区
     * -3:根据卡资源获取到了失败的session
     * -4:tgt非法
     */
    public Map< String, Object > getNewSession ( String vid, String tgt, String areaId, String iccid, String imsi, int lfc ) {
        VaSession session = null;
        String sid = createSessionId( tgt );
//        String areaId = "";
        String sessionType = VaConst.Request.GET_SESSTYPE_SIMP.equals( tgt ) ? VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_SIMPOOL : ( VaConst.Request.GET_SESSTYPE_GOIP.equals( tgt ) ? VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_GOIP : VaConst.Common.EMPTY );

        VaViFiDevice viFiDevice = viFiDeviceService.queryByVID( vid );
        String agentId = StringUtils.isEmpty( viFiDevice.getAgentId() ) ? configUtils.getCfgStr( "server.default.agentId" ) : viFiDevice.getAgentId();
        String uid = viFiDevice.getUserId();
        int expire = viFiDevice.getExpire();
        String devGrpId = viFiDevice.getGroupId();

        if ( VaConst.Request.GET_SESSTYPE_SIMP.equals( tgt ) ) {
            // 是否存在静态分配的卡
            VaSimCard simCard = simCardService.getStaticBindSimCard( devGrpId );
            if ( simCard == null ) {

                if ( StringUtils.isEmpty( areaId ) ) {
                    return setResult( -1, null );
                }

                // 根据lfc,vid得到排除在外的simCard groupId
                List< String > noSCGrpIdList = getUUWiFiDeviceLastSimCardGroupIdList( vid, lfc );

                // 根据地区areaId和代理商id获取所有满足条件的卡组ID
                List< String > scGroupList = simCardService.getSCIdByAgentIdAndAreaId( agentId, areaId, noSCGrpIdList );
                if ( scGroupList == null || scGroupList.size() <= 0 ) {
                    return setResult( -1, null );
                }
                simCard = simCardService.getActiveSimCard( scGroupList, agentId );
            }

            if ( simCard == null ) {
                return setResult( 1, null );
            }

            session = createSessionBySimCard( simCard );
            if ( session == null ) {
                return setResult( -3, null );
            }
            session.getSimPPort().setVid( vid );

            session.setGoIPDev( new VaGoIPDevice( vid ) );
            session.setGoIPPort( new VaGoIPPort( 1, 1 ) );
        } else if ( VaConst.Request.GET_SESSTYPE_GOIP.equals( tgt ) ) {

            // 是否存在静态分配的GOIP端口
            VaGoIPPort goIPPort = goIPPortService.getStaticBindGoIPPort( vid );
            if ( goIPPort == null ) {
                goIPPort = goIPPortService.getActivePortByAgentId( agentId );
            }

            if ( goIPPort == null ) {
                return setResult( 1, null );
            }
            session = createSessionByGoIPPort( goIPPort );
            if ( session == null ) {
                return setResult( -3, null );
            }
            session.getGoIPPort().setVid( vid );
            session.getGoIPPort().setIccid( iccid );
            session.getGoIPPort().setImsi( imsi );
            session.getGoIPPort().setUserAct( uid );

            session.setSimPDev( new VaSimPDevice( vid ) );
            session.setSimPPort( new VaSimPPort( 1, 1 ) );

            session.setSimCard( new VaSimCard( iccid, imsi ) );
        } else {
            return setResult( -4, null );
        }
        session.setId( sid );
        session.setType( sessionType );
        session.setUuWiFiAreaId( areaId );
        session.setAreaName( areaId );
        session.setUuWiFiCellId( VaConst.Common.EMPTY );
        session.setExpire( expire );
        session.setVifiDevice( viFiDevice );
        session.setStatus( VaConst.Tables.TBUUWIFISESSION_STATUS_ONLINE );
        return setResult( 0, session );
    }

    private Map< String, Object > setResult ( int errorCode, VaSession session ) {
        Map< String, Object > result = new HashMap< String, Object >();
        result.put( "errorCode", errorCode );
        result.put( "session", session );
        return result;
    }

    public VaSession createSessionBySimCard ( VaSimCard simCard ) {
        VaSession session = new VaSession();
        if ( simCard == null ) {
            LogUtils.dbg( "create session fail:simCard is null" );
            return null;
        }
        session.setSimCard( simCard );
        session.setIdxSUBindID( simCard.getIdxSUBindId() );

        VaSimPPort simPPort = simPPortService.getSimPPortByIccid( simCard.getIccid() );
        if ( simPPort == null ) {
            LogUtils.dbg( "create session fail:simp port has no sim card,iccid:{0}", simCard.getIccid() );
            return null;
        }
        session.setSimPPort( simPPort );

        VaSimPDevice simPDevice = simPDeviceService.getSimPDeviceById( simPPort.getDeviceId() );
        if ( simPDevice == null ) {
            LogUtils.dbg( "create session fail:simp device not found,id:{0}", simPPort.getDeviceId() );
            return null;
        }
        if ( VaConst.Tables.TBSIMPDEV_STATUS_ONLINE != simPDevice.getStatus() || DateUtils.isTimeout( simPDevice.getExpire(), VaConst.Expire.TIMEOUT_DELAY, simPDevice.getLastUpdateTime() ) ) {
            LogUtils.dbg( "create session fail:simp device offline,id:{0}", simPPort.getDeviceId() );
            return null;
        }
        session.setSimPDev( simPDevice );

        VaVSW vswServer = vswService.getVSWServerById( simPDevice.getVswId() );
        if ( vswServer == null ) {
            LogUtils.dbg( "create session fail:vsw server not found,id:{0}",simPDevice.getVswId() );
            return null;
        }
        if ( !VaConst.Tables.TBVSW_STATE_ONLINE.equals( vswServer.getState() ) || DateUtils.isTimeout( vswServer.getExpire(), VaConst.Expire.TIMEOUT_DELAY, vswServer.getLastUpdate() ) ) {
            LogUtils.dbg( "create session fail:vsw server offline,id:{0}", simPDevice.getVswId() );
            return null;
        }
        session.setVswServer( vswServer );

        return session;
    }

    public VaSession createSessionByGoIPPort ( VaGoIPPort port ) {
        VaSession session = new VaSession();
        if ( port == null ) {
            LogUtils.dbg( "create session fail:goip port is null" );
            return null;
        }
        session.setGoIPPort( port );
        session.setIdxSUBindID( port.getIdxGUStaticBindId() );

        VaGoIPDevice goIPDevice = goIPDeviceService.getGoIPDeviceById( port.getDeviceId() );
        if ( goIPDevice == null ) {
            LogUtils.dbg( "create session fail:goip device not found.id:{0}", port.getDeviceId() );
            return null;
        }
        if ( VaConst.Tables.TBGOIPDEV_STATUS_ONLINE != goIPDevice.getStatus() || DateUtils.isTimeout( goIPDevice.getExpire(), VaConst.Expire.TIMEOUT_DELAY, goIPDevice.getLastUpdateTime() ) ) {
            LogUtils.dbg( "create session fail:goip device offline.id:{0}", port.getDeviceId() );
            return null;
        }
        session.setGoIPDev( goIPDevice );

        VaVSW vswServer = vswService.getVSWServerById( goIPDevice.getVswId() );
        if ( vswServer == null ) {
            LogUtils.dbg( "create session fail:vsw server not found,id:{0}",goIPDevice.getVswId() );
            return null;
        }
        if ( !VaConst.Tables.TBVSW_STATE_ONLINE.equals( vswServer.getState() ) || DateUtils.isTimeout( vswServer.getExpire(), VaConst.Expire.TIMEOUT_DELAY, vswServer.getLastUpdate() ) ) {
            LogUtils.dbg( "create session fail:vsw server offline,id:{0}", goIPDevice.getVswId() );
            return null;
        }
        session.setVswServer( vswServer );

        return session;
    }

    public int cleanTimeoutSession () {
        updateTimeoutSessionStatus( VaConst.Tables.TBUUWIFISESSION_STATUS_ONLINE, VaConst.Tables.TBUUWIFISESSION_STATUS_OFFLINE_TEMP );

        goIPPortService.cleanTimeoutSessionGoIPPort();
        simPPortService.cleanTimeoutSessionSimPPort();

        return updateTimeoutSessionStatus( VaConst.Tables.TBUUWIFISESSION_STATUS_OFFLINE_TEMP, VaConst.Tables.TBUUWIFISESSION_STATUS_OFFLINE );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbUUWiFiSessionDao.class )
    public int updateTimeoutSessionStatus ( int oldStatus, int newStatus, Object...daos ) {
        TbUUWiFiSessionDao dao = ( TbUUWiFiSessionDao ) daos[0];
        return dao.updateTimeoutSessionStatus( oldStatus, newStatus );
    }

    public int distributeSession ( VaSession session ) {
        if ( session == null ) {
            return 0;
        }

        if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_SIMPOOL.equals( session.getType() ) ) {
            simPPortService.updateSimPPort( session.getSimPPort() );
        } else if ( VaConst.Tables.TBUUWIFISESSION_SESSIONTYPE_GOIP.equals( session.getType() ) ) {
            goIPPortService.updateGoIPPort( session.getGoIPPort() );
        } else {
            return 0;
        }

        return addSession( session );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbUUWiFiSessionDao.class )
    public int addSession ( VaSession session, Object...daos ) {
        TbUUWiFiSessionDao dao = ( TbUUWiFiSessionDao ) daos[0];
        if ( session == null ) {
            return 0;
        }
        Date date = new Date();
        TbUUWiFiSession tbUUWiFiSession = new TbUUWiFiSession();
        tbUUWiFiSession.setKeySessID( session.getId() );
        tbUUWiFiSession.setSessType( session.getType() );
        tbUUWiFiSession.setIdxSUBindID( session.getIdxSUBindID() );
        tbUUWiFiSession.setIdxVifiID( session.getVifiDevice().getVid() );
        tbUUWiFiSession.setIdxUUWiFiCellID( session.getUuWiFiCellId() );
        tbUUWiFiSession.setIdxUUWiFiAreaId( session.getUuWiFiAreaId() );
        tbUUWiFiSession.setIdxSimCIccId( session.getSimCard().getIccid() );
        tbUUWiFiSession.setIdxSimPDevID( session.getSimPDev().getId() );
        tbUUWiFiSession.setIdxSimPPortId( String.valueOf( session.getSimPPort().getId() ) );
        tbUUWiFiSession.setIdxGoipDevID( session.getGoIPDev().getId() );
        tbUUWiFiSession.setIdxGoipPortID( session.getGoIPPort().getId() );
        tbUUWiFiSession.setIdxVSWID( session.getVswServer().getId() );
        tbUUWiFiSession.setStatus( session.getStatus() );
        tbUUWiFiSession.setExpire( session.getExpire() );
        tbUUWiFiSession.setLastUpdate( date );
        tbUUWiFiSession.setUserAct( session.getVifiDevice().getUserId() );
        tbUUWiFiSession.setRemarks( VaConst.Common.EMPTY );
        tbUUWiFiSession.setMdfTm( date );
        tbUUWiFiSession.setMdfBy( VaConst.SystemAuthor.AUTHOR );
        tbUUWiFiSession.setCrtTm( date );
        tbUUWiFiSession.setCrtBy( VaConst.SystemAuthor.AUTHOR );
        return dao.insertSelective( tbUUWiFiSession );
    }
}
