package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.BaseUser;
import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.service.IBaseUserService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.UserRoleVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 用户基础控制器类
 * @Author: lzqiang
 * @Created: 19.11.19 14:34
 */
@RestController
@RequestMapping("/baseUser")
public class BaseUserController {

    @Autowired
    private IBaseUserService baseUserService;

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<BaseUser> list = baseUserService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "查询所有",notes = "级联查询用户角色")
    @GetMapping(value = "cascadeRoleFindAll")
    public Message cascadeRoleFindAll(){
        List<BaseUserExtend> list = baseUserService.cascadeRoleFindAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(BaseUser baseUser){
        baseUserService.saveOrUpdate(baseUser);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id){
        baseUserService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "设置权限")
    @PostMapping(value = "setRoles")
    public Message setRoles(UserRoleVM userRoleVM){
        baseUserService.setRoles(userRoleVM.getId(),userRoleVM.getRoles());
        return MessageUtil.success("设置成功");
    }

}
