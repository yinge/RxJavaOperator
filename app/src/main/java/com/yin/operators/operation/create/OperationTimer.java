package com.yin.operators.operation.create;

import android.util.Log;

import com.yin.operators.operation.Operation;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/24
 * at 17:12
 * summary:延迟指定时间后，发送数值0
 */
public class OperationTimer implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.e(getTag(), "这个值是定死的。。。" + aLong);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Observable.timer(2, TimeUnit.SECONDS).subscribe(aLong -> Log.e(getTag(), "这个值是定死的。。。" + aLong));
        return this;
    }
}
