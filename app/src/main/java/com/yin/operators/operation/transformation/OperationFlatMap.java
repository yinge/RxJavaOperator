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
 * at 16:41
 * summary:将被观察者发送的事件序列进行 拆分 & 单独转换，再合并成一个新的事件序列，最后再进行发送
 * 新合并生成的事件序列顺序是无序的，即 与旧序列发送事件的顺序无关
 */
public class OperationFlatMap implements Operation {
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
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
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
