package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.BaseRole;
import com.briup.apps.cms.bean.extend.BaseRoleExtend;
import com.briup.apps.cms.utils.CustomerException;

import java.util.List;

public interface IBaseRoleService {

    //用户授权
    void authorization(long roleId, List<Long> privilegeIds);

    //查询所有角色
    List<BaseRole> findAll();

    //查询角色级联权限
    List<BaseRoleExtend> cascadePrivilegeFindAll();

    //保存或更新
    void saveOrUpdate(BaseRole baseRole) throws CustomerException;

    //通过id删除角色信息
    void deleteById(long id) throws CustomerException;

}
