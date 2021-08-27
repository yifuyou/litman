package com.yifuyou.litman;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        textView=findViewById(R.id.text_for_change);
    }


    public void onclick(View view) {
        switch (view.getId()){
            case R.id.b1:
            textView.setTextColor(Color.GREEN);
            break;

            case R.id.b2:
                textView.setTextColor(Color.YELLOW);
                break;

            case R.id.b3:
                textView.setTextColor(Color.BLUE);
                break;

        }


    }
}
