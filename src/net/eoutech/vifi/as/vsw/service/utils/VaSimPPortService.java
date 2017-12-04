package net.eoutech.vifi.as.vsw.service.utils;

import com.alibaba.fastjson.JSON;
import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbDictionaryDao;
import net.eoutech.vifi.as.commons.dao.TbSimPPortDao;
import net.eoutech.vifi.as.commons.entity.TbDictionary;
import net.eoutech.vifi.as.commons.entity.TbSimPPort;
import net.eoutech.vifi.as.commons.utils.CommonUtils;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.vsw.vo.VaSimPPort;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by SUU on 2016/6/20.
 */
public class VaSimPPortService {

    public static VaSimPPortService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaSimPPortService.class );
    }

    @MyQuery( qryClass = TbSimPPortDao.class )
    public VaSimPPort getSimPPortById ( int id, Object...daos ) {
        TbSimPPortDao dao = ( TbSimPPortDao ) daos[0];
        TbSimPPort tbSimPPort = dao.selectByPrimaryKey( id );
        if ( tbSimPPort == null ) {
            return null;
        }
        return new VaSimPPort( tbSimPPort );
    }

    @MyQuery( qryClass = TbSimPPortDao.class )
    public VaSimPPort getSimPPortByIccid ( String iccid, Object...daos ) {
        TbSimPPortDao dao = ( TbSimPPortDao ) daos[0];
        if ( StringUtils.isEmpty( iccid ) ) {
            return null;
        }
        TbSimPPort tbSimPPort = dao.selectByIccid( iccid );
        if ( tbSimPPort == null ) {
            return null;
        }
        return new VaSimPPort( tbSimPPort );
    }

    @MyQuery( qryClass = TbSimPPortDao.class )
    public TbSimPPort getSimByIccid ( String iccid, Object...daos ) {
        TbSimPPortDao dao = ( TbSimPPortDao ) daos[0];
        TbSimPPort tbSimPPort = dao.selectByIccid( iccid );
        if ( tbSimPPort != null ) {
            return tbSimPPort;
        }else{
            return null;
        }
    }


    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbSimPPortDao.class )
    public int cleanTimeoutSessionSimPPort ( Object...daos ) {
        TbSimPPortDao dao = ( TbSimPPortDao ) daos[0];
        // find
        List< Integer > timeoutPortIdList = dao.selectSimpTimeoutSession();
        if ( timeoutPortIdList == null || timeoutPortIdList.size() <= 0 ) {
            return 0;
        }
        //clean
        return dao.cleanTimeoutResources( timeoutPortIdList );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbSimPPortDao.class )
    public int updateSimPPort ( VaSimPPort port, Object...daos ) {
        TbSimPPortDao dao = ( TbSimPPortDao ) daos[0];
        if ( port == null ) {
            return -1;
        }
        TbSimPPort tbSimPPort = dao.selectByPrimaryKey( port.getId() );
        if ( tbSimPPort == null ) {
            return -1;
        }
        tbSimPPort.setIdxViFiId( port.getVid() );
        tbSimPPort.setMdfTm( new Date() );
        return dao.updateByPrimaryKey( tbSimPPort );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = {TbSimPPortDao.class, TbDictionaryDao.class} )
    public void newupdateSimPPortBatch ( String simPDeviceId,int newPorts,int status, Object...daos ) {

        TbSimPPortDao dao = ( TbSimPPortDao ) daos[0];
        TbDictionaryDao tbDictionaryDao=(TbDictionaryDao)daos[1];
        TbDictionary tbDictionary=tbDictionaryDao.query(simPDeviceId);
        String valueStr=tbDictionary.getValueMap();
        String agentName=valueStr.substring(0,valueStr.indexOf("&"));
        LogUtils.info("Agent:"+agentName);
        List list=dao.selectBySimPDev(simPDeviceId);
        if (list.isEmpty()){//批量添加
            dao.insertBatch(createTbSimPPortBatch(simPDeviceId, newPorts,agentName));
        }else{//批量更新
            int record=dao.updateBatchAgent(simPDeviceId,agentName);
            LogUtils.info("update :"+record);
        }
    }


    private List<TbSimPPort> createTbSimPPortBatch ( String idxSimPDevID, int ports ,String agentName) {
        List<TbSimPPort> list = new ArrayList<TbSimPPort>();
        Date date = new Date();
        int length = ports;
        for ( int i = 0; i < length; i++ ) {
            TbSimPPort port = new TbSimPPort();
            port.setIdxSimPDevID( idxSimPDevID );
            port.setIdxSlotNum( i+1 );
            port.setStatus(2);//卡槽状态和sim卡状态一致  默认为2 未 插入卡
            port.setIdxIccid( VaConst.Common.EMPTY );
            port.setIdxViFiId( VaConst.Common.EMPTY );
            port.setUsage( 0 );
            port.setDuration( 0 );
            port.setIdxAgentID(agentName);
            port.setRemarks( VaConst.Common.EMPTY );
            port.setMdfTm( date );
            port.setMdfBy( VaConst.SystemAuthor.AUTHOR );
            port.setCrtTm( date );
            port.setCrtBy( VaConst.SystemAuthor.AUTHOR );

            list.add( port );
        }

        return list;
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbSimPPortDao.class )
    public int pullPublish ( String simPDevID, int slotNum, int status, Object...daos ) {
        TbSimPPortDao dao = ( TbSimPPortDao ) daos[0];
        int keyid=dao.selectByPDevAndSlot(simPDevID,slotNum);
//        Map<String,Object> map = new ConcurrentHashMap<>();
//        map.put("idxSimPDevID",simPDevID);
//        map.put("idxSlotNum",slotNum);
//        TbSimPPort tbSimPPort=dao.selectByPDevAndSlotNum(map);
        int res=dao.publishPull(keyid,status);
        return res;
    }


    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbSimPPortDao.class )
    public synchronized void portPublish ( String simPDevID, int slotNum, String iccid,int status, Object...daos ) {
        TbSimPPortDao dao = ( TbSimPPortDao ) daos[0];
        Date date=new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        dao.publishPort( simPDevID,slotNum, iccid, status ,ts);
    }
}
