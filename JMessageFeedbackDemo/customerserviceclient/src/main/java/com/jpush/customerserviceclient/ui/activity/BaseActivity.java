package com.jpush.customerserviceclient.ui.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;

import com.jpush.customerserviceclient.R;
import com.jpush.customerserviceclient.util.LogUtils;

import cn.jpush.im.android.api.JMessageClient;

/**
 * Created by hevin on 16/5/17.
 */
public abstract class BaseActivity extends Activity implements Handler.Callback {
    private static final String TAG = LogUtils.makeLogTag(BaseActivity.class);

    protected Context mContext;
    protected Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mHandler = new Handler(this);
        // JMessage 注册事件回调，子类只需重写 onEvent 方法即可处理相应事件。
//        JMessageClient.registerEventReceiver(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initView();
    }

    protected abstract void initView();

    protected <T extends View> T find(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JMessageClient.unRegisterEventReceiver(this);
    }

    /**
     * 获取布局文件 ID。
     * @return 布局文件 ID。
     */
    protected int getContentViewId() {
        return R.layout.activity_base;
    }

    /**
     * 获取布局中 Fragment 的 ID。
     * @return 布局中 Fragment 的 ID。
     */
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }

    public void addFragment(Fragment fragment) {
        if (fragment != null) {
            String className = fragment.getClass().getSimpleName();
            getFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, className)
                    .addToBackStack(className)
                    .commitAllowingStateLoss();
        }
    }

    public void removeFragment() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (getFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
