package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.vm.PrivilegeTree;

import java.util.List;

public interface BasePrivilegeExtendMapper {

    //查询所有权限(父栏目id为空)
    List<PrivilegeTree> selectAll();

    //根据父栏目id查询权限(base_privilege表)
    List<BasePrivilege> selectByParentId(long id);

    //据角色id查询权限(base_privilege,base_role,base_role_privilege(桥表)联合查询)
    List<BasePrivilege> selectByRoleId(long id);

    //据用户id查询权限(base_user u,base_user_role ur(桥表),base_role r,
    //        base_role_privilege rp(桥表),base_privilege p联合查询)
    List<BasePrivilege> selectByUserId(long id);
}
