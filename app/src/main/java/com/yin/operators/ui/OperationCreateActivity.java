package com.yin.operators.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yin.operators.R;
import com.yin.operators.operation.create.OperationCreate;
import com.yin.operators.operation.create.OperationDefer;
import com.yin.operators.operation.create.OperationEmpty;
import com.yin.operators.operation.create.OperationError;
import com.yin.operators.operation.create.OperationFromArray;
import com.yin.operators.operation.create.OperationFromCallable;
import com.yin.operators.operation.create.OperationFromIterable;
import com.yin.operators.operation.create.OperationFuture;
import com.yin.operators.operation.create.OperationInterval;
import com.yin.operators.operation.create.OperationIntervalRange;
import com.yin.operators.operation.create.OperationJust;
import com.yin.operators.operation.create.OperationNever;
import com.yin.operators.operation.create.OperationRange;
import com.yin.operators.operation.create.OperationRangeLong;
import com.yin.operators.operation.create.OperationTimer;

public class OperationCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_create);
    }

    public void operationCreate(View view) {
        new OperationCreate().createOperation().send(this);
    }

    public void operationJust(View view) {
        new OperationJust().createOperation();
    }

    public void operationFromArray(View view) {
        new OperationFromArray().createOperation();
    }

    public void operationFromCallable(View view) {
        new OperationFromCallable().createOperation();
    }

    public void operationFromIterable(View view) {
        new OperationFromIterable().createOperation();
    }

    public void operationEmpty(View view) {
        new OperationEmpty().createOperation();
    }

    public void operationError(View view) {
        new OperationError().createOperation();
    }

    public void operationNever(View view) {
        new OperationNever().createOperation();
    }

    public void operationDefer(View view) {
        new OperationDefer().createOperation();
    }

    public void operationTimer(View view) {
        new OperationTimer().createOperation();
    }

    public void operationInterval(View view) {
        new OperationInterval().createOperation();
    }

    public void operationIntervalRange(View view) {
        new OperationIntervalRange().createOperation();
    }

    public void operationRange(View view) {
        new OperationRange().createOperation();
    }

    public void operationRangeLong(View view) {
        new OperationRangeLong().createOperation();
    }

    public void back(View view) {
        finish();
    }

    public void operationFromFuture(View view) {
        new OperationFuture().createOperation();
    }
}
