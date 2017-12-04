package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbGUStaticBind;

public interface TbGUStaticBindDao {
    int deleteByPrimaryKey( String keyGUBindID );

    int insert( TbGUStaticBind record );

    int insertSelective( TbGUStaticBind record );

    TbGUStaticBind selectByPrimaryKey( String keyGUBindID );

    int updateByPrimaryKeySelective( TbGUStaticBind record );

    int updateByPrimaryKey( TbGUStaticBind record );

    TbGUStaticBind queryByVID( String vid, int status );
}