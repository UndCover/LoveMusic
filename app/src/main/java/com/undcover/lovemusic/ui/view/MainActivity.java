package com.undcover.lovemusic.ui.view;

import android.support.annotation.NonNull;

import com.undcover.lovemusic.R;
import com.undcover.lovemusic.base.BaseActivity;
import com.undcover.lovemusic.databinding.ActivityMainBinding;
import com.undcover.lovemusic.ui.model.MainViewModel;
import com.undcover.lovemusic.ui.presenter.MainPresenter;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainPresenter, MainViewModel> {

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initChildData() {
        super.initChildData();
        mBinding.btnTest.setOnClickListener(view -> getPresenter().sendAction());
        mBinding.btnNext.setOnClickListener(view -> jumpTo(LrcListActivity.class));
        mBinding.btnMedia.setOnClickListener(view -> jumpTo(MediaInfoActivity.class));
    }

    @Override
    public void setViewModel(MainViewModel viewModel) {
        mBinding.setViewModel(viewModel);
    }

//    @Override
//    public void notifyDataChanged() {
//
//    }
}