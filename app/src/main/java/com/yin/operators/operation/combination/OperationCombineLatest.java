package com.yin.operators.operation.combination;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/9/4
 * at 16:29
 * summary:combineLatest() 的作用与 zip() 类似，
 * 但是 combineLatest() 发送事件的序列是与发送的时间线有关的，
 * 当 combineLatest() 中所有的 Observable 都发送了事件，
 * 只要其中有一个 Observable 发送事件，
 * 这个事件就会和其他 Observable 最近发送的事件结合起来发送
 */
public class OperationCombineLatest implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.combineLatest(
                Observable.intervalRange(1, 4, 1, 1, TimeUnit.SECONDS)
                        .map(aLong -> {
                            builder.append("A").append(aLong).append('\n');
                            return "A" + aLong;
                        }),
                Observable.intervalRange(1, 5, 2, 2, TimeUnit.SECONDS)
                        .map(aLong -> {
                            builder.append("B").append(aLong).append('\n');
                            return "B" + aLong;
                        }),
                (s, s1) -> s + s1
        ).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                builder.append(StringEnum.CONNECT_MESSAGE).append('\n');
            }

            @Override
            public void onNext(String s) {
                builder.append(StringEnum.NEXT_MESSAGE).append(s).append('\n');
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
