package com.yin.operators.operation.create;

import android.util.Log;

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
        Log.e(getTag(), StringEnum.NEXT_MESSAGE + s);
    }

    private void handleError(Throwable throwable){
        Log.e(getTag(), StringEnum.ERROR_MESSAGE);
    }

    private void handleComplete(){
        Log.e(getTag(), StringEnum.COMPLETE_MESSAGE);
    }
}
