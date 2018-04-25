package com.undcover.lovemusic.ui.view;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.undcover.lovemusic.R;
import com.undcover.lovemusic.base.BaseActivity;
import com.undcover.lovemusic.databinding.ActivityLrcListBinding;
import com.undcover.lovemusic.ui.adapter.LrcListAdapter;
import com.undcover.lovemusic.ui.model.LrcListViewModel;
import com.undcover.lovemusic.ui.presenter.LrcListPresenter;
import com.undcover.lovemusic.util.SmartLog;

public class LrcListActivity extends BaseActivity<ActivityLrcListBinding, LrcListPresenter, LrcListViewModel> {
    @Override
    public int getContentViewId() {
        return R.layout.activity_lrc_list;
    }

    @Override
    public LrcListPresenter initPresenter() {
        return new LrcListPresenter();
    }

    @Override
    public void setViewModel(LrcListViewModel viewModel) {
        mBinding.setViewModel(viewModel);
        adapter = new LrcListAdapter();
        adapter.setItemClickListener((view, position) -> SmartLog.d(TAG, "position " + position));
        adapter.setDataList(viewModel.getLrcListItem());
    }

    @Override
    public void notifyDataChanged() {
        adapter.notifyDataSetChanged();
    }

    LrcListAdapter adapter;

    @Override
    protected void initChildData() {
        super.initChildData();
        mBinding.btnRequest.setOnClickListener(view -> mPresenter.getLrcList());
    }

    @Override
    protected void initListView() {
        super.initListView();
        mBinding.rvLrc.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        mBinding.rvLrc.setAdapter(adapter);
    }
}
