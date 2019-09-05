package com.yin.operators.operation.transformation;

import com.yin.operators.operation.Operation;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * at 2019/4/25
 * at 16:43
 * summary:类似FlatMap操作符
 * 与FlatMap的 区别在于：拆分 & 重新合并生成的事件序列 的顺序 = 被观察者旧序列生产的顺序
 */
public class OperationConcatMap implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    list.add("事件--" + integer + "变换后的--" + i);
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(s -> builder.append(s).append('\n'));
        return this;
    }
}
