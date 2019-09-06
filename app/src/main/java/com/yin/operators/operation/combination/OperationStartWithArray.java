package com.yin.operators.operation.combination;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/9/5
 * at 17:48
 * summary:
 */
public class OperationStartWithArray implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3, 4)
                .startWithArray(5, 6, 7, 8)
                .subscribe(integer -> builder.append(StringEnum.NEXT_MESSAGE)
                        .append(integer).append('\n'));
        return this;
    }
}
