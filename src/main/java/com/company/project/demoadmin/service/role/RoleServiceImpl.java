package com.company.project.demoadmin.service.role;

import com.company.project.demoadmin.dao.popedomrole.PopedomRoleDao;
import com.company.project.demoadmin.dao.popedomrole.PopedomRoleEO;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private PopedomRoleDao popedomRoleDao;

    @Override
    public PageList<PopedomRoleEO> getRolePageLt() {
        return popedomRoleDao.getRolePageLt();
    }
}
