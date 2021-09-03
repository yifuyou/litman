package com.yifuyou.httpcompack;

public class NetCommon<T> implements RequestInterface{
    private static NetCommon instance;

    private NetCommon(){

    }
    public static synchronized NetCommon getInstance() {
        if(instance==null){
            instance=new NetCommon();
        }
        return instance;
    }

    private void initClient(){




    }



    @Override
    public CommonResult<T> doGet(String url, String... obj) {
        return null;
    }

    @Override
    public CommonResult<T> doPost(String url, String... obj) {
        return null;
    }

    @Override
    public CommonResult<T> doCon(String url, String... obj) {
        return null;
    }
}
