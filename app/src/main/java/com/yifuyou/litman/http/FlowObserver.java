package com.yifuyou.litman.http;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

public class FlowObserver<T> {
    Disposable subscriber;
    public void init(T object){
         subscriber = Flowable.just( object)
                .subscribeWith(new DisposableSubscriber<T>() {


                    @Override
                    public void onNext(T s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        subscriber.dispose();
    }

    public void dispose(){
        if(subscriber!=null){
            if(!subscriber.isDisposed()){
                subscriber.dispose();
            }
        }
    }

}
