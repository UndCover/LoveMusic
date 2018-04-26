package com.undcover.lovemusic.provider.bean;

import java.util.List;

public class SearchXiami {

    /**
     * state : 0
     * message :
     * request_id : 0ab51f3a15246571537432997e
     * data : {"songs":[{"song_id":3351902,"song_name":"MIND GAMES ","album_id":303113,"album_name":"MIND GAMES","album_logo":"http://pic.xiami.net/images/album/img7/7107/3031131394611553_1.jpg","artist_id":7107,"artist_name":"ZARD","artist_logo":"http://pic.xiami.net/images/artistlogo/44/14213915943344_1.jpg","listen_file":"","demo":0,"need_pay_flag":0,"lyric":"http://img.xiami.net/lyric/2/3351902_1480588804655_19.xlrc","is_play":0,"play_counts":0,"singer":""}],"total":8,"previous":0,"next":0}
     */

    private int state;
    private String message;
    private String request_id;
    private DataBean data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * songs : [{"song_id":3351902,"song_name":"MIND GAMES ","album_id":303113,"album_name":"MIND GAMES","album_logo":"http://pic.xiami.net/images/album/img7/7107/3031131394611553_1.jpg","artist_id":7107,"artist_name":"ZARD","artist_logo":"http://pic.xiami.net/images/artistlogo/44/14213915943344_1.jpg","listen_file":"","demo":0,"need_pay_flag":0,"lyric":"http://img.xiami.net/lyric/2/3351902_1480588804655_19.xlrc","is_play":0,"play_counts":0,"singer":""}]
         * total : 8
         * previous : 0
         * next : 0
         */

        private int total;
        private int previous;
        private int next;
        private List<SongsBean> songs;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPrevious() {
            return previous;
        }

        public void setPrevious(int previous) {
            this.previous = previous;
        }

        public int getNext() {
            return next;
        }

        public void setNext(int next) {
            this.next = next;
        }

        public List<SongsBean> getSongs() {
            return songs;
        }

        public void setSongs(List<SongsBean> songs) {
            this.songs = songs;
        }

        public static class SongsBean {
            /**
             * song_id : 3351902
             * song_name : MIND GAMES
             * album_id : 303113
             * album_name : MIND GAMES
             * album_logo : http://pic.xiami.net/images/album/img7/7107/3031131394611553_1.jpg
             * artist_id : 7107
             * artist_name : ZARD
             * artist_logo : http://pic.xiami.net/images/artistlogo/44/14213915943344_1.jpg
             * listen_file :
             * demo : 0
             * need_pay_flag : 0
             * lyric : http://img.xiami.net/lyric/2/3351902_1480588804655_19.xlrc
             * is_play : 0
             * play_counts : 0
             * singer :
             */

            private String song_id;
            private String song_name;
            private String album_id;
            private String album_name;
            private String album_logo;
            private String artist_id;
            private String artist_name;
            private String artist_logo;
            private String listen_file;
            private int demo;
            private int need_pay_flag;
            private String lyric;
            private int is_play;
            private int play_counts;
            private String singer;

            public String getSong_id() {
                return song_id;
            }

            public void setSong_id(String song_id) {
                this.song_id = song_id;
            }

            public String getSong_name() {
                return song_name;
            }

            public void setSong_name(String song_name) {
                this.song_name = song_name;
            }

            public String getAlbum_id() {
                return album_id;
            }

            public void setAlbum_id(String album_id) {
                this.album_id = album_id;
            }

            public String getAlbum_name() {
                return album_name;
            }

            public void setAlbum_name(String album_name) {
                this.album_name = album_name;
            }

            public String getAlbum_logo() {
                return album_logo;
            }

            public void setAlbum_logo(String album_logo) {
                this.album_logo = album_logo;
            }

            public String getArtist_id() {
                return artist_id;
            }

            public void setArtist_id(String artist_id) {
                this.artist_id = artist_id;
            }

            public String getArtist_name() {
                return artist_name;
            }

            public void setArtist_name(String artist_name) {
                this.artist_name = artist_name;
            }

            public String getArtist_logo() {
                return artist_logo;
            }

            public void setArtist_logo(String artist_logo) {
                this.artist_logo = artist_logo;
            }

            public String getListen_file() {
                return listen_file;
            }

            public void setListen_file(String listen_file) {
                this.listen_file = listen_file;
            }

            public int getDemo() {
                return demo;
            }

            public void setDemo(int demo) {
                this.demo = demo;
            }

            public int getNeed_pay_flag() {
                return need_pay_flag;
            }

            public void setNeed_pay_flag(int need_pay_flag) {
                this.need_pay_flag = need_pay_flag;
            }

            public String getLyric() {
                return lyric;
            }

            public void setLyric(String lyric) {
                this.lyric = lyric;
            }

            public int getIs_play() {
                return is_play;
            }

            public void setIs_play(int is_play) {
                this.is_play = is_play;
            }

            public int getPlay_counts() {
                return play_counts;
            }

            public void setPlay_counts(int play_counts) {
                this.play_counts = play_counts;
            }

            public String getSinger() {
                return singer;
            }

            public void setSinger(String singer) {
                this.singer = singer;
            }
        }
    }
}
