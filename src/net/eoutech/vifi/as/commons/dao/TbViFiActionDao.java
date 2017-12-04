package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbViFiAction;

public interface TbViFiActionDao {
    int deleteByPrimaryKey( Integer keyActionID );

    int insert( TbViFiAction record );

    int insertSelective( TbViFiAction record );

    TbViFiAction selectByPrimaryKey( Integer keyActionID );

    int updateByPrimaryKeySelective( TbViFiAction record );

    int updateByPrimaryKey( TbViFiAction record );
}