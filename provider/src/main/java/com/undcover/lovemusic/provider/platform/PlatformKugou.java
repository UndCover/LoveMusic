package com.undcover.lovemusic.provider.platform;

import com.undcover.lovemusic.provider.ISongInfo;
import com.undcover.lovemusic.provider.LrcProvider;
import com.undcover.lovemusic.provider.bean.LrcBean;
import com.undcover.lovemusic.provider.bean.SearchKugou;
import com.undcover.lovemusic.provider.bean.SongSimpleInfo;
import com.undcover.lovemusic.provider.http.Api;
import com.undcover.lovemusic.provider.util.Base64;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class PlatformKugou {

    public static Observable<List<SongSimpleInfo>> searchList(@NonNull ISongInfo info) {
        return searchList(info.getTitle(), info.getDuration()).subscribeOn(Schedulers.io());
    }

    public static Observable<List<SongSimpleInfo>> searchList(String songName, String duration) {
        return search(songName, duration)
                .map(search -> {
                    List<SongSimpleInfo> songs = new ArrayList<>();
                    for (SearchKugou.CandidatesBean cb : search.getCandidates()) {
                        SongSimpleInfo item = new SongSimpleInfo();
                        item.setName(cb.getSong());
                        item.setAlbum("未知");
                        item.setArtist(cb.getSinger());
                        item.setSongId(cb.getId());
                        item.setToken(cb.getAccesskey());
                        item.setSource(Api.SRC_KUGOU);
                        songs.add(item);
                    }
                    return songs;
                });
    }

    public static Observable<SearchKugou> search(String songName, String duration) {
        return LrcProvider.getInstance()
                .getService(RequestCollection.class)
                .searchKugou(songName, duration);
    }

    public static void searchTest(String songName, String duration) {
        search(songName, duration).subscribe(search -> System.out.println("searchTest"));
    }

    public static Observable<LrcBean> fetch(SongSimpleInfo info) {
        return LrcProvider.getInstance()
                .getService(RequestCollection.class)
                .fetchKugou(info.getSongId(), info.getToken())
                .map(lrcKugou -> {
                    LrcBean lrcBean = new LrcBean();
                    lrcBean.setSource(Api.SRC_KUGOU);
                    lrcBean.setLrc(Base64.decode(lrcKugou.getContent()));
                    lrcBean.setLrcTrans("");
                    return lrcBean;
                }).subscribeOn(Schedulers.io());
    }
}
