package com.undcover.lovemusic;

import android.app.Application;
import android.content.Intent;

import com.undcover.lovemusic.support.AtyManager;
import com.undcover.lovemusic.util.SmartLog;

/**
 * Created by UndCover on 10/31/17.
 */

public class SmartApp extends Application {
    private static final String TAG = "SmartApp";
    private static Application sApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplicationContext = this;

        init();
    }

    @Override
    public void onTerminate() {
//        AtyManager.getInstance().finishAll();       //去除所有的Activity
        AtyManager.getInstance().exit(sApplicationContext); //
        super.onTerminate();
    }

    private void init() {
        int logLevel = SmartLog.LEVEL_V;
        SmartLog.getInstance().setLogLevel(logLevel)
                .setFilter(SmartLog.FILTER_NW
                        | SmartLog.FILTER_FW
                        | SmartLog.FILTER_AM
                        | SmartLog.FILTER_LC
                );
        SmartLog.TagConstant.TAG_APP = "LoveMusic";     //设置默认tag
    }
}
