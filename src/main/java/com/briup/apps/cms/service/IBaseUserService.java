package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.BaseUser;
import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.UserVM;

import java.util.List;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 用户接口
 * @Author: lzqiang
 * @Created: 19.11.19 14:34
 */

public interface IBaseUserService {

    //用户登录
    BaseUser login(UserVM userVM) throws CustomerException;

    //查询所有
    List<BaseUser> findAll();

    //通过id查询
    BaseUserExtend findById(long id);

    //级联查询所有
    List<BaseUserExtend> cascadeRoleFindAll();

    //保存或更新
    void saveOrUpdate(BaseUser baseUser) throws CustomerException;

    //通过id删除
    void deleteById(long id) throws CustomerException;

    //设置角色
    void setRoles(long id,List<Long> roles);

    //更新状态
    void changeStatus(long id,String status) throws CustomerException;

}
