package com.yin.operators.operation.filter;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/9/10
 * at 13:46
 * summary: 返回 true 则会发送事件，否则不会发送
 */
public class OperationFilter implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(0, 1, 2, 3, 4, 5)
                .filter(integer -> integer > 3)
                .subscribe(integer -> builder.append(StringEnum.NEXT_MESSAGE).append(integer).append('\n'));
        return this;
    }
}
