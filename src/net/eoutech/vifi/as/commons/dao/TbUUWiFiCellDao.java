package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbUUWiFiCell;

public interface TbUUWiFiCellDao {
    int deleteByPrimaryKey( String keyUUWiFiCellID );

    int insert( TbUUWiFiCell record );

    int insertSelective( TbUUWiFiCell record );

    TbUUWiFiCell selectByPrimaryKey( String keyUUWiFiCellID );

    int updateByPrimaryKeySelective( TbUUWiFiCell record );

    int updateByPrimaryKey( TbUUWiFiCell record );

    TbUUWiFiCell selectByCellInfo( int mcc, int mnc, int cellid, int lac );
}