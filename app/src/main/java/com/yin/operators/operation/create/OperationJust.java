package com.yin.operators.operation.create;

import android.util.Log;

import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/24
 * at 14:21
 * summary:Just 最多只能发送10个参数
 */
public class OperationJust implements Operation {

    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(getTag(), "我连上了。。。");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(getTag(), "下一个。。。" + integer);
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
