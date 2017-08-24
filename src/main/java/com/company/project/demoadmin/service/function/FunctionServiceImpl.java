package com.company.project.demoadmin.service.function;

import com.company.project.demoadmin.dao.popedomfunction.PopedomFunctionDao;
import com.company.project.demoadmin.dao.popedomfunction.PopedomFunctionEO;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private PopedomFunctionDao popedomFunctionDao;

    @Override
    public Collection<MenuVO> getMenuLt(Long prId) {
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getMenuLt(prId);
        Map<Long, MenuVO> M = Maps.newHashMap();
        for (PopedomFunctionEO pfEO : pfEOLt) {
            MenuVO menuVO = new MenuVO();
            menuVO.setPfName(pfEO.getPfName());
            menuVO.setPfPath(pfEO.getPfPath());

            Long pfId = pfEO.getPfId();
            Long pfParentId = pfEO.getPfParentId();
            if (pfParentId == null) {
                M.put(pfId, menuVO);
            } else {
                M.get(pfParentId).getChildren().add(menuVO);
            }
        }

        return M.values();
    }
}
