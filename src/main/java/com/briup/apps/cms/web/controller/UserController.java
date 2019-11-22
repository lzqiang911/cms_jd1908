package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.BaseUser;
import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.service.IBaseUserService;
import com.briup.apps.cms.utils.JwtTokenUtil;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.UserVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 用户控制器
 * @Author: lzqiang
 * @Created: 19.11.18 19:36
 */
@Api("用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IBaseUserService baseUserService;

    @ApiOperation(value = "登录")
    @PostMapping(value = "login")
    public Message login(@RequestBody UserVM userVM){
        //1.验证用户身份
        BaseUser user = baseUserService.login(userVM);
        //2.如果登录成功，产生一个token，缓存起来,返回
        String token = JwtTokenUtil.createJWT(user.getId(),user.getUsername());
        //3.如果登录失败
        Map<String,String > map = new HashMap<>();
        map.put("token",token);
        return MessageUtil.success(map);
    }

    @ApiOperation(value = "退出")
    @PostMapping(value = "logout")
    public Message login(){
        //1.将缓存中的token移除
        //2.其他
        return MessageUtil.success("退出成功");
    }

    @ApiOperation(value = "通过token获取用户的基本信息")
    @GetMapping(value = "info")
    public Message info(String token){
        // 1. 通过token获取用户信息  {id,use,gender,roles:[]}
        Long id = Long.parseLong(JwtTokenUtil.getUserId(token,JwtTokenUtil.base64Secret));
        BaseUserExtend baseUserExtend = baseUserService.findById(id);

        return MessageUtil.success(baseUserExtend);

    }

}
