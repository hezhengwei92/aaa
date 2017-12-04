package net.eoutech.vifi.as.commons.dao;

import net.eoutech.vifi.as.commons.entity.TbCardStatus;

import java.util.List;


/**
 * Created by Administrator on 2016/11/7 0007.
 */
public interface TbCardStatusDao {
    TbCardStatus selectByVifiId(String vid);

    int insertFirstData(String uid, String vid, String status);

    int updateCardStatusAndUserId(String uid, String vid, String status);

    List<TbCardStatus> selectAllStaus();

    int updateStatus(String vid);
}
