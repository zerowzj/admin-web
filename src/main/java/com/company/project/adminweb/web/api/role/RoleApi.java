package com.company.project.adminweb.web.api.role;

import com.company.project.adminweb.support.action.ActionExecutor;
import com.company.project.adminweb.support.annotation.Action;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 角色API
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/api/role")
public class RoleApi {

    @Action("/add")
    public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response) {
        return ActionExecutor.execute(request, response, Action_role_add.class);
    }

    @Action("/list")
    public Map<String, Object> list(HttpServletRequest request, HttpServletResponse response) {
        return ActionExecutor.execute(request, response, Action_role_list.class);
    }

    @Action("/add_func")
    public Map<String, Object> add_func(HttpServletRequest request, HttpServletResponse response) {
        return ActionExecutor.execute(request, response, Action_role_add_func.class);
    }

    @Action("/modify")
    public Map<String, Object> modify(HttpServletRequest request, HttpServletResponse response) {
        return ActionExecutor.execute(request, response, Action_role_modify.class);
    }
}
