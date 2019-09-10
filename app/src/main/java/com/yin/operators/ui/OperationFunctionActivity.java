package com.yin.operators.ui;

import android.view.View;

import com.yin.operators.BaseActivity;
import com.yin.operators.R;
import com.yin.operators.operation.function.*;


/**
 * at 2019/4/25
 * at 14:01
 * summary:
 */
public class OperationFunctionActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_operation_function;
    }

    public void back(View view) {
        finish();
    }

    public void delay(View view) {
        operationTo(new OperationDelay());
    }

    public void doAfterNext(View view) {
        operationTo(new OperationDoAfterNext());
    }

    public void doOnNext(View view) {
        operationTo(new OperationDoOnNext());
    }

    public void doOnSubscribe(View view) {
        operationTo(new OperationDoOnSubscribe());
    }

    public void doOnDispose(View view) {
        operationTo(new OperationDoOnDispose());
    }

    public void doAfterTerminate(View view) {
        operationTo(new OperationDoAfterTerminate());
    }
    public void doFinally(View view) {
        operationTo(new OperationDoFinally());
    }

    public void doOnComplete(View view) {
        operationTo(new OperationDoOnComplete());
    }

    public void doOnEach(View view) {
        operationTo(new OperationDoOnEach());
    }

    public void doOnError(View view) {
        operationTo(new OperationDoOnError());
    }

    public void doOnLifecycle(View view) {
        operationTo(new OperationDoOnLifecycle());
    }

    public void doOnTerminate(View view) {
        operationTo(new OperationDoOnTerminate());
    }

    public void observeOn(View view) {
        operationTo(new OperationObserveOn());
    }

    public void onErrorResumeNext(View view) {
        operationTo(new OperationOnErrorResumeNext());
    }

    public void onErrorReturn(View view) {
        operationTo(new OperationOnErrorReturn());
    }

    public void onExceptionResumeNext(View view) {
        operationTo(new OperationOnExceptionResumeNext());
    }

    public void repeat(View view) {
        operationTo(new OperationRepeat());
    }

    public void repeatUntil(View view) {
        operationTo(new OperationRepeatUntil());
    }

    public void repeatWhen(View view) {
        operationTo(new OperationRepeatWhen());
    }

    public void retry(View view) {
        operationTo(new OperationRetry());
    }

    public void retryUntil(View view) {
        operationTo(new OperationRetryUntil());
    }

    public void retryWhen(View view) {
        operationTo(new OperationRetryWhen());
    }

    public void subscribeOn(View view) {
        operationTo(new OperationSubscribeOn());
    }
}
