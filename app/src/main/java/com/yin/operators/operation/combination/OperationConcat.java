package com.yin.operators.operation.combination;

import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/26
 * at 15:37
 * summary:组合多个被观察者一起发送数据，合并后 按发送顺序串行执行
 * !!!!!!!!最多只能发送四个， 如果需要发送更多请移驾 {@link OperationConcatArray}
 */
public class OperationConcat implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.concat(
                Observable.just(1, 2, 3),
                Observable.just(4, 5, 6),
                Observable.just(7, 8, 9),
                Observable.just(10, 11, 12)
        ).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                builder.append("我连上了。。。").append('\n');
            }

            @Override
            public void onNext(Integer integer) {
                builder.append("下一个。。。" + integer).append('\n');
            }

            @Override
            public void onError(Throwable e) {
                builder.append("我错了。。。").append('\n');
            }

            @Override
            public void onComplete() {
                builder.append("我完了。。。").append('\n');
            }
        });
        return this;
    }
}
