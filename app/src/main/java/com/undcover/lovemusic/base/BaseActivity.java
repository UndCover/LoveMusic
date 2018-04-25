package com.undcover.lovemusic.base;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.undcover.lovemusic.SmartApp;
import com.undcover.lovemusic.support.AtyManager;
import com.undcover.lovemusic.support.Switcher;
import com.undcover.lovemusic.util.SmartLog;

/**
 * Created by UndCover on 10/31/17.
 */

public abstract class BaseActivity<B, P extends BaseMvpPresenter,VM> extends AppCompatActivity implements BaseMvpView<VM>{
    protected String TAG = this.getClass().getSimpleName();
    protected B mBinding;
    protected static SmartApp mApp;
    protected boolean isPortrait = true;
    protected P mPresenter;

    public abstract int getContentViewId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (isPortrait)
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AtyManager.getInstance().add(this);
        mApp = (SmartApp) getApplication();
        initController();
        SmartLog.lc(TAG, "onCreate");
    }

    /**
     * 用于设置初始化流程
     */
    protected void initController() {
        beforeSetContent();
        setContent();
        initPublicView();
        bindPresenter();
        initChildData();
        initFragment();
        initListView();
    }

    /**
     * 用于自定义View的binding方式
     */
    protected void setContent() {
        mBinding = (B) DataBindingUtil.setContentView(this, getContentViewId());
    }

    /**
     * 用于在ContentView设置之前操作
     */
    protected void beforeSetContent() {
        SmartLog.fw(TAG, "beforeSetContent");
    }

    protected void initPublicView() {
        SmartLog.fw(TAG, "initPublicView");
    }

    /**
     * 用于绑定视图
     */
    protected void bindPresenter() {
        SmartLog.fw(TAG, "bindPresenter");
        mPresenter = initPresenter();
        mPresenter.attachView(this);
    }

    public abstract P initPresenter();

    public P getPresenter() {
        return mPresenter;
    }

    /**
     * 设置视图初始数据
     */
    protected void initChildData() {
        SmartLog.fw(TAG, "initChildData");
    }

    protected void initFragment() {
        SmartLog.fw(TAG, "initFragment");
    }

    /**
     * 用于初始化列表
     */
    protected void initListView() {
        SmartLog.fw(TAG, "initListView");
    }


    public void jumpTo(Class clazz) {
        Intent intent = new Intent(this, clazz);
        jumpTo(clazz, intent);
    }

    public void jumpTo(Class clazz, Intent intent) {
        Switcher.switchToActivity(this, intent);
    }

    public void jumpToAndFinishItself(Class clazz) {
        Intent intent = new Intent(this, clazz);
        jumpToAndFinishItself(clazz, intent);
    }

    public void jumpToAndFinishItself(Class clazz, Intent intent) {
        Switcher.switchToActivityAndFinishItself(this, intent);
    }

    public void jumpSingleTop(Class clazz, Intent intent) {
        jumpToAndFinishItself(clazz, intent);
        AtyManager.getInstance().finishExcept(clazz);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SmartLog.lc(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        SmartLog.lc(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        SmartLog.lc(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        SmartLog.lc(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.destroy();
        }
        AtyManager.getInstance().finish(this);
        SmartLog.lc(TAG, "onDestroy");
    }
}
