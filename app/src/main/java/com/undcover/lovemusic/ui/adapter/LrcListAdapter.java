package com.undcover.lovemusic.ui.adapter;

import com.undcover.lovemusic.R;
import com.undcover.lovemusic.base.BaseAdapter;
import com.undcover.lovemusic.databinding.ItemLrcListBinding;
import com.undcover.lovemusic.provider.bean.SongSimpleInfo;

public class LrcListAdapter extends BaseAdapter<SongSimpleInfo, ItemLrcListBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.item_lrc_list;
    }

    @Override
    public void bindView(int position) {
        super.bindView(position);
        mBinding.setViewModel(itemList.get(position));
        mBinding.getRoot().setOnClickListener(this);
    }
}