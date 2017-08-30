package com.company.project.adminweb.web.api.role;

import com.company.exception.entity.param.EmptyValueException;
import com.company.project.adminweb.support.action.BaseAction;
import com.company.project.adminweb.support.context.RequestContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Action_role_modify extends BaseAction {

    @Override
    public void checkData(RequestContext cxt, Map<String, Object> param) {
        LOGGER.info("sdfsfsdf");
        throw new EmptyValueException("ABC");
    }

    @Override
    public Map<String, Object> execute(RequestContext cxt, Map<String, Object> param) {
        return null;
    }
}
