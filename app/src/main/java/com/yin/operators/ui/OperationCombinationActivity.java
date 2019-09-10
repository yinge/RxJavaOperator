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
        operationTo(new OperationConcatArray());
    }

    public void operationMerge(View view) {
        operationTo(new OperationMerge());
    }

    public void operationMergeArray(View view) {
        operationTo(new OperationMergeArray());
    }

    public void operationConcatDelayError(View view) {
        operationTo(new OperationConcatDelayError());
    }

    public void operationMergeDelayError(View view) {
        operationTo(new OperationMergeDelayError());
    }

    public void operationZip(View view) {
        operationTo(new OperationZip());
    }

    public void operationCombineLatest(View view){
        operationTo(new OperationCombineLatest());
    }

    public void operationCombineLatestDelayError(View view) {
        operationTo(new OperationCombineLatestDelayError());
    }

    public void operationReduce(View view) {
        operationTo(new OperationReduce());
    }

    public void operationCollect(View view) {
        operationTo(new OperationCollect());
    }

    public void operationStartWith(View view) {
        operationTo(new OperationStartWith());
    }

    public void operationStartWithArray(View view) {
        operationTo(new OperationStartWithArray());
    }

    public void operationCount(View view) {
        operationTo(new OperationCount());
    }
}
