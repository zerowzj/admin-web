package com.company.project.demoadmin.support.tag;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import javax.servlet.jsp.JspException;

/**
 * Created by wangzhj on 2017/8/22.
 */
public class MenuTag extends BaseTag {

    private static final String FILE_NAME = "menu.txt";

    private static String menu;

    static {
        try {
            ClasspathResourceLoader loader = new ClasspathResourceLoader("");
            Configuration cfg = Configuration.defaultConfiguration();
            GroupTemplate gt = new GroupTemplate(loader, cfg);
            Template t = gt.getTemplate("/menu.txt");
            menu = t.render();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        write("sssssssssssss");
        return this.EVAL_PAGE;
    }
}
