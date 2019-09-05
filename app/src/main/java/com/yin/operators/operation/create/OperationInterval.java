package com.yin.operators.operation.create;

import android.util.Log;

import com.yin.operators.operation.Operation;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/24
 * at 17:24
 * summary:从0开始、无限递增1的的整数序列
 * 方法参数中的 initialDelay 是延迟多久开始发送
 */
public class OperationInterval implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.interval(5,1, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.e(getTag(), "下一个。。。" + aLong);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(getTag(), "我完了。。。");
            }
        });
        return this;
    }
}
