package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbOutboundRoute;

import java.util.List;

public interface TbOutboundRouteDao {
    int deleteByPrimaryKey( Integer keyOutboundRouteId );

    int insert( TbOutboundRoute record );

    int insertSelective( TbOutboundRoute record );

    TbOutboundRoute selectByPrimaryKey( Integer keyOutboundRouteId );

    int updateByPrimaryKeySelective( TbOutboundRoute record );

    int updateByPrimaryKey( TbOutboundRoute record );

    List< TbOutboundRoute > selectByPrefixNum ( String prefix[] );
}