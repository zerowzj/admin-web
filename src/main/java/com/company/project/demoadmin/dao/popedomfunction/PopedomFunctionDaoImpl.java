package com.company.project.demoadmin.dao.popedomfunction;

import com.company.project.demoadmin.common.db.BaseDaoImpl;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PopedomFunctionDaoImpl extends BaseDaoImpl<PopedomFunctionEO> implements PopedomFunctionDao {

    @Override
    public List<PopedomFunctionEO> getMenuLt(Long prId) {
        Map<String, Object> param = Maps.newHashMap();
        param.put("prId", prId);
        return getSqlSession().selectList(getSqlId("getMenuLt"), param);
    }
}
