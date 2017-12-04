package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbRate;

import java.util.Map;

public interface TbRateDao {
    int deleteByPrimaryKey( Integer keyRateID );

    int insert( TbRate record );

    int insertSelective( TbRate record );

    TbRate selectByPrimaryKey( Integer keyRateID );

    int updateByPrimaryKeySelective( TbRate record );

    int updateByPrimaryKey( TbRate record );

    TbRate queryCallRate ( Map< String, Object > params );

    /**
     * String countryCode, String agentId
     * @return
     */
    TbRate queryDataRate( Map< String, Object > params );
}