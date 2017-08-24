package com.company.project.adminweb.web.api.role;

import com.company.project.adminweb.common.util.JsonUtil;
import com.company.project.adminweb.dao.popedomrole.PopedomRoleEO;
import com.company.project.adminweb.service.role.RoleService;
import com.company.project.adminweb.support.action.BaseAction;
import com.company.project.adminweb.support.context.RequestContext;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Action_role_list extends BaseAction {

    @Autowired
    private RoleService roleService;

    @Override
    public void checkData(RequestContext cxt, Map<String, Object> param) {

    }

    @Override
    public Map<String, Object> execute(RequestContext cxt, Map<String, Object> param) {

        PageList<PopedomRoleEO> pageLt = roleService.getRolePageLt(null, 1, 10);

        LOGGER.info(JsonUtil.toJson(pageLt));
        Map<String, Object> data = Maps.newHashMap();
        data.put("121", "");
        data.put("", "");
        return data;
    }
}
