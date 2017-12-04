package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbUUWiFiCountDaily;

public interface TbUUWiFiCountDailyDao {
    int deleteByPrimaryKey( String keyUUWiFiCDID );

    int insert( TbUUWiFiCountDaily record );

    int insertSelective( TbUUWiFiCountDaily record );

    TbUUWiFiCountDaily selectByPrimaryKey( String keyUUWiFiCDID );

    int updateByPrimaryKeySelective( TbUUWiFiCountDaily record );

    int updateByPrimaryKey( TbUUWiFiCountDaily record );
}