package com.yin.operators.ui;

import android.view.View;

import com.yin.operators.BaseActivity;
import com.yin.operators.R;
import com.yin.operators.operation.transformation.*;

/**
 * at 2019/4/25
 * at 13:55
 * summary:
 */
public class OperationTransformationActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_operation_transformation;
    }

    public void back(View view) {
        finish();
    }

    public void operationMap(View view) {
        operationTo(new OperationMap());
    }

    public void operationFlatMap(View view) {
        operationTo(new OperationFlatMap());
    }

    public void operationConcatMap(View view) {
        operationTo(new OperationConcatMap());
    }

    public void operationBuffer(View view) {
        operationTo(new OperationBuffer());
    }

    public void operationGroupBy(View view) {
        operationTo(new OperationGroupBy());
    }

    public void operationScan(View view) {
        operationTo(new OperationScan());
    }

    public void operationWindow(View view) {
        operationTo(new OperationWindow());
    }
}
