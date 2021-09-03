package com.yifuyou.httpcompack;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;

public class CommonResult<T> extends BaseObservable{
    public final static String CODE="code";
    public final static String DATA="data";

    private int code;
    private String data;

    public static boolean isSuccess(int code){
        return code==200;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @NonNull
    @Override
    public String toString() {
        return "CommonResult{" +
                CODE+"=" + code +
                ", "+DATA+"=" + data +
                '}';
    }
}
