package com.yifuyou.litman.recycler2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.yifuyou.litman.R;
import com.yifuyou.litman.databinding.Rv2LayoutBinding;
import com.yifuyou.litman.recycler2.base.BaseActivity;
import com.yifuyou.litman.recycler2.base.BaseViewModel;

public class RVActivity extends BaseActivity<Rv2LayoutBinding, BaseViewModel> {
    @Override
    public int getLayoutId() {
        return R.layout.rv2_layout;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel=new ViewModelProvider(this).get(BaseViewModel.class);
        binding.rv1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rv2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        binding.rv1.setAdapter(new RVAdapter());
        binding.rv2.setAdapter(new RVAdapter());

    }




}
