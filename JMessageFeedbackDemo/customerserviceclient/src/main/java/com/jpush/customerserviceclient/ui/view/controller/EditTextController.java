package com.jpush.customerserviceclient.ui.view.controller;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

/**
 * 控制包含删除图标的 EditText。
 * Created by hevin on 16/5/18.
 */
public class EditTextController implements View.OnFocusChangeListener {
    /**
     * 输入框。
     */
    private EditText mEditText;

    /**
     * 清空输入栏图标。
     */
    private View mClearView;

    private OnEditTextFocusChangedListener mListener;

    protected boolean hasFocus = false;

    /**
     * 可以继续扩展当输入框焦点变化时的事件。
     */
    public interface OnEditTextFocusChangedListener {
        void onEditTextFocusChange(View v, boolean hasFocus);
    }

    public EditTextController(EditText editText, View clearView,
            OnEditTextFocusChangedListener listener) {
        mEditText = editText;
        mClearView = clearView;
        mListener = listener;
        mEditText.setOnFocusChangeListener(this);
        mClearView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText("");
                mClearView.setVisibility(View.GONE);
            }
        });
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start,
                    int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start,
                    int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    mClearView.setVisibility(View.GONE);
                } else {
                    if (hasFocus) {
                        mClearView.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    public OnEditTextFocusChangedListener getOnEditTextFocusChangedListener() {
        return mListener;
    }

    public void setOnEditTextFocusChangedListener(OnEditTextFocusChangedListener listener) {
        mListener = listener;
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        mClearView.setVisibility(hasFocus && (mEditText.length() > 0) ?
                View.VISIBLE : View.GONE);
        this.hasFocus = hasFocus;
        if (mListener != null) {
            mListener.onEditTextFocusChange(view, hasFocus);
        }
    }
}
