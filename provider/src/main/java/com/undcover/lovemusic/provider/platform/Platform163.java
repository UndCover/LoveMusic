package com.undcover.lovemusic.provider.platform;

import com.undcover.lovemusic.provider.Gate;
import com.undcover.lovemusic.provider.ISongInfo;
import com.undcover.lovemusic.provider.bean.Lrc163;
import com.undcover.lovemusic.provider.bean.LrcBean;
import com.undcover.lovemusic.provider.bean.SongSimpleInfo;
import com.undcover.lovemusic.provider.bean.Search163;
import com.undcover.lovemusic.provider.http.Api;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class Platform163 {
    public static Observable<List<SongSimpleInfo>> searchList(@NonNull ISongInfo info) {
        return searchList(info.getTitle()).subscribeOn(Schedulers.io());
    }

    public static Observable<List<SongSimpleInfo>> searchList(String songName) {
        return search(songName)
                .map(search -> {
                    List<SongSimpleInfo> songs = new ArrayList<>();
                    for (Search163.ResultBean.SongsBean sb : search.getResult().getSongs()) {
                        SongSimpleInfo item = new SongSimpleInfo();
                        item.setName(sb.getName());
                        item.setAlbum(sb.getAlbum().getName());
                        item.setArtist(sb.getArtists().get(0).getName());
                        item.setSongId(sb.getId());
                        item.setSource(Api.SRC_163);
                        songs.add(item);
                    }
                    return songs;
                });
    }


    public static Observable<Search163> search(String songName) {
        return Gate.getInstance()
                .getService(RequestCollection.class)
                .search163(songName);
    }

    public static void searchTest(String songName) {
        search(songName).subscribe(search -> System.out.println("searchTest"));
    }

    public static Observable<LrcBean> fetch(String songId) {
        return Gate.getInstance()
                .getService(RequestCollection.class)
                .fetch163(songId)
                .map(lrc163 -> {
                    LrcBean lrcBean = new LrcBean();
                    lrcBean.setSource(Api.SRC_163);
                    lrcBean.setLrc(lrc163.getLrc().getLyric());
                    lrcBean.setLrcTrans(lrc163.getTlyric().getLyric());
                    return lrcBean;
                });
    }

    public static void fetchTest(String songId) {
        fetch(songId).subscribe(jsonObject -> System.out.println("fetchTest"));
    }

    public static Observable<LrcBean> fetch(@NonNull SongSimpleInfo info) {
        return fetch(info.getSongId()).subscribeOn(Schedulers.io());
    }
}
