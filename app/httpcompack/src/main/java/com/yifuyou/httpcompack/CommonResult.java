package com.yifuyou.httpcompack;

import androidx.annotation.NonNull;

public class CommonResult {
    public final static String CODE="code";
    public final static String DATA="data";

    private int code;
    private String data;


    @NonNull
    @Override
    public String toString() {
        return "CommonResult{" +
                CODE+"=" + code +
                ", "+DATA+"=" + data +
                '}';
    }
}
