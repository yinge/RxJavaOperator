package com.yin.operators.operation;

import android.content.Context;
import android.content.Intent;

import com.yin.operators.OperationResultActivity;

/**
 * at 2019/4/24
 * at 15:52
 * summary:
 */
public interface Operation {

    StringBuilder builder = new StringBuilder();

    default void send(Context context) {
        Intent intent = new Intent(context, OperationResultActivity.class);
        intent.putExtra("result", builder.toString());
        context.startActivity(intent);
        if (builder != null) {
            builder.setLength(0);
        }
    }

    String getTag();

    Operation createOperation();
}
