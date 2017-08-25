package com.company.project.adminweb.service.function;

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
     * @return List<PermissionVO>
     */
    List<PermissionVO> getRolePermissionLt(Long prId);
}
