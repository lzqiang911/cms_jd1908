package com.briup.apps.cms.vm;

import com.briup.apps.cms.bean.BasePrivilege;

import java.util.List;

/**
 * @ProjectName: cms_jd1908
 * @Decription: 权限树
 * @Author: lzqiang
 * @Created: 19.11.19 09:48
 */
public class PrivilegeTree extends BasePrivilege{
    private List<BasePrivilege> children;

    public List<BasePrivilege> getChildren() {
        return children;
    }

    public void setChildren(List<BasePrivilege> children) {
        this.children = children;
    }
}
