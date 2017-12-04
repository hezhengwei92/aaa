package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbSimPPort;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface TbSimPPortDao {
    int deleteByPrimaryKey( Integer keyID );

    int insert( TbSimPPort record );

    int insertSelective( TbSimPPort record );

    TbSimPPort selectByPrimaryKey( Integer keyID );

    int updateByPrimaryKeySelective( TbSimPPort record );

    int updateByPrimaryKey( TbSimPPort record );

    Integer queryPortCountBySimPDevID ( String simpDevID );

    Integer deleteBySimPDevID ( String simpDevID );

    @Update("update tbSimPPort set idxIccid = '', status=2 where idxSimPDevID=#{0}")
    void updateBySimPDevID(String simpDevID);

    Integer insertBatch( List< TbSimPPort > simPPortList );

    @Update("update tbSimPPort set idxAgentID=#{1} where idxSimPDevID=#{0}")
    Integer updateBatchAgent(String simPDev,String agentName);
    //新添加的方法
    TbSimPPort selectByPDevAndSlotNum(Map<String,Object> map);
    /**
     * idxSimPDevID--list--status
     * @param params
     * @return
     */

    Integer updateBatch( Map< String, Object > params );

    int publishPort (String simPDevID, int slotNum, String iccid, int status , Timestamp ts);
//    int publishPort ( int keyid, String iccid, int status );
//    int publishPort ( Map< String, Object > params );

    int publishPull( int keyid,int status );

    int updatePortVID ( int id, String vid );

    TbSimPPort selectByIccid ( String iccid );

    @Select("select idxIccid from tbSimPPort where idxSimPDevID = #{0} and idxIccid!=''")
    List<String> selectIccidBySimPDev(String idxSimPDevID);

    @Select("select idxIccid from tbSimPPort where idxSimPDevID = #{0}")
    List<String> selectBySimPDev(String idxSimPDevID);

    @Select("select keyID from tbSimPPort where idxSimPDevID=#{0} and idxSlotNum=#{1}")
    int selectByPDevAndSlot(String idxSimPDevID,int Sim_slot);

    @Select("select DISTINCT(a.keyID) from tbSimPPort a,tbUUWiFiSession b where TIMESTAMPDIFF( SECOND, b.lastUpdate ,NOW() ) > b.expire and a.idxViFiId = b.idxVifiID and a.idxIccid = b.idxSimCIccId and b.sessType = 'S' and b.`status` = 12 for update")
    List<Integer> selectSimpTimeoutSession () ;

    @Select("select idxIccid from tbSimPPort where idxSimPDevID=#{0} and idxSlotNum=#{1}")
    String selectByNameAndSlot(String username,int Sim_slot);

    int cleanTimeoutResources ( List< Integer > timeoutPortIdList );
}