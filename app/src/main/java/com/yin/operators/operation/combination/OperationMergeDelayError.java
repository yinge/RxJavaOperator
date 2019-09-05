package com.yin.operators.operation.combination;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/26
 * at 16:30
 * summary:在concat或merge操作符里面 如果其中1个Observable发送了onError，
 * 那么其他Observable不会再发送事件，为了解决这个问题concatDelayError和mergeDelayError出现了
 * mergeArrayDelayError 也是一样 see {@link io.reactivex.Observable#mergeArrayDelayError(ObservableSource[])}
 */
public class OperationMergeDelayError implements Operation {
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

        Observable
                .mergeDelayError(source1, source2, source3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        builder.append(StringEnum.NEXT_MESSAGE + integer).append("\n");
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
