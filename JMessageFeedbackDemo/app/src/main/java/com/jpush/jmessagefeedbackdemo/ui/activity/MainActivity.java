package com.jpush.jmessagefeedbackdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.jpush.jmessagefeedbackdemo.R;


/**
 * 登录之后的主界面。
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        TextView tvCustomerService = find(R.id.tv_customerService);
        tvCustomerService.setOnClickListener(this);
    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_customerService:
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }
}
