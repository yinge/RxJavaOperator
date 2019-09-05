package com.yin.operators.operation.create;

import android.util.Log;

import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/24
 * at 16:27
 * summary:
 */
public class OperationError implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.error(new Throwable()).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(getTag(), "我连上了。。。");
            }

            @Override
            public void onNext(Object object) {
                Log.e(getTag(), "下一个。。。" + object);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(getTag(), "我错了。。。");
            }

            @Override
            public void onComplete() {
                Log.e(getTag(), "我完了。。。");
            }
        });
        return this;
    }
}
