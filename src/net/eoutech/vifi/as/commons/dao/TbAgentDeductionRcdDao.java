package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbAgentDeductionRcd;

import java.util.List;

public interface TbAgentDeductionRcdDao {
    int deleteByPrimaryKey( Integer keyID );

    int insert( TbAgentDeductionRcd record );

    int insertSelective( TbAgentDeductionRcd record );

    TbAgentDeductionRcd selectByPrimaryKey( Integer keyID );

    int updateByPrimaryKeySelective( TbAgentDeductionRcd record );

    int updateByPrimaryKey( TbAgentDeductionRcd record );

    int insertBatch ( List< TbAgentDeductionRcd > list );
}