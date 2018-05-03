package com.undcover.lovemusic.provider;

import com.undcover.lovemusic.provider.bean.LrcBean;
import com.undcover.lovemusic.provider.bean.LyricsBean;
import com.undcover.lovemusic.provider.bean.SongSimpleInfo;
import com.undcover.lovemusic.provider.http.Api;
import com.undcover.lovemusic.provider.http.UrlHeaderInterceptor;
import com.undcover.lovemusic.provider.parser.LrcParser;
import com.undcover.lovemusic.provider.platform.Platform163;
import com.undcover.lovemusic.provider.platform.PlatformKugou;
import com.undcover.lovemusic.provider.platform.PlatformQQ;
import com.undcover.lovemusic.provider.platform.PlatformXiami;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LrcProvider {
    HttpLoggingInterceptor defInterceptor;     //主体日志
    OkHttpClient okHttpClient;         //Json
    Retrofit retrofit;
    public static HttpLoggingInterceptor loggingInterceptor;

    private LrcProvider() {
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

//        File cacheFile = new File("", "cache");
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new UrlHeaderInterceptor())
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(defInterceptor)
//                .cache(cache)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Api.URL_LRC_XIAMI)
                .build();
    }

    private static LrcProvider sLrcProvider;

    public static LrcProvider getInstance() {
        if (sLrcProvider == null) {
            synchronized (LrcProvider.class) {
                if (sLrcProvider == null) {
                    sLrcProvider = new LrcProvider();
                }
            }
        }
        return sLrcProvider;
    }

    public <T> T getService(Class<T> clazz) {
        return retrofit.create(clazz);
    }


    public Observable<List<SongSimpleInfo>> search(String keyword) {
        //todo 匹配策略
        return Observable.merge(PlatformQQ.searchList(keyword),
                Platform163.searchList(keyword),
                PlatformXiami.searchList(keyword))
                .subscribeOn(Schedulers.io());
    }

    public Observable<List<SongSimpleInfo>> search(@NonNull ISongInfo songInfo) {
        return Observable.merge(PlatformQQ.searchList(songInfo),
                Platform163.searchList(songInfo),
                PlatformXiami.searchList(songInfo),
                PlatformKugou.searchList(songInfo))
                .subscribeOn(Schedulers.io());
    }

    public Observable<LrcBean> fetch(SongSimpleInfo info) {
        if (info != null) {
            switch (info.getSource()) {
                case Api.SRC_163:
                    return Platform163.fetch(info);
                case Api.SRC_QQ:
                    return PlatformQQ.fetch(info);
                case Api.SRC_XIAMI:
                    return PlatformXiami.fetch(info);
                case Api.SRC_KUGOU:
                    return PlatformKugou.fetch(info);
            }
        }
        return null;
    }

    public Observable<LyricsBean> fetchLyrics(SongSimpleInfo info) {
        return fetch(info).map(lrcBean -> {
            LyricsBean lyricsBean = LrcParser.getCombineLyrics(lrcBean.getLrc(), lrcBean.getLrcTrans());
            lyricsBean.setSource(lrcBean.getSource());
            return lyricsBean;
        });
    }
}
