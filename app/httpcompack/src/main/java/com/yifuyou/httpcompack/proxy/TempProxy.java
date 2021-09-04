package com.yifuyou.httpcompack.proxy;

import com.yifuyou.httpcompack.common.CommonResult;
import com.yifuyou.httpcompack.common.CommonString;
import com.yifuyou.httpcompack.server.HttpServer;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TempProxy  {

    Retrofit retrofit;
    HttpServer server;
    public TempProxy(){
        retrofit=new Retrofit.Builder()
                .baseUrl(CommonString.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
        .build();

         server = retrofit.create(HttpServer.class);
    }

    /*public CommonResult<String> request() throws IOException {
        Call<CommonResult<String>> call = server.request();
        Response<CommonResult<String>> response = call.execute();
        return response.body();
    }




    public CommonResult<String> getRequest(String path, String args) throws IOException {

        Call<CommonResult<String>> call = server.getRequest(path, args);
        Response<CommonResult<String>> response = call.execute();
        return response.body();
    }

    public Call<CommonResult> postRequest(String path, Map<String, Object> objectMap) {
        return null;
    }*/
}
