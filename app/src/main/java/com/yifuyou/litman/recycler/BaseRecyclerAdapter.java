package com.yifuyou.litman.recycler;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.yifuyou.litman.R;
import com.yifuyou.litman.databinding.RvItemBinding;
import com.yifuyou.litman.recycler.holder.Holder1;
import com.yifuyou.litman.recycler.holder.Holder2;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseHolder> {

        List<String> nameList;
        Map<String,String> titleContentList;
        SparseIntArray typeArray;
        LifecycleOwner lifecycleOwner;


    public BaseRecyclerAdapter(LifecycleOwner lifecycleOwner){
        nameList=new ArrayList<>();
        titleContentList=new HashMap<>();
        this.lifecycleOwner=lifecycleOwner;
        addData();
    }

    private void addData(){
        for (int i = 0; i < 20; i++) {
            nameList.add(i,"title"+i);
            titleContentList.put(nameList.get(i),"content.."+i);
        }
    }

    @NonNull
    @Override
    public BaseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
/*        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
//        RvItemBinding binding=DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.rv_item,parent,false);
        return new BaseHolder(view,viewType);*/
        BaseHolder holder;
        if(viewType==0){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
            holder= new Holder1(view);
        }else {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item2,parent,false);
            holder= new Holder2(view);
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHolder holder, int position) {
        String name = nameList.get(position);
        holder.set(name,titleContentList.get(name));
    }




    @Override
    public int getItemCount() {
        return nameList.size();
    }

//    public static class BaseHolder extends RecyclerView.ViewHolder{
//        RvItemBinding binding;
//
//        public Holder(View view,int viewType) {
//            super(view);
//            binding=DataBindingUtil.bind(view);
//            if (binding != null) {
//                binding.setContent(new RecyclerItem());
//            }
//        }
//        public void set(String t,String c){
//            RecyclerItem item=binding.getContent();
//            item.title.set(t);
//            item.content.set(c);
//            binding.setContent(item);
//        }
//    }
//        public static class BaseHolder extends RecyclerView.ViewHolder{
//        TextView title;
//        TextView content;
//
//        public Holder(View view) {
//            super(view);
//            title=view.findViewById(R.id.item_1);
//            content=view.findViewById(R.id.item_2);
//        }
//        public void set(String t,String c){
//            title.setText(t);
//            content.setText(c);
//        }
//    }


    @Override
    public int getItemViewType(int position) {
        return position%2;
    }



}
