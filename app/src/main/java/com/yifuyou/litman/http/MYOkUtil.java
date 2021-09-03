package com.yifuyou.litman.http;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.internal.GsonBuildConfig;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MYOkUtil {



    public void getPage(){
        new Thread(new Runnable() {
            @Override
                public void run() {
                    OkHttpClient okHttpClient=new OkHttpClient();
                    Request request= new Request.Builder()
                            .url("https://www.baidu.com")
                            .get()
                            .build();

                    Call call = okHttpClient.newCall(request);


                    try(Response response = call.execute()){
                        Log.e("OkHttpClient", "onResponse: "  +response.headers()+
                                "\n" +response.body().string()+
                                "", null );
                        JSONObject jsonObject = new JSONObject("{'a':'b'}");
                        Log.d("JSONObject", "run: "+jsonObject.toString());

                    }catch (Exception e){

                        Log.d("OkHttpClient", "run: =====================");
                    }
                }
        }).start();




    }



}
