package me.mrliu.utils;

/**
 * Created by LiuKang on 2017/1/6.
 */

/**
 * @author LiuKang
 *  转换相关工具类
 */
public class ConvertUtils {

    private ConvertUtils() {
        throw new UnsupportedOperationException("不能初始化ConvertUtils");
    }

    /**
     * dp转px
     * @param dpValue
     * @return
     */
    public static int dp2px(float dpValue) {
        final float scale = ContextUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     * @param pxValue
     * @return
     */
    public static int px2dp(float pxValue) {
        final float scale = ContextUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
