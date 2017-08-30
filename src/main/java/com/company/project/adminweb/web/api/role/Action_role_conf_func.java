package com.company.project.adminweb.web.api.role;

import com.company.project.adminweb.service.role.RoleService;
import com.company.project.adminweb.support.action.BaseAction;
import com.company.project.adminweb.support.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Action_role_conf_func extends BaseAction {

    @Autowired
    private RoleService roleService;

    @Override
    public void checkData(RequestContext cxt, Map<String, Object> param) {

    }

    @Override
    public Map<String, Object> execute(RequestContext cxt, Map<String, Object> param) {


        return null;
    }
}
