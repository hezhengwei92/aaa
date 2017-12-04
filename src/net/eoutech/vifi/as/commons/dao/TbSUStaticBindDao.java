package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbSUStaticBind;

public interface TbSUStaticBindDao {
    int deleteByPrimaryKey( String keySUBindID );

    int insert( TbSUStaticBind record );

    int insertSelective( TbSUStaticBind record );

    TbSUStaticBind selectByPrimaryKey( String keySUBindID );

    int updateByPrimaryKeySelective( TbSUStaticBind record );

    int updateByPrimaryKey( TbSUStaticBind record );

    TbSUStaticBind selectByDevGrpID ( String devGrpId, int status );
}