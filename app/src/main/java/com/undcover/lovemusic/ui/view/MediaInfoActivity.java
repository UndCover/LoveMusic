package com.undcover.lovemusic.ui.view;

import android.support.annotation.NonNull;
import android.util.Base64;

import com.undcover.lovemusic.R;
import com.undcover.lovemusic.base.BaseActivity;
import com.undcover.lovemusic.databinding.ActivityMediaInfoBinding;
import com.undcover.lovemusic.ui.model.MediaInfoViewModel;
import com.undcover.lovemusic.ui.presenter.MediaInfoPresenter;

public class MediaInfoActivity extends BaseActivity<ActivityMediaInfoBinding, MediaInfoPresenter, MediaInfoViewModel> {
    @Override
    public int getContentViewId() {
        return R.layout.activity_media_info;
    }

    @NonNull
    @Override
    public MediaInfoPresenter createPresenter() {
        return new MediaInfoPresenter();
    }


    @Override
    public void setViewModel(MediaInfoViewModel viewModel) {
        mBinding.setViewModel(viewModel);
    }

    @Override
    protected void initChildData() {
        super.initChildData();
//        mBinding.btnInfo.setOnClickListener(view -> getPresenter().getMediaInfo("誰かが待ってる.mp3"));
        mBinding.btnInfo.setOnClickListener(view -> getPresenter().getMediaInfo("zard.mp3"));
    }
}
