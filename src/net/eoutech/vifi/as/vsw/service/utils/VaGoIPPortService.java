package net.eoutech.vifi.as.vsw.service.utils;

import com.alibaba.fastjson.JSON;
import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbGUStaticBindDao;
import net.eoutech.vifi.as.commons.dao.TbGoIPPortDao;
import net.eoutech.vifi.as.commons.entity.TbGUStaticBind;
import net.eoutech.vifi.as.commons.entity.TbGoIPPort;
import net.eoutech.vifi.as.commons.utils.CommonUtils;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.vsw.vo.VaGoIPPort;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by SUU on 2016/6/20.
 */
public class VaGoIPPortService {

    public static VaGoIPPortService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaGoIPPortService.class );
    }

    @MyQuery( qryType = MyQuery.QUERY, qryClass = TbGoIPPortDao.class )
    public VaGoIPPort getGoIPPortById ( int id, Object...daos ) {
        TbGoIPPortDao dao = ( TbGoIPPortDao ) daos[0];
        TbGoIPPort tbGoIPPort = dao.selectByPrimaryKey( id );
        if ( tbGoIPPort == null ) {
            return null;
        }
        return new VaGoIPPort( tbGoIPPort );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbGoIPPortDao.class )
    public int updateGoIPPort ( VaGoIPPort goIPPort, Object...daos ) {
        TbGoIPPortDao dao = ( TbGoIPPortDao ) daos[0];
        if ( goIPPort == null ) {
           return  -1;
        }
        TbGoIPPort tbGoIPPort = dao.selectByPrimaryKey( goIPPort.getId() );
        if ( tbGoIPPort == null ) {
            return -1;
        }
        tbGoIPPort.setIdxViFiID( goIPPort.getVid() );
        tbGoIPPort.setUuIccid( goIPPort.getIccid() );
        tbGoIPPort.setUuImsi( goIPPort.getImsi() );
        tbGoIPPort.setUserAct( goIPPort.getUserAct() );
        tbGoIPPort.setMdfTm( new Date() );
        return dao.updateByPrimaryKeySelective( tbGoIPPort );
    }

    @MyQuery( qryClass = TbGoIPPortDao.class )
    public VaGoIPPort getGoIPByDevIdAndSlot ( String devId, int slot, Object...daos ) {
        TbGoIPPortDao dao = ( TbGoIPPortDao ) daos[0];
        TbGoIPPort tbGoIPPort = dao.selectByDevIdSlot( devId, slot );
        if ( tbGoIPPort == null ) {
            return null;
        }
        return new VaGoIPPort( tbGoIPPort );
    }

    @MyQuery( qryClass = TbGUStaticBindDao.class )
    public VaGoIPPort getStaticBindGoIPPort ( String vid, Object...daos ) {
        TbGUStaticBindDao dao = ( TbGUStaticBindDao ) daos[0];
        TbGUStaticBind tbGUStaticBind = dao.queryByVID( vid, VaConst.Tables.TBGUSTATICBIND_STATUS_ENABLE );
        if ( tbGUStaticBind == null ) {
            return null;
        }
        VaGoIPPort goIPPort = getGoIPByDevIdAndSlot( tbGUStaticBind.getIdxGoIPDevID(), tbGUStaticBind.getIdxPortNum() );
        goIPPort.setIdxGUStaticBindId( tbGUStaticBind.getKeyGUBindID() );
        return goIPPort;
    }

    @MyQuery( qryClass = TbGoIPPortDao.class )
    public VaGoIPPort getGoIPPortByUserAct ( String userAct, Object...daos ) {
        TbGoIPPortDao dao = ( TbGoIPPortDao ) daos[0];
        TbGoIPPort tbGoIPPort = dao.selectByUserId( userAct );
        if ( tbGoIPPort == null ) {
            return null;
        }
        return new VaGoIPPort( tbGoIPPort );
    }

    /**
     * 获取一个可用的goip端口
     */
    @MyQuery( qryClass = TbGoIPPortDao.class )
    public VaGoIPPort getActivePortByAgentId ( String agentId, Object...daos ) {
        TbGoIPPortDao dao = ( TbGoIPPortDao ) daos[0];
        TbGoIPPort tbGoIPPort = dao.selectActiveGoIPPort( agentId );
        if ( tbGoIPPort == null ) {
            return null;
        }
        return new VaGoIPPort( tbGoIPPort );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbGoIPPortDao.class )
    public int cleanTimeoutSessionGoIPPort ( Object...daos ) {
        TbGoIPPortDao dao = ( TbGoIPPortDao ) daos[0];

        // find
        List< Integer > timeoutGoIPIdList = dao.selectGoIPTimeoutSession();
        if ( timeoutGoIPIdList == null || timeoutGoIPIdList.size() <= 0) {
            return 0;
        }
        //clean
        return dao.cleanTimeoutResources( timeoutGoIPIdList );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbGoIPPortDao.class )
    public int updateGoIPPortBatch ( String goIPDeviceId, String oldPorts, String newPorts, Object...daos ) {
        TbGoIPPortDao dao = ( TbGoIPPortDao ) daos[0];
        int result = -1;
        LogUtils.dbg( "updateGoIPPortBatch|oldPorts:{0},newPorts:{1}", oldPorts, newPorts );
        //获取数据库中GoIP设备端口数
        Integer count = dao.queryPortCountByGoIPDevID( goIPDeviceId );
        if ( count == null || count != newPorts.length() ) {
            //delete...add all
            dao.deletePortByGoIPDevID( goIPDeviceId );
            result = dao.insertBatch( createTbGoIPPorts( goIPDeviceId, newPorts ) );
        } else {
            Map< Integer, List< Integer > > map = CommonUtils.stringCompare( oldPorts, newPorts );
            if ( map != null ) {
                for ( Map.Entry< Integer, List< Integer > > entry : map.entrySet() ) {
                    Integer status = entry.getKey();
                    List< Integer > portsNum = entry.getValue();

                    Map< String, Object > params = new HashMap< String, Object >();
                    params.put( "idxGoIPDevID", goIPDeviceId );
                    params.put( "list", portsNum );
                    params.put( "status", status );

                    result += dao.updateBatch( params );
                }
                LogUtils.dbg( "updateGoIPPortBatch|map info:{0}", JSON.toJSONString( map ) );
            }
        }

        return result;
    }

    private List<TbGoIPPort> createTbGoIPPorts ( String idxGoIPDevID, String ports ) {
        if ( StringUtils.isEmpty( idxGoIPDevID ) || StringUtils.isEmpty( ports ) ) {
            return null;
        }

        List<TbGoIPPort> list = new ArrayList<TbGoIPPort>();

        Date date = new Date();
        for ( int i = 0; i < ports.length(); i++ ) {
            TbGoIPPort port = new TbGoIPPort();

            port.setIdxGoIPDevID( idxGoIPDevID );
            port.setIdxportNum( i + 1 );
            port.setStatus( Integer.parseInt( String.valueOf( ports.charAt( i ) ), 16 ) );
            port.setBindType( VaConst.Tables.TBGOIPPORT_BINDTYPE_D );
            port.setIdxViFiID( VaConst.Common.EMPTY );
            port.setUuIccid( VaConst.Common.EMPTY );
            port.setUuImsi( VaConst.Common.EMPTY );
            port.setUserAct( VaConst.Common.EMPTY );
            port.setUsage( 0 );
            port.setDuration( 0 );
            port.setRemarks( VaConst.Common.EMPTY );
            port.setMdfBy( VaConst.SystemAuthor.AUTHOR );
            port.setMdfTm( date );
            port.setCrtBy( VaConst.SystemAuthor.AUTHOR );
            port.setCrtTm( date );

            list.add( port );
        }

        return list;
    }

}
