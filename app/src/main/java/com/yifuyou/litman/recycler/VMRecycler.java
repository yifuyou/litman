package com.yifuyou.litman.recycler;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yifuyou.litman.recycler.adapter.BaseRecyclerAdapter;

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
