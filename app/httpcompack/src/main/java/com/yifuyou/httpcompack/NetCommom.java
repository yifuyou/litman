package com.yifuyou.httpcompack;

public class NetCommom {
    private static NetCommom instance;

    private NetCommom(){

    }


    public static synchronized NetCommom getInstance() {
        if(instance==null){
            instance=new NetCommom();
        }
        return instance;
    }








}
