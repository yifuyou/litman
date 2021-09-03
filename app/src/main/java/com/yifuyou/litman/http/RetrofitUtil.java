package com.yifuyou.litman.http;


import android.content.ClipData;

import java.util.Locale;

import okhttp3.ResponseBody;
import okio.Utf8;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static Retrofit retrofit;

    public static Call<ResponseBody> get(String url){
        retrofit= new Retrofit.Builder()
                .baseUrl(url)
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.get();
    }

    public static Call<ResponseBody> post(String url,String jsonString){
        retrofit= new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);

        return service.post(jsonString);
    }
    public static Call<ResponseBody> getData(String url, String city, String key){
        retrofit= new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.getData("http://apis.juhe.cn/simpleWeather/query?city=广州&key=a354ab396cd4ac85e65d6bc069560668");
    }

}
