package com.undcover.lovemusic.base;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface BaseMvpView extends MvpView {
    <VM> void setViewModel(VM viewModel);
}
