package com.common.baselib.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import com.common.baselib.R;
import com.common.baselib.immersion.StatusBarUtils;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * @author yiche
 */

public abstract class BaseActivity<P extends BasePresent> extends FragmentActivity implements IView<P> {

    protected P mPresent;

    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    public final Object mHandlerToken = hashCode();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.colorPrimaryDark));
        mPresent = bindPresent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresent != null) {
            mPresent.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresent != null) {
            mPresent.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        // 移除和这个 Activity 相关的消息回调
        HANDLER.removeCallbacksAndMessages(mHandlerToken);
        if (mPresent != null) {
            mPresent.onDestroy();
        }
        super.onDestroy();
    }

    /**
     * 如果当前的 Activity（singleTop 启动模式） 被复用时会回调
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // 设置为当前的 Intent，避免 Activity 被杀死后重启 Intent 还是最原先的那个
        setIntent(intent);
    }


    @Override
    public abstract P bindPresent();

    @Override
    public boolean canReceive() {
        return !isFinishing();
    }


    @Override
    public void onRequestStart(String tag) {

    }

    @Override
    public void onRequestSuccess(String tag, Object response) {

    }

    @Override
    public void onRequestFail(String tag, Throwable throwable) {

    }

    /**
     * 延迟执行
     */
    public final boolean post(Runnable r) {
        return postDelayed(r, 0);
    }

    /**
     * 延迟一段时间执行
     */
    public final boolean postDelayed(Runnable r, long delayMillis) {
        if (delayMillis < 0) {
            delayMillis = 0;
        }
        return postAtTime(r, SystemClock.uptimeMillis() + delayMillis);
    }

    /**
     * 在指定的时间执行
     */
    public final boolean postAtTime(Runnable r, long uptimeMillis) {
        // 发送和这个 Activity 相关的消息回调
        return HANDLER.postAtTime(r, mHandlerToken, uptimeMillis);
    }

}
