package com.yin.operators.operation.combination;

import com.yin.operators.operation.Operation;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/26
 * at 16:29
 * summary:在concat或merge操作符里面 如果其中1个Observable发送了onError，
 * 那么其他Observable不会再发送事件，为了解决这个问题concatDelayError和mergeDelayError出现了
 * concatArrayDelayError 也是一样 see{@link io.reactivex.Observable#concatArrayDelayError(ObservableSource[])}
 */
public class OperationConcatDelayError implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.concat(
                Observable.create(emitter -> {
                    emitter.onNext(1);
                    emitter.onNext(2);
                    emitter.onNext(3);
                    emitter.onError(new Throwable());
                    emitter.onComplete();
                }),
                Observable.just(4, 5, 6)
        ).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                builder.append("我是concat连上了。。。").append('\n');
            }

            @Override
            public void onNext(Integer integer) {
                builder.append("下一个concat。。。" + integer).append('\n');
            }

            @Override
            public void onError(Throwable e) {
                builder.append("我concat错了。。。").append('\n');
            }

            @Override
            public void onComplete() {
                builder.append("我concat完了。。。").append('\n');
            }
        });




        ArrayList<ObservableSource<Integer>> observableSources = new ArrayList<>();
        Observable<Integer> one = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onError(new Throwable());
            emitter.onComplete();
        });

        Observable<Integer> two = Observable.just(4, 5, 6);
        observableSources.add(one);
        observableSources.add(two);

        Observable.concatDelayError(observableSources).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                builder.append("我是concatDelayError连上了。。。").append('\n');
            }

            @Override
            public void onNext(Integer integer) {
                builder.append("下一个concatDelayError。。。" + integer).append('\n');
            }

            @Override
            public void onError(Throwable e) {
                builder.append("我concatDelayError错了。。。").append('\n');
            }

            @Override
            public void onComplete() {
                builder.append("我concatDelayError完了。。。").append('\n');
            }
        });

        return this;
    }
}
