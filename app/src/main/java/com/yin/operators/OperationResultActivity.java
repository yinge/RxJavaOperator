package com.yin.operators;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * at 2019/4/25
 * at 14:15
 * summary:
 */
public class OperationResultActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_result);
        result = findViewById(R.id.tv_result);
        result.setText(getIntent().getStringExtra("result"));
    }

    public void back(View view) {
        finish();
    }
}
