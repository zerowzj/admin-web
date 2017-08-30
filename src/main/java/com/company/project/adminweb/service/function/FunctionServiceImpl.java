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
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getFunctionLt(pfStatus, pfLevelLt);
        return pfEOLt;
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
    public List<PopedomFunctionEO> getRoleFunctionLt(Long prId) {
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getRoleFunctionLt(prId, null);
        return pfEOLt;
    }

    @Override
    public List<ConfFuncVO> getRoleConfFuncLt(Long prId) {
        List<PopedomFunctionEO> rolePfEOLt = popedomFunctionDao.getRoleFunctionLt(prId, null);
        List<Long> rolePfIdLt = Lists.newArrayList();
        for(PopedomFunctionEO pfEO : rolePfEOLt){
            rolePfIdLt.add(pfEO.getPfId());
        }

        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getFunctionLt(null, null);
        List<ConfFuncVO> confFuncVOLt = Lists.newArrayList();
        ConfFuncVO confFuncVO;
        for (PopedomFunctionEO pfEO : pfEOLt) {
            Long pfId = pfEO.getPfId();

            confFuncVO = new ConfFuncVO();
            confFuncVO.setPfId(pfId);
            confFuncVO.setPfParentId(pfEO.getPfParentId());
            confFuncVO.setPfName(pfEO.getPfName());
            confFuncVO.setPfPath(pfEO.getPfPath());

            if(rolePfIdLt.contains(pfId)){
                confFuncVO.setIsPermit("Y");
            } else {
                confFuncVO.setIsPermit("N");
            }

            confFuncVOLt.add(confFuncVO);
        }
        return confFuncVOLt;
    }
}
