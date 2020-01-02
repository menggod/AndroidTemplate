package com.common.baselib.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * ViewPager 懒加载 用途
 */
public abstract class LazyFragment extends BaseFragment {
    /**
     * 是否已经完成 周期
     */
    protected boolean isCreateView;
    /**
     * 是否已经显示给用户 {@link #setUserVisibleHint(boolean)}
     */
    protected boolean isVisible;
    /**
     * 是否初始化过data
     */
    protected boolean isInitData;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInVisible();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        if (isVisible) {
            initData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isCreateView = false;
    }


    /**
     * Fragment 显示给用户
     */
    protected void onVisible() {
        //加载数据
        if (isCreateView) {
            initData();
        }
    }

    /**
     * Fragment 隐藏
     */
    protected void onInVisible() {
    }

    protected void setViewCreated() {
        isCreateView = true;
    }


    private void initData() {
        if (isInitData) {
            restoreState();
        } else {
            isInitData = true;
            lazyInitData();
        }
    }

    protected abstract void initView();

    /**
     * 当界面第一次显示给用户的时候进行，懒加载显示数据</br>
     * 也就是说这里进行加载显示数据
     */
    protected abstract void lazyInitData();

    /**
     * 当界面第二次显示给用户的时候进行，恢复状态</br>
     * 这里用来恢复数据与view的关系
     */
    protected abstract void restoreState();

}
