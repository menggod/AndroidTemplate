package com.common.template.pages.splash;

import android.os.Bundle;

import com.common.baselib.base.BaseActivity;
import com.common.baselib.base.BasePresent;
import com.common.baselib.immersion.StatusBarUtils;
import com.common.template.R;

/**
 * 项目名称：Template
 *
 * @author menggod
 * @date 2020/01/06
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setTransparentNoStatus(this);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public BasePresent bindPresent() {
        return new SplashPresenter(this);
    }

    @Override
    public void onRequestSuccess(String tag, Object response) {
        super.onRequestSuccess(tag, response);
    }

    @Override
    public void onRequestFail(String tag, Throwable throwable) {
        super.onRequestFail(tag, throwable);
    }

}
