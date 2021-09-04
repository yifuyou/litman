package com.yifuyou.httpcompack.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 网络代理实现类
 *
 */
public class HttpInvocationHandler<T> implements InvocationHandler{

    private  T instance;
    public void setObjectClass(T service){
        if(service!=null){
            instance = service;
        }

    }

    //代理类 通过 反射实现具体方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj=method.invoke(instance,args);

        return obj;
    }
}
