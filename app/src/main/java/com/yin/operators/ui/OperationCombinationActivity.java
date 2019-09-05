package com.yin.operators.ui;

import android.view.View;

import com.yin.operators.BaseActivity;
import com.yin.operators.R;
import com.yin.operators.operation.combination.*;

/**
 * at 2019/4/25
 * at 13:59
 * summary:
 */
public class OperationCombinationActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_operation_combination;
    }

    public void back(View view) {
        finish();
    }

    public void operationConcat(View view) {
        operationTo(new OperationConcat());
    }

    public void operationConcatArray(View view) {
        new OperationConcatArray().createOperation().send(this);
    }

    public void operationMerge(View view) {
        new OperationMerge().createOperation().send(this);
    }

    public void operationMergeArray(View view) {
        new OperationMergeArray().createOperation().send(this);
    }

    public void operationConcatDelayError(View view) {
        new OperationConcatDelayError().createOperation().send(this);
    }

    public void operationMergeDelayError(View view) {
        new OperationMergeDelayError().createOperation().send(this);
    }

    public void operationZip(View view) {
        new OperationZip().createOperation().send(this);
    }

    public void operationCombineLatest(View view){
        new OperationCombineLatest().createOperation().send(this);
    }

    public void operationCombineLatestDelayError(View view) {
        new OperationCombineLatestDelayError().createOperation().send(this);
    }
}
