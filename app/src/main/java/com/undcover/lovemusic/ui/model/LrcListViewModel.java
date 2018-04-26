package com.undcover.lovemusic.ui.model;

import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.undcover.lovemusic.base.BaseViewModel;
import com.undcover.lovemusic.provider.bean.SongSimpleInfo;

import java.util.ArrayList;
import java.util.List;

public class LrcListViewModel extends BaseViewModel {
    private List<SongSimpleInfo> lrcListItem;
    private String keyword = "fly me to the moon";
    private String lrc;
    private String lrcTrans;

    public List<SongSimpleInfo> getLrcListItem() {
        return lrcListItem;
    }

    public void setLrcListItem(List<SongSimpleInfo> lrcListItem) {
        this.lrcListItem.clear();
        this.lrcListItem.addAll(lrcListItem);
    }

    public void addLrcListItem(List<SongSimpleInfo> lrcListItem) {
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

    @Bindable
    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
        notifyPropertyChanged(BR.lrc);
    }

    public String getLrcTrans() {
        return lrcTrans;
    }

    public void setLrcTrans(String lrcTrans) {
        this.lrcTrans = lrcTrans;
    }
}
