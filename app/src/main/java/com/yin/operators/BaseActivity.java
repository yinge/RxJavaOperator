package com.yin.operators;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yin.operators.operation.Operation;

/**
 * at 2019/8/30
 * at 17:00
 * summary:
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    public abstract int getLayoutId();

    public void go2(Class<? extends Activity> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    public void operationTo(@NonNull Operation operation) {
        operation.createOperation().send(this);
    }
}
