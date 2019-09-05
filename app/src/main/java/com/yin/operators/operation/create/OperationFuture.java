package com.yin.operators.operation.create;

import android.util.Log;

import com.yin.operators.operation.Operation;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/8/29
 * at 15:41
 * summary:
 */
public class OperationFuture implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        FutureTask<String> futureTask = new FutureTask<>(
                () -> "我就是结果"
        );

        Observable.fromFuture(futureTask, 5, TimeUnit.SECONDS)
                .doOnSubscribe(
                        disposable -> futureTask.run()
                )
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(getTag(), "我连上了。。。");
                    }

                    @Override
                    public void onNext(String integer) {
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
