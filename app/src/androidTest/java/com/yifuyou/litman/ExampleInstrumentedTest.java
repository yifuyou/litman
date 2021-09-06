package com.yifuyou.litman;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.yifuyou.httpcompack.common.CommonRequest;
import com.yifuyou.httpcompack.common.CommonResult;
import com.yifuyou.httpcompack.common.Weather;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.yifuyou.litman", appContext.getPackageName());
    }




    @Test
    public void HttpCompack(){
        CommonRequest commonRequest=CommonRequest.getInstance();
        commonRequest.addObserver(new Observer<Weather>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("======onSubscribe===");
            }

            @Override
            public void onNext(@NonNull Weather commonResult) {
                System.out.println("=====onNext========");
                System.out.println(commonResult.toString());


            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("=====onError========");

            }

            @Override
            public void onComplete() {
                System.out.println("=====onComplete========");

            }
        });
        commonRequest.doRequest("","get","");

    }
}