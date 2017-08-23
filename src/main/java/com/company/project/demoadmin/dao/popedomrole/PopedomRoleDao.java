package com.company.project.demoadmin.dao.popedomrole;

import com.company.project.demoadmin.common.db.BaseDao;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 角色Dao
 *
 * @author wangzhj
 */
public interface PopedomRoleDao extends BaseDao<PopedomRoleEO> {

    PageList<PopedomRoleEO> getRolePageLt(String prName, int pageNo, int pageSize);
}
