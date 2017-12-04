package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbAgent;

import java.util.List;
import java.util.Map;

public interface TbAgentDao {
    int deleteByPrimaryKey( String idxAgentId );

    int insert( TbAgent record );

    int insertSelective( TbAgent record );

    TbAgent selectByPrimaryKey( String idxAgentId );

    int updateByPrimaryKeySelective( TbAgent record );

    int updateByPrimaryKey( TbAgent record );

    List< TbAgent > selectBatch ( List< String > ids );

    //List< String > list, int cost
    int agentCost ( Map< String, Object > params );

}