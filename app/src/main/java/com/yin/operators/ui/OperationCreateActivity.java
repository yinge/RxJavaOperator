package com.yin.operators.ui;

import android.view.View;

import com.yin.operators.BaseActivity;
import com.yin.operators.R;
import com.yin.operators.operation.create.*;

public class OperationCreateActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_operation_create;
    }

    public void operationCreate(View view) {
        operationTo(new OperationCreate());
    }

    public void operationJust(View view) {
        operationTo(new OperationJust());
    }

    public void operationFromArray(View view) {
        operationTo(new OperationFromArray());
    }

    public void operationFromCallable(View view) {
        operationTo(new OperationFromCallable());
    }

    public void operationFromIterable(View view) {
        operationTo(new OperationFromIterable());
    }

    public void operationEmpty(View view) {
        operationTo(new OperationEmpty());
    }

    public void operationError(View view) {
        operationTo(new OperationError());
    }

    public void operationNever(View view) {
        operationTo(new OperationNever());
    }

    public void operationDefer(View view) {
        operationTo(new OperationDefer());
    }

    public void operationTimer(View view) {
        operationTo(new OperationTimer());
    }

    public void operationInterval(View view) {
        operationTo(new OperationInterval());
    }

    public void operationIntervalRange(View view) {
        operationTo(new OperationIntervalRange());
    }

    public void operationRange(View view) {
        operationTo(new OperationRange());
    }

    public void operationRangeLong(View view) {
        operationTo(new OperationRangeLong());
    }

    public void back(View view) {
        finish();
    }

    public void operationFromFuture(View view) {
        operationTo(new OperationFuture());
    }
}
