package com.common.baselib.base;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author yiche
 */

public  abstract class BasePresent<V> implements IPresent {

    protected V mView;

    public BasePresent(V view) {
        mView = view;
    }

    private CompositeDisposable mDisposables = new CompositeDisposable();

    public void addDisposable(Disposable disposables) {
        if (disposables == null) {
            return;
        }
        mDisposables.add(disposables);
    }

    private void clearDisposables() {
        mDisposables.clear();
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onDestroy() {
        clearDisposables();
        mView = null;
    }

}
