package me.mrliu.utils;

import android.content.Context;

/**
 * Created by LiuKang on 2017/1/5.
 */

/**
 * 上下文工具类
 */
public class ContextUtils {
    private static Context mContext;

    private ContextUtils(){
        throw new UnsupportedOperationException("不能初始化ContextUtils");
    }

    /**
     * 初始化上下文对象
     * @param context
     */
    public static void init(Context context) {
        ContextUtils.mContext = context.getApplicationContext();
    }

    /**
     * 获取上下文对象
     * @return
     */
    public static Context getContext() {
        if (mContext != null) {
            return mContext;
        }
        throw new NullPointerException("请先初始化ContextUtils");
    }

}
