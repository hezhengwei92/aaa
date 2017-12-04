package net.eoutech.vifi.as.vsw.service.utils;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.dao.TbResidualflowDao;
import net.eoutech.vifi.as.commons.entity.TbResidualflow;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class VaResidualflowService {

    public static VaResidualflowService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaResidualflowService.class );
    }

    @MyQuery(qryType = MyQuery.QUERY,qryClass = {TbResidualflowDao.class})
    public List<TbResidualflow>  queryByUid(String uid, Object...daos){
        TbResidualflowDao dao =(TbResidualflowDao)daos[0];
        List<TbResidualflow> list=dao.list(uid);
        return list;
    }
    @MyQuery(qryType = MyQuery.QUERY,qryClass = {TbResidualflowDao.class})
    public double selectTotal(String idxUserId, Object...daos){
        TbResidualflowDao dao = (TbResidualflowDao)daos[0];
        return dao.selectResidualflow(idxUserId);
    }
    @MyQuery(qryType = MyQuery.MODIFY,qryClass = {TbResidualflowDao.class})
    public int updateFlow(Double residualflow,String idxUserId,int keyID, Object...daos){
        TbResidualflowDao dao = (TbResidualflowDao)daos[0];
        return dao.updateResidualflow(residualflow,idxUserId,keyID);
    }
    @MyQuery(qryType = MyQuery.MODIFY,qryClass = {TbResidualflowDao.class})
    public int delete(String uid,int flowid, Object...daos){
        TbResidualflowDao dao = (TbResidualflowDao)daos[0];
        return dao.deleteDefeat(uid,flowid);
    }


    @MyQuery(qryType = MyQuery.MODIFY,qryClass = {TbResidualflowDao.class})
    public List<TbResidualflow> queryBystatus( Object...daos){
        TbResidualflowDao dao = (TbResidualflowDao)daos[0];
        return dao.selectByStatus();
    }

    @MyQuery(qryType = MyQuery.MODIFY,qryClass = {TbResidualflowDao.class})
    public int deleteByKey(Integer keyId, Object...daos){
        TbResidualflowDao dao = (TbResidualflowDao)daos[0];
        return dao.deleteByKeyId(keyId);
    }
    @MyQuery(qryType = MyQuery.MODIFY,qryClass = {TbResidualflowDao.class})
    public int updateResidualStatus(Integer keyId, Object...daos){
        TbResidualflowDao dao = (TbResidualflowDao)daos[0];
        return dao.updateResidualStatus(keyId);
    }


    @MyQuery(qryType = MyQuery.MODIFY,qryClass = {TbResidualflowDao.class})
    public int updateStatus(String uid, Object...daos){
        TbResidualflowDao dao = (TbResidualflowDao)daos[0];
        return dao.updateStatus(uid);
    }

    @MyQuery(qryType = MyQuery.MODIFY,qryClass = {TbResidualflowDao.class})
    public int insertFlow(TbResidualflow record, Object...daos){
        TbResidualflowDao dao = (TbResidualflowDao)daos[0];
        return dao.insertFlow(record);
    }

    @MyQuery(qryType = MyQuery.MODIFY,qryClass = {TbResidualflowDao.class})
    public int updateLock( Object...daos){
        TbResidualflowDao dao = (TbResidualflowDao)daos[0];
        return dao.updateLock();
    }

    @MyQuery(qryType = MyQuery.MODIFY,qryClass = {TbResidualflowDao.class})
    public int deleteOverdue(Object...daos){
        TbResidualflowDao dao = (TbResidualflowDao)daos[0];
        return dao.deleteOverdue();
    }

    @MyQuery(qryType = MyQuery.QUERY,qryClass = {TbResidualflowDao.class})
    public List<TbResidualflow>  query(Object...daos){
        TbResidualflowDao dao =(TbResidualflowDao)daos[0];
        List<TbResidualflow> list=dao.listOrderID();
        return list;
    }

    @MyQuery(qryType = MyQuery.QUERY,qryClass = {TbResidualflowDao.class})
    public List<TbResidualflow>  queryList(String userId,Object...daos){
        TbResidualflowDao dao =(TbResidualflowDao)daos[0];
        List<TbResidualflow> list=dao.selectListByUserID(userId);
        return list;
    }


}
