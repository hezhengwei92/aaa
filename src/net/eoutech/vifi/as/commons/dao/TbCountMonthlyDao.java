package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbCountMonthly;

public interface TbCountMonthlyDao {
    int deleteByPrimaryKey( String keyCMID );

    int insert( TbCountMonthly record );

    int insertSelective( TbCountMonthly record );

    TbCountMonthly selectByPrimaryKey( String keyCMID );

    int updateByPrimaryKeySelective( TbCountMonthly record );

    int updateByPrimaryKey( TbCountMonthly record );
}