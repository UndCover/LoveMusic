package com.undcover.lovemusic.base;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface BaseMvpView<VM> extends MvpView {
    void setViewModel(VM viewModel);

    /**
     * List数据变化
     */
    void notifyDataChanged();
}
