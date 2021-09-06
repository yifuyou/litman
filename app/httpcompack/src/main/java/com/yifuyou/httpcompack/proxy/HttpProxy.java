package com.yifuyou.httpcompack.proxy;

import com.yifuyou.httpcompack.server.HttpServer;
import java.lang.reflect.Proxy;

public class HttpProxy<T> {

    //
    public static <T> T getHttpService(Class<T> cls){
        return (T)Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{HttpServer.class}, new HttpInvocationHandler<>(cls));
    }

}
