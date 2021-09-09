package com.yifuyou.litman.recycler2;

import android.view.View;

import com.yifuyou.litman.R;
import com.yifuyou.litman.recycler2.base.BaseRVAdapter;
import com.yifuyou.litman.recycler2.holder.DefaulHolder;

import java.util.ArrayList;

public class RVAdapter extends BaseRVAdapter<String, DefaulHolder> {
    private static boolean first=false;

    @Override
    public int getLayoutId() {
        return R.layout.rv2_layout_item;
    }

    @Override
    public void initData() {
        ArrayList<String> list=new ArrayList<>();
        if(!first){
            for (int i=0;i<10;i++){
                list.add("text__ "+i);
            }
            first=!first;
        }else {
            for (int i=0;i<20;i+=2){
                list.add("text__ "+i);
            }
        }
            setData(list);
    }

    @Override
    public DefaulHolder createHolder(View view) {
        DefaulHolder viewHolder = new DefaulHolder(view);
        return viewHolder;
    }


}
