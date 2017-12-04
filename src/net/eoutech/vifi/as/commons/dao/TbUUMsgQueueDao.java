package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbUUMsgQueue;

public interface TbUUMsgQueueDao {
    int deleteByPrimaryKey( Integer keyUUMsgId );

    int insert( TbUUMsgQueue record );

    int insertSelective( TbUUMsgQueue record );

    TbUUMsgQueue selectByPrimaryKey( Integer keyUUMsgId );

    int updateByPrimaryKeySelective( TbUUMsgQueue record );

    int updateByPrimaryKey( TbUUMsgQueue record );
}