package com.undcover.lovemusic.ui.presenter;

import com.undcover.lovemusic.base.BaseMvpPresenter;
import com.undcover.lovemusic.ui.model.MainViewModel;

public class MainPresenter extends BaseMvpPresenter<MainViewModel> {
    public void sendAction() {
        int count = mViewModel.getCount();
        count++;
        mViewModel.setCount(count);
    }

    @Override
    public Class getViewModelClass() {
        return MainViewModel.class;
    }
}
