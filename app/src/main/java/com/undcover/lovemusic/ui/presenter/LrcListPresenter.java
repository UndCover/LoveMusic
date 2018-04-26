package com.undcover.lovemusic.ui.presenter;

import android.media.MediaMetadataRetriever;

import com.undcover.lovemusic.base.BaseMvpPresenter;
import com.undcover.lovemusic.provider.Gate;
import com.undcover.lovemusic.provider.bean.SongSimpleInfo;
import com.undcover.lovemusic.ui.model.LrcListViewModel;
import com.undcover.lovemusic.ui.model.MediaInfoViewModel;
import com.undcover.lovemusic.ui.view.LrcListActivity;
import com.undcover.lovemusic.util.SmartLog;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import static android.os.Environment.getExternalStorageDirectory;

public class LrcListPresenter extends BaseMvpPresenter<LrcListViewModel> {
    @Override
    public LrcListViewModel getViewModelInstance() {
        return new LrcListViewModel();
    }

    public void getLrcList(String keyword) {
        Gate.getInstance().search(keyword)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mViewModel.getLrcListItem().clear())
                .subscribe(songs -> {
                    mViewModel.addLrcListItem(songs);
                    getEmitter().onNext(LrcListActivity.ACT_DATA_REFRESH);
                });
    }

    public void getLrcList() {
        getLrcList(mViewModel.getKeyword());
    }

    public void searchLrc(String songName) {
        Gate.getInstance().search(getMediaInfo(songName))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mViewModel.getLrcListItem().clear())
                .subscribe(songs -> {
                    mViewModel.addLrcListItem(songs);
                    getEmitter().onNext(LrcListActivity.ACT_DATA_REFRESH);
                });
    }

    private MediaInfoViewModel getMediaInfo(String songName) {
        MediaInfoViewModel mediaInfo = new MediaInfoViewModel();
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        String str = getExternalStorageDirectory() + "/Download/" + songName;
        SmartLog.d(TAG, "str:" + str);
        try {
            mmr.setDataSource(str);
            String title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE); // api level 10, 即从GB2.3.3开始有此功能
            String album = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
            String mime = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE);
            String artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
            String duration = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION); // 播放时长单位为毫秒
            String bitrate = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_BITRATE); // 从api level 14才有，即从ICS4.0才有此功能
            String date = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DATE);

            mediaInfo.setName(songName);
            mediaInfo.setTitle(title);
            mediaInfo.setAlbum(album);
            mediaInfo.setArtist(artist);
            mediaInfo.setDuration(duration);
            mediaInfo.setMime(mime);
            mediaInfo.setBitrate(bitrate);
            mediaInfo.setDate(date);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        return mediaInfo;
    }

    public void fetchLrc(SongSimpleInfo lrc) {
        Disposable disposable = Gate.getInstance().fetch(lrc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(lrcBean -> {
                    if (lrcBean == null) {
                        return;
                    }
                    mViewModel.setLrc(lrcBean.getLrc());
                    mViewModel.setLrcTrans(lrcBean.getLrcTrans());
                    getEmitter().onNext(LrcListActivity.ACT_LRC_DIALOG);
                });
    }
}
