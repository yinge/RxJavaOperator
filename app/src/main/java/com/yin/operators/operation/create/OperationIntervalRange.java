package com.yin.operators.operation.create;

import android.util.Log;

import com.yin.operators.operation.Operation;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/24
 * at 17:40
 * summary:就是给 interval 操作符 ，加上了起始点 和 发送个数的限制
 */
public class OperationIntervalRange implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.intervalRange(1, 5,
                2, 1, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(getTag(), "我连上了。。。");
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
