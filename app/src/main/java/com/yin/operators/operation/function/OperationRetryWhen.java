package com.yin.operators.operation.function;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/9/9
 * at 13:29
 * summary:当被观察者接收到异常或者错误事件时会回调该方法，
 * 这个方法会返回一个新的被观察者。
 * 如果返回的被观察者发送 Error 事件则之前的被观察者不会继续发送事件，
 * 如果发送正常事件则之前的被观察者会继续不断重试发送事件
 */
public class OperationRetryWhen implements Operation {
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
                    emitter.onError(new Exception("250"));
                    emitter.onNext(4);
                });
        integerObservable.retryWhen(throwableObservable -> {
            if (throwableObservable.toString().equals("java.lang.Exception: 250")) {
                return Observable.error(new Throwable("结束了"));
            } else {
                return Observable.just(10);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                builder.append(StringEnum.CONNECT_MESSAGE).append('\n');
            }

            @Override
            public void onNext(Integer integer) {
                builder.append(StringEnum.NEXT_MESSAGE).append(integer).append('\n');
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
