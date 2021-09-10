package com.yifuyou.litman.recycler2.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.yifuyou.litman.databinding.Rv2LayoutItemBinding;
import com.yifuyou.litman.recycler2.base.BaseViewHolder;

public class DefaultHolder extends BaseViewHolder<String, Rv2LayoutItemBinding> {


    public DefaultHolder(@NonNull View itemView) {
        super(itemView, DataBindingUtil.bind(itemView.getRootView()));
    }

    @Override
    public void setData(String s) {
        binding.itemText.setText(s);
    }

    @Override
    public void onBindViewHolder(String s) {
        setData(s);
    }
}
