package com.company.project.adminweb.support.action;

import com.company.project.adminweb.support.SpringContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Action执行器
 *
 * @author wangzhj
 */
public class ActionExecutor {

    /**
     * 执行
     *
     * @param request  Http请求
     * @param response Http响应
     * @param clazz    执行类
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response,
                                              Class<? extends Action> clazz) {
        if (!SpringContext.containsBean(clazz)) {
            throw new IllegalStateException("Bean不存在");
        }
        Action action = SpringContext.getBean(clazz);
        return action.doExecute(request, response);
    }

    /**
     * 执行
     *
     * @param request  Http请求
     * @param response Http响应
     * @param name     执行类名称
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response,
                                              String name) {
        if (!SpringContext.containsBean(name)) {
            throw new IllegalStateException("Bean不存在");
        }
        Action action = SpringContext.getBean(name, Action.class);
        return action.doExecute(request, response);
    }
}
