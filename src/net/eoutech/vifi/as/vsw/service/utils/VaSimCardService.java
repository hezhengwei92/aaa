package net.eoutech.vifi.as.vsw.service.utils;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.dao.*;
import net.eoutech.vifi.as.commons.entity.*;
import net.eoutech.vifi.as.commons.utils.CommonUtils;
import net.eoutech.vifi.as.commons.utils.ConfigUtils;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.vsw.vo.VaSimCard;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.helpers.UtilLoggingLevel;

import java.util.*;

/**
 * Created by SUU on 2016/5/30.
 */
public class VaSimCardService {

    public static VaSimCardService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaSimCardService.class );
    }

    @MyQuery( qryClass = { TbSimCardDao.class } )
    public List< String > getGroupIdListByIccid ( List< String > iccidList, Object...daos ) {
        TbSimCardDao dao = ( TbSimCardDao ) daos[0];
        return dao.selectSCGrpIdList( iccidList );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = {TbSimCardDao.class,TbConfigureDao.class,TbSimCardCopyDao.class} )
    public void updateNetData (Object...daos ) {
        TbSimCardDao simCardDao = ( TbSimCardDao ) daos[0];
        TbConfigureDao tbConfigureDao=(TbConfigureDao)daos[1];
        TbSimCardCopyDao tbSimCardCopyDao=(TbSimCardCopyDao) daos[2];
        //TbConfigure 单位为G  simcard 单位为M
        int netData=Integer.valueOf(tbConfigureDao.selectByName("REST_NET_DATA").getValue())*1024;
        //只有正常的sim卡才重置流量  status=0 or status=1
        tbSimCardCopyDao.updateNetData(netData);
        simCardDao.updateNetData(netData);
    }


    @MyQuery( qryType = MyQuery.MODIFY, qryClass = {TbSimCardDao.class,TbSimCardCopyDao.class} )
    public void resetNetData ( String iccid, double total,Object...daos ) {
        TbSimCardDao tbSimCardDao=(TbSimCardDao)daos[0];
        TbSimCardCopyDao tbSimCardCopyDao=(TbSimCardCopyDao)daos[1];
        TbSimCard tbSimCard=tbSimCardDao.selectByIccid(iccid);
        TbSimCard tbSimCardCopy=tbSimCardCopyDao.selectByIccid(iccid);

//        if (tbSimCard != null ){/
//            double resetNetData=tbSimCard.getRestNetData()-total;
//            if (resetNetData > 0){
//                tbSimCardDao.updateSimCardData(iccid,resetNetData,0,VaConst.SystemAuthor.AUTHOR);
//            }else{
//                tbSimCardDao.updateSimCardData(iccid,resetNetData,3,VaConst.SystemAuthor.AUTHOR);
//            }
//        }
//        [["0","空闲"],["1","使用中"],["2","无卡"],["3","SIM卡故障"]]  故障包括流量用完
//        数据库中的 restNetData 是M
        if (tbSimCardCopy !=null){
            double restNetData=(tbSimCardCopy.getRestNetData())-total;//先更新copy中的流量 再把copy表中的数据更新到原表中
            if (restNetData > 0){
                tbSimCardCopyDao.updateSimCardData2(iccid,restNetData,VaConst.SystemAuthor.AUTHOR);
                if(tbSimCard != null){
                    tbSimCardDao.updateSimCardData2(iccid,restNetData,VaConst.SystemAuthor.AUTHOR);
                }else{

                }
            }else{//每月重置流量的时候 要把状态为 0 和 1 的流量卡改变 其他sim卡的不变
                //当流量扣完时要把这张sim卡状态改变为不可用。
                tbSimCardCopyDao.updateSimCardData(iccid,restNetData,3,VaConst.SystemAuthor.AUTHOR);
                if(tbSimCard != null){
                    tbSimCardDao.updateSimCardData(iccid,restNetData,3,VaConst.SystemAuthor.AUTHOR);
                }
            }
        }
    }


    @MyQuery( qryType = MyQuery.MODIFY, qryClass = {TbSimCardDao.class,TbSimPPortDao.class} )
    public int changeSimCard ( String username, int Sim_slot,int status,Object...daos ) {
        TbSimCardDao simCardDao = ( TbSimCardDao ) daos[0];
        TbSimPPortDao simPPortDao=(TbSimPPortDao)daos[1];

        String iccid=simPPortDao.selectByNameAndSlot(username,Sim_slot);
        if (iccid==null || "".equals(iccid)){
            return 1;
        }else{
            TbSimCard tbSimCard = simCardDao.selectByIccid( iccid );
            tbSimCard.setStatus(status);
            tbSimCard.setMdfBy( VaConst.SystemAuthor.AUTHOR );
            simCardDao.updateSimCard(tbSimCard.getIdxIccid(),status,tbSimCard.getMdfBy());
            return 0;
        }
    }

    //添加新卡  以及把备份的卡的数据更新到新卡中
    @MyQuery( qryType = MyQuery.MODIFY, qryClass = {TbSimCardDao.class,TbConfigureDao.class,TbSimCardCopyDao.class} )
    public int addSimCard ( String iccid, String imsi,byte[] cardATR, int status,Object...daos ) {
        TbSimCardDao dao = ( TbSimCardDao ) daos[0];
//        TbConfigureDao condao=(TbConfigureDao)daos[1];
        TbSimCardCopyDao copyDao=(TbSimCardCopyDao)daos[2];
        Date date = new Date();
        TbSimCard tbSimCardCopy=copyDao.selectByIccid(iccid);
        TbSimCard tbSimCard = dao.selectByIccid( iccid );
        if ( null != tbSimCard && null != tbSimCardCopy) {//更新卡的状态
            tbSimCard.setStatus(status);
            tbSimCard.setRestNetData(tbSimCardCopy.getRestNetData()>0?tbSimCardCopy.getRestNetData():0);
            tbSimCard.setIdxAgentID(tbSimCardCopy.getIdxAgentID());
            tbSimCard.setExActions(tbSimCardCopy.getExActions());
            tbSimCard.setMdfTm(date);
            tbSimCard.setCardATR(cardATR);
            dao.updateByPrimaryKeySelective(tbSimCard);
            return 1;
        }else if(null == tbSimCard && null != tbSimCardCopy){//把copy表的数据插入到原表
            tbSimCard=new TbSimCard();
            tbSimCard.setKeySimCardID( tbSimCardCopy.getIdxIccid() );
            tbSimCard.setIdxSCGroupID( "1" );
            tbSimCard.setIdxIccid( tbSimCardCopy.getIdxIccid() );
            tbSimCard.setImsi( imsi );
            tbSimCard.setImei( VaConst.Common.EMPTY );
            tbSimCard.setSsId( 0 );
            tbSimCard.setStatus(tbSimCardCopy.getStatus());
            tbSimCard.setRestNetData(tbSimCardCopy.getRestNetData()>0?tbSimCardCopy.getRestNetData():0 );
            tbSimCard.setExActions(tbSimCardCopy.getExActions());
            tbSimCard.setIdxAgentID(tbSimCardCopy.getIdxAgentID());
            tbSimCard.setMdfBy( VaConst.SystemAuthor.AUTHOR );
            tbSimCard.setMdfTm( date );
            tbSimCard.setCrtBy( VaConst.SystemAuthor.AUTHOR );
            tbSimCard.setCrtTm( date );
            tbSimCard.setCardATR(tbSimCardCopy.getCardATR());
            LogUtils.info("-------simcard insert ------- "+tbSimCardCopy.getIdxAgentID());
            dao.insertSelective( tbSimCard );
        }
        return 0;
    }

