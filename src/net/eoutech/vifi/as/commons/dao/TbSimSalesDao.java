package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbSimSales;

import java.util.List;
import java.util.Map;

public interface TbSimSalesDao {
    int deleteByPrimaryKey( Integer keySimSalesID );

    int insert( TbSimSales record );

    int insertSelective( TbSimSales record );

    TbSimSales selectByPrimaryKey( Integer keySimSalesID );

    int updateByPrimaryKeySelective( TbSimSales record );

    int updateByPrimaryKey( TbSimSales record );

    /**
     * agentIdList...areaIdList
     * @param params
     * @return
     */
    List< String > selectByAgentArea ( Map< String, List< String > > params );
}