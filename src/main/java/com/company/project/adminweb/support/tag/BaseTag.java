package com.company.project.adminweb.support.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 基础Tag
 *
 * @author wangzhj
 */
public class BaseTag extends TagSupport {

    private PageContext pageContext;

    /**
     * 输出
     *
     * @param msg
     */
    public void write(String msg) {
        try {
            pageContext.getOut().write(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取HttpServletRequest
     *
     * @return HttpServletRequest
     */
    protected HttpServletRequest getHttpServletRequest() {
        return (HttpServletRequest) pageContext.getRequest();
    }

    /**
     * 获取HttpServletResponse
     *
     * @return HttpServletResponse
     */
    protected HttpServletResponse getHttpServletResponse() {
        return (HttpServletResponse) pageContext.getResponse();
    }

    /**
     * 获取HttpSession
     *
     * @return HttpSession
     */
    protected HttpSession getHttpSession() {
        return pageContext.getSession();
    }

    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }
}
