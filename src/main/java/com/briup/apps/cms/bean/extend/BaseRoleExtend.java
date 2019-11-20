package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.bean.BaseRole;

import java.util.List;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 角色拓展类
 * @Author: lzqiang
 * @Created: 19.11.19 09:58
 */
public class BaseRoleExtend extends BaseRole {
    private List<BasePrivilege> privileges;

    public List<BasePrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<BasePrivilege> privileges) {
        this.privileges = privileges;
    }
}
