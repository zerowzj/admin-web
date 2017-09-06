package com.company.project.adminweb.web.api;

import com.company.project.adminweb.support.action.ActionExecutor;
import com.company.project.adminweb.support.annotation.Action;
import com.company.project.adminweb.support.annotation.Api;
import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Api路由
 *
 * @author wangzhj
 */
@Api
public class ApiRouter {

    private static final String ACTION_PREFIX = "action";

    @Action("/${module}/${action}")
    public Map<String, Object> route(@PathVariable String module, @PathVariable String action,
                                     HttpServletRequest request, HttpServletResponse response) {
        String actionName = Joiner.on("_").join(ACTION_PREFIX, module, action);
        return ActionExecutor.execute(request, response, actionName);
    }

    @Action("/${action}")
    public Map<String, Object> route_(@PathVariable String action,
                                      HttpServletRequest request, HttpServletResponse response) {
        String actionName = Joiner.on("_").join(ACTION_PREFIX, action);
        return ActionExecutor.execute(request, response, actionName);
    }
}
