package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbVSW;

public interface TbVSWDao {
    int deleteByPrimaryKey( String keyVSWID );

    int insert( TbVSW record );

    int insertSelective( TbVSW record );

    TbVSW selectByPrimaryKey( String keyVSWID );

    int updateByPrimaryKeySelective( TbVSW record );

    int updateByPrimaryKey( TbVSW record );

    TbVSW selectByHostName ( String hostname );

    Integer updateVSWREG( String keyVswID, String ip, int port, String state, int expire );

}