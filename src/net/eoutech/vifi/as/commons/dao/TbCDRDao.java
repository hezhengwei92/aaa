package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbCDR;

public interface TbCDRDao {
    int deleteByPrimaryKey( Integer keyCDRID );

    int insert( TbCDR record );

    int insertSelective( TbCDR record );

    TbCDR selectByPrimaryKey( Integer keyCDRID );

    int updateByPrimaryKeySelective( TbCDR record );

    int updateByPrimaryKey( TbCDR record );

    TbCDR selectByCallId ( String callId );

    TbCDR selectCrtTm(String idxUserID);

    TbCDR selectByUserId(String idxUserID);
}