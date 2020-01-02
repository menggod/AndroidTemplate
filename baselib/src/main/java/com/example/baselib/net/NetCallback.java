package com.example.baselib.net;

/**
 * @author yiche
 */
public interface NetCallback {

    void onRequestStart(String tag);

    void onRequestSuccess(String tag, Object response);

    void onRequestFail(String tag, Throwable throwable);

    boolean canReceive();
}
