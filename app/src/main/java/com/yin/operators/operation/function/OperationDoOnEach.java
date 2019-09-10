package com.yin.operators.operation.function;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/9/6
 * at 10:36
 * summary: 每发送一件事件之前都会先回调这个方法
 */
public class OperationDoOnEach implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {

        Observable<Integer> integerObservable =
                Observable.create(emitter -> {
                    emitter.onNext(1);
                    emitter.onNext(2);
                    emitter.onNext(3);
                    emitter.onComplete();
                });
        integerObservable.doOnEach(integerNotification -> {
            if (integerNotification.isOnNext()) {
                builder.append("doOnEach---next---").append(integerNotification.getValue()).append('\n');
            }

            if (integerNotification.isOnError()) {
                builder.append("onError---").append('\n');
            }

            if (integerNotification.isOnComplete()) {
                builder.append("onComplete---").append('\n');
            }
        }).subscribe(integer -> builder.append(StringEnum.NEXT_MESSAGE).append(integer).append('\n'));
        return this;
    }
}
