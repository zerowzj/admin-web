package com.company.project.demoweb.dao.popedomfunction;


import com.company.project.demoweb.common.db.BaseEO;

/**
 * 功能信息EO
 *
 * @author wangzhj
 */
public class PopedomFunctionEO extends BaseEO {

    /**
     * 功能编号
     */
    private Long pfId;
    /**
     * 父功能编号
     */
    private Long pfParentId;
    /**
     * 功能名称
     */
    private String pfName;
    /**
     * 功能状态
     */
    private String pfStatus;
    /**
     * 功能级别
     */
    private Integer pfLevel;
    /**
     * 功能路径
     */
    private String pfPath;

    public Long getPfId() {
        return pfId;
    }

    public void setPfId(Long pfId) {
        this.pfId = pfId;
    }

    public Long getPfParentId() {
        return pfParentId;
    }

    public void setPfParentId(Long pfParentId) {
        this.pfParentId = pfParentId;
    }

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName;
    }

    public String getPfStatus() {
        return pfStatus;
    }

    public void setPfStatus(String pfStatus) {
        this.pfStatus = pfStatus;
    }

    public Integer getPfLevel() {
        return pfLevel;
    }

    public void setPfLevel(Integer pfLevel) {
        this.pfLevel = pfLevel;
    }

    public String getPfPath() {
        return pfPath;
    }

    public void setPfPath(String pfPath) {
        this.pfPath = pfPath;
    }
}
