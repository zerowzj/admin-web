package com.company.project.adminweb.auth;

import com.company.project.adminweb.dao.popedomfunction.PopedomFunctionEO;
import com.company.project.adminweb.service.function.FunctionService;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 功能映射
 *
 * @author wangzhj
 */
public class FunctionMapFactoryBean implements FactoryBean<LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionMapFactoryBean.class);

    @Autowired
    private FunctionService functionService;

    @Override
    public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> getObject() throws Exception {
        //TODO 受保护功能列表
        List<PopedomFunctionEO> pfEOLt = functionService.getFunctionLt(null, null);
        //生成映射
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> funMap = Maps.newLinkedHashMap();
        AntPathRequestMatcher matcher;
        List<ConfigAttribute> configAttrLt;
        for (PopedomFunctionEO pfEO : pfEOLt) {
//            //过滤掉1级
//            Integer pfLevel = pfEO.getPfLevel();
//            if (pfLevel == 1) {
//                continue;
//            }
            String pfPath = pfEO.getPfPath();
            if (Strings.isNullOrEmpty(pfPath)) {
                LOGGER.warn("功能[{}]Path为空", pfEO.getPfId());
                continue;
            }
            //匹配器
            matcher = new AntPathRequestMatcher(pfPath + "*");
            //配置属性
            configAttrLt = Lists.newArrayList();
            configAttrLt.add(new SecurityConfig(pfPath));

            funMap.put(matcher, configAttrLt);
        }
        return funMap;
    }

    @Override
    public Class<?> getObjectType() {
        return LinkedHashMap.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
