package com.yin.operators.operation.transformation;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/8/30
 * at 11:08
 * summary:发送指定数量的事件时，就将这些事件分为一组。window 中的 count 的参数就是代表指定的数量，
 * 例如将 count 指定为2，那么每发2个数据就会将这2个数据分成一组
 */
public class OperationWindow implements Operation {
    @Override
    public String getTag() {
        return getClass().getSimpleName();
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3, 4, 5)
                .window(2)
                .subscribe(new Observer<Observable<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        builder.append(StringEnum.CONNECT_MESSAGE + "\n");
                    }

                    @Override
                    public void onNext(Observable<Integer> integerObservable) {
                        integerObservable.subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                builder.append("WindowObservable---" + StringEnum.CONNECT_MESSAGE + "\n");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                builder.append("WindowObservable---" + StringEnum.NEXT_MESSAGE + integer + "\n");
                            }

                            @Override
                            public void onError(Throwable e) {
                                builder.append("WindowObservable---" + StringEnum.ERROR_MESSAGE + "\n");
                            }

                            @Override
                            public void onComplete() {
                                builder.append("WindowObservable---" + StringEnum.COMPLETE_MESSAGE + "\n");
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        builder.append(StringEnum.ERROR_MESSAGE + "\n");
                    }

                    @Override
                    public void onComplete() {
                        builder.append(StringEnum.COMPLETE_MESSAGE + "\n");
                    }
                });
        return this;
    }
}
