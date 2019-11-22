package com.briup.apps.cms.utils;

/**
 * @Program: cms_jd1908
 * @Description: 权限异常类
 * @Author: lzqiang
 * @DateTime: 2019年11月13日
 */
public class PermissionException extends CustomerException {
    public PermissionException() {
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }

    public PermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
