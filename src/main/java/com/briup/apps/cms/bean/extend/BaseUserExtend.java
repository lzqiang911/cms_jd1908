package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.BaseRole;
import com.briup.apps.cms.bean.BaseUser;

import java.util.List;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 用户拓展类
 * @Author: lzqiang
 * @Created: 19.11.18 18:55
 */
public class BaseUserExtend extends BaseUser {

    public final static String STATUS_NORMAL = "正常";
    public final static String STATUS_FORBIDDEN = "禁用";
    private List<BaseRole> roles;

    public List<BaseRole> getRoles() {
        return roles;
    }

    public void setRoles(List<BaseRole> roles) {
        this.roles = roles;
    }
}
