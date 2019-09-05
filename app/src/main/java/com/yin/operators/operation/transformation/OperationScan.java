package com.yin.operators.operation.transformation;

import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/8/30
 * at 10:42
 * summary:将数据以一定的逻辑聚合起来
 */
public class OperationScan implements Operation {
    @Override
    public String getTag() {
        return getClass().getSimpleName();
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3, 4, 5)
                .scan(((integer, integer2) -> {
                    builder.append("apply--: " + integer + "\n");
                    builder.append("apply--: " + integer2 + "\n");
                    return integer + integer2;
                }))
                .subscribe(integer -> builder.append("accept--: " + integer + "\n"));
        return this;
    }
}
