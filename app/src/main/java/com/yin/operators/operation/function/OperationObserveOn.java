package com.yin.operators.operation.function;

import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * at 2019/9/9
 * at 17:03
 * summary:
 */
public class OperationObserveOn implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3)
                .observeOn(Schedulers.newThread())
                .flatMap(integer -> {
                    builder.append("flatMap--").append("threadName--")
                            .append(Thread.currentThread().getName()).append('\n');
                    return Observable.just("FlatMap--" + integer);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    builder.append("subscribe--").append("threadName--")
                            .append(Thread.currentThread().getName()).append('\n');
                    builder.append(s).append('\n');
                });
        return this;
    }
}
