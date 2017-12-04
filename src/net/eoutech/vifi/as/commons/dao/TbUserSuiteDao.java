package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbUserSuite;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbUserSuiteDao {
    int deleteByPrimaryKey( Integer keyID );

    int insert( TbUserSuite record );

    int insertSelective( TbUserSuite record );

    TbUserSuite selectByPrimaryKey( Integer keyID );

    int updateByPrimaryKeySelective( TbUserSuite record );

    int updateByPrimaryKey( TbUserSuite record );

    List< TbUserSuite > selectByUserIdSuiteType ( @Param( "userId" ) String userId, @Param( "suiteType" ) String suiteType, @Param( "areaIdList" ) List< String > areaIdList );

    int suiteCostBatch ( List< Map< String, Integer > > params );
}