package com.yifuyou.litman;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.yifuyou.httpcompack.common.CommonRequest;
import com.yifuyou.httpcompack.common.CommonResult;
import com.yifuyou.httpcompack.common.Weather;
import com.yifuyou.litman.databinding.HttpCallLayoutBinding;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class HttpCallActivity extends AppCompatActivity {
    private HttpCallLayoutBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_call_layout);
        binding = DataBindingUtil.setContentView(this, R.layout.http_call_layout);

    }

    //                http://apis.juhe.cn/simpleWeather/query?city=广州&key=a354ab396cd4ac85e65d6bc069560668
    public void onClick(View view){
        Map<String, String> map=new HashMap<>();
        if(view.getId()==binding.button6.getId()){
            CommonRequest commonRequest=CommonRequest.getInstance();
            commonRequest.addObserver(new Observer<Weather>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    System.out.println("======onSubscribe===");
                }

                @Override
                public void onNext(@NonNull Weather commonResult) {
                    System.out.println("=====onNext========");
                    binding.textViewK.post(()->{
                        binding.textViewK.setText(commonResult.toString());
                    });


                }

                @Override
                public void onError(@NonNull Throwable e) {
                    System.out.println("=====onError========");
                    e.printStackTrace();

                }

                @Override
                public void onComplete() {
                    System.out.println("=====onComplete========");

                }
            });
            commonRequest.doRequest("","get","");

        }else if(view.getId()==binding.button7.getId()){

        }
        if(map.isEmpty())return;
        System.out.println("==========");
        map.forEach((k,v)-> System.out.println(k+"  "+v));
    }
}
