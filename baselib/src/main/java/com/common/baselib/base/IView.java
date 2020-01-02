package com.common.baselib.base;

import com.common.baselib.net.NetCallback;

/**
 * @author yiche
 */

public interface IView<P> extends NetCallback {

    P bindPresent();
}
