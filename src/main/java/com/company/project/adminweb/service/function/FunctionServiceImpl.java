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
    public List<PopedomFunctionEO> getFunctionLt(String pfStatus, List<Integer> pfLevelLt) {
        return popedomFunctionDao.getFunctionLt(pfStatus, pfLevelLt);
    }

    @Override
    public Collection<MenuVO> getRoleMenuLt(Long prId) {
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getRoleFunctionLt(prId, "Y");
        Map<Long, MenuVO> menuVOMap = Maps.newHashMap();
        for (PopedomFunctionEO pfEO : pfEOLt) {
            MenuVO menuVO = new MenuVO();
            menuVO.setPfName(pfEO.getPfName());
            menuVO.setPfPath(pfEO.getPfPath());

            Long pfId = pfEO.getPfId();
            Long pfParentId = pfEO.getPfParentId();
            if (pfParentId == null) {
                menuVOMap.put(pfId, menuVO);
            } else {
                menuVOMap.get(pfParentId).getChildren().add(menuVO);
            }
        }
        return menuVOMap.values();
    }

    @Override
    public List<PermissionVO> getRolePermissionLt(Long prId) {

        List<PopedomFunctionEO> rolePfEOLt = popedomFunctionDao.getRoleFunctionLt(prId, null);
        List<Long> rolePfIdLt = Lists.newArrayList();
        for(PopedomFunctionEO pfEO : rolePfEOLt){
            rolePfIdLt.add(pfEO.getPfId());
        }

        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getFunctionLt(null, null);
        List<PermissionVO> permissionVOLt = Lists.newArrayList();
        PermissionVO permissionVO;
        for (PopedomFunctionEO pfEO : pfEOLt) {
            Long pfId = pfEO.getPfId();

            permissionVO = new PermissionVO();
            permissionVO.setPfId(pfId);
            permissionVO.setPfParentId(pfEO.getPfParentId());
            permissionVO.setPfName(pfEO.getPfName());
            permissionVO.setPfPath(pfEO.getPfPath());

            if(rolePfIdLt.contains(pfId)){
                permissionVO.setIsPermit("Y");
            } else {
                permissionVO.setIsPermit("N");
            }

            permissionVOLt.add(permissionVO);
        }
        return permissionVOLt;
    }
}
