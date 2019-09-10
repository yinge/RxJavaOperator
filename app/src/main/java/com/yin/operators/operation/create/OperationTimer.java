package com.yin.operators.operation.create;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/4/24
 * at 17:12
 * summary:延迟指定时间后，发送数值0
 */
public class OperationTimer implements Operation {
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public Operation createOperation() {
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                builder.append(StringEnum.CONNECT_MESSAGE).append('\n');
            }

            @Override
            public void onNext(Long aLong) {
                builder.append("这个值是定死的。。。").append(aLong).append('\n');
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
