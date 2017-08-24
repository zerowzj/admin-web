package com.company.project.demoadmin.service.function;

import com.company.project.demoadmin.dao.popedomfunction.PopedomFunctionEO;

import java.util.Collection;
import java.util.List;

/**
 * 功能服务
 *
 * @author wangzhj
 */
public interface FunctionService {

    /**
     * 获取角色菜单列表
     *
     * @param prId
     * @return Collection<MenuVO>
     */
    Collection<MenuVO> getRoleMenuLt(Long prId);

    /**
     * 获取角色授权列表
     *
     * @param prId
     * @return List<PopedomFunctionEO>
     */
    List<PopedomFunctionEO> getRolePermissionLt(Long prId);
}
