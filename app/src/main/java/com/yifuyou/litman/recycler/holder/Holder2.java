package com.yifuyou.litman.recycler.holder;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

import com.yifuyou.litman.databinding.RvItem2Binding;
import com.yifuyou.litman.recycler.BaseHolder;
import com.yifuyou.litman.recycler.BeanObserver;
import com.yifuyou.litman.recycler.model.RecyclerItem;
import com.yifuyou.litman.recycler.model.RvItem;

public class Holder2 extends BaseHolder {
    RvItem2Binding binding;


    public Holder2(@NonNull View itemView) {
        super(itemView);
        binding= DataBindingUtil.bind(itemView);
        if(binding!=null){
            binding.setItem2(new RvItem());
        }
    }

    @Override
    public void set(String t, String c) {
        super.set(t, c);
        RvItem item= binding.getItem2();
        item.title.set(t);
        binding.setItem2(item);
    }
}
