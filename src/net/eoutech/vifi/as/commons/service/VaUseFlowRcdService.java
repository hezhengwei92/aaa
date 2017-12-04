package net.eoutech.vifi.as.commons.service;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.dao.TbUseFlowRcdDao;
import net.eoutech.vifi.as.commons.entity.TbUseFlowRcd;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.commons.vo.VaUseFlowRcd;

/**
 * Created by admin on 2017/7/7.
 */
public class VaUseFlowRcdService {

    public static VaUseFlowRcdService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaUseFlowRcdService.class );
    }
    @MyQuery( qryClass = TbUseFlowRcdDao.class )
    public VaUseFlowRcd getUseFlowByKey (String keyId, Object...daos ) {

        TbUseFlowRcdDao dao = ( TbUseFlowRcdDao ) daos[0];
        TbUseFlowRcd tbUseFlowRcd=dao.selectFlowRcd(keyId);

        return new VaUseFlowRcd( tbUseFlowRcd );
    }



}
