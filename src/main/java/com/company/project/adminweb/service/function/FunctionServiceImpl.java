package com.company.project.adminweb.service.function;

import com.company.project.adminweb.dao.popedomfunction.PopedomFunctionDao;
import com.company.project.adminweb.dao.popedomfunction.PopedomFunctionEO;
import com.google.common.collect.Lists;
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
    public List<PopedomFunctionEO> getFunctionLt() {
        return popedomFunctionDao.getFunctionLt(null, null);
    }

    @Override
    public Collection<MenuVO> getRoleMenuLt(Long prId) {
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getRoleFunctionLt(prId, "Y");
        Map<Long, MenuVO> data = Maps.newHashMap();
        for (PopedomFunctionEO pfEO : pfEOLt) {
            MenuVO menuVO = new MenuVO();
            menuVO.setPfName(pfEO.getPfName());
            menuVO.setPfPath(pfEO.getPfPath());

            Long pfId = pfEO.getPfId();
            Long pfParentId = pfEO.getPfParentId();
            if (pfParentId == null) {
                data.put(pfId, menuVO);
            } else {
                data.get(pfParentId).getChildren().add(menuVO);
            }
        }
        return data.values();
    }

    @Override
    public List<PermissionVO> getRolePermissionLt(Long prId) {
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getFunctionLt(null, null);
        List<PopedomFunctionEO> rolePfEOLt = popedomFunctionDao.getRoleFunctionLt(prId, null);

        List<PermissionVO> permissionVOLt = Lists.newArrayList();
        PermissionVO permissionVO;
        for(PopedomFunctionEO pfEO : pfEOLt){
            permissionVO = new PermissionVO();


            Long pfId = pfEO.getPfId();
            Long pfParentId = pfEO.getPfParentId();

            permissionVOLt.add(permissionVO);
        }
        return permissionVOLt;
    }
}
