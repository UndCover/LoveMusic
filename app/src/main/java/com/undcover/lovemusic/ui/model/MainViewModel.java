package com.undcover.lovemusic.ui.model;

import android.databinding.Bindable;

import com.undcover.lovemusic.BR;
import com.undcover.lovemusic.base.BaseViewModel;

public class MainViewModel extends BaseViewModel {
    private int count;

    @Bindable
    public int getCount() {
        return count;
    }

    @Bindable
    public String getCountDesc() {
        return "getCount: " + count;
    }

    public void setCount(int count) {
        this.count = count;
        notifyPropertyChanged(BR.count);
        notifyPropertyChanged(BR.countDesc);
    }
}
