package net.eoutech.vifi.as.vsw.service.utils;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.dao.TbViFiCtrlCmdDao;
import net.eoutech.vifi.as.commons.dao.TbViFiCtrlRcdDao;
import net.eoutech.vifi.as.commons.dao.TbViFiDeviceDao;
import net.eoutech.vifi.as.commons.entity.TbViFiCtrlRcd;
import net.eoutech.vifi.as.commons.entity.TbViFiDevice;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.vsw.vo.VaViFiDevice;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by SUU on 2016/6/15.
 */
public class VaViFiDeviceService {

    public static VaViFiDeviceService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaViFiDeviceService.class );
    }

    @MyQuery( qryClass = TbViFiDeviceDao.class )
    public VaViFiDevice queryByVID ( String vid, Object...daos ) {
        TbViFiDeviceDao dao = ( TbViFiDeviceDao ) daos[0];
        TbViFiDevice tbViFiDevice = dao.selectByIdxViFiID( vid );
        if ( tbViFiDevice == null ) {
            return null;
        }
        VaViFiDevice device = new VaViFiDevice( tbViFiDevice );
        return device;
    }


    @MyQuery( qryType = MyQuery.MODIFY, qryClass = { TbViFiDeviceDao.class} )
    public VaViFiDevice queryByUidAndVid(String uid,String vid,Object...daos){
        TbViFiDeviceDao dao = ( TbViFiDeviceDao ) daos[0];
        TbViFiDevice tbViFiDevice=dao.queryByUidAndVid(uid,vid);
        if ( tbViFiDevice == null ) {
            return null;
        }
        VaViFiDevice device = new VaViFiDevice( tbViFiDevice );
        return device;
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = { TbViFiCtrlCmdDao.class, TbViFiCtrlRcdDao.class } )
    public List< Map< String, String > > queryDeviceCMD ( String vid, Object...daos ) {
        TbViFiCtrlCmdDao dao = (TbViFiCtrlCmdDao) daos[0];
        TbViFiCtrlRcdDao rcdDao = (TbViFiCtrlRcdDao) daos[1];
        List< Map< String, Object > > list = dao.selectAllCMDByVID( vid );
        if ( list == null || list.size() == 0 ) {
            return null;
        }

        List< TbViFiCtrlRcd > rcds = new ArrayList< TbViFiCtrlRcd >();
        List< Map< String, String > > res = new ArrayList< Map< String, String > >();
        for (Map<String, Object> map : list) {
            String cmd = String.valueOf( map.get( "cmd" ) );
            String params = String.valueOf( map.get( "params" ) );
            String idxCtrlCmdID = String.valueOf( map.get( "keyCtrlCmdID" ) );
            Map< String, String > m = new HashMap< String, String >();
            m.put( cmd, params );
            res.add( m );

            rcds.add( createRecord(idxCtrlCmdID, vid, "R", 1, "" ) );
        }

        rcdDao.insertBatch( rcds );
        return res;
    }

    private TbViFiCtrlRcd createRecord ( String idxCtrlCmdID, String vid, String cmdState, Integer respCode, String respDetail ) {
        TbViFiCtrlRcd record = new TbViFiCtrlRcd();
        Date date = new Date();
        record.setIdxCtrlCmdID(idxCtrlCmdID);
        record.setIdxViFiID(vid);
        record.setCmdState(cmdState);
        record.setRespCode(respCode);
        record.setRespDetail(respDetail);
        record.setReqDate(date);
        record.setUpdateDate(date);
        return record;
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = { TbViFiDeviceDao.class } )
    public int updateDeviceLastOnlineInfo ( String vid, String ip, String areaId, Object...daos ) {
        TbViFiDeviceDao dao = (TbViFiDeviceDao) daos[0];

        if ( StringUtils.isEmpty( vid ) ) {
            return 0;
        }

        Map<String, String> params = new HashMap<String,String>();
        params.put( "idxViFiID", vid );
        params.put( "lastConnectIP", StringUtils.isEmpty( ip ) ? null : ip );
        params.put( "lastUUWiFiAreaId", StringUtils.isEmpty( areaId ) ? null : areaId );

        return dao.updateLastOnlineInfo( params );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = { TbViFiDeviceDao.class } )
    public int updateDeviceUUWiFiInfo ( String vid, String lastUUWiFiSessId, Integer lastUUWiFiData, Object...daos ) {
        TbViFiDeviceDao dao = ( TbViFiDeviceDao ) daos[0];
        return dao.updateUUWiFiInfo( vid, lastUUWiFiSessId, lastUUWiFiData );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = { TbViFiDeviceDao.class } )
    public int updateDeviceInfo ( String vid,Double leftFlow, Object...daos ) {
        TbViFiDeviceDao dao = ( TbViFiDeviceDao ) daos[0];
        return dao.updateDeviceInfo( vid, leftFlow );
    }

    @MyQuery( qryClass = TbViFiDeviceDao.class )
    public VaViFiDevice queryVID ( String vid, Object...daos ) {
        TbViFiDeviceDao dao = ( TbViFiDeviceDao ) daos[0];
        TbViFiDevice tbViFiDevice = dao.queryTimeOut( vid );
        if ( tbViFiDevice == null ) {
            return null;
        }
        VaViFiDevice device = new VaViFiDevice( tbViFiDevice );
        return device;
    }

}
