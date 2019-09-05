package com.yin.operators.operation.create;

import android.util.Log;

import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/24
 * at 16:35
 * summary:直到有观察者（Observer ）订阅时，才动态创建被观察者对象（Observable）
 * 每次订阅后，都会得到一个刚创建的最新的Observable对象
 */
public class OperationDefer implements Operation {

    Integer i = 10;

    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {

        Observable<Integer> integerObservable = Observable.defer(() -> Observable.just(i));

        i = 20;

        integerObservable.subscribe(new Observer<Integer>() {
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
