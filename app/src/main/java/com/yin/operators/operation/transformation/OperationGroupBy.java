package com.yin.operators.operation.transformation;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.GroupedObservable;

/**
 * at 2019/8/29
 * at 17:21
 * summary:给Observable 分组，groupBy() 方法的返回值，就是分成的组的key。
 * 最终还会按顺序给事件发出去，而不是一个组发完，再发另外一个组.
 */
public class OperationGroupBy implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 5, 6, 8, 98, 26, 67, 345)
                .groupBy(integer -> integer % 2)
                .subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        builder.append(StringEnum.CONNECT_MESSAGE + "\n");
                    }

                    @Override
                    public void onNext(GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                        integerIntegerGroupedObservable.subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                builder.append("GroupedObservable---" + StringEnum.CONNECT_MESSAGE + "\n");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                builder.append("GroupedObservable---"+StringEnum.NEXT_MESSAGE + integerIntegerGroupedObservable.getKey() + "---" + integer + "\n");
                            }

                            @Override
                            public void onError(Throwable e) {
                                builder.append("GroupedObservable---" + StringEnum.ERROR_MESSAGE + "\n");
                            }

                            @Override
                            public void onComplete() {
                                builder.append("GroupedObservable---" + StringEnum.COMPLETE_MESSAGE + "\n");
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
