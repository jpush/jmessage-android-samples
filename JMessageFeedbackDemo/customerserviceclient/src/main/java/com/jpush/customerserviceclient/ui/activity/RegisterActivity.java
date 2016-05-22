package com.jpush.customerserviceclient.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jpush.customerserviceclient.R;
import com.jpush.customerserviceclient.ui.view.controller.EditTextController;
import com.jpush.customerserviceclient.util.CommonUtils;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText mEtUsername;
    private EditText mEtPassword;
    private ImageView mIvClearUsername;
    private ImageView mIvClearPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditTextController etUsernameCon = new EditTextController(
                mEtUsername, mIvClearUsername, null);
        EditTextController etPasswordCon = new EditTextController(
                mEtPassword, mIvClearPassword, null);
    }

    @Override
    protected void initView() {
        mEtUsername = find(R.id.et_username);
        mEtPassword = find(R.id.et_password);
        mIvClearUsername = find(R.id.iv_clearUsername);
        mIvClearPassword = find(R.id.iv_clearPassword);

        Button btnRegister = find(R.id.btn_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                String username = mEtUsername.getEditableText().toString();
                String password = mEtPassword.getEditableText().toString();
                register(username, password);
                break;
            default:
        }
    }

    private void register(final String username, final String password) {
        CommonUtils.hideSoftInput(this);

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(mContext, "用户名不能为空。", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isPasswordLegal(password)) {
            Toast.makeText(mContext, "密码不合法，密码长度必须在 4 至 128 个字节以内。",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        JMessageClient.register(username, password, new BasicCallback() {
            @Override
            public void gotResult(int responseCode, String desc) {
                if (responseCode == 0) {    // 说明成功注册。
                    Intent intent = new Intent();
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    setResult(LoginActivity.REQUEST_CODE_REGISTER, intent);
                    finish();
                } else {
                    CommonUtils.handleResponseCode(RegisterActivity.this, responseCode);
                }
            }
        });
    }

    /**
     * 本地判断密码是否合法。
     *
     * @return
     */
    private boolean isPasswordLegal(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            return false;
        } else if (pwd.length() > 128 || pwd.length() < 4) {
            return false;
        }
        return true;
    }
}
