package com.undcover.lovemusic.base;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.undcover.lovemusic.util.SmartLog;

import io.reactivex.Emitter;
import io.reactivex.Observable;

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

    Emitter<Integer> emitter;
    Observable<Integer> observable = Observable.create(imEmitter -> this.emitter = imEmitter);

    public Observable<Integer> getEventStream() {
        return observable;
    }

    protected Emitter<Integer> getEmitter() {
        return emitter;
    }

    protected void sendNextAction(int action) {
        emitter.onNext(action);
    }

    protected void sendCompleteAction() {
        emitter.onComplete();
    }
}
