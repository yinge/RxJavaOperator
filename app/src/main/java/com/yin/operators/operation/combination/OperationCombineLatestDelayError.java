package com.yin.operators.operation.combination;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/9/4
 * at 17:48
 * summary:
 */
public class OperationCombineLatestDelayError implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        ObservableSource<Integer> source1 =
                observer -> {
                    observer.onNext(1);
                    observer.onNext(2);
                    observer.onError(new Throwable());
                    observer.onNext(3);
                };

        ObservableSource<Integer> source2 =
                observer -> {
                    observer.onNext(4);
                    observer.onNext(5);
                    observer.onNext(6);
                };

        ObservableSource<Integer> source3 =
                observer -> {
                    observer.onNext(7);
                    observer.onNext(8);
                    observer.onNext(9);
                };
        ObservableSource<Integer>[] observableSources = new ObservableSource[]{source1, source2, source3};
        Observable.combineLatestDelayError(observableSources,
                integers -> {
                    String result = "";
                    for (Object integer : integers) {
                        result += integer;
                    }
                    return result;
                }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                builder.append(StringEnum.NEXT_MESSAGE).append(s).append('\n');
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return this;
    }
}
