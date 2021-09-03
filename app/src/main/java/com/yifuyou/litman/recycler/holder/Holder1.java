package com.yifuyou.litman.recycler.holder;

import android.util.Log;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

import com.yifuyou.litman.databinding.RvItemBinding;
import com.yifuyou.litman.recycler.BaseHolder;
import com.yifuyou.litman.recycler.BeanObserver;
import com.yifuyou.litman.recycler.model.RecyclerItem;

public class Holder1 extends BaseHolder {
    RvItemBinding binding;
    BeanObserver observer;

    public Holder1(@NonNull View itemView) {
        super(itemView);
        binding= DataBindingUtil.bind(itemView);
        if(binding!=null){
            binding.setContent(new RecyclerItem());
            observer=new BeanObserver();
            observer.addCallback(new Observable.OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(Observable sender, int propertyId) {
                    Log.e("observer", "onPropertyChanged: =============="+propertyId+sender.toString(), null);
                }
            });

            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = observer.getMessage().concat("+1");
                    observer.setMessage(s);
                }
            });
        }

    }



    @Override
    public void set(String t, String c) {
        super.set(t, c);
        RecyclerItem item=binding.getContent();
        item.title.set(t);
        item.content.set(c);
        observer.setMessage(c+"\t"+t);
        binding.setMsg(observer);
        binding.setContent(item);
    }

}
