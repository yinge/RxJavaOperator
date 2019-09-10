package com.yin.operators.operation.function;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/9/6
 * at 14:57
 * summary:Disposable 的 dispose() 之后回调该方法
 */
public class OperationDoOnDispose implements Operation {
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
        integerObservable.doOnDispose(() -> builder.append("doOnDispose").append('\n'))
                .subscribe(new Observer<Integer>() {
                    private Disposable d;

                    @Override
                    public void onSubscribe(Disposable d) {
                        builder.append(StringEnum.CONNECT_MESSAGE).append('\n');
                        this.d = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        builder.append(StringEnum.NEXT_MESSAGE + integer).append('\n');
                        d.dispose();
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
