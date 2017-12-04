package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbViFiDevice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface TbViFiDeviceDao {
    int deleteByPrimaryKey( String keyDevID );

    int insert( TbViFiDevice record );

    int insertSelective( TbViFiDevice record );

    TbViFiDevice selectByPrimaryKey( String keyDevID );

    int updateByPrimaryKeySelective( TbViFiDevice record );

    int updateByPrimaryKey( TbViFiDevice record );

    TbViFiDevice selectByIdxViFiID( String idxViFiID );

    int updateLastOnlineInfo ( Map<String, String> params );

    int updateUUWiFiInfo ( @Param( value = "deviceId") String deviceId, @Param( value = "lastUUWiFiSessId" ) String lastUUWiFiSessId, @Param( value = "lastUUWiFiData") Integer lastUUWiFiData );

    TbViFiDevice queryTimeOut(String idxViFiID);

    @Select("select * from tbvifidevice where idxUserID=#{0} and idxViFiID=#{1}")
    TbViFiDevice queryByUidAndVid(String uid,String vid);

    @Update("update tbvifidevice set deviceFlow=#{1} where idxViFiID=#{0}")
    int updateDeviceInfo(String vid,Double leafFlow);

}