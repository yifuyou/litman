package com.yifuyou.httpcompack.common;

import androidx.annotation.NonNull;

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
