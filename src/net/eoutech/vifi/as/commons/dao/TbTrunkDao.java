package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbTrunk;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface TbTrunkDao {
    int deleteByPrimaryKey( Integer keyTrunkID );

    int insert( TbTrunk record );

    int insertSelective( TbTrunk record );

    TbTrunk selectByPrimaryKey( Integer keyTrunkID );

    int updateByPrimaryKeySelective( TbTrunk record );

    int updateByPrimaryKey( TbTrunk record );

    List< TbTrunk > selectBatchById ( @Param( "idList" ) Set< Integer > idList );

    TbTrunk selectByHost ( String host );
}