package com.yin.operators.operation.create;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/24
 * at 13:58
 * summary:
 */
public class OperationCreate implements Operation {

    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable<Integer> observable = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        });

        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                builder.append("我连上了。。。").append('\n');
            }

            @Override
            public void onNext(Integer integer) {
                builder.append(StringEnum.NEXT_MESSAGE + integer).append('\n');
            }

            @Override
            public void onError(Throwable e) {
                builder.append(StringEnum.ERROR_MESSAGE).append('\n');
            }

            @Override
            public void onComplete() {
                builder.append(StringEnum.COMPLETE_MESSAGE).append('\n');
            }
        });
        return this;
    }
}
