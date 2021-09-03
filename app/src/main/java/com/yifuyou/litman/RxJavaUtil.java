package com.yifuyou.litman;


import com.yifuyou.litman.http.RequestObserver;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RxJavaUtil {
    static Observable<String> observable;
    static volatile int count=0;

    public static Observable<String> create(){
        observable=Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("llll");
                emitter.onNext("oooo");
                emitter.onComplete();
            }
        });
        return observable;
    }
    public static void addObserver(){
        observable.subscribe(new RequestObserver());
    }
    public static void addObservers(int s){
        for (int i = 0; i < s; i++) {
            addObserver();
        }
    }

    public static int getCount() {
        int tem=0;
        tem=count+1;
        count = tem;
        return tem;
    }
}
