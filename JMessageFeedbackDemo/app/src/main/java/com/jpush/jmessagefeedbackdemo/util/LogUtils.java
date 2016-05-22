package com.jpush.jmessagefeedbackdemo.util;

import android.util.Log;

/**
 * 日志工具类。
 * Created by hevin on 16/5/17.
 */
public class LogUtils {
    private static final String LOG_PREFIX = "JMessage_";
    private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
    private static final int MAX_LOG_TAG_LENGTH = 23;

    public static boolean LOGGING_ENABLED = true;

    public static String makeLogTag(String str) {
        if (str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + str.substring(0,
                    MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH);
        }
        return LOG_PREFIX + str;
    }

    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }

    public static void LOGD(final String tag, String msg) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.DEBUG)) {
                Log.d(tag, msg);
            }
        }
    }

    public static void LOGD(final String tag, String msg, Throwable cause) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.DEBUG)) {
                Log.d(tag, msg, cause);
            }
        }
    }

    public static void LOGV(final String tag, String msg) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.VERBOSE)) {
                Log.v(tag, msg);
            }
        }
    }

    public static void LOGV(final String tag, String msg, Throwable cause) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.VERBOSE)) {
                Log.v(tag, msg, cause);
            }
        }
    }

    public static void LOGI(final String tag, String msg) {
        if (LOGGING_ENABLED) {
            Log.i(tag, msg);
        }
    }

    public static void LOGI(final String tag, String msg, Throwable cause) {
        if (LOGGING_ENABLED) {
            Log.i(tag, msg, cause);
        }
    }

    public static void LOGW(final String tag, String msg) {
        if (LOGGING_ENABLED) {
            Log.w(tag, msg);
        }
    }

    public static void LOGW(final String tag, String msg, Throwable cause) {
        if (LOGGING_ENABLED) {
            Log.w(tag, msg, cause);
        }
    }

    public static void LOGE(final String tag, String msg) {
        if (LOGGING_ENABLED) {
            Log.e(tag, msg);
        }
    }

    public static void LOGE(final String tag, String msg, Throwable cause) {
        if (LOGGING_ENABLED) {
            Log.e(tag, msg, cause);
        }
    }

    private LogUtils() {

    }

}
