package com.yifuyou.httpcompack.proxy;

import com.yifuyou.httpcompack.common.CommonString;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络代理实现类
 *
 */
public class HttpInvocationHandler<T> implements InvocationHandler{

     T instance;

    public HttpInvocationHandler(Class<T> cls){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(CommonString.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        this.instance = retrofit.create(cls);
    }

    //代理类 通过 反射实现具体方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj=method.invoke(instance,args);

        return obj;
    }
}
