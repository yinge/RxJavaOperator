package com.yin.operators.operation.transformation;

import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/4/25
 * at 15:22
 * summary:
 */
public class OperationMap implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable
                .range(89, 6)
                .doOnNext(integer -> builder.append("原始数据---").append(integer).append('\n'))
                .map(integer -> "这是通过map转化之后的---" + integer)
                .subscribe(s -> builder.append(s).append('\n'));
        return this;
    }
}
