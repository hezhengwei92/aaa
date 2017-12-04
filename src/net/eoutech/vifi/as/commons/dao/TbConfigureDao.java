package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbConfigure;

public interface TbConfigureDao {
    int deleteByPrimaryKey(Integer keyConfigureId);

    int insert(TbConfigure record);

    int insertSelective(TbConfigure record);

    TbConfigure selectByPrimaryKey(Integer keyConfigureId);

    int updateByPrimaryKeySelective(TbConfigure record);

    int updateByPrimaryKey(TbConfigure record);

    TbConfigure selectByName ( String name );
}