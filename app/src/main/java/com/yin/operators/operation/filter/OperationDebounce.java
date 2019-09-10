package com.yin.operators.operation.filter;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * at 2019/9/10
 * at 15:05
 * summary: 如果两件事件发送的时间间隔小于设定的时间间隔则前一件事件就不会发送给观察者
 */
public class OperationDebounce implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable<Integer> integerObservable =
                Observable.create(emitter -> {
                    emitter.onNext(1);
                    Thread.sleep(900);
                    emitter.onNext(2);
                    emitter.onComplete();
                });
        integerObservable.debounce(1, TimeUnit.SECONDS)
                .subscribe(integer -> builder.append(StringEnum.NEXT_MESSAGE).append(integer).append('\n'));
        return this;
    }
}
