package com.yifuyou.litman;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

public class ColorSPUtil {
    public static void setColor(Context context,int color){
        SharedPreferences sp=context.getSharedPreferences("inColor",Context.MODE_PRIVATE);
        sp.edit().putInt("colorInt",color).apply();
    }

    public static int getColor(Context context){
        SharedPreferences sp=context.getSharedPreferences("inColor",Context.MODE_PRIVATE);
        return sp.getInt("colorInt", 0);
    }

}
