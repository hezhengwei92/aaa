package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbGoIPGrp;

public interface TbGoIPGrpDao {
    int deleteByPrimaryKey( String keyGoIPDevGrpID );

    int insert( TbGoIPGrp record );

    int insertSelective( TbGoIPGrp record );

    TbGoIPGrp selectByPrimaryKey( String keyGoIPDevGrpID );

    int updateByPrimaryKeySelective( TbGoIPGrp record );

    int updateByPrimaryKey( TbGoIPGrp record );
}