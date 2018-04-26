package com.undcover.lovemusic.ui.presenter;

import android.media.MediaMetadataRetriever;

import com.undcover.lovemusic.base.BaseMvpPresenter;
import com.undcover.lovemusic.ui.model.MediaInfoViewModel;
import com.undcover.lovemusic.util.SmartLog;

import static android.os.Environment.getExternalStorageDirectory;

public class MediaInfoPresenter extends BaseMvpPresenter<MediaInfoViewModel> {
    @Override
    public MediaInfoViewModel getViewModelInstance() {
        return new MediaInfoViewModel();
    }

    public void getMediaInfo(String songName) {
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

            mViewModel.setName(songName);
            mViewModel.setTitle(title);
            mViewModel.setAlbum(album);
            mViewModel.setArtist(artist);
            mViewModel.setDuration(duration);
            mViewModel.setMime(mime);
            mViewModel.setBitrate(bitrate);
            mViewModel.setDate(date);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
