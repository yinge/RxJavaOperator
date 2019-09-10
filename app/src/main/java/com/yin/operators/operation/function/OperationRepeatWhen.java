package com.yin.operators.operation.function;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/9/9
 * at 16:43
 * summary:
 * ① 如果新的被观察者返回 onComplete 或者 onError 事件，则旧的被观察者不会继续发送事件
 * ② 如果被观察者返回其他事件，则会重复发送事件
 */
public class OperationRepeatWhen implements Operation {
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
        integerObservable.retryWhen(throwableObservable ->
                Observable.empty()
//                Observable.error(new Throwable())
//                Observable.just(4)
//                null
        ).subscribe(new Observer<Integer>() {
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
