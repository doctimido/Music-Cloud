package com.vovk.Music_Cloud.ParseSoundInfo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by student on 18.05.2015.
 */
public class SoundInfo implements Serializable {

    String title;
    String duration;

    @SerializedName("artwork_url")
    String artworkUrl;
    @SerializedName("download_url")
    String downloadUrl;
    @SerializedName("stream_url")
    String streamUrl;
    @SerializedName("likes_count")
    String likesCount;

    public SoundInfo(String title, String duration, String artworkUrl, String downloadUrl, String streamUrl, String likesCount) {
        this.title = title;
        this.duration = duration;
        this.artworkUrl = artworkUrl;
        this.downloadUrl = downloadUrl;
        this.streamUrl = streamUrl;
        this.likesCount = likesCount;
    }

    @Override
    public String toString() {
        return "MusicParse{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", artworkUrl='" + artworkUrl + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", streamUrl='" + streamUrl + '\'' +
                ", likesCount=" + likesCount +
                '}';
    }

    public String getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public String getLikesCount() {
        return likesCount;
    }
}
