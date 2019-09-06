package com.yin.operators.operation.combination;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/9/5
 * at 17:50
 * summary:返回被观察者发送事件的数量
 */
public class OperationCount implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3)
                .count()
                .subscribe(aLong -> builder.append(StringEnum.NEXT_MESSAGE).
                        append("一共发送的数量").
                        append(aLong).append('\n'));
        return this;
    }
}
