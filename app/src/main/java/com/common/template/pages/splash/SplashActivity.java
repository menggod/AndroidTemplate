package com.common.template.pages.splash;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.common.baselib.base.BaseActivity;
import com.common.baselib.base.BasePresent;
import com.common.baselib.imageload.ImageLoader;
import com.common.baselib.immersion.StatusBarUtils;
import com.common.baselib.utils.ResUtils;
import com.common.template.MainActivity;
import com.common.template.R;
import com.common.template.pages.guide.GuideActivity;

/**
 * 项目名称：Template
 *
 * @author menggod
 * @date 2020/01/06
 */
public class SplashActivity extends BaseActivity {
    private TextView mTvSkip;
    private ImageView mIvSplash;

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setTransparentNoStatus(this);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        mTvSkip = findViewById(R.id.tv_splash_skip);
        mIvSplash = findViewById(R.id.iv_splash_img);
        startClock();
        ImageLoader.with(this)
                .load(ResUtils.getDrawable(R.drawable.uoko_guide_background_3))
                .into(mIvSplash);
        mTvSkip.setOnClickListener(view -> {
            processJump();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void startClock() {
        countDownTimer = new CountDownTimer(3200, 1000) {
            @Override
            public void onTick(long l) {
                mTvSkip.setText("跳过广告" + l / 1000 + "s");
            }

            @Override
            public void onFinish() {
                processJump();
            }
        };
        countDownTimer.start();
    }

    /**
     * 处理跳主页还是引导页
     */
    private void processJump() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (true) {
            GuideActivity.openActivity(this);
        } else {
            MainActivity.openActivity(this);
        }
        finish();
    }


    @Override
    public BasePresent bindPresent() {
        return new SplashPresenter(this);
    }

    /**
     * 处理请求广告
     *
     * @param tag
     * @param response
     */
    @Override
    public void onRequestSuccess(String tag, Object response) {
        super.onRequestSuccess(tag, response);
    }

    @Override
    public void onRequestFail(String tag, Throwable throwable) {
        super.onRequestFail(tag, throwable);
    }

}
