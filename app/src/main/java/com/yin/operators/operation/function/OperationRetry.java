package com.yin.operators.operation.function;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/9/6
 * at 16:14
 * summary: 如果出现错误事件，则会重新发送所有事件序列。times 是代表重新发的次数
 */
public class OperationRetry implements Operation {
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
                    emitter.onError(new RuntimeException("我错了 不行啊"));
                });
        integerObservable.retry(2)
                .subscribe(new Observer<Integer>() {
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
