package com.company.project.adminweb.dao.popedomfunction;


import com.company.project.adminweb.common.db.BaseDao;

import java.util.List;

/**
 * 功能Dao
 *
 * @author wangzhj
 */
public interface PopedomFunctionDao extends BaseDao<PopedomFunctionEO> {

    /**
     * 获取功能列表
     *
     * @return List<PopedomFunctionEO>
     */
    List<PopedomFunctionEO> getFunctionLt();

    /**
     * 获取角色功能列表
     *
     * @param prId
     * @param pfIsMenu
     * @return List<PopedomFunctionEO>
     */
    List<PopedomFunctionEO> getRoleFunctionLt(Long prId, String pfIsMenu);
}
