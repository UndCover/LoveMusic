package com.undcover.lovemusic.provider.bean;

import java.util.List;

public class SearchKugou {

    /**
     * info : OK
     * status : 200
     * proposal : 21400041
     * keyword : 誰かが待ってる
     * candidates : [{"soundname":"","krctype":2,"nickname":"","originame":"","accesskey":"06E5CCFCB8C2DF2929907F1D728E82D9","origiuid":"0","score":60,"hitlayer":7,"duration":235000,"sounduid":"0","song":"誰かが待ってる","uid":"486954092","transuid":"0","transname":"","adjust":0,"id":"21400041","singer":"ZARD (坂井泉水)","language":""}]
     */

    private String info;
    private int status;
    private String proposal;
    private String keyword;
    private List<CandidatesBean> candidates;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<CandidatesBean> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<CandidatesBean> candidates) {
        this.candidates = candidates;
    }

    public static class CandidatesBean {
        /**
         * soundname :
         * krctype : 2
         * nickname :
         * originame :
         * accesskey : 06E5CCFCB8C2DF2929907F1D728E82D9
         * origiuid : 0
         * score : 60
         * hitlayer : 7
         * duration : 235000
         * sounduid : 0
         * song : 誰かが待ってる
         * uid : 486954092
         * transuid : 0
         * transname :
         * adjust : 0
         * id : 21400041
         * singer : ZARD (坂井泉水)
         * language :
         */

        private String soundname;
        private int krctype;
        private String nickname;
        private String originame;
        private String accesskey;
        private String origiuid;
        private int score;
        private int hitlayer;
        private String duration;
        private String sounduid;
        private String song;
        private String uid;
        private String transuid;
        private String transname;
        private int adjust;
        private String id;
        private String singer;
        private String language;

        public String getSoundname() {
            return soundname;
        }

        public void setSoundname(String soundname) {
            this.soundname = soundname;
        }

        public int getKrctype() {
            return krctype;
        }

        public void setKrctype(int krctype) {
            this.krctype = krctype;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getOriginame() {
            return originame;
        }

        public void setOriginame(String originame) {
            this.originame = originame;
        }

        public String getAccesskey() {
            return accesskey;
        }

        public void setAccesskey(String accesskey) {
            this.accesskey = accesskey;
        }

        public String getOrigiuid() {
            return origiuid;
        }

        public void setOrigiuid(String origiuid) {
            this.origiuid = origiuid;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getHitlayer() {
            return hitlayer;
        }

        public void setHitlayer(int hitlayer) {
            this.hitlayer = hitlayer;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getSounduid() {
            return sounduid;
        }

        public void setSounduid(String sounduid) {
            this.sounduid = sounduid;
        }

        public String getSong() {
            return song;
        }

        public void setSong(String song) {
            this.song = song;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getTransuid() {
            return transuid;
        }

        public void setTransuid(String transuid) {
            this.transuid = transuid;
        }

        public String getTransname() {
            return transname;
        }

        public void setTransname(String transname) {
            this.transname = transname;
        }

        public int getAdjust() {
            return adjust;
        }

        public void setAdjust(int adjust) {
            this.adjust = adjust;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSinger() {
            return singer;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }
}
