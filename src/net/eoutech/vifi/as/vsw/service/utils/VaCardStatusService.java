package net.eoutech.vifi.as.vsw.service.utils;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.dao.TbCardStatusDao;
import net.eoutech.vifi.as.commons.dao.TbViFiDeviceDao;
import net.eoutech.vifi.as.commons.entity.TbCardStatus;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class VaCardStatusService {

    public static VaCardStatusService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaCardStatusService.class );
    }

    @MyQuery(qryType = MyQuery.QUERY,qryClass = {TbCardStatusDao.class})
    public TbCardStatus selectByVifiId(String vid, Object...daos){
        TbCardStatusDao dao =(TbCardStatusDao)daos[0];
        return dao.selectByVifiId(vid);
    }

    @MyQuery( qryType = MyQuery.MODIFY, qryClass = { TbViFiDeviceDao.class } )
    public int updateCardStatus ( String vid, Object...daos ) {
        TbCardStatusDao dao =(TbCardStatusDao)daos[0];
        return dao.updateStatus( vid );
    }



}
