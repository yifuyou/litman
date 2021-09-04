package com.yifuyou.httpcompack.proxy;

import com.yifuyou.httpcompack.common.CommonString;
import com.yifuyou.httpcompack.server.HttpServer;

import java.lang.reflect.Proxy;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpProxy<T> {

    //
    public static <T> T getHttpService(Class<T> cls){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(CommonString.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        T server = retrofit.create(cls);

        HttpInvocationHandler<T> handler = new HttpInvocationHandler<T>();
        handler.setObjectClass(server);
        return (T)Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{HttpServer.class}, handler);
    }

}
