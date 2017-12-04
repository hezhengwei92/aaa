package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbUseFlowRcd;
import org.apache.ibatis.annotations.Select;

/**
 * Created by admin on 2017/7/7.
 */
public interface TbUseFlowRcdDao {

    int insertFlowRcd(TbUseFlowRcd useFlowRcd);

    @Select("select * from tbUseFlowRcd where keyId=#{0}")
    TbUseFlowRcd selectFlowRcd(String keyId);

}
