package com.kong.qingwei.common;

import com.alibaba.fastjson.JSON;
import com.kong.qingwei.controller.SysUserController;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by kongwc on 2017/7/30.
 */
public class SessionInterceptor implements MethodInterceptor {
    public static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        logger.error("method is =" + method.getName());
        logger.error("argument is =" +  JSON.toJSONString(invocation.getArguments()));
       return invocation.proceed();
    }
}
