package com.yifuyou.litman;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.yifuyou.litman.databinding.HttpCallLayoutBinding;

import java.util.HashMap;
import java.util.Map;

public class HttpCallActivity extends AppCompatActivity {
    private HttpCallLayoutBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.http_call_layout);

    }

    //                http://apis.juhe.cn/simpleWeather/query?city=广州&key=a354ab396cd4ac85e65d6bc069560668
    public void onClick(View view){
        Map<String, String> map=new HashMap<>();
        if(view.getId()==binding.button6.getId()){

        }else if(view.getId()==binding.button7.getId()){

        }
        if(map==null||map.isEmpty())return;
        System.out.println("==========");
        map.forEach((k,v)-> System.out.println(k+"  "+v));
    }
}
