package com.common.baselib.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

import com.common.baselib.base.BaseApplication;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;


/**
 * Created by sudi on 2018/6/28.
 * Email：sudi@yiche.com
 */
public class ResUtils {

    public static int getColor(@ColorRes int id) {
        try {
            return BaseApplication.getInstance().getResources().getColor(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Color.WHITE;
    }

    public static String getString(@StringRes int id) {
        try {
            return BaseApplication.getInstance().getResources().getString(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Drawable getDrawable(@DrawableRes int id) {
        try {
            return BaseApplication.getInstance().getResources().getDrawable(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ColorDrawable(Color.parseColor("#00000000"));
    }

    public static ColorStateList getColorStateList(int color) {
        return BaseApplication.getInstance().getResources().getColorStateList(color);
    }

    /**
     * dp2px
     *
     * @param context
     * @param dpVal
     * @return
     */
    public static int dp2px(Context context, float dpVal) {

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,

                dpVal, context.getResources().getDisplayMetrics());

    }


}
