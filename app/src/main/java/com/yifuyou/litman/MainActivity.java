package com.yifuyou.litman;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yifuyou.litman.http.RequestTestActivity;
import com.yifuyou.litman.recycler.RecyclerActivity;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

    public void OnClick(View view){
        switch (view.getId()){
            case R.id.button_1:
                startActivity(new Intent(this, RequestTestActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, VMActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, RecyclerActivity.class));
                break;
            case R.id.button4:
//                startActivity(new Intent(this, Ac.class));
            default:break;
        }


    }


}
