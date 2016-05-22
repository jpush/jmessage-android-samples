package com.jpush.customerserviceclient.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jpush.customerserviceclient.ui.activity.BaseActivity;

/**
 * Created by hevin on 16/5/20.
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;

    protected abstract void initView(View view, Bundle savedInstanceState);

    /**
     * 获取布局文件 ID。
     * @return Layout ID.
     */
    protected abstract int getLayoutId();

    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (BaseActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(getLayoutId(), container, false);
        initView(v, savedInstanceState);
        return v;
    }

    protected void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getHoldingActivity().addFragment(fragment);
        }
    }

    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }

}
