package com.undcover.lovemusic.ui.model;

import android.databinding.Bindable;

import com.undcover.lovemusic.BR;
import com.undcover.lovemusic.base.BaseViewModel;
import com.undcover.lovemusic.provider.ISongInfo;

public class MediaInfoViewModel extends BaseViewModel implements ISongInfo {
    String name;
    String title;
    String album;
    String artist;
    String duration;
    String mime;
    String bitrate;
    String date;

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public void setAlbum(String album) {
        this.album = album;
        notifyPropertyChanged(BR.album);
    }

    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    public void setDuration(String duration) {
        this.duration = duration;
        notifyPropertyChanged(BR.duration);
    }

    public void setMime(String mime) {
        this.mime = mime;
        notifyPropertyChanged(BR.mime);
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
        notifyPropertyChanged(BR.bitrate);
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    @Override
    @Bindable
    public String getName() {
        return name;
    }

    @Override
    @Bindable
    public String getTitle() {
        return title;
    }

    @Override
    @Bindable
    public String getAlbum() {
        return album;
    }

    @Override
    @Bindable
    public String getArtist() {
        return artist;
    }

    @Override
    @Bindable
    public String getDuration() {
        return duration;
    }

    @Override
    @Bindable
    public String getMime() {
        return name;
    }

    @Override
    @Bindable
    public String getBitrate() {
        return bitrate;
    }

    @Override
    @Bindable
    public String getDate() {
        return date;
    }
}
