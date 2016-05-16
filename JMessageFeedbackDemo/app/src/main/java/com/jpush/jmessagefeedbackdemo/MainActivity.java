package com.jpush.jmessagefeedbackdemo;

import android.app.Activity;
import android.os.Bundle;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.im.android.api.JMessageClient;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JMessageClient.init(getApplicationContext());
        JPushInterface.setDebugMode(true);
    }
}
