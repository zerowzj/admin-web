package com.company.project.adminweb.web.api;

import com.company.project.adminweb.support.action.ActionExecutor;
import com.company.project.adminweb.support.annotation.Action;
import com.company.project.adminweb.web.api.role.Action_role_add;
import com.google.common.base.Joiner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by wangzhj on 2017/8/30.
 */
@Controller
@RequestMapping("/api")
public class ApiRouter {

    private static final String ACTION_PREFIX = "Action";

    @Action("/${module}/${action}")
    public Map<String, Object> route(@PathVariable String module, @PathVariable String action,
                                     HttpServletRequest request, HttpServletResponse response) {

        String actionName = Joiner.on("_").join(ACTION_PREFIX, module, action);

        return ActionExecutor.execute(request, response, Action_role_add.class);
    }
}
