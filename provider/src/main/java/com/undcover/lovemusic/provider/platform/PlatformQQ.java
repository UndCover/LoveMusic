package com.undcover.lovemusic.provider.platform;

import com.google.gson.Gson;
import com.undcover.lovemusic.provider.ISongInfo;
import com.undcover.lovemusic.provider.LrcProvider;
import com.undcover.lovemusic.provider.bean.LrcBean;
import com.undcover.lovemusic.provider.bean.LrcQQ;
import com.undcover.lovemusic.provider.bean.SearchQQ;
import com.undcover.lovemusic.provider.bean.SongSimpleInfo;
import com.undcover.lovemusic.provider.http.Api;
import com.undcover.lovemusic.provider.parser.LrcParser;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class PlatformQQ {
    public static Observable<List<SongSimpleInfo>> searchList(@NonNull ISongInfo info) {
        return searchList(info.getTitle()).subscribeOn(Schedulers.io());
    }

    public static Observable<List<SongSimpleInfo>> searchList(String songName) {
        return search(songName)
                .map(search -> {
                    List<SongSimpleInfo> songs = new ArrayList<>();
                    for (SearchQQ.DataBean.SongBean.ListBean lb : search.getData().getSong().getList()) {
                        SongSimpleInfo item = new SongSimpleInfo();
                        item.setName(lb.getName());
                        item.setAlbum(lb.getAlbum().getName());
                        item.setArtist(lb.getSinger().get(0).getName());
                        item.setSongId(lb.getMid());
                        item.setSource(Api.SRC_QQ);
                        songs.add(item);
                    }
                    return songs;
                });
    }

    public static Observable<SearchQQ> search(String songName) {
        return LrcProvider.getInstance()
                .getService(RequestCollection.class)
                .searchQQ(songName);
    }

    public static void searchTest(String songName) {
        search(songName).subscribe(search -> System.out.println("searchTest"));
    }

    public static Observable<LrcBean> fetch(String songId) {
        if (songId == null) {
            return null;
        }
        return LrcProvider.getInstance()
                .getService(RequestCollection.class)
                .fetchQQ(songId)
                .map(responseBody -> {
                    String str = responseBody.string();
                    Gson gson = new Gson();
                    LrcQQ lrcQQ = gson.fromJson(str.substring(4, str.length() - 1), LrcQQ.class);

                    LrcBean lrcBean = new LrcBean();
                    lrcBean.setSource(Api.SRC_QQ);
                    lrcBean.setLrc(lrcQQ.getLyric());
                    lrcBean.setLrcTrans(lrcQQ.getTrans());
                    return lrcBean;
                });
    }

    public static Observable<LrcBean> fetch(@NonNull SongSimpleInfo info) {
        return fetch(info.getSongId()).subscribeOn(Schedulers.io());
    }
}
