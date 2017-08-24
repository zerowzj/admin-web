package com.company.project.demoadmin.support.tag;

import com.company.project.demoadmin.service.function.FunctionService;
import com.company.project.demoadmin.service.function.MenuVO;
import com.company.project.demoadmin.support.SpringContext;
import com.google.common.collect.Maps;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import javax.servlet.jsp.JspException;
import java.util.Collection;
import java.util.Map;

/**
 * 菜单Tag
 *
 * @author wangzhj
 */
public class MenuTag extends BaseTag {

    private static final String FILE_NAME = "menu.txt";

    private static Template template;

    static {
        try {
            ClasspathResourceLoader loader = new ClasspathResourceLoader("");
            Configuration config = Configuration.defaultConfiguration();
            GroupTemplate gt = new GroupTemplate(loader, config);
            template = gt.getTemplate(FILE_NAME);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int doEndTag() throws JspException {
        FunctionService functionService = SpringContext.getBean(FunctionService.class);
        Collection<MenuVO> menuVOLt = functionService.getRoleMenuLt(1L);

        Map data = Maps.newHashMap();
        data.put("menuVOLt", menuVOLt);

        template.binding(data);
        write(template.render());

        return this.EVAL_PAGE;
    }
}
