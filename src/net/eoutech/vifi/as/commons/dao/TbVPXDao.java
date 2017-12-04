package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbVPX;

public interface TbVPXDao {
    int deleteByPrimaryKey( String keyVPXID );

    int insert( TbVPX record );

    int insertSelective( TbVPX record );

    TbVPX selectByPrimaryKey( String keyVPXID );

    int updateByPrimaryKeySelective( TbVPX record );

    int updateByPrimaryKey( TbVPX record );
}