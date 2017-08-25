package com.company.project.adminweb.service.function;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 菜单VO
 *
 * @author wangzhj
 */
public class MenuVO {

    /**
     * 功能名称
     */
    private String pfName;
    /**
     * 功能路径
     */
    private String pfPath;
    /**
     * 子功能
     */
    private List<MenuVO> children = Lists.newArrayList();

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName;
    }

    public String getPfPath() {
        return pfPath;
    }

    public void setPfPath(String pfPath) {
        this.pfPath = pfPath;
    }

    public List<MenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }
}
