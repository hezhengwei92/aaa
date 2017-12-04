package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbViFiDevGroup;

public interface TbViFiDevGroupDao {
    int deleteByPrimaryKey( String keyDevGrpID );

    int insert( TbViFiDevGroup record );

    int insertSelective( TbViFiDevGroup record );

    TbViFiDevGroup selectByPrimaryKey( String keyDevGrpID );

    int updateByPrimaryKeySelective( TbViFiDevGroup record );

    int updateByPrimaryKey( TbViFiDevGroup record );
}