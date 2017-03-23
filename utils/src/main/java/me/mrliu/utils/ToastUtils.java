package me.mrliu.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by LiuKang on 2017/1/5.
 */

public class ToastUtils {
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static Toast mToast;
    private static boolean isJumpWhenMore;

    private ToastUtils() {
        throw new UnsupportedOperationException("不能初始化ToastUtils");
    }

    /**
     * 初始化Toast
     * @param isJumpWhenMore 连续弹出Toast时，是弹出新Toast，还是只修改文本。
     *                       {@code true}：弹出新Toast
     *                       {@code false}：修改文本内容
     */
    public static void init(boolean isJumpWhenMore) {
        ToastUtils.isJumpWhenMore = isJumpWhenMore;
    }

    /**
     * 自定义显示位置地Toast
     * @param text
     * @param duration
     * @param gravity
     * @param xOffset
     * @param yOffset
     */
    public static void showToastGravity (CharSequence text, int duration, int gravity, int xOffset, int yOffset) {
        if (isJumpWhenMore) cancelToast();
        if (mToast == null) {
            mToast = Toast.makeText(ContextUtils.getContext(), text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.setGravity(gravity, xOffset, yOffset);
        mToast.show();
    }

    /**
     * 自定义显示位置地Toast
     * @param duration
     * @param gravity
     * @param xOffset
     * @param yOffset
     */
    public static void showToastGravity (int resId, int duration, int gravity, int xOffset, int yOffset) {
        if (isJumpWhenMore) cancelToast();
        if (mToast == null) {
            mToast = Toast.makeText(ContextUtils.getContext(), resId, duration);
        } else {
            mToast.setText(resId);
            mToast.setDuration(duration);
        }
        mToast.setGravity(gravity, xOffset, yOffset);
        mToast.show();
    }

    /**
     * 安全地显示短时Toast
     * @param resId
     */
    public static void showShortToastSafe(final int resId) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                showToast(resId, Toast.LENGTH_SHORT);
            }
        });
    }
    /**
     * 安全地显示短时Toast
     * @param text
     */
    public static void showShortToastSafe(final String text) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                showToast(text, Toast.LENGTH_SHORT);
            }
        });
    }

    /**
     * 安全地显示长时Toast
     * @param resId
     */
    public static void showLongToastSafe(final int resId) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                showToast(resId, Toast.LENGTH_LONG);
            }
        });
    }
    /**
     * 安全地显示长时Toast
     * @param text
     */
    public static void showLongToastSafe(final String text) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                showToast(text, Toast.LENGTH_LONG);
            }
        });
    }

    /**
     * 显示短时Toast
     * @param resId
     */
    public static void showShortToast(int resId) {
        showToast(resId, Toast.LENGTH_SHORT);
    }
    /**
     * 显示短时Toast
     * @param text
     */
    public static void showShortToast(CharSequence text) {
        showToast(text, Toast.LENGTH_SHORT);
    }

    /**
     * 显示长时Toast
     * @param resId
     */
    public static void showLongToast(int resId) {
        showToast(resId, Toast.LENGTH_LONG);
    }
    /**
     * 显示长时Toast
     * @param text
     */
    public static void showLongToast(CharSequence text) {
        showToast(text, Toast.LENGTH_LONG);
    }

    /**
     * 显示Toast
     * @param resId     资源id
     * @param duration  显示时长
     */
    private static void showToast(int resId, int duration) {
        showToast(ContextUtils.getContext().getResources().getText(resId).toString(), duration);
    }

    /**
     * 显示Toast
     * @param text      Toast显示的文本
     * @param duration  Toast显示时长
     */
    private static void showToast(CharSequence text, int duration) {
        if (isJumpWhenMore) cancelToast();
        if (mToast == null) {
            mToast = Toast.makeText(ContextUtils.getContext(), text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }

    /**
     * 取消Toast显示
     */
    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }
}
