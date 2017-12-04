package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbGoIPDev;
import org.apache.ibatis.annotations.Update;

public interface TbGoIPDevDao {
    int deleteByPrimaryKey( String keyGoIPDevID );

    int insert( TbGoIPDev record );

    int insertSelective( TbGoIPDev record );

    TbGoIPDev selectByPrimaryKey( String keyGoIPDevID );

    int updateByPrimaryKeySelective( TbGoIPDev record );

    int updateByPrimaryKey( TbGoIPDev record );

    /**
     * mysql...create by mr_wu
     */
    TbGoIPDev selectByUserName ( String userName );

    @Update( "update tbGoIPDev set ipaddr=#{1}, port=#{2}, `status`=#{3}, expire=#{4}, lastUpdate = NOW() where keyGoIPDevID = #{0}" )
    int updateGoIPReg ( String keyGoIPDevID, String ip, int port, int status, int expire );

    @Update( "update tbGoIPDev set sipIP = #{1}, sipPort = #{2}, sipRegExp = #{4}, `status` = #{3}, sipRegDate = NOW() where username = #{0} " )
    int updateGoIPSipReg ( String username, String ip, int port, int status, int expire );
}