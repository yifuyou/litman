package com.yifuyou.httpcompack.common;

import android.util.Log;

import com.yifuyou.httpcompack.proxy.HttpProxy;
import com.yifuyou.httpcompack.proxy.TempProxy;
import com.yifuyou.httpcompack.server.HttpServer;

import org.json.JSONException;

import java.io.IOException;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;


public class CommonRequest  {
    private ObserverUtil observerUtil;
    private static CommonRequest instance;
    private CommonResult<String> result;

    private CommonRequest(){
        observerUtil=new ObserverUtil();
    }

    public static CommonRequest getInstance(){
        if(instance==null){
            instance=new CommonRequest();
        }
        return instance;
    }

    public void addObserver(Observer<CommonResult<String>> observer){
        if (observer==null){
            throw new NullPointerException("Observer<CommonResult> observer should not be null");
        }
        observerUtil.addObserver(observer);

    }

    /**
     *
     * @param url  路径
     * @param type 请求类型
     * @param org  参数
     * @return
     */
    public void doRequest(String url, String type ,String...org){

        newThreadRun(()->{
            result=new CommonResult<>();
            try {
//                Call<ResponseBody> request = HttpProxy.getHttpService(HttpServer.class).request();
//                Response<ResponseBody> response = request.execute();
                Observable<ResponseBody> observable = HttpProxy.getHttpService(HttpServer.class).requestObservable();
                observerUtil.setObservable(observable);

                //返回参数判断。。。

//                result.purse(response);
//            } catch (IOException | JSONException e) {
//                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }


        });

    }

    private void setObservable(CommonResult<String> commonResult){
        observerUtil.setObservable(new Observable<CommonResult<String>>() {
            @Override
            protected void subscribeActual(@NonNull Observer<? super CommonResult<String>> observer) {
                observer.onNext(commonResult);
                observer.onComplete();
            }
        });
    }

    private void newThreadRun(RunDemo runDemo){
        new Thread(()->{
                runDemo.run();
            Log.e("TAG", "newThreadRun: "+ result.toString(),null);
                setObservable(result);
                observerUtil.notifyChange();
            }).start();
    }


    private interface RunDemo{
        void run();
    }


}
