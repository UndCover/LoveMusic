package com.undcover.lovemusic.ui.presenter;

import com.undcover.lovemusic.base.BaseMvpPresenter;
import com.undcover.lovemusic.provider.platform.PlatformQQ;
import com.undcover.lovemusic.ui.model.MainViewModel;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BaseMvpPresenter<MainViewModel> {
    @Override
    public MainViewModel getViewModelInstance() {
        return new MainViewModel();
    }

    public void sendAction() {
//        PlatformQQ qq = new PlatformQQ();
//        Disposable disposable = qq.searchSingle("誰かが待ってる", 0)
//                .observeOn(Schedulers.io())
//                .flatMap(songs -> qq.fetch(songs.get(0)))
//                .observeOn(Schedulers.io())     //由于使用VM自动刷新UI,所以这里不需要切换线程来处理
//                .subscribe(lrcBean -> {
//                    mViewModel.setLrc(lrcQQ.getLyric());
//                    mViewModel.setLrcTrans(lrcQQ.getTrans());
//                });
    }
}
