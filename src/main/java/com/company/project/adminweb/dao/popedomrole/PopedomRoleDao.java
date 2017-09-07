package com.company.project.adminweb.dao.popedomrole;

import com.company.project.adminweb.dao.BaseDao;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 角色Dao
 *
 * @author wangzhj
 */
public interface PopedomRoleDao extends BaseDao<PopedomRoleEO> {

    PageList<PopedomRoleEO> getRolePageLt(String prName, int pageNo, int pageSize);
}
