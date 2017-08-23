package com.company.project.demoadmin.web.api.demo;

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
@RequestMapping("/demo")
public class DemoApi {

    @Action("/say_hi")
    public Map<String, Object> say_hi(HttpServletRequest request, HttpServletResponse response) {
        return ActionExecutor.execute(request, response, Action_say_hi.class);
    }

    @Action("/say_bye")
    public Map<String, Object> say_bye(HttpServletRequest request, HttpServletResponse response) {
        return ActionExecutor.execute(request, response, Action_say_bye.class);
    }
}