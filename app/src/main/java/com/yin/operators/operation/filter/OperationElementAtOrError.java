package com.yin.operators.operation.filter;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/9/10
 * at 15:35
 * summary:指定取出事件序列中事件，
 * 但是输入的 index 超出事件序列的总数的话就发出异常信息
 */
public class OperationElementAtOrError implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(0, 1, 2, 3, 4, 5)
                .elementAtOrError(10)
                .subscribe(this::handleNext, this::handleError);
        return this;
    }

    private void handleNext(Integer integer){
        builder.append(StringEnum.NEXT_MESSAGE).append(integer).append('\n');
    }

    private void handleError(Throwable throwable){
        builder.append(StringEnum.ERROR_MESSAGE).append(throwable.getMessage()).append('\n');
    }
}
