package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbGoIPPort;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TbGoIPPortDao {
    int deleteByPrimaryKey( Integer keyID );

    int insert( TbGoIPPort record );

    int insertSelective( TbGoIPPort record );

    TbGoIPPort selectByPrimaryKey( Integer keyID );

    int updateByPrimaryKeySelective( TbGoIPPort record );

    int updateByPrimaryKey( TbGoIPPort record );

    Integer queryPortCountByGoIPDevID ( String goIPDevID );

    Integer deletePortByGoIPDevID ( String goIPDevID );

    Integer insertBatch ( List< TbGoIPPort > goIPPortList );

    /**
     * map 参数：idxGoIPDevID--list--status
     * @param params
     * @return
     */
    Integer updateBatch ( Map< String, Object > params );

    TbGoIPPort selectByUserId ( String userId );

    TbGoIPPort selectByDevIdSlot ( String devId, int slot );

    TbGoIPPort selectActiveGoIPPort ( String agentId );

    @Select("select DISTINCT(a.keyID) from tbGoIPPort a,tbUUWiFiSession b where TIMESTAMPDIFF( SECOND, b.lastUpdate ,NOW() ) > b.expire and a.idxViFiID = b.idxVifiID and b.sessType = 'G' and b.`status` = 12 for update")
    List<Integer> selectGoIPTimeoutSession ();

    int cleanTimeoutResources ( List< Integer > timeoutGoIPIdList );
}