package com.yifuyou.litman.recycler.model;

import androidx.databinding.ObservableField;

public class RecyclerItem {
    public ObservableField<String> title;
    public ObservableField<String> content;
    public RecyclerItem(){
        title=new ObservableField<>();
        content=new ObservableField<>();
    }
    public RecyclerItem (String t,String c){
        title=new ObservableField<>();
        content=new ObservableField<>();
        title.set(t);
        content.set(c);
    }


}
