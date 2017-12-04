package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbSupplier;

public interface TbSupplierDao {
    int deleteByPrimaryKey( String idxSupplierId );

    int insert( TbSupplier record );

    int insertSelective( TbSupplier record );

    TbSupplier selectByPrimaryKey( String idxSupplierId );

    int updateByPrimaryKeySelective( TbSupplier record );

    int updateByPrimaryKey( TbSupplier record );
}