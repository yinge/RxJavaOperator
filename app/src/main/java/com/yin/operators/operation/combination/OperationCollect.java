package com.yin.operators.operation.combination;

import com.yin.operators.StringEnum;
import com.yin.operators.operation.Operation;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * at 2019/9/5
 * at 17:27
 * summary: 将数据收集到数据结构当中
 */
public class OperationCollect implements Operation {
    @Override
    public String getTag() {
        return null;
    }

    @Override
    public Operation createOperation() {
        Observable.just(1, 2, 3, 4)
                .collect(() -> new ArrayList<Integer>(),
                        (integers, integer) -> integers.add(integer))
                .subscribe(integers -> builder.append(StringEnum.NEXT_MESSAGE).append(integers).append('\n'));

        Observable.just(5, 6, 7, 8)
                .collect(() -> new MyObj(), (myObj, integer) -> myObj.setAge(integer))
                .subscribe((myObj, throwable) -> {
                    builder.append(StringEnum.NEXT_MESSAGE).append(myObj.getAge()).append('\n');
                    builder.append(StringEnum.ERROR_MESSAGE).append('\n');
                });
        return this;
    }

    class MyObj {
        private int age;

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }
}
