package com.yifuyou.litman.recycler2.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<DATA,DB extends ViewDataBinding> extends RecyclerView.ViewHolder {

    public DB binding;

    public BaseViewHolder(@NonNull View itemView,DB dataBind) {
        super(itemView);
        binding=dataBind;
    }

    public abstract void setData(DATA data);

    public abstract void onBind(DATA data);
}
