package com.yifuyou.litman.recycler.model;

import androidx.databinding.ObservableField;

public class RvItem {

    public ObservableField<String> title;
    public RvItem(){
        title=new ObservableField<>();
    }
    public RvItem (String t){
        title=new ObservableField<>();
        title.set(t);
    }

}
