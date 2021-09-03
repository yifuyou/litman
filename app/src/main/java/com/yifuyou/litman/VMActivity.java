package com.yifuyou.litman;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.yifuyou.litman.model.Person;
import com.yifuyou.litman.vm.BaseViewModel;

public class VMActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseViewModel viewModel = new ViewModelProvider(this).get(BaseViewModel.class).init(this);
        viewModel.getNames().observe(this, new Observer<Person>() {
            @Override
            public void onChanged(Person s) {
                Toast.makeText(VMActivity.this, s.toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
