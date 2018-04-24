package com.undcover.lovemusic.ui.view;

import com.undcover.lovemusic.R;
import com.undcover.lovemusic.base.BaseActivity;
import com.undcover.lovemusic.databinding.ActivityMainBinding;
import com.undcover.lovemusic.ui.model.MainViewModel;
import com.undcover.lovemusic.ui.presenter.MainPresenter;

public class MainActivity extends BaseActivity {
    MainPresenter mPresenter;
    ActivityMainBinding mBinding;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindView() {
        super.bindView();
        mBinding = (ActivityMainBinding) baseDataBinding;
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void initChildData() {
        super.initChildData();
        mBinding.btnClick.setOnClickListener(view -> mPresenter.sendAction());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    @Override
    public <VM> void setViewModel(VM viewModel) {
        mBinding.setContent((MainViewModel) viewModel);
    }
}