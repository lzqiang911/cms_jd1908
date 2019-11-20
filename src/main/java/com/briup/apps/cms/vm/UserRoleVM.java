package com.briup.apps.cms.vm;

import java.util.List;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 用户角色
 * @Author: lzqiang
 * @Created: 19.11.19 14:32
 */

public class UserRoleVM {
    private Long id;
    private List<Long> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }
}
