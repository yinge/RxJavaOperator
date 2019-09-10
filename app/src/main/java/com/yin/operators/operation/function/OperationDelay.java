package com.yin.operators.operation.function;

import android.util.Log;

import com.yin.operators.operation.Operation;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * at 2019/9/6
 * at 10:12
 * summary:
 */
public class OperationDelay implements Operation {
    @Override
    public String getTag() {
        return getClass().getSimpleName();
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3, 4)
                .delay(3, TimeUnit.SECONDS)
                .subscribe(integer -> {
                    Log.e(getTag(), "result---" + integer);
                    builder.append("看Log");
                });
        return this;
    }
}
