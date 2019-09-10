package com.yin.operators.operation.filter;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/9/10
 * at 14:53
 * summary:控制观察者接收的事件的数量(前xxx个事件)
 */
public class OperationTake implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3, 4, 5)
                .take(3)
                .subscribe(integer -> builder.append(StringEnum.NEXT_MESSAGE).append(integer).append('\n'));
        return this;
    }
}
