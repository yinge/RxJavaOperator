package com.yin.operators.operation.create;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/24
 * at 16:27
 * summary:
 */
public class OperationError implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.error(new Throwable()).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                builder.append(StringEnum.CONNECT_MESSAGE).append('\n');
            }

            @Override
            public void onNext(Object object) {
                builder.append(StringEnum.NEXT_MESSAGE + object).append('\n');
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
