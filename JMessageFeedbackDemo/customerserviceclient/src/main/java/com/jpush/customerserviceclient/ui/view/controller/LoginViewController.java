package com.jpush.customerserviceclient.ui.view.controller;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.jpush.customerserviceclient.R;
import com.jpush.customerserviceclient.ui.activity.MainActivity;
import com.jpush.customerserviceclient.ui.view.LoginView;
import com.jpush.customerserviceclient.util.CommonUtils;
import com.jpush.customerserviceclient.util.LogUtils;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;

/**
 * 登录界面控制器。
 * Created by hevin on 16/5/19.
 */
public class LoginViewController implements View.OnClickListener {
    private static final String TAG = LogUtils.makeLogTag(LoginViewController.class);

    private LoginView mLoginView;
    private Activity mLoginActivity;

    public LoginViewController(Activity loginActivity, LoginView loginView) {
        mLoginActivity = loginActivity;
        mLoginView = loginView;
        mLoginView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                LogUtils.LOGI(TAG, "logining...");
                String username = mLoginView.getUsername();
                String password = mLoginView.getPassword();
                login(username, password);
                break;
            default:
        }
    }

    private void login(String username, String pwd) {
        CommonUtils.hideSoftInput(mLoginActivity);    // 隐藏软键盘。

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(mLoginActivity, "用户名、密码不能为空。",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        JMessageClient.login(username, pwd, new BasicCallback() {
            @Override
            public void gotResult(int status, String desc) {
                if (status == 0) {  // 登录成功，进入主界面。
                    Intent intent = new Intent(mLoginActivity, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                            | Intent.FLAG_ACTIVITY_NEW_TASK);
                    mLoginActivity.startActivity(intent);
                } else {
                    // 根据返回码，输出错误日志。
                    CommonUtils.handleResponseCode(mLoginActivity, status);
                }
            }
        });
    }

}
