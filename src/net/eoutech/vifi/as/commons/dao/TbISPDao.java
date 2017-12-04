package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbISP;

public interface TbISPDao {
    int deleteByPrimaryKey( Integer keyISPID );

    int insert( TbISP record );

    int insertSelective( TbISP record );

    TbISP selectByPrimaryKey( Integer keyISPID );

    int updateByPrimaryKeySelective( TbISP record );

    int updateByPrimaryKey( TbISP record );

    TbISP selectByMCC ( int mcc );
}