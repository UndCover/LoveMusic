package com.undcover.lovemusic.provider.parser;

import com.undcover.lovemusic.provider.bean.LyricsBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LrcParser {

    public static LyricsBean getCombineLyrics(String lrc, String lrcTrans) {
        if (lrc == null || lrc.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        String[] array = lrc.split("\\n");
        Map<Long, String> transMap = parseTransLrc(lrcTrans);

        List<LyricsBean.SingleLine> lrcList = new ArrayList<>();

        for (String line : array) {
            List<LyricsBean.SingleLine> lines = getLyrics(line, transMap);
            if (lines != null && lines.size() > 0)
                lrcList.addAll(lines);
        }

        Collections.sort(lrcList);

        LyricsBean lyricsBean = new LyricsBean();
        lyricsBean.setLyrics(lrcList);

        return lyricsBean;
    }

    public static List<LyricsBean.SingleLine> getLyrics(String line, Map<Long, String> lrcMap) {
        if (line == null || line.isEmpty()) {
            return null;
        }

        line = line.trim();

        List<LyricsBean.SingleLine> lines = new ArrayList<>();

        Matcher lineMatcher = Pattern.compile("((\\[\\d\\d:\\d\\d\\.\\d+\\])+)(.*)").matcher(line);
        if (!lineMatcher.matches()) {
            LyricsBean.SingleLine singleLine = new LyricsBean.SingleLine();
            singleLine.setInfo(true);
            singleLine.setPrefix(line);
            lines.add(singleLine);
            return lines;
        }

        String times = lineMatcher.group(1);
        String text = lineMatcher.group(3);

        // 针对多种时间指向的
        Matcher timeMatcher = Pattern.compile("\\[(\\d\\d):(\\d\\d)\\.(\\d+)\\]").matcher(times);
        while (timeMatcher.find()) {
            long min = Long.parseLong(timeMatcher.group(1));
            long sec = Long.parseLong(timeMatcher.group(2));
            String milStr = timeMatcher.group(3);
            long mil = Long.parseLong(timeMatcher.group(3));
            long time = min * 60000 + sec * 1000;
            if (milStr.length() == 2) {
                time += mil * 10;
            } else if (milStr.length() == 3) {
                time += mil;
            }

            String trans = null;
            if (lrcMap != null && lrcMap.size() > 0) {
                trans = lrcMap.get(time);
            }

            LyricsBean.SingleLine singleLine = new LyricsBean.SingleLine();
            singleLine.setTimeStamp(time);
            singleLine.setPrefix(timeMatcher.group());
            singleLine.setLrc(text);
            singleLine.setTranslation(trans);
            lines.add(singleLine);
        }

        return lines;
    }

    public static String parseRaw(String lrc, String lrcTrans) {
        if (lrc == null || lrc.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        String[] array = lrc.split("\\n");
        Map<Long, String> transMap = parseTransLrc(lrcTrans);

        for (String line : array) {
            sb.append(parseLineRaw(line, transMap));
            sb.append("\n");
        }

        return sb.toString();
    }

    public static String parseLineRaw(String line, Map<Long, String> lrcMap) {
        if (line == null || line.isEmpty()) {
            return "";
        }

        line = line.trim();
        Matcher lineMatcher = Pattern.compile("((\\[\\d\\d:\\d\\d\\.\\d+\\])+)(.+)").matcher(line);
        if (!lineMatcher.matches()) {
            return line;
        }

        String times = lineMatcher.group(1);
        String text = lineMatcher.group(3);

        // 针对多种时间指向的
        Matcher timeMatcher = Pattern.compile("\\[(\\d\\d):(\\d\\d)\\.(\\d+)\\]").matcher(times);
        while (timeMatcher.find()) {
            long min = Long.parseLong(timeMatcher.group(1));
            long sec = Long.parseLong(timeMatcher.group(2));
            String milStr = timeMatcher.group(3);
            long mil = Long.parseLong(timeMatcher.group(3));
            long time = min * 60000 + sec * 1000;
            if (milStr.length() == 2) {
                time += mil * 10;
            } else if (milStr.length() == 3) {
                time += mil;
            }

            String str = lrcMap.get(time);
            if (str == null) {
                str = "【】";
            } else {
                str = "【" + str + "】";
            }

            text += str;
        }

        return times + text;
    }

    public static Map<Long, String> parseTransLrc(String lrc) {
        if (lrc == null || lrc.isEmpty()) {
            return null;
        }
        Map<Long, String> lrcMap = new HashMap<>();

        String[] array = lrc.split("\\n");
        for (String line : array) {

            Map<Long, String> tempMap = parseTransLine(line);
            if (tempMap != null && tempMap.size() > 0) {
                lrcMap.putAll(tempMap);
            }
        }
        return lrcMap;
    }

    public static Map<Long, String> parseTransLine(String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }

        line = line.trim();
        Matcher lineMatcher = Pattern.compile("((\\[\\d\\d:\\d\\d\\.\\d+\\])+)(.+)").matcher(line);
        if (!lineMatcher.matches()) {
            return null;
        }

        String times = lineMatcher.group(1);
        String text = lineMatcher.group(3);
        Map<Long, String> lrcMap = new HashMap<>();

        // 针对多种时间指向的
        Matcher timeMatcher = Pattern.compile("\\[(\\d\\d):(\\d\\d)\\.(\\d+)\\]").matcher(times);
        while (timeMatcher.find()) {
            long min = Long.parseLong(timeMatcher.group(1));
            long sec = Long.parseLong(timeMatcher.group(2));
            String milStr = timeMatcher.group(3);
            long mil = Long.parseLong(timeMatcher.group(3));
            long time = min * 60000 + sec * 1000;
            if (milStr.length() == 2) {
                time += mil * 10;
            } else if (milStr.length() == 3) {
                time += mil;
            }

            lrcMap.put(time, text);
        }
        return lrcMap;
    }
}
