package com.company.project.demoadmin.web.controller.role;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangzhj on 2017/8/18.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("/list")
    public String tt(){
        return "/role/list";
    }
}
