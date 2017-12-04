package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbSimPDev;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbSimPDevDao {
    int deleteByPrimaryKey( String keySimPDevID );

    int insert( TbSimPDev record );

    int insertSelective( TbSimPDev record );

    TbSimPDev selectByPrimaryKey( String keySimPDevID );

    int updateByPrimaryKeySelective( TbSimPDev record );

    int updateByPrimaryKey( TbSimPDev record );

    TbSimPDev selectByUserName ( String userName );

    @Update( "update tbSimPDev set ipaddr=#{1}, port=#{2}, `status`=#{3}, expire=#{4}, ports=#{5} , serveIp=#{6} ,servePort=#{7},idxAgentID=#{8},mdfTm=NOW(),lastUpdate=NOW() where keySimPDevID = #{0}" )
    int updateSimPReg ( String keyDeviceID, String ip, int port, int status, int expire ,int ports ,String serveIp ,int servePort, String agentName);

    @Update( "update tbSimPDev set ipaddr=#{1}, port=#{2}, `status`=#{3}, ports=#{4} , serveIp=#{5} ,servePort=#{6},lastUpdate=NOW() where keySimPDevID = #{0}" )
    int resetSimPReg ( String keyDeviceID, String ip, int port, int status, int ports ,String serveIp ,int servePort);

    @Select("select * from tbSimPDev where ipaddr = #{0} and port = #{1} limit 1")
    TbSimPDev selectCardPoolByIPPort(String ip, String port);
}