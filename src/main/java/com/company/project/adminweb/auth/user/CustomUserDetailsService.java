package com.company.project.adminweb.auth.user;

import com.company.project.adminweb.service.function.FunctionService;
import com.company.project.adminweb.service.function.PermissionVO;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        List<SimpleGrantedAuthority> grantedAuthLt = makeGrantedAuthLt(permissionVOLt);
        userDetails.setGrantedAuthLt(grantedAuthLt);

        //返回
        return userDetails;
    }

    private List<SimpleGrantedAuthority> makeGrantedAuthLt(List<PermissionVO> permissionVOLt) {
        List<SimpleGrantedAuthority> grantedAuthLt = Lists.newArrayList();
        for (PermissionVO permissionVO : permissionVOLt) {
            String pfPath = permissionVO.getPfPath();
            if (Strings.isNullOrEmpty(pfPath)) {
                LOGGER.info("功能[{}]path为空", permissionVO.getPfId());
                continue;
            }
            grantedAuthLt.add(new SimpleGrantedAuthority(pfPath));
        }
        return grantedAuthLt;
    }
}
