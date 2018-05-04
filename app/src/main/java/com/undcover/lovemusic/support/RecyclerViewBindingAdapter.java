package com.undcover.lovemusic.support;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.undcover.lovemusic.ui.adapter.CommonAdapter;

import java.util.Collections;
import java.util.List;

public class RecyclerViewBindingAdapter {

    @BindingAdapter({"itemLayout", "onBindItem"})
    public static void setAdapter(RecyclerView view, int resId, DataBindingItemViewBinder.OnBindItem onBindItem) {
        final CommonAdapter adapter = getOrCreateAdapter(view);
        adapter.bindItemView(resId, onBindItem);
    }

    private static CommonAdapter getOrCreateAdapter(RecyclerView view) {
        if (view.getAdapter() instanceof CommonAdapter) {
            return (CommonAdapter) view.getAdapter();
        } else {
            final CommonAdapter adapter = new CommonAdapter();
            view.setAdapter(adapter);
            return adapter;
        }
    }

    @BindingAdapter({"linker", "onBindItem"})
    public static void setAdapter(RecyclerView view, List<Linker> linkers, DataBindingItemViewBinder.OnBindItem onBindItem) {
        final CommonAdapter adapter = getOrCreateAdapter(view);
        adapter.bindItemView(linkers, onBindItem);
    }

    @BindingAdapter("dataList")
    public static void setDataList(RecyclerView view, List items) {
        final CommonAdapter adapter = getOrCreateAdapter(view);
        adapter.setDataList(items == null ? Collections.emptyList() : items);
        adapter.notifyDataSetChanged();
    }
}
