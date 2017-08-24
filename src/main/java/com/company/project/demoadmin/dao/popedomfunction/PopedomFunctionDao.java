package com.company.project.demoadmin.dao.popedomfunction;


import com.company.project.demoadmin.common.db.BaseDao;

import java.util.List;

/**
 * 功能Dao
 *
 * @author wangzhj
 */
public interface PopedomFunctionDao extends BaseDao<PopedomFunctionEO> {

    List<PopedomFunctionEO> getMenuLt(Long prId);
}
