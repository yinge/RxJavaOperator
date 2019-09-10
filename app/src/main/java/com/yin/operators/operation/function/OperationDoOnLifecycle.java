package com.yin.operators.operation.function;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * at 2019/9/6
 * at 15:06
 * summary:① 在回调 onSubscribe 之前回调该方法的第一个参数的回调方法，可以使用该回调方法决定是否取消订阅
 * ② 当在 onNext() 方法进行取消订阅操作后，doOnDispose() 和 doOnLifecycle() 的Action，都会被回调
 * ③ 如果使用 doOnLifecycle 进行取消订阅 ，doOnDispose Action 和 doOnLifecycle Action 都没有被回调
 */
public class OperationDoOnLifecycle implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {

        boolean select = false;

        Observable.just(1, 2, 3)
                .doOnLifecycle(disposable -> {
                            if (select) {
                                disposable.dispose();
                            }
                        }
                        , () -> builder.append("doOnLifecycle--Action").append('\n'))
                .doOnDispose(() -> builder.append("doOnDispose").append('\n'))
                .subscribe(new Observer<Integer>() {
                    private Disposable d;

                    @Override
                    public void onSubscribe(Disposable d) {
                        builder.append(StringEnum.CONNECT_MESSAGE).append('\n');
                        this.d = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        builder.append(StringEnum.NEXT_MESSAGE + integer).append('\n');
                        if (!select) {
                            d.dispose();
                        }
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
