package com.company.project.demoadmin.dao.popedomrole;

import com.company.project.demoadmin.common.db.BaseDaoImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Repository;

@Repository
public class PopedomRoleDaoImpl extends BaseDaoImpl<PopedomRoleEO> implements PopedomRoleDao {

    @Override
    public PageList<PopedomRoleEO> getRolePageLt() {
        return null;
    }
}
