package com.jpush.jmessagefeedbackdemo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jpush.jmessagefeedbackdemo.R;
import com.jpush.jmessagefeedbackdemo.ui.widget.controller.EditTextController;
import com.jpush.jmessagefeedbackdemo.util.LogUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 常规登录界面，配合 layout/view_login.xml 使用，可自行扩展。
 * Created by hevin on 16/5/19.
 */
public class LoginView extends LinearLayout {
    private static final String TAG = LogUtils.makeLogTag(LoginView.class);

    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnLogin;

    private List<View> mClickableViews;  // 保存需要注册点击事件的视图。

    public LoginView(Context context) {
        super(context);
    }

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void initialize() {
        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);

        ImageView ivClearUsername = (ImageView) findViewById(R.id.iv_clearUsername);
        ImageView ivClearPassword = (ImageView) findViewById(R.id.iv_clearPassword);

        EditTextController etUsernameCon = new EditTextController(mEtUsername,
                ivClearUsername, null);
        EditTextController etPwdCon = new EditTextController(mEtPassword,
                ivClearPassword, null);

        mBtnLogin = (Button) findViewById(R.id.btn_login);

        // 添加需要注册点击事件的视图。
        mClickableViews = new ArrayList<>();
        mClickableViews.add(mBtnLogin);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        for (View v : mClickableViews) {
            v.setOnClickListener(onClickListener);
        }
    }

    public String getUsername() {
        if (mEtUsername != null) {
            return mEtUsername.getEditableText().toString();
        }
        return "";
    }

    public void setUsername(String username) {
        mEtUsername.setText(username);
    }

    public String getPassword() {
        if (mEtPassword != null) {
            return mEtPassword.getEditableText().toString();
        }
        return "";
    }

    public void setPassword(String password) {
        mEtPassword.setText(password);
    }

}
