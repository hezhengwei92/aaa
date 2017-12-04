package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbIPAddress;

public interface TbIPAddressDao {
    int deleteByPrimaryKey( Integer id );

    int insert( TbIPAddress record );

    int insertSelective( TbIPAddress record );

    TbIPAddress selectByPrimaryKey( Integer id );

    int updateByPrimaryKeySelective( TbIPAddress record );

    int updateByPrimaryKey( TbIPAddress record );
}