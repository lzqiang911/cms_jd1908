package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.service.IBasePrivilegeService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.PrivilegeTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 权限控制器
 * @Author: lzqiang
 * @Created: 19.11.19 13:54
 */
@Api("权限相关接口")
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    private IBasePrivilegeService basePrivilegeService;

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<BasePrivilege> list = basePrivilegeService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过parentId查询")
    @GetMapping(value = "findByParentId")
    public Message findByParentId(Long id){
        List<BasePrivilege> list = basePrivilegeService.findByParentId(id);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过userId查询所有权限")
    @GetMapping(value = "findByUserId")
    public Message findByUserId(Long id){
        List<BasePrivilege> list = basePrivilegeService.findByUserId(id);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "查询树")
    @GetMapping(value = "findPrivilegeTree")
    public Message findPrivilegeTree(){
        List<PrivilegeTree> list = basePrivilegeService.findPrivilegeTree();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(BasePrivilege basePrivilege){
        basePrivilegeService.saveOrUpdate(basePrivilege);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id){
        basePrivilegeService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

}
