package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbSCGroup;

public interface TbSCGroupDao {
    int deleteByPrimaryKey( String keySCGroupID );

    int insert( TbSCGroup record );

    int insertSelective( TbSCGroup record );

    TbSCGroup selectByPrimaryKey( String keySCGroupID );

    int updateByPrimaryKeySelective( TbSCGroup record );

    int updateByPrimaryKey( TbSCGroup record );

    Integer selectCountByAreaCodeAndISP( String areaCode, String ispId );
}