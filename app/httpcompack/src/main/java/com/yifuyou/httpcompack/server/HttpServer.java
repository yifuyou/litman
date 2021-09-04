package com.yifuyou.httpcompack.server;

import android.os.Bundle;

import com.yifuyou.httpcompack.common.CommonResult;
import com.yifuyou.httpcompack.common.CommonString;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HttpServer {



    @GET("/{path}")
    Call<CommonResult<String>> getRequest(@Path("path")String path,String args);

    @POST("/{path}")
    Call<CommonResult<String>> postRequest(@Path("path")String path, @FieldMap Map<String,Object> objectMap);

    @HTTP(path = CommonString.TEST_URL,method = "GET")
    Call<CommonResult<String>> request();
}
