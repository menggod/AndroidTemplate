package com.common.baselib.utils;

import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.common.baselib.R;
import com.common.baselib.base.BaseApplication;

import androidx.annotation.StringRes;


/**
 * @author menggod
 */
public class ToastUtil {

    private static Toast mToast;
    private static TextView mTvMessage;

    private ToastUtil() {

    }


    /**
     * miui部分版本会自带包名 用此方法解决该Bug
     */
    private static void createToast(Context context, CharSequence message, int duration) {
        mToast = new Toast(context);

        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.transient_notification, null);
        mTvMessage = v.findViewById(R.id.message);
        mTvMessage.setText(message);

        mToast.setView(v);
        mToast.setDuration(duration);
    }

    /**
     *  short Toast
     * @param message
     */
    public static void showShort(CharSequence message) {
        show(message, Toast.LENGTH_SHORT);
    }

    public static void showShort(@StringRes int message) {
        show(ResUtils.getString(message), Toast.LENGTH_SHORT);
    }


    /**
     * long Toast
     * @param message
     */
    public static void showLong(CharSequence message) {
        show(message, Toast.LENGTH_SHORT);
    }

    public static void showLong(@StringRes int message) {
        show(ResUtils.getString(message), Toast.LENGTH_SHORT);
    }


    public static void show(CharSequence message, int duration) {
        //缓存一个Toast 这种方式体验感觉最好，Toast消失的计时会从最后一次show之后才开始计算，还可以通过setText设置不同的内容
        //if (mToast == null)
        //  mToast = Toast.makeText(BaseApplication.getInstance().getApplicationContext(),message, duration);
        // else mToast.setText(message);
        Context context = BaseApplication.getInstance().getApplicationContext();
        //8.0对Toast做了改动
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createToast(context, message, duration);
        } else {
            if (mToast == null) {
                createToast(context, message, duration);
            } else if (mTvMessage != null) {
                mTvMessage.setText(message);
            } else {
                mToast = null;
                show(message, duration);
            }
        }

        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }


}
