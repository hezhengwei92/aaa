package net.eoutech.vifi.as.vsw.service.utils;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.dao.TbUserTopupRcdDao;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class VaUserTopupRcdService {

    public static VaUserTopupRcdService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaUserTopupRcdService.class );
    }

    @MyQuery(qryType = MyQuery.MODIFY,qryClass = {TbUserTopupRcdDao.class})
    public int updateStatus(String oid, Object...daos){
        TbUserTopupRcdDao dao = (TbUserTopupRcdDao)daos[0];
        return dao.updateLock( oid );
    }

}
