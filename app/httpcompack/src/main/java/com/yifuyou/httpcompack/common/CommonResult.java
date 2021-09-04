package com.yifuyou.httpcompack.common;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class CommonResult<T>   {
    public static final String CODE="code";
    public static final String MSG="message";
    public static final String DATA="data";

    int code;
    String message;
    T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

public static final String TAG_1="reason";
    public static final String TAG_2="result";

    public void purse(Response<ResponseBody> response) throws JSONException, IOException {
        if(response==null)return;
        this.code=response.code();
        this.message=response.message();
        String json=response.body().string();
        JSONObject object = new JSONObject(json);
        this.data=(T)object.getString(TAG_2);
    }

    @NonNull
    @Override
    public String toString() {
        return "CommonResult{" +
                " "+CODE+"=" + code +
                ", "+MSG+"='" + message + '\'' +
                ", "+DATA+"=" + data +
                '}';
    }
}
