package com.yin.operators.operation.filter;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/9/10
 * at 15:31
 * summary:指定取出事件序列中事件，
 * 但是输入的 index 超出事件序列的总数的话就不会出现任何结果
 */
public class OperationElementAt implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(0, 1, 2, 3, 4, 5)
                .elementAt(3)
                .subscribe(integer -> builder.append(StringEnum.NEXT_MESSAGE).append(integer).append('\n'));
        return this;
    }
}
