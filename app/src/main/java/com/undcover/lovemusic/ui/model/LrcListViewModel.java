package com.undcover.lovemusic.ui.model;

import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.undcover.lovemusic.base.BaseViewModel;
import com.undcover.lovemusic.provider.bean.LrcListItem;

import java.util.ArrayList;
import java.util.List;

public class LrcListViewModel extends BaseViewModel {
    private List<LrcListItem> lrcListItem;
    private String keyword = "fly me to the moon";

    public List<LrcListItem> getLrcListItem() {
        return lrcListItem;
    }

    public void setLrcListItem(List<LrcListItem> lrcListItem) {
        this.lrcListItem.clear();
        this.lrcListItem.addAll(lrcListItem);
    }

    public LrcListViewModel() {
        lrcListItem = new ArrayList<>();
    }

    @Bindable
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
        notifyPropertyChanged(BR.keyword);
    }
}
