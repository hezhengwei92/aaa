package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbUUMsgTmpl;

public interface TbUUMsgTmplDao {
    int deleteByPrimaryKey( Integer keyTmplId );

    int insert( TbUUMsgTmpl record );

    int insertSelective( TbUUMsgTmpl record );

    TbUUMsgTmpl selectByPrimaryKey( Integer keyTmplId );

    int updateByPrimaryKeySelective( TbUUMsgTmpl record );

    int updateByPrimaryKey( TbUUMsgTmpl record );

    TbUUMsgTmpl selectByNameLang ( String name, String lang );
}