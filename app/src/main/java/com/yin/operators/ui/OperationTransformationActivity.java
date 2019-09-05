package com.yin.operators.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yin.operators.R;
import com.yin.operators.operation.transformation.OperationBuffer;
import com.yin.operators.operation.transformation.OperationConcatMap;
import com.yin.operators.operation.transformation.OperationFlatMap;
import com.yin.operators.operation.transformation.OperationGroupBy;
import com.yin.operators.operation.transformation.OperationMap;
import com.yin.operators.operation.transformation.OperationScan;
import com.yin.operators.operation.transformation.OperationWindow;

/**
 * at 2019/4/25
 * at 13:55
 * summary:
 */
public class OperationTransformationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_transformation);
    }

    public void back(View view) {
        finish();
    }

    public void operationMap(View view) {
        new OperationMap().createOperation().send(this);
    }

    public void operationFlatMap(View view) {
        new OperationFlatMap().createOperation().send(this);
    }

    public void operationConcatMap(View view) {
        new OperationConcatMap().createOperation().send(this);
    }

    public void operationBuffer(View view) {
        new OperationBuffer().createOperation().send(this);
    }

    public void operationGroupBy(View view) {
        new OperationGroupBy().createOperation().send(this);
    }

    public void operationScan(View view) {
        new OperationScan().createOperation().send(this);
    }

    public void operationWindow(View view) {
        new OperationWindow().createOperation().send(this);
    }
}
