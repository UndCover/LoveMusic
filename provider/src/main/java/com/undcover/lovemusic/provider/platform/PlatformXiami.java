package com.undcover.lovemusic.provider.platform;

import com.undcover.lovemusic.provider.LrcProvider;
import com.undcover.lovemusic.provider.ISongInfo;
import com.undcover.lovemusic.provider.bean.LrcBean;
import com.undcover.lovemusic.provider.bean.SongSimpleInfo;
import com.undcover.lovemusic.provider.bean.SearchXiami;
import com.undcover.lovemusic.provider.http.Api;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class PlatformXiami {

    public static Observable<List<SongSimpleInfo>> searchList(@NonNull ISongInfo info) {
        return searchList(info.getTitle()).subscribeOn(Schedulers.io());
    }

    public static Observable<List<SongSimpleInfo>> searchList(String songName) {
        return search(songName)
                .map(search -> {
                    List<SongSimpleInfo> songs = new ArrayList<>();
                    for (SearchXiami.DataBean.SongsBean sb : search.getData().getSongs()) {
                        SongSimpleInfo item = new SongSimpleInfo();
                        item.setName(sb.getSong_name());
                        item.setAlbum(sb.getAlbum_name());
                        item.setArtist(sb.getArtist_name());
                        item.setSongId(sb.getSong_id());
                        item.setLrc(sb.getLyric());
                        item.setSource(Api.SRC_XIAMI);
                        songs.add(item);
                    }
                    return songs;
                });
    }

    public static Observable<SearchXiami> search(String songName) {
        return LrcProvider.getInstance()
                .getService(RequestCollection.class)
                .searchXiami(songName);
    }

    public static void searchTest(String songName) {
        search(songName).subscribe(search -> System.out.println("searchTest"));
    }

    public static Observable<LrcBean> fetch(SongSimpleInfo info) {
        return Observable.just(info)
                .map(songInfo -> {
                    LrcBean lrcBean = new LrcBean();
                    lrcBean.setSource(Api.SRC_XIAMI);
                    lrcBean.setLrc(info.getLrc());
                    return lrcBean;
                }).subscribeOn(Schedulers.io());
    }
}