//把备份表中的数据更新  并把备份数据更新到原表中
    @MyQuery( qryType = MyQuery.MODIFY, qryClass = {TbSimCardCopyDao.class,TbConfigureDao.class,TbDictionaryDao.class} )
    public int addSimCardCopy ( String simPdev,String iccid, String imsi,byte[] cardATR, int status,Object...daos ) {
        TbSimCardCopyDao daocopy = ( TbSimCardCopyDao ) daos[0];
        TbConfigureDao conDao=(TbConfigureDao)daos[1];
        TbDictionaryDao dictionaryDao=(TbDictionaryDao)daos[2];
        TbDictionary tbdictionary=dictionaryDao.query(simPdev);
        if(null==tbdictionary){
            LogUtils.error("TbDictionary is null --- please check out Table TbDictionary");
            return 0;
        }
        TbSimCard tbSimCard = daocopy.selectByIccid( iccid );
        Date date = new Date();
        String valueStr=tbdictionary.getValueMap();
        String agentName=valueStr.substring(0,valueStr.indexOf("&"));//代理商
        String batch=valueStr.substring(valueStr.indexOf("&")+1,valueStr.length());//卡批次

        LogUtils.info("-------------- 代理商:"+agentName+"  卡批次："+batch);
        if ( null != tbSimCard ) {
            tbSimCard.setStatus(status);
            tbSimCard.setMdfTm(date);
            tbSimCard.setExActions(batch);
            tbSimCard.setCardATR(cardATR);
            tbSimCard.setIdxAgentID(agentName);
            LogUtils.info("-------------------update----------------------");
            daocopy.updateByPrimaryKeySelective(tbSimCard);
            return 1;
        }
        TbConfigure tbConfigure=conDao.selectByName("REST_NET_DATA");
        String restNetData=tbConfigure.getValue();
        tbSimCard = new TbSimCard();
        tbSimCard.setKeySimCardID( iccid );
        tbSimCard.setIdxSCGroupID( "1" );
        tbSimCard.setIdxIccid( iccid );
        tbSimCard.setImsi( imsi );
        tbSimCard.setImei( VaConst.Common.EMPTY );
        tbSimCard.setSsId( 0 );
        tbSimCard.setStatus(status);
        tbSimCard.setExActions(batch);
        tbSimCard.setIdxAgentID(agentName);
        tbSimCard.setRestNetData(Integer.valueOf(restNetData)*1024 );//G*1024  单位M
        tbSimCard.setMdfBy( VaConst.SystemAuthor.AUTHOR );
        tbSimCard.setMdfTm( date );
        tbSimCard.setCrtBy( VaConst.SystemAuthor.AUTHOR );
        tbSimCard.setCrtTm( date );
        tbSimCard.setCardATR(cardATR);
        LogUtils.info("-------------------insert----------------------");
        return daocopy.insertSelective( tbSimCard );
    }


    @MyQuery( qryClass = { TbSimCardDao.class, TbSCGroupDao.class } )
    public VaSimCard getSimCardByIccid ( String iccid, Object...daos ) {
        TbSimCardDao simCardDao = ( TbSimCardDao ) daos[0];
        TbSCGroupDao scGroupDao = ( TbSCGroupDao ) daos[1];
        TbSimCard tbSimCard = simCardDao.selectByIccid( iccid );
        if ( tbSimCard == null ) {
            return null;
        }

        TbSCGroup tbSCGroup = scGroupDao.selectByPrimaryKey( tbSimCard.getIdxSCGroupID()  );
        return new VaSimCard( tbSimCard, tbSCGroup );
    }
    //这里用了注释 传值
    @MyQuery( qryClass = { TbSimCardDao.class, TbSCGroupDao.class } )
    public VaSimCard getSimCardById ( String id, Object...daos ) {
        TbSimCardDao simCardDao = ( TbSimCardDao ) daos[0];
        TbSCGroupDao scGroupDao = ( TbSCGroupDao ) daos[1];
        //这里用mybatise 查询
        TbSimCard tbSimCard = simCardDao.selectByPrimaryKey( id );
        if ( tbSimCard == null ) {
            return null;
        }

        TbSCGroup tbSCGroup = scGroupDao.selectByPrimaryKey( tbSimCard.getIdxSCGroupID() );
        return new VaSimCard( tbSimCard, tbSCGroup );
    }

    @MyQuery( qryClass = { TbSUStaticBindDao.class, TbSimCardDao.class, TbSCGroupDao.class } )
    public VaSimCard getStaticBindSimCard ( String devGrpID, Object...daos ) {
        TbSUStaticBindDao tbSUStaticBindDao = ( TbSUStaticBindDao ) daos[0];
        TbSimCardDao tbSimCardDao = ( TbSimCardDao ) daos[1];
        TbSCGroupDao tbSCGroupDao = ( TbSCGroupDao ) daos[2];
        if ( StringUtils.isEmpty( devGrpID ) ) {
            return null;
        }
        TbSUStaticBind tbSUStaticBind = tbSUStaticBindDao.selectByDevGrpID( devGrpID, VaConst.Tables.TBSUSTATICBIND_STATUS_ENABLE );
        if ( tbSUStaticBind == null ) {
            return null;
        }
        String scGroupId = tbSUStaticBind.getIdxSCGroupID();
        TbSCGroup tbSCGroup = tbSCGroupDao.selectByPrimaryKey( scGroupId );
        if ( tbSCGroup == null ) {
            return null;
        }

        TbSimCard tbSimCard = tbSimCardDao.selectBestSimCardByGroupId( scGroupId, VaConst.Tables.TBSIMCARD_BINDTYPE_S );
        if ( tbSimCard == null ) {
            return null;
        }
        VaSimCard simCard = new VaSimCard( tbSimCard, tbSCGroup );
        simCard.setIdxSUBindId( tbSUStaticBind.getKeySUBindID() );
        return simCard;
    }

    /**
     * 根据代理商ID和地区ID获取所有满足条件的卡组ID
     * @param agentId
     * @param areaId
     * @param daos
     * @return
     */
    @MyQuery( qryType = MyQuery.QUERY, qryClass = TbSimSalesDao.class )
    public List< String > getSCIdByAgentIdAndAreaId ( String agentId, String areaId, List<String> noSCGrpIdList, Object...daos ) {
        TbSimSalesDao dao = ( TbSimSalesDao ) daos[0];
        List< String > agentIdList = CommonUtils.domainStringFormat( agentId );
        List< String > areaIdList = CommonUtils.domainStringFormat( areaId );

        if ( areaIdList == null ) {
            if ( VaConst.Common.UUWIFI_FIRST_AREAID.equals( areaId ) ) {
                areaIdList = new ArrayList< String >();
            } else {
                return null;
            }
        }
        areaIdList.add( VaConst.Common.UUWIFI_FIRST_AREAID );

        if ( agentIdList == null ) {
            agentIdList = new ArrayList< String >();
            agentIdList.add( ConfigUtils.getInstance().getCfgStr( "server.default.agentId" ) );
        }

        agentIdList.add( VaConst.Symbol.ASTERISK );
        Map< String, List< String > > map = new HashMap< String, List< String > >();
        map.put( "agentIdList", agentIdList );
        map.put( "areaIdList", areaIdList );
        map.put( "noSCGrpIdList", noSCGrpIdList );
        return dao.selectByAgentArea( map );
    }

    /**
     * 根据卡组ID和代理商ID找到一个最优选择的卡
     * TODO 目前的策略为：剩余流量最大的卡优先分配
     * @param scGroupList
     * @param agentId
     * @param daos
     * @return
     */
    @MyQuery( qryType = MyQuery.QUERY, qryClass = TbSimCardDao.class )
    public VaSimCard getActiveSimCard ( List< String > scGroupList, String agentId, Object...daos ) {
        TbSimCardDao dao = ( TbSimCardDao ) daos[0];
        if ( scGroupList == null ) {
            return null;
        }
        Map< String, Object > map = new HashMap< String, Object >();
        map.put( "scGroupList", scGroupList );
        map.put( "agentId", agentId );
        String iccid = dao.selectActiveSimCard( map );
        if ( StringUtils.isEmpty( iccid ) ) {
            return null;
        }

//        List< TbSimCard > simCardList = dao.selectActiveSimCard( map );
//
//        if ( simCardList == null || simCardList.size() <= 0 ) {
//            return null;
//        }
//
//        Collections.sort( simCardList, new Comparator< TbSimCard >() {
//            @Override
//            public int compare( TbSimCard o1, TbSimCard o2 ) {
//                if ( o1.getRestNetData() < o2.getRestNetData() ) {
//                    return 1;
//                }
//                if ( o1.getRestNetData() == o2.getRestNetData() ) {
//                    return 0;
//                }
//                return -1;
//            }
//        } );
        return getSimCardByIccid( iccid );
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = TbSimCardDao.class )
    public int simCardCost ( String iccid, int dataCost, Object...daos ) {
        TbSimCardDao dao = ( TbSimCardDao ) daos[0];
        TbSimCard simCard = dao.selectByIccid( iccid );

        if ( simCard == null ) {
            return -1;
        }
        int restNetData = simCard.getRestNetData() - dataCost;
        /*if ( restNetData <= 0 ) {
            simCard.setStatus( VaConst.Tables.TBSIMCARD_STATUS_DISABLE );
        }*/
        simCard.setRestNetData( restNetData );
        simCard.setTotalSuccess( simCard.getTotalSuccess() + 1 );
        simCard.setTotalData( simCard.getTotalData() + dataCost );

        return dao.updateByPrimaryKeySelective( simCard );
    }

    @MyQuery( qryClass = { TbSCGroupDao.class } )
    public Integer countSimCardGroupByAreaCodeAndISP ( String countryCode, String ispId, Object...daos ) {
        TbSCGroupDao dao = ( TbSCGroupDao ) daos[0];
        return dao.selectCountByAreaCodeAndISP( countryCode, ispId );
    }

    /**
     * 判断SIM卡的状态是否正常(用于checkSession失败后判断是否是因为SIM卡的状态的问题)
     * @param simCard
     * @return
     */
    public boolean checkSimCardStatus ( VaSimCard simCard ) {
        return simCard != null && VaConst.Tables.TBSIMCARD_STATUS_ENABLE == simCard.getStatus();
    }

}
