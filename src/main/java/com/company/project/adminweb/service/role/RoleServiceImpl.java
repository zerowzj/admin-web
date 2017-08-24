package com.company.project.adminweb.service.role;

import com.company.project.adminweb.dao.popedomrole.PopedomRoleDao;
import com.company.project.adminweb.dao.popedomrole.PopedomRoleEO;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private PopedomRoleDao popedomRoleDao;

    @Override
    public PageList<PopedomRoleEO> getRolePageLt(String prName, int pageNo, int pageSize) {
        return popedomRoleDao.getRolePageLt(prName, pageNo, pageSize);
    }
}
