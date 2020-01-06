package com.common.template;

import android.os.Bundle;

import com.common.baselib.base.BaseActivity;
import com.common.baselib.base.BasePresent;
import com.common.baselib.utils.ActivityManager;
import com.common.baselib.utils.DoubleClickHelper;
import com.common.baselib.utils.ToastUtil;

/**
 * @author yiche
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public BasePresent bindPresent() {
        return null;
    }

    @Override
    public void onBackPressed() {
        if (DoubleClickHelper.isOnDoubleClick()) {
            //移动到上一个任务栈，避免侧滑引起的不良反应
            moveTaskToBack(false);
            postDelayed(new Runnable() {

                @Override
                public void run() {
                    // 进行内存优化，销毁掉所有的界面
                    ActivityManager.getInstance().finishAll();
                    // 销毁进程（请注意：调用此 API 可能导致当前 Activity onDestroy 方法无法正常回调）
                    // System.exit(0);
                }
            }, 300);
        } else {
            ToastUtil.showShort(R.string.home_exit_hint);
        }
    }
}
