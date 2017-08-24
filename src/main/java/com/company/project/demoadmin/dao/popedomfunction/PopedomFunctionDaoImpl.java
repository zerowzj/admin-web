package com.company.project.demoadmin.dao.popedomfunction;

import com.company.project.demoadmin.common.db.BaseDaoImpl;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PopedomFunctionDaoImpl extends BaseDaoImpl<PopedomFunctionEO> implements PopedomFunctionDao {

    @Override
    public List<PopedomFunctionEO> getRoleFunctionLt(Long prId, String pfIsMenu) {
        Map<String, Object> param = Maps.newHashMap();
        param.put("prId", prId);
        param.put("pfIsMenu", pfIsMenu);
        return getSqlSession().selectList(getSqlId("getRoleFunctionLt"), param);
    }
}
