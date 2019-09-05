package com.yin.operators.operation.combination;

import com.yin.operators.operation.Operation;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/26
 * at 15:54
 * summary:组合多个被观察者一起发送数据，合并后 按时间线并行执行
 * !!!!!最多只能发送四个， 如果需要发送更多请移驾 {@link OperationMergeArray}
 */
public class OperationMerge implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.merge(
                Observable.intervalRange(1, 3, 1, 1, TimeUnit.SECONDS),
                Observable.intervalRange(4, 3, 2, 1, TimeUnit.SECONDS),
                Observable.intervalRange(7, 3, 3, 1, TimeUnit.SECONDS)
        ).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                builder.append("我连上了。。。").append('\n');
            }

            @Override
            public void onNext(Long aLong) {
                builder.append("下一个。。。" + aLong).append('\n');
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
