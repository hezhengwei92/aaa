package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbViFiCtrlCmd;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TbViFiCtrlCmdDao {
    int deleteByPrimaryKey( String keyCtrlCmdID );

    int insert( TbViFiCtrlCmd record );

    int insertSelective( TbViFiCtrlCmd record );

    TbViFiCtrlCmd selectByPrimaryKey( String keyCtrlCmdID );

    int updateByPrimaryKeySelective( TbViFiCtrlCmd record );

    int updateByPrimaryKey( TbViFiCtrlCmd record );

    @Select("select keyCtrlCmdID, cmd, params from tbViFiCtrlCmd where idxViFiID = #{0} and NOW() between effectDate and ineffectDate")
    List< Map< String, Object > > selectAllCMDByVID ( String idxViFiID );

}