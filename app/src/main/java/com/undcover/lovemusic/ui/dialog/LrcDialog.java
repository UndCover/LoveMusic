package com.undcover.lovemusic.ui.dialog;

import com.undcover.lovemusic.R;
import com.undcover.lovemusic.base.BaseViewModel;
import com.undcover.lovemusic.base.SmartDialog;
import com.undcover.lovemusic.databinding.DialogTestBinding;
import com.undcover.lovemusic.ui.model.LrcListViewModel;

public class LrcDialog extends SmartDialog<DialogTestBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.dialog_test;
    }

    @Override
    protected void afterBindView() {
        mBinding.btnConfirm.setOnClickListener(this);
        if (viewModel != null) {
            mBinding.setViewModel(viewModel);
        }
    }

    LrcListViewModel viewModel;

    public LrcDialog setViewModel(LrcListViewModel viewModel) {
        this.viewModel = viewModel;
        return this;
    }
}
