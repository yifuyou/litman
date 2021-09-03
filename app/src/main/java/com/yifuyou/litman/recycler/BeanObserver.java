package com.yifuyou.litman.recycler;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.yifuyou.litman.BR;


public class BeanObserver extends BaseObservable {

    public String message;

    public void addCallback(OnPropertyChangedCallback callback){
        addOnPropertyChangedCallback(callback);
    }


    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }
}
