package com.vovk.Music_Cloud.ParseSoundInfo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by student on 18.05.2015.
 */
public class SoundInfo implements Serializable {

    String title;
    String duration;
    String artwork_url;
    String download_url;
    String stream_url;
    String likes_count;

    public SoundInfo(String title, String duration, String artwork_url, String download_url, String stream_url, String likes_count) {
        this.title = title;
        this.duration = duration;
        this.artwork_url = artwork_url;
        this.download_url = download_url;
        this.stream_url = stream_url;
        this.likes_count = likes_count;
    }

    @Override
    public String toString() {
        return "MusicParse{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", artwork_url='" + artwork_url + '\'' +
                ", downloadUrl='" + download_url + '\'' +
                ", streamUrl='" + stream_url + '\'' +
                ", likesCount=" + likes_count +
                '}';
    }

    public String getDuration() {
        int milliseconds=Integer.valueOf(duration);
        int seconds = (int) (milliseconds / 1000) % 60 ;
        int minutes = (int) ((milliseconds / (1000*60)) % 60);
        String.valueOf(seconds);
        String.valueOf(minutes);
        String duration=minutes+"m"+" "+seconds+"s";
        return duration;
    }

    public String getTitle() {
        if (title.contains("-")) {
            String string = title;
            String[] parts = string.split("-");
            String part1=parts[0];
            return part1;
        } else {
            return title;
        }
    }
    public String getSoundName() {
        if (title.contains("-")) {
            String string = title;
            String[] parts = string.split("-");
            String part2=parts[1];
            return part2;
            //TODO java.lang.ArrayIndexOutOfBoundsException: length=1; index=1
            //TODO at com.vovk.Music_Cloud.ParseSoundInfo.SoundInfo.getSoundName(SoundInfo.java:64)
            //TODO at com.vovk.Music_Cloud.MyAdapter.getView(MyAdapter.java:53)
        } else {
            return title;
        }

    }

    public String getArtworkUrl() {
        return artwork_url;
    }

    public String getDownloadUrl() {
        return download_url;
    }

    public String getStreamUrl() {
        return stream_url;
    }

    public String getLikesCount() {
        return likes_count;
    }
}
