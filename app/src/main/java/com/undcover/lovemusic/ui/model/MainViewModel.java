package com.undcover.lovemusic.ui.model;

import android.databinding.Bindable;

import com.undcover.lovemusic.BR;
import com.undcover.lovemusic.base.BaseViewModel;

public class MainViewModel extends BaseViewModel {
    private String lrc;
    private String lrcTrans;

    @Bindable
    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
        notifyPropertyChanged(BR.lrc);
    }

    @Bindable
    public String getLrcTrans() {
        return lrcTrans;
    }

    public void setLrcTrans(String lrcTrans) {
        this.lrcTrans = lrcTrans;
        notifyPropertyChanged(BR.lrcTrans);
    }
}
