package com.jpush.customerserviceclient.ui.activity;

import android.os.Bundle;
import android.os.Message;

import com.jpush.customerserviceclient.R;

/**
 * 登录后的主界面。
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {

    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }
}
