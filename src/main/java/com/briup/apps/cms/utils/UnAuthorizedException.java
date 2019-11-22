package com.briup.apps.cms.utils;

/**
 * @Program: cms_jd1908
 * @Description: 未授权异常类
 * @Author: lzqiang
 * @DateTime: 2019年11月13日
 */

public class UnAuthorizedException extends CustomerException {
    public UnAuthorizedException() {
    }

    public UnAuthorizedException(String message) {
        super(message);
    }

    public UnAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnAuthorizedException(Throwable cause) {
        super(cause);
    }

    public UnAuthorizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
