package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbUUWiFiArea;
import org.apache.ibatis.annotations.Param;

public interface TbUUWiFiAreaDao {
    int deleteByPrimaryKey( String keyAreaId );

    int insert( TbUUWiFiArea record );

    int insertSelective( TbUUWiFiArea record );

    TbUUWiFiArea selectByPrimaryKey( String keyAreaId );

    int updateByPrimaryKeySelective( TbUUWiFiArea record );

    int updateByPrimaryKey( TbUUWiFiArea record );

    TbUUWiFiArea selectByMcc ( int mcc );

    String getIdxCode( @Param( "areaId" ) String areaId );
}