package com.jpush.jmessagefeedbackdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.jpush.jmessagefeedbackdemo.R;
import com.jpush.jmessagefeedbackdemo.ui.widget.LoginView;
import com.jpush.jmessagefeedbackdemo.util.LogUtils;


public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = LogUtils.makeLogTag(LoginActivity.class);

    public static final int REQUEST_CODE_REGISTER = 1;

    private LoginView mLoginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    protected void initView() {
        mLoginView = (LoginView) findViewById(R.id.ll_login);
        mLoginView.initialize();

        Button btnRegister = find(R.id.btn_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivityForResult(intent, REQUEST_CODE_REGISTER);
                break;
            default:
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_REGISTER) {
            if (resultCode == RESULT_OK) {
                String username = data.getStringExtra("username");
                String pwd = data.getStringExtra("password");
                mLoginView.setUsername(username);
                mLoginView.setPassword(pwd);
            }
        }
    }

}
