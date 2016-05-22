package com.jpush;

import android.app.Application;

import com.jpush.customerserviceclient.util.LogUtils;

import cn.jpush.im.android.api.JMessageClient;

/**
 * Created by hevin on 16/5/17.
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.LOGI("AppApplication", "JMessage init");
        JMessageClient.init(getApplicationContext());
    }
}
