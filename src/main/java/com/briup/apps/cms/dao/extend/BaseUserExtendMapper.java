package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.extend.BaseUserExtend;

import java.util.List;

public interface BaseUserExtendMapper {

    //查询所有
    List<BaseUserExtend> selectAll();

    //根据id查询用户
    BaseUserExtend selectById(long id);

}
