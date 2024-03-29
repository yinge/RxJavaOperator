package com.yin.operators.operation.create;

import com.yin.operators.StringEnum;
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
                        builder.append(StringEnum.CONNECT_MESSAGE).append('\n');
                    }

                    @Override
                    public void onNext(String s) {
                        builder.append(StringEnum.NEXT_MESSAGE + s).append('\n');
                    }

                    @Override
                    public void onError(Throwable e) {
                        builder.append(StringEnum.ERROR_MESSAGE).append('\n');
                    }

                    @Override
                    public void onComplete() {
                        builder.append(StringEnum.COMPLETE_MESSAGE).append('\n');
                    }
                });
        return this;
    }
}
