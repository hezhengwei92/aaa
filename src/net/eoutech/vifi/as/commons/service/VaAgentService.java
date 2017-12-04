package net.eoutech.vifi.as.commons.service;

import net.eoutech.vifi.as.commons.annotation.MyQuery;
import net.eoutech.vifi.as.commons.dao.TbAgentDao;
import net.eoutech.vifi.as.commons.entity.TbAgent;
import net.eoutech.vifi.as.commons.utils.MybatisUtils;
import net.eoutech.vifi.as.commons.vo.VaAgent;

/**
 * Created by SUU on 2016/6/22.
 */
public class VaAgentService {

    public static VaAgentService getInstance () {
        return MybatisUtils.sqlProxyInstance( VaAgentService.class );
    }

    @MyQuery( qryClass = TbAgentDao.class )
    public VaAgent getAgentById ( String agentId, Object...daos ) {
        TbAgentDao dao = ( TbAgentDao ) daos[0];
        TbAgent tbAgent = dao.selectByPrimaryKey( agentId );
        if ( tbAgent == null ) {
            return null;
        }
        return new VaAgent( tbAgent );
    }

}
