package com.company.project.demoweb.api.demo;

import com.company.project.demoweb.support.action.BaseAction;
import com.company.project.demoweb.support.context.RequestContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by wangzhj on 2017/8/10.
 */
@Component
public class Action_say_bye extends BaseAction {

    @Override
    public void checkData(RequestContext cxt, Map<String, Object> param) {
        LOGGER.info("sdfsfsdf");
    }

    @Override
    public Map<String, Object> execute(RequestContext cxt, Map<String, Object> param) {
        return null;
    }
}
