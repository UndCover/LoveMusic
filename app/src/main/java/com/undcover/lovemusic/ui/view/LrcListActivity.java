package com.undcover.lovemusic.ui.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.undcover.lovemusic.R;
import com.undcover.lovemusic.base.BaseActivity;
import com.undcover.lovemusic.base.SmartDialog;
import com.undcover.lovemusic.databinding.ActivityLrcListBinding;
import com.undcover.lovemusic.support.MarginDecoration;
import com.undcover.lovemusic.ui.adapter.LrcListAdapter;
import com.undcover.lovemusic.ui.dialog.LrcDialog;
import com.undcover.lovemusic.ui.model.LrcListViewModel;
import com.undcover.lovemusic.ui.presenter.LrcListPresenter;

public class LrcListActivity extends BaseActivity<ActivityLrcListBinding, LrcListPresenter, LrcListViewModel> {
    @Override
    public int getContentViewId() {
        return R.layout.activity_lrc_list;
    }

    @NonNull
    @Override
    public LrcListPresenter createPresenter() {
        return new LrcListPresenter();
    }

    @Override
    public void setViewModel(LrcListViewModel viewModel) {
        mBinding.setViewModel(viewModel);

        adapter = new LrcListAdapter();
        adapter.setDataList(viewModel.getLrcListItem());
        adapter.setItemClickListener((view, position) -> getPresenter().fetchLrc(viewModel.getLrcListItem().get(position)));
    }

//    @Override
//    public void notifyDataChanged() {
//        adapter.notifyDataSetChanged();
//    }

    @Override
    protected void initChildData() {
        super.initChildData();
        mBinding.btnRequest.setOnClickListener(view -> getPresenter().getLrcList());
//        01 誰かが待ってる
//        mBinding.btnSearchLocal.setOnClickListener(view-> getPresenter().searchLrc("01.日常-田馥甄.mp3"));
//        mBinding.btnSearchLocal.setOnClickListener(view -> getPresenter().searchLrc("06.灵魂伴侣-田馥甄.mp3"));
//        mBinding.btnSearchLocal.setOnClickListener(view -> getPresenter().searchLrc("誰かが待ってる.mp3"));
        mBinding.btnSearchLocal.setOnClickListener(view -> getPresenter().searchLrc("zard.mp3"));
    }

    LrcListAdapter adapter;

    @Override
    protected void initListView() {
        super.initListView();
        mBinding.rvLrc.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        mBinding.rvLrc.addItemDecoration(new MarginDecoration(getApplicationContext(), 0, 1));
        mBinding.rvLrc.setAdapter(adapter);
    }

    public static final int ACT_DATA_REFRESH = 1;
    public static final int ACT_LRC_DIALOG = 2;

    @Override
    public void handleAction(int action) {
        switch (action) {
            case ACT_DATA_REFRESH:
                adapter.notifyDataSetChanged();
                break;
            case ACT_LRC_DIALOG:
                showDialog();
                break;
        }
    }

    LrcDialog lrcDialog;

    private void showDialog() {
        lrcDialog = new SmartDialog.DialogBuilder(this)
                .setNoTitle(true)
                .setCancelable(false)
                .setCanceledOnTouchOutside(false)
                .setSupportFragmentManager(getSupportFragmentManager())
                .create(LrcDialog.class);
        lrcDialog.setViewModel(mBinding.getViewModel()).show();
    }
}
