package com.jpush.customerserviceclient.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Created by hevin on 16/5/17.
 */
public class CommonUtils {

    /**
     * 隐藏软键盘。
     * @param activity 目标 Activity。
     */
    public static void hideSoftInput(Activity activity) {
        InputMethodManager manager = (InputMethodManager) activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE);
        if (activity.getWindow().getAttributes().softInputMode !=
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (activity.getCurrentFocus() != null) {
                manager.hideSoftInputFromWindow(
                        activity.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    /**
     * 处理 JMessage 事件状态码。
     * @param context Activity。
     * @param status 返回的状态码。
     */
    public static void handleResponseCode(Context context, int status) {
        String strResourceName = "error_" + status;
        int resourceId = context.getResources().getIdentifier(strResourceName,
                "string", context.getPackageName());
        String desc = context.getResources().getString(resourceId);

        if (!TextUtils.isEmpty(desc)) {
            // 可自行修改，做不同的操作。
            Toast.makeText(context, desc, Toast.LENGTH_LONG).show();
        }
    }
}
