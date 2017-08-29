package com.company.project.adminweb.auth.user;

import com.company.project.adminweb.service.function.FunctionService;
import com.company.project.adminweb.service.function.PermissionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * 用户详情服务
 *
 * @author wangzhj
 */
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private FunctionService functionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //用户详情
        CustomUserDetails userDetails = new CustomUserDetails(username, "123123");

        //TODO 用户被授权功能列表
        List<PermissionVO> permissionVOLt = functionService.getRolePermissionLt(1L);
        //返回
        return userDetails;
    }
}
