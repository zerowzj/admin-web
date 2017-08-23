package com.company.project.demoadmin.auth.handler;

import com.company.project.demoadmin.auth.user.CustomUserDetails;
import com.company.project.demoadmin.dao.popedomfunction.MenuEO;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 认证成功处理器
 *
 * @author wangzhj
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        //获取认证信息
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        CustomUserDetails userDetails = (CustomUserDetails) token.getPrincipal();

        LOGGER.info("===>用户[{}]登录成功!", userDetails.getUsername());
        List<MenuEO> menuEOLt = Lists.newArrayList();

        MenuEO menuEO = new MenuEO();
        menuEO.setPfName("权限管理");

        menuEOLt.add(menuEO);

        List<MenuEO> children = Lists.newArrayList();
        MenuEO menuEO1 = new MenuEO();
        menuEO1.setPfName("角色列表");
        children.add(menuEO1);
        request.getSession().setAttribute("menuEOLt", menuEOLt);

        //执行父逻辑
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
