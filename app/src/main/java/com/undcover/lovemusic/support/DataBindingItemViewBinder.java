package com.undcover.lovemusic.support;

import android.databinding.ViewDataBinding;

public class DataBindingItemViewBinder {
    public interface OnBindItem {
        void onBind(ViewDataBinding binding, Object data, int position);
    }
}


