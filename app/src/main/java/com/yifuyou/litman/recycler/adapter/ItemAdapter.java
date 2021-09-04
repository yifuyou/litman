package com.yifuyou.litman.recycler.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yifuyou.litman.R;
import com.yifuyou.litman.recycler.BaseHolder;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder>{
    private ArrayList<String> array;

    public ItemAdapter(){
        array=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            array.add("string__"+i);
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_rvitem,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.set(array.get(position),"");
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    static class Holder extends BaseHolder{

        public TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView_itemm);
        }

        @Override
        public void set(String t, String c) {
           textView.setText(t.trim());
        }
    }

}
