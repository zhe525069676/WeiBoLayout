package com.zheblog.weibogridview.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by liuz on 16/6/3.
 */
public class Utils {

    /**
     * 获取屏幕的宽度
     *
     * @param activity
     * @return
     */
    public static int getScreenWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * px转换dp
     *
     * @param activity
     * @param value
     * @return
     */
    public static int px2dp(Context activity, float value) {
        final float scale = activity.getResources().getDisplayMetrics().densityDpi;
        return (int) ((value * 160) / scale + 0.5f);
    }

}
