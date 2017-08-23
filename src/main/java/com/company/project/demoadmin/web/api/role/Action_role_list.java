package com.company.project.demoadmin.web.api.role;

import com.company.project.demoadmin.dao.popedomrole.PopedomRoleEO;
import com.company.project.demoadmin.service.role.RoleService;
import com.company.project.demoadmin.support.action.BaseAction;
import com.company.project.demoadmin.support.context.RequestContext;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by wangzhj on 2017/8/10.
 */
@Component
public class Action_role_list extends BaseAction {

    @Autowired
    private RoleService roleService;

    @Override
    public void checkData(RequestContext cxt, Map<String, Object> param) {

    }

    @Override
    public Map<String, Object> execute(RequestContext cxt, Map<String, Object> param) {

        PageList<PopedomRoleEO> pageLt = roleService.getRolePageLt();

        Map<String, Object> data = Maps.newHashMap();

        data.put("", "");
        data.put("", "");
        return data;
    }
}
