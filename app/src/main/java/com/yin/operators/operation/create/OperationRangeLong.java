package com.yin.operators.operation.create;

import android.util.Log;

import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/25
 * at 9:40
 * summary:
 */
public class OperationRangeLong implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.rangeLong(3, 9).subscribe(new Observer<Long>() {
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
