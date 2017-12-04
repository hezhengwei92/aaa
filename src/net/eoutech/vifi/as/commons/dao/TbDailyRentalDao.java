package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbDailyRental;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbDailyRentalDao {
    int deleteByPrimaryKey( Integer keyID );

    int insert( TbDailyRental record );

    int insertSelective( TbDailyRental record );

    TbDailyRental selectByPrimaryKey( Integer keyID );

    int updateByPrimaryKeySelective( TbDailyRental record );

    int updateByPrimaryKey( TbDailyRental record );

    List< TbDailyRental > selectByUserId ( @Param( "userId" ) String userId, @Param( "vid" ) String vid );
}