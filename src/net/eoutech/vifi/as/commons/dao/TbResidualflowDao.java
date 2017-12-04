package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbResidualflow;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public interface TbResidualflowDao {
        List<TbResidualflow> list(String idxUserID);

        double selectResidualflow(String idxUserID);

        @Update("UPDATE tbResidualflow set residualflow = #{0} WHERE idxUserID = #{1} and keyID = #{2}")
        int updateResidualflow(Double residualflow, String idxUserId,int keyID);

        @Update("UPDATE tbResidualflow set residualflow = 0 ,`status` = 1 WHERE keyID = #{0}")
        int updateResidualStatus(int keyID);

        List<TbResidualflow> selectByStatus();

        int deleteDefeat(String idxUserID,int flowid);

        int deleteByKeyId(Integer keyId);

        int updateStatus(String idxUserID);

        int insertFlow(TbResidualflow record);

        int updateLock();

        int deleteOverdue();

        List<TbResidualflow> listOrderID();

        List<TbResidualflow> selectListByUserID(String idxUserID);
}
