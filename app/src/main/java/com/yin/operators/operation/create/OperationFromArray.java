package com.yin.operators.operation.create;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/24
 * at 15:24
 * summary:fromArray 对发送的数量没有限制
 */
public class OperationFromArray implements Operation {

    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Integer[] integers = {1, 2, 3};
        Observable.fromArray(integers).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                builder.append(StringEnum.CONNECT_MESSAGE).append('\n');
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
