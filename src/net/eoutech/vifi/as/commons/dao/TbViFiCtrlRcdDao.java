package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbViFiCtrlRcd;

import java.util.List;

public interface TbViFiCtrlRcdDao {
    int deleteByPrimaryKey( Integer keyCtrlRcdID );

    int insert( TbViFiCtrlRcd record );

    int insertSelective( TbViFiCtrlRcd record );

    TbViFiCtrlRcd selectByPrimaryKey( Integer keyCtrlRcdID );

    int updateByPrimaryKeySelective( TbViFiCtrlRcd record );

    int updateByPrimaryKey( TbViFiCtrlRcd record );

    int insertBatch( List< TbViFiCtrlRcd > records );
}