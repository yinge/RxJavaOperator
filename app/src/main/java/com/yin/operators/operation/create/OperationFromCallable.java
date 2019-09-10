package com.yin.operators.operation.create;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/8/29
 * at 15:14
 * summary:
 */
public class OperationFromCallable implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.fromCallable(() -> "我就是结果").subscribe(this::handleNext, this::handleError, this::handleComplete);
        return this;
    }

    private void handleNext(String s){
        builder.append(StringEnum.NEXT_MESSAGE).append(s).append('\n');
    }

    private void handleError(Throwable throwable){
        builder.append(StringEnum.ERROR_MESSAGE).append('\n');
    }

    private void handleComplete(){
        builder.append(StringEnum.COMPLETE_MESSAGE).append('\n');
    }
}
