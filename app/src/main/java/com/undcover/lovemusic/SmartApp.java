package com.undcover.lovemusic;

import android.app.Application;

import com.undcover.lovemusic.provider.Gate;
import com.undcover.lovemusic.support.AtyManager;
import com.undcover.lovemusic.util.SmartLog;
import com.undcover.lovemusic.util.UtilsJson;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by UndCover on 10/31/17.
 */

public class SmartApp extends Application {
    private static final String TAG = "SmartApp";
    private static Application sApplicationContext;

    public static Application getApplication() {
        return sApplicationContext;
    }

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

        Gate.loggingInterceptor = new HttpLoggingInterceptor((message) -> {
            String text;
            try {
                text = URLDecoder.decode(message, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                SmartLog.nw(TAG, message, true);
                return;
            }
            String str = UtilsJson.jsonFormat(text);
            SmartLog.nw(TAG, str);
        });
    }
}
