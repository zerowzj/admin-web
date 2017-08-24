package com.company.project.adminweb.service.role;

import com.company.project.adminweb.dao.popedomrole.PopedomRoleEO;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 角色服务
 *
 * @author wangzhj
 */
public interface RoleService {

    /**
     * 获取角色列表
     *
     * @return PageList<PopedomRoleEO>
     */
    PageList<PopedomRoleEO> getRolePageLt(String prName, int pageNo, int pageSize);
}
