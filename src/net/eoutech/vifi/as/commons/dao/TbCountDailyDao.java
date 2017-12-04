package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbCountDaily;

public interface TbCountDailyDao {
    int deleteByPrimaryKey( String keyCDID );

    int insert( TbCountDaily record );

    int insertSelective( TbCountDaily record );

    TbCountDaily selectByPrimaryKey( String keyCDID );

    int updateByPrimaryKeySelective( TbCountDaily record );

    int updateByPrimaryKey( TbCountDaily record );
}