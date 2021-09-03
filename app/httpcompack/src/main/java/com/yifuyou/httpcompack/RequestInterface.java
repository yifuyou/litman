package com.yifuyou.httpcompack;

public interface RequestInterface<T> {
    CommonResult<T> doGet(String url,String...obj);
    CommonResult<T> doPost(String url,String...obj);

    CommonResult<T> doCon(String url,String...obj);

}
