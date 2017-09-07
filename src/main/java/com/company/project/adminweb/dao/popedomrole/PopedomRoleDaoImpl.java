package com.company.project.adminweb.dao.popedomrole;

import com.company.project.adminweb.dao.BaseDaoImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PopedomRoleDaoImpl extends BaseDaoImpl<PopedomRoleEO> implements PopedomRoleDao {

    @Override
    public PageList<PopedomRoleEO> getRolePageLt(String prName, int pageNo, int pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("prName", prName);
        PageBounds pageBounds = new PageBounds(pageNo, pageSize);
        return (PageList) getSqlSession().selectList(getSqlId("getRolePageLt"), params, pageBounds);
    }
}
