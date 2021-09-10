package com.yifuyou.litman.recycler2;


import android.view.View;

import androidx.annotation.NonNull;

import com.yifuyou.litman.R;
import com.yifuyou.litman.recycler2.base.BaseRVAdapter;
import com.yifuyou.litman.recycler2.holder.DefaultHolder;

import java.util.ArrayList;

public class RVAdapter extends BaseRVAdapter<String, DefaultHolder> {
    private static boolean first=false;

    @Override
    public int getLayoutId() {
        return R.layout.rv2_layout_item;
    }

    @Override
    public void initData() {
        ArrayList<String> list=new ArrayList<>();
        int count=40;
        if(!first){
            for (int i=0;i<count;i++){
                list.add("text__ "+i);
            }
            first=!first;
        }else {
            for (int i=0;i<count*2;i+=2){
                list.add("text__ "+i);
            }
        }
            setData(list);
    }

    @Override
    public DefaultHolder createHolder(View view) {

        return  new DefaultHolder(view);
    }

    @Override
    public View.OnClickListener clickListener(DefaultHolder holder) {
        return (view -> {
            CharSequence text = holder.binding.itemText.getText();
            

            holder.binding.itemText.setText(text.toString().trim()+"+1");
        });
    }

    @Override
    public void onBindViewHolder(@NonNull DefaultHolder holder,  int position) {
        super.onBindViewHolder(holder, position);

    }


}
