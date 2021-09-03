package com.yifuyou.litman.http;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import okhttp3.ResponseBody;

//定义响应行为

public  class RequestObserver implements Observer<String> {


    static int index=0;

    private void init(){
        System.out.println("=======");
        System.out.println("init");

    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        init();
        d.dispose();
    }

    @Override
    public void onNext(@NonNull String responseBody) {
        System.out.println("==onNext"+index);
        index=index+1;
    }


    @Override
    public void onError(@NonNull Throwable e) {
        System.out.println("==onError");
    }

    @Override
    public void onComplete() {
        System.out.println("finish");
        System.out.println("=======");
    }
}
