package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbChinaCity;


public interface TbChinaCityDao {
    int deleteByPrimaryKey( String keyAreaId );

    int insert( TbChinaCity record );

    int insertSelective( TbChinaCity record );

    TbChinaCity selectByPrimaryKey( String keyAreaId );

    int updateByPrimaryKeySelective( TbChinaCity record );

    int updateByPrimaryKey( TbChinaCity record );

    String selectByRegionCity( String name );

    String selectByRegion ( String name );
}