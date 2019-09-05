package com.yin.operators.operation.create;

import android.util.Log;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/25
 * at 9:31
 * summary:
 */
public class OperationRange implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.range(4, 10).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.e(getTag(), "下一个。。。" + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(getTag(), StringEnum.COMPLETE_MESSAGE);
            }
        });
        return this;
    }
}
