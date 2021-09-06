package com.yifuyou.httpcompack.common;


import androidx.databinding.ObservableArrayList;

import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObserverUtil<T> {
    static int count;
    List<Observer<T>> observers;
    Observable<T> observable;

    public ObserverUtil(){
        observers=new ObservableArrayList<>();
    }


    public void addObserver(Observer<T> observer){
        observers.add(observer);
    }

    public void setObservable(Observable<T> observable) {
        this.observable = observable;
    }

    public Observable<T> getObservable() {
        return observable;
    }

    private void configObservable(){
        for (Observer<T> observer : observers) {
            observable.subscribe(observer);
        }
    }
    public void notifyChange(){
        configObservable();
         observable.subscribe().dispose();
    }

    private void destroy(){
        for (Observer<T> observer : observers) {
            observer.onComplete();
        }
        observers=null;
    }

}
