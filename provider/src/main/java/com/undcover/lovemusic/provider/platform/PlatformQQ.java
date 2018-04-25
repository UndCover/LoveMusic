package com.undcover.lovemusic.provider.platform;

import com.google.gson.Gson;
import com.undcover.lovemusic.provider.Gate;
import com.undcover.lovemusic.provider.bean.LrcListItem;
import com.undcover.lovemusic.provider.bean.LrcQQ;
import com.undcover.lovemusic.provider.bean.SearchQQ;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class PlatformQQ {
//    String songId;

    public Observable<List<LrcListItem>> searchList(String songName) {
        return Gate.getInstance()
                .getService(RequestCollection.class)
                .searchQQ(songName)
                .subscribeOn(Schedulers.io())
                .map(search -> {
                    List<LrcListItem> songs = new ArrayList<>();
                    for (SearchQQ.DataBean.SongBean.ListBean lb : search.getData().getSong().getList()) {
                        LrcListItem item = new LrcListItem();
                        item.setTitle(lb.getName());
                        item.setAlbum(lb.getAlbum().getName());
                        item.setArtist(lb.getSinger().get(0).getName());
                        item.setSongId(lb.getMid());
                        item.setSource(1);
                        songs.add(item);
                    }
                    return songs;
                });
    }

    public Observable<List<String>> search(String songName, int index) {
        return Gate.getInstance()
                .getService(RequestCollection.class)
                .searchQQ(songName)
                .subscribeOn(Schedulers.io())
                .map(search -> {
                    List<String> songs = new ArrayList<>();
                    for (SearchQQ.DataBean.SongBean.ListBean lb : search.getData().getSong().getList()) {
                        songs.add(lb.getMid());
                    }
                    return songs;
                });
//                .subscribe(search -> {
//                    if (0 == search.getCode()) {
//                        List<SearchQQ.DataBean.SongBean.ListBean> list = search.getData().getSong().getList();
//                        if (index <= list.size()) {
//                            songId = list.get(index).getMid();
//
//                            fetch();
//                        }
//                    }
//                });

    }

    public Observable<LrcQQ> fetch(String songId) {
        if (songId == null) {
            return null;
        }
        return Gate.getInstance()
                .getService(RequestCollection.class)
                .fetchQQ(songId)
                .subscribeOn(Schedulers.io())
                .map(responseBody -> {
                    String str = responseBody.string();
                    Gson gson = new Gson();
                    LrcQQ lrcQQ = gson.fromJson(str.substring(4, str.length() - 1), LrcQQ.class);
                    return lrcQQ;
                });
    }
}
