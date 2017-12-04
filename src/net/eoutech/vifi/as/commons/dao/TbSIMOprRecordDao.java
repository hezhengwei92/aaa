package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbSIMOprRecord;

public interface TbSIMOprRecordDao {
    int deleteByPrimaryKey( Integer keyID );

    int insert( TbSIMOprRecord record );

    int insertSelective( TbSIMOprRecord record );

    TbSIMOprRecord selectByPrimaryKey( Integer keyID );

    int updateByPrimaryKeySelective( TbSIMOprRecord record );

    int updateByPrimaryKey( TbSIMOprRecord record );
}