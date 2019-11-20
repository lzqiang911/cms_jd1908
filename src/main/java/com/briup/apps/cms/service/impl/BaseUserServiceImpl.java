package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.BaseUser;
import com.briup.apps.cms.bean.BaseUserExample;
import com.briup.apps.cms.bean.UserRole;
import com.briup.apps.cms.bean.UserRoleExample;
import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.dao.BaseUserMapper;
import com.briup.apps.cms.dao.UserRoleMapper;
import com.briup.apps.cms.dao.extend.BaseUserExtendMapper;
import com.briup.apps.cms.service.IBaseUserService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.UserVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 用户业务实现类
 * @Author: lzqiang
 * @Created: 19.11.18 20:01
 */
@Service
public class BaseUserServiceImpl implements IBaseUserService {

    @Resource
    private BaseUserExtendMapper baseUserExtendMapper;
    @Resource
    private BaseUserMapper baseUserMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public BaseUser login(UserVM userVM) throws CustomerException {
        BaseUserExample example = new BaseUserExample();
        example.createCriteria().andUsernameEqualTo(userVM.getUsername());
        List<BaseUser> list = baseUserMapper.selectByExample(example);
        if (list.size()>0){
            throw new CustomerException("该用户不存在");
        }
        BaseUser user = list.get(0);
        if (!user.getPassword().equals(userVM.getPassword())){
            throw new CustomerException("密码不匹配");
        }
        return user;
    }

    @Override
    public List<BaseUser> findAll() {
        return baseUserMapper.selectByExample(new BaseUserExample());
    }

    @Override
    public BaseUserExtend findById(long id) {
        return baseUserExtendMapper.selectById(id);
    }

    @Override
    public List<BaseUserExtend> cascadeRoleFindAll() {
        return baseUserExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(BaseUser baseUser) throws CustomerException {
        if (baseUser.getId() != null){
            baseUserMapper.updateByPrimaryKey(baseUser);
        }else{
            BaseUserExample example = new BaseUserExample();
            example.createCriteria().andUsernameEqualTo(baseUser.getUsername());
            List<BaseUser> list = baseUserMapper.selectByExample(example);
            if (list.size()>0){
                throw new CustomerException("该用户名已被占用");
            }
            baseUser.setRegisterTime(new Date().getTime());
            baseUser.setStatus(BaseUserExtend.STATUS_NORMAL);
            baseUserMapper.insert(baseUser);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        BaseUser user = this.findById(id);
        if (user == null){
            throw new CustomerException("该用户不存在");
        }
        baseUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void changeStatus(long id, String status) throws CustomerException {
        BaseUser user = this.findById(id);
        if (user == null){
            throw new CustomerException("该用户不存在");
        }
        user.setStatus(status);
        baseUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public void setRoles(long id, List<Long> roles) {
        //根据userId查询自己的角色
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(id);
        //用户角色关系，获取所有老的角色
        List<UserRole> list = userRoleMapper.selectByExample(example);
        List<Long> oldRoles = new ArrayList<>();
        Iterator<UserRole> iterator = list.iterator();
        while (iterator.hasNext()){
            oldRoles.add(iterator.next().getRoleId());
        }
        // 依次判断老角色是否存在于roles中，如果不存在则删除
        for (UserRole userRole : list){
            if (!roles.contains(userRole.getRoleId())){
//                UserRoleExample example1 = new UserRoleExample();
                userRoleMapper.deleteByPrimaryKey(userRole.getId());
            }
        }

        // 依次判断新角色是否存在于list中，如果不存在则添加
        for (Long roleId : roles) {
            if (!oldRoles.contains(roleId)){
                UserRole userRole = new UserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(id);
                userRoleMapper.insert(userRole);
            }
        }
    }
}
