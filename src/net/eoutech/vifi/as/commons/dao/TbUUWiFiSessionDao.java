package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbUUWiFiSession;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TbUUWiFiSessionDao {
    int deleteByPrimaryKey( String keySessID );

    int insert( TbUUWiFiSession record );

    int insertSelective( TbUUWiFiSession record );

    TbUUWiFiSession selectByPrimaryKey( String keySessID );

    int updateByPrimaryKeySelective( TbUUWiFiSession record );

    int updateByPrimaryKey( TbUUWiFiSession record );

    @Select( "select * from tbUUWiFiSession where idxViFiID = #{0} and sessType = #{1} and `status` != 13 order by lastUpdate desc limit 1 for update" )
    TbUUWiFiSession selectByVidAndType ( String vid, String type );

    int updateTimeoutSessionStatus ( int oldStatus, int newStatus );

    String selectUUWiFiLastSimCardIccid( String vid );

}