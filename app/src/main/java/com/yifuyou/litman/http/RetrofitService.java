package com.yifuyou.litman.http;



import android.content.ClipData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface RetrofitService {

    @GET("/rsh8u4rs")
    Call<ResponseBody> get();

    @POST("/rsh8u4rs")
    @Headers("content-type: application/json")
    @FormUrlEncoded
    Call<ResponseBody> post(@Field("json") String jsonObject);

    //http://apis.juhe.cn/simpleWeather/query?city=广州&key=a354ab396cd4ac85e65d6bc069560668


    @GET()
//    Call<ResponseBody> getData(@Query(value = "city",encoded = true) String city, @Query("key") String key);
    Call<ResponseBody> getData(@Url String url);

}
