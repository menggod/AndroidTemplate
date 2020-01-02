package com.common.baselib.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


/**
 * @author yiche
 */

public abstract class BaseFragment<P extends BasePresent> extends Fragment implements IView<P> {

    protected P mPresent;

    protected FragmentActivity mContext;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresent = bindPresent();
    }


    @Override
    public void onDestroy() {
        if (mPresent != null) {
            mPresent.onDestroy();
        }

        super.onDestroy();
    }

    @Override
    public abstract P bindPresent();

    @Override
    public boolean canReceive() {
        return getActivity() != null && !getActivity().isFinishing() && isAdded();
    }

}
