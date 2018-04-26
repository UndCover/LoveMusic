package com.undcover.lovemusic.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.trello.rxlifecycle2.components.support.RxDialogFragment;
import com.undcover.lovemusic.SmartApp;
import com.undcover.lovemusic.util.SmartLog;
import com.undcover.lovemusic.util.UtilsScreen;

/**
 * Created by UndCover on 9/9/17.
 */

public abstract class SmartDialog<B extends ViewDataBinding> extends RxDialogFragment implements View.OnClickListener {
    protected String TAG = this.getClass().getSimpleName();

    public abstract int getLayoutId();

    private DialogConfig config;
    protected B mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (config != null) {
            getDialog().setCancelable(config.isCancelable);
            getDialog().setCanceledOnTouchOutside(config.isCanceledOnTouchOutside);
            if (config.isTransparent) {     //内部透明
                getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        }
        beforeBindView();
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        afterBindView();
        SmartLog.lc(TAG, "onCreateView");
        return mBinding.getRoot();
    }

    protected void beforeBindView() {
        if (config != null && config.isNoTitle) {
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
    }

    protected void afterBindView() {

    }

    public void setConfig(DialogConfig config) {
        this.config = config;
    }

    @Override
    public void onClick(View v) {
        if (config.clickListener != null) {
            config.clickListener.onClick(v);
        }
        dismiss();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (config != null) {
            if (config.mHeight == -1 || config.mWidth == -1) {
                return;
            }
            getDialog().getWindow().setLayout(config.mHeight, config.mWidth);
        }
        SmartLog.lc(TAG, "onResume");
    }

    public SmartDialog show() {
        if (config != null && config.mSupportFragmentManager != null) {
            show(config.mSupportFragmentManager, TAG);
            return this;
        } else throw new NullPointerException("FragmentManager is null !");
    }

    public static class DialogConfig {
        Context mContext;
        FragmentManager mSupportFragmentManager;
        boolean isNoTitle;
        boolean isTransparent;
        boolean isCancelable;
        boolean isCanceledOnTouchOutside;
        int mHeight = -1, mWidth = -1;
        View.OnClickListener clickListener;
    }

    public static class DialogBuilder {
        private final DialogConfig P;
//        private final T dialog;
//        public T create(){
//            dialog = T.instantiate(P.mContext,"sss");
//        }

        /**
         * return T extends SmartDialog
         *
         * @param tClass
         * @param <T>
         * @return
         * @throws InstantiationException
         * @throws IllegalAccessException
         * @throws java.lang.InstantiationException
         */
        public <T extends SmartDialog> T create(Class<T> tClass) {
            T instance = null;
            try {
                instance = tClass.newInstance();
                instance.setConfig(P);
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return instance;
        }

        public <T extends SmartDialog> T show(Class<T> tClass) {
            T instance = this.create(tClass);
            if (instance != null) {
                instance.show();
            }
            return instance;
        }

        public DialogBuilder(Context context) {
            P = new DialogConfig();
            P.mContext = context;
        }

        /**
         * 是否显示标题
         *
         * @param isNoTitle
         * @return
         */
        public DialogBuilder setNoTitle(boolean isNoTitle) {
            P.isNoTitle = isNoTitle;
            return this;
        }

        /**
         * 背景是否透明
         *
         * @param isTransparent
         * @return
         */
        public DialogBuilder setTransparent(boolean isTransparent) {
            P.isTransparent = isTransparent;
            return this;
        }

        /**
         * 是否可以取消
         *
         * @param isCancelable
         * @return
         */
        public DialogBuilder setCancelable(boolean isCancelable) {
            P.isCancelable = isCancelable;
            return this;
        }

        /**
         * 点击外部取消
         *
         * @param isCanceledOnTouchOutside
         * @return
         */
        public DialogBuilder setCanceledOnTouchOutside(boolean isCanceledOnTouchOutside) {
            P.isCanceledOnTouchOutside = isCanceledOnTouchOutside;
            return this;
        }

        /**
         * 设置FragmentManager
         *
         * @param frgManager
         * @return
         */
        public DialogBuilder setSupportFragmentManager(FragmentManager frgManager) {
            P.mSupportFragmentManager = frgManager;
            return this;
        }

        /**
         * 设置宽度dp值
         *
         * @param widthDip
         * @return
         */
        public DialogBuilder setWidthDip(float widthDip) {
            P.mWidth = UtilsScreen.dip2px(SmartApp.getApplication(), widthDip);
            return this;
        }

        /**
         * 设置高度dp值
         *
         * @param heightDip
         * @return
         */
        public DialogBuilder setHeightDip(float heightDip) {
            P.mHeight = UtilsScreen.dip2px(SmartApp.getApplication(), heightDip);
            return this;
        }

        /**
         * 设置宽度值
         *
         * @param width
         * @return
         */
        public DialogBuilder setWidth(int width) {
            P.mWidth = width;
            return this;
        }

        /**
         * 设置高度值
         *
         * @param height
         * @return
         */
        public DialogBuilder setHeight(int height) {
            P.mHeight = height;
            return this;
        }

        public DialogBuilder setListener(View.OnClickListener listener) {
            P.clickListener = listener;
            return this;
        }
    }
}
