package com.undcover.lovemusic.ui.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.IdRes;

import com.undcover.lovemusic.base.BaseAdapter;
import com.undcover.lovemusic.support.DataBindingItemViewBinder;
import com.undcover.lovemusic.support.Linker;

import java.util.List;

public class CommonAdapter<T, B extends ViewDataBinding> extends BaseAdapter<T, B> {

    @IdRes
    int resId = 0;
    DataBindingItemViewBinder.OnBindItem onBindItem;
    boolean multipleType = false;
    List<Linker> linkers;

    @Override
    public int getLayoutId(int type) {
        if (multipleType) {
            return linkers.get(type).getLayoutId();
        }
        return resId;
    }

    @Override
    public void bindView(B binding, T itemData, int position) {
        if (onBindItem != null) {
            onBindItem.onBind(binding, itemData, position);
        }
    }

    public void bindItemView(@IdRes int resId, DataBindingItemViewBinder.OnBindItem onBindItem) {
        this.resId = resId;
        this.onBindItem = onBindItem;
    }

    public void bindItemView(List<Linker> linkers, DataBindingItemViewBinder.OnBindItem onBindItem) {
        this.multipleType = true;
        this.linkers = linkers;
        this.onBindItem = onBindItem;
    }

    @Override
    public int getItemViewType(int position) {
        T item = getItem(position);
        if (multipleType && item != null) {
            for (int i = 0; i < linkers.size(); i++) {
                try {
                    if (linkers.get(i).getMatcher().apply(item)) {
                        return i;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}