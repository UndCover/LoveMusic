package com.undcover.lovemusic.base;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.undcover.lovemusic.util.SmartLog;

public abstract class BaseMvpPresenter<VM extends BaseViewModel> extends MvpBasePresenter<BaseMvpView> {
    protected final String TAG = this.getClass().getSimpleName();
    protected VM mViewModel;

    public BaseMvpPresenter() {
        if (mViewModel == null) {
            mViewModel = getViewModelInstance();
        }
    }

    public abstract VM getViewModelInstance();

    /**
     * 绑定视图，设置ViewModel
     *
     * @param view
     */
    @Override
    public void attachView(BaseMvpView view) {
        super.attachView(view);
        if (mViewModel == null) {
            SmartLog.e(TAG, "ViewModel is null");
        }
        ifViewAttached(it -> it.setViewModel(mViewModel));
    }
}
