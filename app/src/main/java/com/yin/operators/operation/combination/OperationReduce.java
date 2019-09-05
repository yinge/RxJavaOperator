package com.yin.operators.operation.combination;

import com.yin.operators.operation.Operation;

import io.reactivex.Observable;

/**
 * at 2019/9/5
 * at 14:01
 * summary:与 scan() 操作符的作用也是将发送数据以一定逻辑聚合起来，
 * 这两个的区别在于 scan() 每处理一次数据就会将事件发送给观察者，
 * 而 reduce() 会将所有数据聚合在一起才会发送事件给观察者
 */
public class OperationReduce implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3, 4)
                .reduce((integer, integer2) -> integer + integer2)
                .subscribe(integer -> builder.append(integer).append("\n"));
        return this;
    }
}
