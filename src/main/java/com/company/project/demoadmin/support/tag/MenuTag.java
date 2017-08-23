package com.company.project.demoadmin.support.tag;

import com.company.project.demoadmin.dao.popedomfunction.MenuEO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import javax.servlet.jsp.JspException;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhj on 2017/8/22.
 */
public class MenuTag extends BaseTag {

    private static final String FILE_NAME = "menu.txt";

    private static Template template;

    static {
        try {
            ClasspathResourceLoader loader = new ClasspathResourceLoader("");
            Configuration cfg = Configuration.defaultConfiguration();
            GroupTemplate gt = new GroupTemplate(loader, cfg);
            template = gt.getTemplate(FILE_NAME);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        List<MenuEO> menuEOLt = Lists.newArrayList();

        MenuEO menuEO = new MenuEO();
        menuEO.setPfName("权限管理");

        menuEOLt.add(menuEO);

        List<MenuEO> children = Lists.newArrayList();
        MenuEO menuEO1 = new MenuEO();
        menuEO1.setPfName("角色列表");
        children.add(menuEO1);
        menuEO.setChildren(children);

        Map data = Maps.newHashMap();
        data.put("menuEOLt", menuEOLt);
        template.binding(data);

        write(template.render());

        return this.EVAL_PAGE;
    }
}
