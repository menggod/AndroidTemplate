package com.common.baselib.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 *  @author yiche
 */

public abstract class BaseActivity<P extends BasePresent> extends FragmentActivity implements IView<P> {

    protected P mPresent;

    private boolean mCloseDoubleClick = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        if (mPresent != null) {
            mPresent.onDestroy();
        }
        super.onDestroy();
    }

    @Override
    public abstract P bindPresent();

    @Override
    public boolean canReceive() {
        return !isFinishing();
    }


}
