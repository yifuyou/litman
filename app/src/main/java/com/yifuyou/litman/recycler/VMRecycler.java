package com.yifuyou.litman.recycler;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VMRecycler extends ViewModel {
    private RecyclerView recyclerView;


    public void initRecyclerView(LifecycleOwner lifecycleOwner,RecyclerView view){
        if(view==null)throw new NullPointerException();
        recyclerView=view;
        recyclerView.setAdapter(new BaseRecyclerAdapter(lifecycleOwner));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

    }

    public void doAny(){

    }

}
