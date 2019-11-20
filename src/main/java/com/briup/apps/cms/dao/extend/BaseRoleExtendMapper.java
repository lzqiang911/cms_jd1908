package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.BaseRole;
import com.briup.apps.cms.bean.extend.BaseRoleExtend;

import java.util.List;

public interface BaseRoleExtendMapper {
    //根据用户id查询角色
    List<BaseRole> selectByUserId(long id);
    //查询所有
    List<BaseRoleExtend> selectAll();
}
