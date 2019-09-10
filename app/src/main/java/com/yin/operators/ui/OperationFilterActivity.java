package com.yin.operators.ui;

import android.view.View;

import com.yin.operators.BaseActivity;
import com.yin.operators.R;
import com.yin.operators.operation.filter.*;

/**
 * at 2019/4/25
 * at 14:02
 * summary:
 */
public class OperationFilterActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_operation_filter;
    }

    public void back(View view) {
        finish();
    }

    public void filter(View view) {
        operationTo(new OperationFilter());
    }

    public void ofType(View view) {
        operationTo(new OperationOfType());
    }

    public void skip(View view) {
        operationTo(new OperationSkip());
    }

    public void skipLast(View view) {
        operationTo(new OperationSkipLast());
    }

    public void distinct(View view) {
        operationTo(new OperationDistinct());
    }

    public void distinctUntilChanged(View view) {
        operationTo(new OperationDistinctUntilChanged());
    }

    public void take(View view) {
        operationTo(new OperationTake());
    }

    public void takeLast(View view) {
        operationTo(new OperationTakeLast());
    }

    public void debounce(View view) {
        operationTo(new OperationDebounce());
    }

    public void firstElement(View view) {
        operationTo(new OperationFirstElement());
    }

    public void lastElement(View view) {
        operationTo(new OperationLastElement());
    }

    public void elementAt(View view) {
        operationTo(new OperationElementAt());
    }

    public void elementAtOrError(View view) {
        operationTo(new OperationElementAtOrError());
    }
}
