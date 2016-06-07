package com.zheblog.weibogridview.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.Toast;

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
     * dp转换px
     *
     * @param context
     * @param value
     * @return
     */
    public static int dp2px(Context context, float value) {
        final float scale = context.getResources().getDisplayMetrics().densityDpi;
        return (int) (value * (scale / 160) + 0.5f);
    }

    /**
     * 弹出Toast
     *
     * @param context
     * @param str
     */
    public static void showToast(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

}
