package com.common.baselib.imageload;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import androidx.fragment.app.Fragment;

public class ImageLoader {

    public static RequestManager with(Context context){
        return Glide.with(context);
    }

    public static RequestManager with(Fragment fragment){
        return Glide.with(fragment);
    }
}
