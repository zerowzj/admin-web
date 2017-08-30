package com.company.project.adminweb.service.function;

import com.company.project.adminweb.dao.popedomfunction.PopedomFunctionEO;

import java.util.Collection;
import java.util.List;

/**
 * 功能服务
 *
 * @author wangzhj
 */
public interface FunctionService {

    /**
     * 获取功能列表
     *
     * @param pfStatus
     * @param pfLevelLt
     * @return List<PopedomFunctionEO>
     */
    List<PopedomFunctionEO> getFunctionLt(String pfStatus, List<Integer> pfLevelLt);

    /**
     * 获取角色菜单列表
     *
     * @param prId
     * @return Collection<MenuVO>
     */
    Collection<MenuVO> getRoleMenuLt(Long prId);

    /**
     * 获取角色功能列表
     *
     * @param prId
     * @return List<PopedomFunctionEO>
     */
    List<PopedomFunctionEO> getRoleFunctionLt(Long prId);

    /**
     * 获取角色配置功能列表
     *
     * @param prId
     * @return List<ConfFuncVO>
     */
    List<ConfFuncVO> getRoleConfFuncLt(Long prId);
}
