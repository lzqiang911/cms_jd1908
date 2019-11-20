package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;

import java.util.List;

public interface IBasePrivilegeService {

    //查询所有权限
    List<BasePrivilege> findAll();

    //通过parentId查询权限
    List<BasePrivilege> findByParentId(Long parentId);

    //查询权限树
    List<PrivilegeTree> findPrivilegeTree();

    //查询用户所有权限
    List<BasePrivilege> findByUserId(long id) ;

    //保存或更新
    void  saveOrUpdate(BasePrivilege basePrivilege) throws CustomerException;

    //删除权限
    void deleteById(long id) throws CustomerException;

}
