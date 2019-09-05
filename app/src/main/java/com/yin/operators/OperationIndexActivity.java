package com.yin.operators;

import android.view.View;

import com.yin.operators.ui.OperationCombinationActivity;
import com.yin.operators.ui.OperationConditionActivity;
import com.yin.operators.ui.OperationCreateActivity;
import com.yin.operators.ui.OperationFilterActivity;
import com.yin.operators.ui.OperationFunctionActivity;
import com.yin.operators.ui.OperationTransformationActivity;

/**
 * at 2019/4/25
 * at 10:05
 * summary:
 */
public class OperationIndexActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_operation_index;
    }

    public void operationCreate(View view) {
        go2(OperationCreateActivity.class);
    }

    public void operationTransformation(View view) {
        go2(OperationTransformationActivity.class);
    }

    public void operationCombination(View view) {
        go2(OperationCombinationActivity.class);
    }

    public void operationFunction(View view) {
        go2(OperationFunctionActivity.class);
    }

    public void operationFilter(View view) {
        go2(OperationFilterActivity.class);
    }

    public void operationCondition(View view) {
        go2(OperationConditionActivity.class);
    }
}
