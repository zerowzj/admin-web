package com.company.project.demoadmin.web.api.role;

import com.company.project.demoadmin.support.action.ActionExecutor;
import com.company.project.demoadmin.support.annotation.Action;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by wangzhj on 2017/8/10.
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
}
