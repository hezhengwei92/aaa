package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbSimCard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface TbSimCardDao {
    int deleteByPrimaryKey( String keySimCardID );

    int insert( TbSimCard record );

    int insertSelective( TbSimCard record );

    TbSimCard selectByPrimaryKey( String keySimCardID );

    int updateByPrimaryKeySelective( TbSimCard record );

    int updateByPrimaryKey( TbSimCard record );

    TbSimCard selectByIccid ( String iccid );

    /**
     * scGroupList...agentId
     * @param params
     * @return
     */
    String selectActiveSimCard( Map< String, Object > params );

    List< String > selectSCGrpIdList( List< String > iccidList );

    TbSimCard selectBestSimCardByGroupId ( String scGroupId, String bindType );

    @Update("update tbSimCard set Status=#{1},MdfBy=#{2},MdfTm=NOW() where IdxIccid=#{0}")
    int updateSimCard(String idxIccid,int status,String MdfBy);

    @Update("update tbSimCard set restNetData=#{1},Status=#{2},MdfBy=#{3},MdfTm=NOW() where IdxIccid=#{0}")
    int updateSimCardData(String idxIccid,double restNetData,int status,String MdfBy);

    @Update("update tbSimCard set restNetData=#{1},MdfBy=#{2},MdfTm=NOW() where IdxIccid=#{0}")
    int updateSimCardData2(String idxIccid,double restNetData,String MdfBy);

    @Delete("delete from tbSimCard where idxIccid = #{0}")
    void deleteByIccid( String iccid);
    @Update("update tbSimCard set restNetData=#{0} where status=0 or status=1")
    void updateNetData(int restNetData);
}