package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbUserDao {
    int deleteByPrimaryKey( String keyUserID );

    int insert( TbUser record );

    int insertSelective( TbUser record );

    TbUser selectByPrimaryKey( String keyUserID );

    int updateByPrimaryKeySelective( TbUser record );

    int updateByPrimaryKey( TbUser record );

    int userCost ( String userId, int cost );

    TbUser selectByPhoneNumber ( String phoneNumber );

    @Update( "update tbUser set appState = #{1}, sipExpire = #{2}, lastAPPOnlineDate = NOW(), lastAPPPublicIP = #{3}, lastAPPPublicPort = #{4} where idxPhoneNumber = #{0}" )
    int updateUserSipReg ( String uid, int appState, int sipExpire, String lastAPPPublicIP, int lastAPPPublicPort );

    @Select( "select * from tbUser where idxPhoneNumber like CONCAT( '%', #{0} ) limit 1" )
    TbUser fuzzyQueryUserByUId( String uid );
}