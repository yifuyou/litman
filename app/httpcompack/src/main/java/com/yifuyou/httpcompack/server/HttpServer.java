package com.yifuyou.httpcompack.server;

import android.os.Bundle;

import com.yifuyou.httpcompack.common.CommonResult;
import com.yifuyou.httpcompack.common.CommonString;
import com.yifuyou.httpcompack.common.Weather;
import com.yifuyou.httpcompack.proxy.HttpProxy;

import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HttpServer {

    static HttpServer getInstance(){
        return HttpProxy.getHttpService(HttpServer.class);
    }

    @GET("/{path}")
    Call<ResponseBody> getRequest(@Path("path")String path, String args);

    @POST("/{path}")
    Call<ResponseBody> postRequest(@Path("path")String path, @FieldMap Map<String,Object> objectMap);

    @HTTP(path = CommonString.TEST_URL,method = "GET")
    Call<ResponseBody> request();


    @HTTP(path = CommonString.TEST_URL,method = "GET")
    Observable<Weather> requestObservable();
}
