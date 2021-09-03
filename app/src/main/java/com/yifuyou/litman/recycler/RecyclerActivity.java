package com.yifuyou.litman.recycler;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.yifuyou.litman.R;


/**
 * 练习 recyclerView
 *
 *
 *
 */
public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);
        VMRecycler vm= new ViewModelProvider(this).get(VMRecycler.class);
        RecyclerView rv = findViewById(R.id.recycler_test);
        vm.initRecyclerView(this,rv);


    }


}
