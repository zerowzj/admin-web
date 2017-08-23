package com.company.project.demoadmin.dao.popedomfunction;

import java.util.List;

/**
 * Created by wangzhj on 2017/8/22.
 */
public class MenuEO {

    private Long pfId;

    private String pfName;

    private String prPath;

    private List<MenuEO> children;

    public Long getPfId() {
        return pfId;
    }

    public void setPfId(Long pfId) {
        this.pfId = pfId;
    }

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName;
    }

    public String getPrPath() {
        return prPath;
    }

    public void setPrPath(String prPath) {
        this.prPath = prPath;
    }

    public List<MenuEO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuEO> children) {
        this.children = children;
    }
}
