package net.eoutech.vifi.as.vsw.service.utils;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.TbDictionaryDao;
import net.eoutech.vifi.as.commons.dao.TbSimCardDao;
import net.eoutech.vifi.as.commons.dao.TbSimPDevDao;
import net.eoutech.vifi.as.commons.dao.TbSimPPortDao;
import net.eoutech.vifi.as.commons.entity.TbDictionary;
import net.eoutech.vifi.as.commons.entity.TbSimPDev;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.vsw.vo.VaSimPDevice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SUU on 2016/6/20.
 */
public class VaSimPDeviceService {

    public static VaSimPDeviceService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaSimPDeviceService.class );
    }

    @MyQuery( qryClass = TbSimPDevDao.class )
    public VaSimPDevice getSimPDeviceById ( String id, Object...daos ) {
        TbSimPDevDao dao = ( TbSimPDevDao ) daos[0];
        TbSimPDev simPDev = dao.selectByPrimaryKey( id );
        if ( simPDev == null ) {
            return null;
        }
        return new VaSimPDevice( simPDev );
    }

    @MyQuery( qryClass = TbSimPDevDao.class )
    public VaSimPDevice getSimPDeviceByUserName ( String userName, Object...daos ) {
        TbSimPDevDao dao = ( TbSimPDevDao ) daos[0];
        TbSimPDev tbSimPDev = dao.selectByUserName( userName );
        if ( null  == tbSimPDev ) {
            return null;
        }
        return new VaSimPDevice( tbSimPDev );
    }

    @MyQuery( qryType = MyQuery.MODIFY,qryClass = {TbSimPDevDao.class,TbSimCardDao.class,TbSimPPortDao.class} )
    public void resetSimPDevice ( String simpoolName, Object...daos ) {
        TbSimPDevDao simPDevDao = ( TbSimPDevDao ) daos[0];
        TbSimPPortDao simPPortDao = ( TbSimPPortDao ) daos[2];
        TbSimCardDao simCardDao = ( TbSimCardDao ) daos[1];

        List<String> simCardList=new ArrayList();
        simCardList = simPPortDao.selectIccidBySimPDev(simpoolName);
        //清空卡池
        simPPortDao.deleteBySimPDevID(simpoolName);
        if (simCardList!=null && simCardList.size()>0){
            for(int i=0;i<simCardList.size();i++){
                //清除卡
                simCardDao.deleteByIccid(simCardList.get(i));
            }

        }
//        simPDevDao.deleteByPrimaryKey(simpoolName);
    }


    @MyQuery( qryType = MyQuery.MODIFY, qryClass = {TbSimPDevDao.class, TbDictionaryDao.class} )
    public int doSimPDeviceSIPReg ( String username, String ip, int port, int status, int expire,int ports,String serveIp,int servePort, Object...daos ) {
        TbSimPDevDao dao = ( TbSimPDevDao ) daos[0];
        TbDictionaryDao dao1=(TbDictionaryDao) daos[1];
        TbDictionary tbDictionary=dao1.query(username);
        if (null==tbDictionary){
            LogUtils.error("TbDictionary is null --- please check out table TbDictionary");
            return 0;
        }
        String valueStr=tbDictionary.getValueMap();
        String agentName=valueStr.substring(0,valueStr.indexOf("&"));
        LogUtils.info("tbDictionary  AgentName:"+agentName);
        TbSimPDev tbSimPDev=dao.selectByPrimaryKey(username);
        if(tbSimPDev==null){
            //添加新的卡池  默认状态 在线0
            Date date = new Date();
            tbSimPDev=new TbSimPDev();
            tbSimPDev.setKeySimPDevID(username);
            tbSimPDev.setDevName(username);
            tbSimPDev.setIpaddr(ip);
            tbSimPDev.setPort(port);
            tbSimPDev.setPorts(ports);
            tbSimPDev.setUsername(username);
            tbSimPDev.setLastUpdate(date);
            tbSimPDev.setIdxAgentID(agentName);
            tbSimPDev.setStatus( status);//刚开始一定是在线 0
//            tbSimPDev.setStatus( VaConst.Tables.TBSIMCARD_STATUS_ENABLE );  0为激活
            tbSimPDev.setMdfBy( VaConst.Common.SERVER_RUN_MODAL_TEST );
            tbSimPDev.setMdfTm( date );
            tbSimPDev.setCrtBy( VaConst.SystemAuthor.AUTHOR );
            tbSimPDev.setCrtTm( date );
            tbSimPDev.setServeIp(serveIp);
            tbSimPDev.setServePort(servePort);
            return dao.insertSelective(tbSimPDev);
        }else{
            return dao.updateSimPReg( username, ip, port, status, expire , ports ,serveIp , servePort,agentName);
        }
    }

    @MyQuery( qryClass = TbSimPDevDao.class )
    public TbSimPDev selectCardPoolByIPPort(String ip, String port, Object...daos) {
        TbSimPDevDao dao = ( TbSimPDevDao ) daos[0];
        return dao.selectCardPoolByIPPort(ip,port);
    }
}
