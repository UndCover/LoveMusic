package com.undcover.lovemusic.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.undcover.lovemusic.R;

import java.util.List;

public abstract class BaseAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter implements View.OnClickListener {
    protected final String TAG = this.getClass().getSimpleName();
    protected LayoutInflater mInflater;
    protected List<T> itemList;
    protected B mBinding;
    protected ItemClickListener listener;
    int currentPos = -1;

    public BaseAdapter() {

    }

    public void setDataList(List<T> items) {
        this.itemList = items;
    }

    public void setItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public interface ItemClickListener {
        void onClick(View view, int position);
    }


    @Override
    public void onClick(View view) {
        Object tag = view.getTag(R.id.index_adapter);
        if (listener != null && tag != null) {
            int position = (int) tag;
            listener.onClick(view, position);
        }
    }

    public abstract int getLayoutId(int type);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(mInflater, getLayoutId(viewType), parent, false);
        ViewHolder holder = new ViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        mBinding = (B) mHolder.getBinding();
        bindView(mBinding, itemList.get(position), position);
        mBinding.executePendingBindings(); //此方法必须执行在UI线程，
    }

    /**
     * 用于设置item点击事件
     *
     * @param view
     * @param position
     */
    public void bindViewClick(View view, int position) {
        view.setTag(R.id.index_adapter, position);
        view.setOnClickListener(this);
    }

    public abstract void bindView(B binding, T itemData, int position);

    public List<T> getItemList() {
        return itemList;
    }

    public T getItem(int position) {
        if (itemList != null && position <= itemList.size()) {
            return itemList.get(position);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    public class ViewHolder<T> extends RecyclerView.ViewHolder {
        private T itemBinding;

        public T getBinding() {
            return itemBinding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.itemBinding = (T) binding;
        }

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            setBinding(binding);
        }
    }
}