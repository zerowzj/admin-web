package com.company.project.adminweb.service.role;

import com.company.project.adminweb.dao.popedomrole.PopedomRoleEO;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

/**
 * 角色服务
 *
 * @author wangzhj
 */
public interface RoleService {

    /**
     * 获取角色列表
     *
     * @param prName
     * @param pageNo
     * @param pageSize
     * @return PageList<PopedomRoleEO>
     */
    PageList<PopedomRoleEO> getRolePageLt(String prName, Integer pageNo, Integer pageSize);

    /**
     * 新增角色功能
     *
     * @param prId
     * @param pfIdLt
     */
    void addFunction(Long prId, List<Long> pfIdLt);
}
