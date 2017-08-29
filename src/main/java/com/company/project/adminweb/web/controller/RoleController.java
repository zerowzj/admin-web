package com.company.project.adminweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 角色控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("/to_add")
    public String to_add(HttpServletRequest request, HttpServletResponse response) {
        return "/role/role_add";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response) {
        return "/role/role_list";
    }
}
