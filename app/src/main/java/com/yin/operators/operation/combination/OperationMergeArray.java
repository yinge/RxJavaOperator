package com.yin.operators.operation.combination;

import com.yin.operators.operation.Operation;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/26
 * at 15:55
 * summary:组合多个被观察者一起发送数据，合并后 按时间线并行执行
 * !!!!!!发送的数量没有限制
 */
public class OperationMergeArray implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.mergeArray(
                Observable.intervalRange(1, 3, 1, 1, TimeUnit.SECONDS),
                Observable.intervalRange(4, 3, 2, 1, TimeUnit.SECONDS),
                Observable.intervalRange(7, 3, 3, 1, TimeUnit.SECONDS),
                Observable.intervalRange(10, 3, 4, 1, TimeUnit.SECONDS),
                Observable.intervalRange(13, 3, 5, 1, TimeUnit.SECONDS)
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
