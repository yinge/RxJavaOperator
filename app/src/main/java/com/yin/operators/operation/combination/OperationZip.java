package com.yin.operators.operation.combination;

import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/8/30
 * at 16:58
 * summary:
 */
public class OperationZip implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable observable1 = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
        });

        Observable observable2 = Observable.just(4, 5, 6);
        Observable observable3 = Observable.range(7, 4);
        Observable.zip(
                observable1,
                observable2,
                observable3,
                (integer1, integer2, integer3) -> "ZIP_RESULT" + "--" + integer1 + "--" + integer2 + "--" + integer3
        ).subscribe(string -> builder.append(string).append("\n"));
        return this;
    }
}
