package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.bean.BasePrivilegeExample;
import com.briup.apps.cms.dao.BasePrivilegeMapper;
import com.briup.apps.cms.dao.extend.BasePrivilegeExtendMapper;
import com.briup.apps.cms.service.IBasePrivilegeService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 权限控制实现类
 * @Author: lzqiang
 * @Created: 19.11.19 11:17
 */
@Service
public class BasePrivilegeServiceImpl implements IBasePrivilegeService {

    @Resource
    private BasePrivilegeMapper basePrivilegeMapper;
    @Resource
    private BasePrivilegeExtendMapper basePrivilegeExtendMapper;

    @Override
    public List<BasePrivilege> findAll() {
        return basePrivilegeMapper.selectByExample(new BasePrivilegeExample());
    }

    @Override
    public List<BasePrivilege> findByParentId(Long parentId) {
        BasePrivilegeExample example = new BasePrivilegeExample();
        //判断当前权限有没有父权限
        if(parentId == null){
            //若为空，将父权限id置空
            example.createCriteria().andParentIdIsNull();
        }else {
            //若不为空，判断是否相等
            example.createCriteria().andParentIdEqualTo(parentId);
        }
        return basePrivilegeMapper.selectByExample(example);
    }

    @Override
    public List<PrivilegeTree> findPrivilegeTree() {
        return basePrivilegeExtendMapper.selectAll();
    }

    @Override
    public List<BasePrivilege> findByUserId(long id) {
        return basePrivilegeExtendMapper.selectByUserId(id);
    }

    @Override
    public void saveOrUpdate(BasePrivilege basePrivilege) throws CustomerException {
        if (basePrivilege.getId() != null){
            basePrivilegeMapper.updateByPrimaryKey(basePrivilege);
        }else {
            basePrivilegeMapper.insert(basePrivilege);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        BasePrivilege privilege = basePrivilegeMapper.selectByPrimaryKey(id);
        if (privilege == null){
            throw new CustomerException("没有该权限");
        }
        basePrivilegeMapper.deleteByPrimaryKey(id);
    }
}
