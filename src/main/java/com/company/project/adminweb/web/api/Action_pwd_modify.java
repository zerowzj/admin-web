package com.company.project.adminweb.web.api;

import com.company.project.adminweb.support.action.BaseAction;
import com.company.project.adminweb.support.context.RequestContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 密码修改
 *
 * @author wangzhj
 */
@Component
public class Action_pwd_modify extends BaseAction {

    @Override
    public void checkData(RequestContext cxt, Map<String, Object> param) {

    }

    @Override
    public Map<String, Object> execute(RequestContext cxt, Map<String, Object> param) {
        return null;
    }
}
