package com.undcover.lovemusic.provider.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchQQ {


    /**
     * code : 0
     * data : {"keyword":"MIND GAMES zard","song":{"curnum":7,"curpage":1,"list":[{"action":{"alert":11,"icons":4680,"msg":0,"switch":79635},"album":{"id":205311,"mid":"002I5ewH2gtM7o","name":"Mind Games","subtitle":"","title":"Mind Games","title_hilight":"<em>Mind<\/em> <em>Games<\/em>"},"chinesesinger":0,"desc":"","desc_hilight":"","docid":"10988460288436565098","file":{"media_mid":"002LliVp2D2Dyu","size_128":3865088,"size_320":0,"size_aac":0,"size_ape":0,"size_dts":0,"size_flac":0,"size_ogg":0,"size_try":0,"strMediaMid":"002LliVp2D2Dyu","try_begin":0,"try_end":0},"fnote":8013,"genre":0,"grp":[],"id":2565642,"index_album":1,"index_cd":0,"interval":241,"isonly":0,"ksong":{"id":1331387,"mid":"001xuVBg1mlZ3D"},"language":3,"lyric":"","lyric_hilight":"","mid":"002LliVp2D2Dyu","mv":{"id":0,"vid":""},"name":"Hypnosis","newStatus":2,"nt":1399644770,"pay":{"pay_down":0,"pay_month":0,"pay_play":0,"pay_status":0,"price_album":0,"price_track":0,"time_free":0},"pure":0,"singer":[{"id":5426,"mid":"004P4J0D0bAzf3","name":"ZARD","title":"ZARD (ザード)","title_hilight":"<em>ZARD<\/em> (ザード)","type":1,"uin":0}],"status":0,"subtitle":"","t":1,"tag":10,"time_public":"1999-04-07","title":"Hypnosis","title_hilight":"Hypnosis","type":0,"url":"http://stream10.qqmusic.qq.com/2565642.wma","ver":0,"volume":{"gain":-8.355999946594238,"lra":2.852999925613403,"peak":1}}],"totalnum":7}}
     * time : 1524550733
     */

    private int code;
    private DataBean data;
    private int time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static class DataBean {
        /**
         * keyword : MIND GAMES zard
         * song : {"curnum":7,"curpage":1,"list":[{"action":{"alert":11,"icons":4680,"msg":0,"switch":79635},"album":{"id":205311,"mid":"002I5ewH2gtM7o","name":"Mind Games","subtitle":"","title":"Mind Games","title_hilight":"<em>Mind<\/em> <em>Games<\/em>"},"chinesesinger":0,"desc":"","desc_hilight":"","docid":"10988460288436565098","file":{"media_mid":"002LliVp2D2Dyu","size_128":3865088,"size_320":0,"size_aac":0,"size_ape":0,"size_dts":0,"size_flac":0,"size_ogg":0,"size_try":0,"strMediaMid":"002LliVp2D2Dyu","try_begin":0,"try_end":0},"fnote":8013,"genre":0,"grp":[],"id":2565642,"index_album":1,"index_cd":0,"interval":241,"isonly":0,"ksong":{"id":1331387,"mid":"001xuVBg1mlZ3D"},"language":3,"lyric":"","lyric_hilight":"","mid":"002LliVp2D2Dyu","mv":{"id":0,"vid":""},"name":"Hypnosis","newStatus":2,"nt":1399644770,"pay":{"pay_down":0,"pay_month":0,"pay_play":0,"pay_status":0,"price_album":0,"price_track":0,"time_free":0},"pure":0,"singer":[{"id":5426,"mid":"004P4J0D0bAzf3","name":"ZARD","title":"ZARD (ザード)","title_hilight":"<em>ZARD<\/em> (ザード)","type":1,"uin":0}],"status":0,"subtitle":"","t":1,"tag":10,"time_public":"1999-04-07","title":"Hypnosis","title_hilight":"Hypnosis","type":0,"url":"http://stream10.qqmusic.qq.com/2565642.wma","ver":0,"volume":{"gain":-8.355999946594238,"lra":2.852999925613403,"peak":1}}],"totalnum":7}
         */

        private String keyword;
        private SongBean song;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public SongBean getSong() {
            return song;
        }

        public void setSong(SongBean song) {
            this.song = song;
        }

        public static class SongBean {
            /**
             * curnum : 7
             * curpage : 1
             * list : [{"action":{"alert":11,"icons":4680,"msg":0,"switch":79635},"album":{"id":205311,"mid":"002I5ewH2gtM7o","name":"Mind Games","subtitle":"","title":"Mind Games","title_hilight":"<em>Mind<\/em> <em>Games<\/em>"},"chinesesinger":0,"desc":"","desc_hilight":"","docid":"10988460288436565098","file":{"media_mid":"002LliVp2D2Dyu","size_128":3865088,"size_320":0,"size_aac":0,"size_ape":0,"size_dts":0,"size_flac":0,"size_ogg":0,"size_try":0,"strMediaMid":"002LliVp2D2Dyu","try_begin":0,"try_end":0},"fnote":8013,"genre":0,"grp":[],"id":2565642,"index_album":1,"index_cd":0,"interval":241,"isonly":0,"ksong":{"id":1331387,"mid":"001xuVBg1mlZ3D"},"language":3,"lyric":"","lyric_hilight":"","mid":"002LliVp2D2Dyu","mv":{"id":0,"vid":""},"name":"Hypnosis","newStatus":2,"nt":1399644770,"pay":{"pay_down":0,"pay_month":0,"pay_play":0,"pay_status":0,"price_album":0,"price_track":0,"time_free":0},"pure":0,"singer":[{"id":5426,"mid":"004P4J0D0bAzf3","name":"ZARD","title":"ZARD (ザード)","title_hilight":"<em>ZARD<\/em> (ザード)","type":1,"uin":0}],"status":0,"subtitle":"","t":1,"tag":10,"time_public":"1999-04-07","title":"Hypnosis","title_hilight":"Hypnosis","type":0,"url":"http://stream10.qqmusic.qq.com/2565642.wma","ver":0,"volume":{"gain":-8.355999946594238,"lra":2.852999925613403,"peak":1}}]
             * totalnum : 7
             */

            private int curnum;
            private int curpage;
            private int totalnum;
            private List<ListBean> list;

            public int getCurnum() {
                return curnum;
            }

            public void setCurnum(int curnum) {
                this.curnum = curnum;
            }

            public int getCurpage() {
                return curpage;
            }

            public void setCurpage(int curpage) {
                this.curpage = curpage;
            }

            public int getTotalnum() {
                return totalnum;
            }

            public void setTotalnum(int totalnum) {
                this.totalnum = totalnum;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * action : {"alert":11,"icons":4680,"msg":0,"switch":79635}
                 * album : {"id":205311,"mid":"002I5ewH2gtM7o","name":"Mind Games","subtitle":"","title":"Mind Games","title_hilight":"<em>Mind<\/em> <em>Games<\/em>"}
                 * chinesesinger : 0
                 * desc :
                 * desc_hilight :
                 * docid : 10988460288436565098
                 * file : {"media_mid":"002LliVp2D2Dyu","size_128":3865088,"size_320":0,"size_aac":0,"size_ape":0,"size_dts":0,"size_flac":0,"size_ogg":0,"size_try":0,"strMediaMid":"002LliVp2D2Dyu","try_begin":0,"try_end":0}
                 * fnote : 8013
                 * genre : 0
                 * grp : []
                 * id : 2565642
                 * index_album : 1
                 * index_cd : 0
                 * interval : 241
                 * isonly : 0
                 * ksong : {"id":1331387,"mid":"001xuVBg1mlZ3D"}
                 * language : 3
                 * lyric :
                 * lyric_hilight :
                 * mid : 002LliVp2D2Dyu
                 * mv : {"id":0,"vid":""}
                 * name : Hypnosis
                 * newStatus : 2
                 * nt : 1399644770
                 * pay : {"pay_down":0,"pay_month":0,"pay_play":0,"pay_status":0,"price_album":0,"price_track":0,"time_free":0}
                 * pure : 0
                 * singer : [{"id":5426,"mid":"004P4J0D0bAzf3","name":"ZARD","title":"ZARD (ザード)","title_hilight":"<em>ZARD<\/em> (ザード)","type":1,"uin":0}]
                 * status : 0
                 * subtitle :
                 * t : 1
                 * tag : 10
                 * time_public : 1999-04-07
                 * title : Hypnosis
                 * title_hilight : Hypnosis
                 * type : 0
                 * url : http://stream10.qqmusic.qq.com/2565642.wma
                 * ver : 0
                 * volume : {"gain":-8.355999946594238,"lra":2.852999925613403,"peak":1}
                 */

                private ActionBean action;
                private AlbumBean album;
                private int chinesesinger;
                private String desc;
                private String desc_hilight;
                private String docid;
                private FileBean file;
                private String fnote;
                private int genre;
                private String id;
                private int index_album;
                private int index_cd;
                private int interval;
                private int isonly;
                private KsongBean ksong;
                private int language;
                private String lyric;
                private String lyric_hilight;
                private String mid;
                private MvBean mv;
                private String name;
                private int newStatus;
                private String nt;
                private PayBean pay;
                private int pure;
                private int status;
                private String subtitle;
                private int t;
                private int tag;
                private String time_public;
                private String title;
                private String title_hilight;
                private int type;
                private String url;
                private int ver;
                private VolumeBean volume;
                private List<?> grp;
                private List<SingerBean> singer;

                public ActionBean getAction() {
                    return action;
                }

                public void setAction(ActionBean action) {
                    this.action = action;
                }

                public AlbumBean getAlbum() {
                    return album;
                }

                public void setAlbum(AlbumBean album) {
                    this.album = album;
                }

                public int getChinesesinger() {
                    return chinesesinger;
                }

                public void setChinesesinger(int chinesesinger) {
                    this.chinesesinger = chinesesinger;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDesc_hilight() {
                    return desc_hilight;
                }

                public void setDesc_hilight(String desc_hilight) {
                    this.desc_hilight = desc_hilight;
                }

                public String getDocid() {
                    return docid;
                }

                public void setDocid(String docid) {
                    this.docid = docid;
                }

                public FileBean getFile() {
                    return file;
                }

                public void setFile(FileBean file) {
                    this.file = file;
                }

                public String getFnote() {
                    return fnote;
                }

                public void setFnote(String fnote) {
                    this.fnote = fnote;
                }

                public int getGenre() {
                    return genre;
                }

                public void setGenre(int genre) {
                    this.genre = genre;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public int getIndex_album() {
                    return index_album;
                }

                public void setIndex_album(int index_album) {
                    this.index_album = index_album;
                }

                public int getIndex_cd() {
                    return index_cd;
                }

                public void setIndex_cd(int index_cd) {
                    this.index_cd = index_cd;
                }

                public int getInterval() {
                    return interval;
                }

                public void setInterval(int interval) {
                    this.interval = interval;
                }

                public int getIsonly() {
                    return isonly;
                }

                public void setIsonly(int isonly) {
                    this.isonly = isonly;
                }

                public KsongBean getKsong() {
                    return ksong;
                }

                public void setKsong(KsongBean ksong) {
                    this.ksong = ksong;
                }

                public int getLanguage() {
                    return language;
                }

                public void setLanguage(int language) {
                    this.language = language;
                }

                public String getLyric() {
                    return lyric;
                }

                public void setLyric(String lyric) {
                    this.lyric = lyric;
                }

                public String getLyric_hilight() {
                    return lyric_hilight;
                }

                public void setLyric_hilight(String lyric_hilight) {
                    this.lyric_hilight = lyric_hilight;
                }

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }

                public MvBean getMv() {
                    return mv;
                }

                public void setMv(MvBean mv) {
                    this.mv = mv;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getNewStatus() {
                    return newStatus;
                }

                public void setNewStatus(int newStatus) {
                    this.newStatus = newStatus;
                }

                public String getNt() {
                    return nt;
                }

                public void setNt(String nt) {
                    this.nt = nt;
                }

                public PayBean getPay() {
                    return pay;
                }

                public void setPay(PayBean pay) {
                    this.pay = pay;
                }

                public int getPure() {
                    return pure;
                }

                public void setPure(int pure) {
                    this.pure = pure;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getSubtitle() {
                    return subtitle;
                }

                public void setSubtitle(String subtitle) {
                    this.subtitle = subtitle;
                }

                public int getT() {
                    return t;
                }

                public void setT(int t) {
                    this.t = t;
                }

                public int getTag() {
                    return tag;
                }

                public void setTag(int tag) {
                    this.tag = tag;
                }

                public String getTime_public() {
                    return time_public;
                }

                public void setTime_public(String time_public) {
                    this.time_public = time_public;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTitle_hilight() {
                    return title_hilight;
                }

                public void setTitle_hilight(String title_hilight) {
                    this.title_hilight = title_hilight;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getVer() {
                    return ver;
                }

                public void setVer(int ver) {
                    this.ver = ver;
                }

                public VolumeBean getVolume() {
                    return volume;
                }

                public void setVolume(VolumeBean volume) {
                    this.volume = volume;
                }

                public List<?> getGrp() {
                    return grp;
                }

                public void setGrp(List<?> grp) {
                    this.grp = grp;
                }

                public List<SingerBean> getSinger() {
                    return singer;
                }

                public void setSinger(List<SingerBean> singer) {
                    this.singer = singer;
                }

                public static class ActionBean {
                    /**
                     * alert : 11
                     * icons : 4680
                     * msg : 0
                     * switch : 79635
                     */

                    private int alert;
                    private int icons;
                    private int msg;
                    @SerializedName("switch")
                    private int switchX;

                    public int getAlert() {
                        return alert;
                    }

                    public void setAlert(int alert) {
                        this.alert = alert;
                    }

                    public int getIcons() {
                        return icons;
                    }

                    public void setIcons(int icons) {
                        this.icons = icons;
                    }

                    public int getMsg() {
                        return msg;
                    }

                    public void setMsg(int msg) {
                        this.msg = msg;
                    }

                    public int getSwitchX() {
                        return switchX;
                    }

                    public void setSwitchX(int switchX) {
                        this.switchX = switchX;
                    }
                }

                public static class AlbumBean {
                    /**
                     * id : 205311
                     * mid : 002I5ewH2gtM7o
                     * name : Mind Games
                     * subtitle :
                     * title : Mind Games
                     * title_hilight : <em>Mind</em> <em>Games</em>
                     */

                    private String id;
                    private String mid;
                    private String name;
                    private String subtitle;
                    private String title;
                    private String title_hilight;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getMid() {
                        return mid;
                    }

                    public void setMid(String mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getSubtitle() {
                        return subtitle;
                    }

                    public void setSubtitle(String subtitle) {
                        this.subtitle = subtitle;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getTitle_hilight() {
                        return title_hilight;
                    }

                    public void setTitle_hilight(String title_hilight) {
                        this.title_hilight = title_hilight;
                    }
                }

                public static class FileBean {
                    /**
                     * media_mid : 002LliVp2D2Dyu
                     * size_128 : 3865088
                     * size_320 : 0
                     * size_aac : 0
                     * size_ape : 0
                     * size_dts : 0
                     * size_flac : 0
                     * size_ogg : 0
                     * size_try : 0
                     * strMediaMid : 002LliVp2D2Dyu
                     * try_begin : 0
                     * try_end : 0
                     */

                    private String media_mid;
                    private int size_128;
                    private int size_320;
                    private int size_aac;
                    private int size_ape;
                    private int size_dts;
                    private int size_flac;
                    private int size_ogg;
                    private int size_try;
                    private String strMediaMid;
                    private int try_begin;
                    private int try_end;

                    public String getMedia_mid() {
                        return media_mid;
                    }

                    public void setMedia_mid(String media_mid) {
                        this.media_mid = media_mid;
                    }

                    public int getSize_128() {
                        return size_128;
                    }

                    public void setSize_128(int size_128) {
                        this.size_128 = size_128;
                    }

                    public int getSize_320() {
                        return size_320;
                    }

                    public void setSize_320(int size_320) {
                        this.size_320 = size_320;
                    }

                    public int getSize_aac() {
                        return size_aac;
                    }

                    public void setSize_aac(int size_aac) {
                        this.size_aac = size_aac;
                    }

                    public int getSize_ape() {
                        return size_ape;
                    }

                    public void setSize_ape(int size_ape) {
                        this.size_ape = size_ape;
                    }

                    public int getSize_dts() {
                        return size_dts;
                    }

                    public void setSize_dts(int size_dts) {
                        this.size_dts = size_dts;
                    }

                    public int getSize_flac() {
                        return size_flac;
                    }

                    public void setSize_flac(int size_flac) {
                        this.size_flac = size_flac;
                    }

                    public int getSize_ogg() {
                        return size_ogg;
                    }

                    public void setSize_ogg(int size_ogg) {
                        this.size_ogg = size_ogg;
                    }

                    public int getSize_try() {
                        return size_try;
                    }

                    public void setSize_try(int size_try) {
                        this.size_try = size_try;
                    }

                    public String getStrMediaMid() {
                        return strMediaMid;
                    }

                    public void setStrMediaMid(String strMediaMid) {
                        this.strMediaMid = strMediaMid;
                    }

                    public int getTry_begin() {
                        return try_begin;
                    }

                    public void setTry_begin(int try_begin) {
                        this.try_begin = try_begin;
                    }

                    public int getTry_end() {
                        return try_end;
                    }

                    public void setTry_end(int try_end) {
                        this.try_end = try_end;
                    }
                }

                public static class KsongBean {
                    /**
                     * id : 1331387
                     * mid : 001xuVBg1mlZ3D
                     */

                    private String id;
                    private String mid;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getMid() {
                        return mid;
                    }

                    public void setMid(String mid) {
                        this.mid = mid;
                    }
                }

                public static class MvBean {
                    /**
                     * id : 0
                     * vid :
                     */

                    private int id;
                    private String vid;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getVid() {
                        return vid;
                    }

                    public void setVid(String vid) {
                        this.vid = vid;
                    }
                }

                public static class PayBean {
                    /**
                     * pay_down : 0
                     * pay_month : 0
                     * pay_play : 0
                     * pay_status : 0
                     * price_album : 0
                     * price_track : 0
                     * time_free : 0
                     */

                    private int pay_down;
                    private int pay_month;
                    private int pay_play;
                    private int pay_status;
                    private int price_album;
                    private int price_track;
                    private int time_free;

                    public int getPay_down() {
                        return pay_down;
                    }

                    public void setPay_down(int pay_down) {
                        this.pay_down = pay_down;
                    }

                    public int getPay_month() {
                        return pay_month;
                    }

                    public void setPay_month(int pay_month) {
                        this.pay_month = pay_month;
                    }

                    public int getPay_play() {
                        return pay_play;
                    }

                    public void setPay_play(int pay_play) {
                        this.pay_play = pay_play;
                    }

                    public int getPay_status() {
                        return pay_status;
                    }

                    public void setPay_status(int pay_status) {
                        this.pay_status = pay_status;
                    }

                    public int getPrice_album() {
                        return price_album;
                    }

                    public void setPrice_album(int price_album) {
                        this.price_album = price_album;
                    }

                    public int getPrice_track() {
                        return price_track;
                    }

                    public void setPrice_track(int price_track) {
                        this.price_track = price_track;
                    }

                    public int getTime_free() {
                        return time_free;
                    }

                    public void setTime_free(int time_free) {
                        this.time_free = time_free;
                    }
                }

                public static class VolumeBean {
                    /**
                     * gain : -8.355999946594238
                     * lra : 2.852999925613403
                     * peak : 1
                     */

                    private String gain;
                    private String lra;
                    private String peak;

                    public String getGain() {
                        return gain;
                    }

                    public void setGain(String gain) {
                        this.gain = gain;
                    }

                    public String getLra() {
                        return lra;
                    }

                    public void setLra(String lra) {
                        this.lra = lra;
                    }

                    public String getPeak() {
                        return peak;
                    }

                    public void setPeak(String peak) {
                        this.peak = peak;
                    }
                }

                public static class SingerBean {
                    /**
                     * id : 5426
                     * mid : 004P4J0D0bAzf3
                     * name : ZARD
                     * title : ZARD (ザード)
                     * title_hilight : <em>ZARD</em> (ザード)
                     * type : 1
                     * uin : 0
                     */

                    private String id;
                    private String mid;
                    private String name;
                    private String title;
                    private String title_hilight;
                    private int type;
                    private int uin;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getMid() {
                        return mid;
                    }

                    public void setMid(String mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getTitle_hilight() {
                        return title_hilight;
                    }

                    public void setTitle_hilight(String title_hilight) {
                        this.title_hilight = title_hilight;
                    }

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public int getUin() {
                        return uin;
                    }

                    public void setUin(int uin) {
                        this.uin = uin;
                    }
                }
            }
        }
    }
}
