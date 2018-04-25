package com.undcover.lovemusic.ui.presenter;

import com.undcover.lovemusic.base.BaseMvpPresenter;
import com.undcover.lovemusic.provider.platform.PlatformQQ;
import com.undcover.lovemusic.ui.model.LrcListViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class LrcListPresenter extends BaseMvpPresenter<LrcListViewModel> {
    @Override
    public LrcListViewModel getViewModelInstance() {
        return new LrcListViewModel();
    }

    public void getLrcList(String keyword) {
        PlatformQQ qq = new PlatformQQ();
        Disposable disposable = qq.searchList(keyword)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(songs -> {
                    mViewModel.setLrcListItem(songs);
                    ifViewAttached(it -> it.notifyDataChanged());
                });
    }

    public void getLrcList() {
        getLrcList(mViewModel.getKeyword());
    }

}
