package com.company.project.adminweb.service.function;

/**
 * 授权VO
 *
 * @author wangzhj
 */
public class PermissionVO {

    /**
     * 功能编号
     */
    private Long pfId;
    /**
     * 功能父编号
     */
    private Long pfParentId;
    /**
     * 功能名称
     */
    private String pfName;

    /**
     * 功能路径
     */
    private String pfPath;
    /**
     * 是否已授权
     */
    private String isPermit;

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

    public String getIsPermit() {
        return isPermit;
    }

    public void setIsPermit(String isPermit) {
        this.isPermit = isPermit;
    }

    public String getPfPath() {
        return pfPath;
    }

    public void setPfPath(String pfPath) {
        this.pfPath = pfPath;
    }
}
