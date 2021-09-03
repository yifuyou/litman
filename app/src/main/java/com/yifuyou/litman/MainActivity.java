package com.yifuyou.litman;

import android.Manifest;
import android.content.ClipData;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.JsonWriter;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yifuyou.litman.http.FlowObserver;
import com.yifuyou.litman.http.MYOkUtil;
import com.yifuyou.litman.http.RetrofitUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kotlin.Pair;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int currColor = 0;
    MYOkUtil myOkUtil;

    OkHttpClient httpClient = new OkHttpClient();

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Log.d("Handler", "handleMessage: " + msg.obj.toString());
            switch (msg.what) {
                case 0x999:
                    postData(msg.obj);
                    break;
                case 0x888:
                    Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
            }


        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        textView = findViewById(R.id.text_for_change);
        myOkUtil = new MYOkUtil();


    }

    private void getData() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Request request = new Request.Builder().url("http://apis.juhe.cn/simpleWeather/query?city=广州&key=a354ab396cd4ac85e65d6bc069560668")
                        .get()
                        .addHeader("accept", "application/json")
                        .build();

                Call call = httpClient.newCall(request);
                try (Response execute = call.execute()) {
                    JSONObject jsonArray = new JSONObject(execute.body().source().readUtf8());
                    JSONObject result = jsonArray.getJSONObject("result");
                    Log.e("TAG", "run: " + String.valueOf(result), null);
                    String city, weather, date;
                    city = result.getString("city");
                    JSONArray future = result.getJSONArray("future");

                    weather = future.getJSONObject(0).getString("weather");
                    date = future.getJSONObject(0).getString("date");
                    Map<String, String> map = new HashMap<>();
                    map.put("city", city);
                    map.put("weather", weather);
                    map.put("date", date);

                    Message message = new Message();
                    message.what = 0x999;
                    message.obj = map;
                    handler.sendMessage(message);


                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("TAG", "get fail! ", null);
                }
                ;
            }
        }).start();


    }

    private void postData(Object jsonData) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (jsonData instanceof HashMap) {

                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("city", ((HashMap<?, ?>) jsonData).get("city"));
                        jsonObject.put("weather", ((HashMap<?, ?>) jsonData).get("weather"));
                        jsonObject.put("date", ((HashMap<?, ?>) jsonData).get("date"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.d("TAG", "run: " + String.valueOf(jsonObject));

                    MediaType jsonType = MediaType.parse("application/jsonp; charset=UTF-8");//链接 为外域时需要跨域，此处用jsonp
                    RequestBody body = RequestBody.create(jsonType, String.valueOf(jsonObject));
                    Request request = new Request.Builder()
                            .url("https://requestbin.net/r/gjw49to5")
                            .post(body)
                            .build();
                   /* try (Response response = httpClient.newCall(request).execute()) {
                        System.out.println(response.body().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/

                    httpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(@NonNull Call call, @NonNull IOException e) {

                            Log.e("TAG", "get fail! ", e);
                        }

                        @Override
                        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                            Request request1 = response.request();
                            Log.d("onResponse", "call: "
                                    + request1.headers().toString() + "\n"
                                    + String.valueOf(request1.body())

                            );


                            ResponseBody body = response.body();

                            Message message = new Message();
                            message.what = 0x888;
                            message.obj = body.string();
                            handler.sendMessage(message);
                        }
                    });
                }
            }
        }).start();

    }

    private void getDataByRetrofit(){

        new Thread(new Runnable() {
            @Override
            public void run() {
//                http://apis.juhe.cn/simpleWeather/query?city=广州&key=a354ab396cd4ac85e65d6bc069560668
                retrofit2.Call<ResponseBody> call = RetrofitUtil.getData("http://apis.juhe.cn/simpleWeather/", "广州", "a354ab396cd4ac85e65d6bc069560668");
                retrofit2.Response<ResponseBody> response = null;
                try {
                    response = call.execute();
                    System.out.println("============");
                    System.out.println(response.message());
                    System.out.println("============");
                    if(!response.isSuccessful()){
                        System.out.println(response.errorBody().string());
                        System.out.println(call.request());
                    }else{
                        System.out.println(response.body().source());
                    }
                    System.out.println("============");


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();




    }


    @Override
    protected void onResume() {
        super.onResume();
        int color = ColorSPUtil.getColor(this);
        if (color != 0) {
            currColor = color;
            String ds = "";
            switch (currColor) {
                case Color.BLUE:
                    ds = "蓝色";
                    break;
                case Color.YELLOW:
                    ds = "黄色";
                    break;
                case Color.GREEN:
                    ds = "绿色";
                    break;
            }

            Toast.makeText(this, "上次最后颜色： " + ds, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public int checkSelfPermission(String permission) {
        Log.d(MainActivity.this.getCallingPackage(), "checkSelfPermission: " + permission);
        return super.checkSelfPermission(permission);
    }

    @Override
    protected void onStop() {
        ColorSPUtil.setColor(this, currColor);
        super.onStop();

    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.b1:
                currColor = Color.GREEN;
//                getData();
//                getDataByRetrofit();

//                RxJavaUtil.create();
//                RxJavaUtil.addObserver();

                FlowObserver<String> observer = new FlowObserver<String>();
                observer.init("ssss");
                observer.dispose();
                break;

            case R.id.b2:
                currColor = Color.YELLOW;
                new Thread(new Runnable() {
                    /*
                    @Override//post
                    public void run() {
                        String url="http://requestbin.cn/";
                        retrofit2.Call<ResponseBody> call = RetrofitUtil.post(url,"{'data':'00'}");
                        try {
                            retrofit2.Response<ResponseBody> response = call.execute();
                            String s="";
                            if(response.body()!=null){
                                s = response.body().string();
                                System.out.println("===========\n"+s+"\n==========");
                            }else if(!response.isSuccessful()){
                                s = call.request().toString();
                                System.out.println("error===========\n"+s+"==========\n");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }*/

                    @Override//post
                    public void run() {
                        String url="http://requestbin.cn/";
                        retrofit2.Call<ResponseBody> call = RetrofitUtil.get(url);
                        try {
                            retrofit2.Response<ResponseBody> response = call.execute();
                            String s="";
                            if(response.body()!=null){
                                s = response.body().string();
                                System.out.println("===========\n"+s+"\n==========");
                            }else if(!response.isSuccessful()){
                                s = call.request().toString();
                                System.out.println("error===========\n"+s+"==========\n");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();


                break;

            case R.id.b3:
                currColor = Color.BLUE;
                myOkUtil.getPage();

                break;
        }
        textView.setTextColor(currColor);

    }

    @Override
    public int checkPermission(String permission, int pid, int uid) {
        return super.checkPermission(permission, pid, uid);
    }
}
