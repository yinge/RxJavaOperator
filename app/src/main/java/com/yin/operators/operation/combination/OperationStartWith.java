package com.yin.operators.operation.combination;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/9/5
 * at 17:46
 * summary:在发送事件之前追加事件。追加的事件会先发出
 */
public class OperationStartWith implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3)
                .startWith(4)
                .startWith(observer -> observer.onNext(5))
                .subscribe(integer -> builder.append(StringEnum.NEXT_MESSAGE)
                        .append(integer).append('\n'));
        return this;
    }
}
