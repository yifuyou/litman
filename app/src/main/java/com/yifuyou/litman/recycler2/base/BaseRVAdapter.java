package com.yifuyou.litman.recycler2.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yifuyou.litman.recycler2.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRVAdapter<DATA,VH extends BaseViewHolder> extends RecyclerView.Adapter<VH>{

    private List<DATA> data;

    public abstract int getLayoutId();

    public abstract VH createHolder( View view);
    public abstract View.OnClickListener clickListener(VH holder);


    public BaseRVAdapter(){
        data=new ArrayList<>();
        initData();
    }

    public abstract void initData();

    public void setData(List<DATA> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        return createHolder(view) ;

    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.onBindViewHolder(data.get(position));
        holder.itemView.setOnClickListener(clickListener(holder));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public DATA getItemByIndex(int position){
        if(position<data.size()){
            return data.get(position);
        }
        return null;
    }

}
