package com.undcover.lovemusic.provider.bean;

import java.util.List;

public class LyricsBean {

    List<SingleLine> lyrics;
    int source;

    public List<SingleLine> getLyrics() {
        return lyrics;
    }

    public void setLyrics(List<SingleLine> lyrics) {
        this.lyrics = lyrics;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lyrics.size(); i++) {
            sb.append(lyrics.get(i));
        }
        return sb.toString();
    }

    public static class SingleLine implements Comparable<SingleLine> {
        boolean isInfo = false;
        long timeStamp;
        String prefix;
        String lrc;
        String translation;

        public boolean isInfo() {
            return isInfo;
        }

        public void setInfo(boolean info) {
            isInfo = info;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getLrc() {
            return lrc;
        }

        public void setLrc(String lrc) {
            this.lrc = lrc;
        }

        public String getTranslation() {
            return translation;
        }

        public void setTranslation(String translation) {
            this.translation = translation;
        }

        @Override
        public String toString() {
            if (isInfo) {
                return prefix + "\n";
            }
            if (translation == null) {
                return prefix + lrc + "\n";
            }
            return prefix + lrc + "【" + getTranslation() + "】\n";
        }

        @Override
        public int compareTo(SingleLine singleLine) {
            if (singleLine == null) {
                return -1;
            }
            return (int) (timeStamp - singleLine.getTimeStamp());
        }
    }
}
