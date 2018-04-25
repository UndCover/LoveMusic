package com.undcover.lovemusic.provider;

import com.undcover.lovemusic.provider.http.Api;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Gate {
    HttpLoggingInterceptor defInterceptor;     //主体日志
    OkHttpClient okHttpClient;         //Json
    Retrofit retrofit;
    public static HttpLoggingInterceptor loggingInterceptor;

    private Gate() {
        if (loggingInterceptor == null) {
            defInterceptor = new HttpLoggingInterceptor((message) -> {
                String text;
                try {
                    text = URLDecoder.decode(message, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return;
                }
                System.out.println(text);
            });
        } else {
            defInterceptor = loggingInterceptor;
        }

        defInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        File cacheFile = new File("", "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new UrlHeaderInterceptor())
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(defInterceptor)
                .cache(cache)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Api.URL_LRC_QQ)
                .build();
    }

    private static Gate sGate;

    public static Gate getInstance() {
        if (sGate == null) {
            synchronized (Gate.class) {
                if (sGate == null) {
                    sGate = new Gate();
                }
            }
        }
        return sGate;
    }

    public <T> T getService(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
