package com.yin.operators.operation.transformation;

import com.yin.operators.operation.Operation;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/25
 * at 16:58
 * summary:
 */
public class OperationBuffer implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .buffer(3, 2)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        builder.append("我连上了。。。").append('\n');
                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        builder.append("缓存区里的事件数量---" + integers.size()).append('\n');
                        for (Integer integer : integers) {
                            builder.append("事件---"+integer).append('\n');
                        }
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
