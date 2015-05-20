package com.vovk.Music_Cloud.ParseSoundInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 18.05.2015.
 */
public class GetSoundInfoList implements Serializable {

    public List<SoundInfo> getList(String json) {

        List<SoundInfo> list = new ArrayList();

        JSONArray jsonarray = null;
        try

        {
            jsonarray = new JSONArray(json);

            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject obj = jsonarray.getJSONObject(i);

                String title = obj.getString("title");
                String duration = obj.getString("duration");
                String artworkUrl = obj.getString("artwork_url");
                String downloadUrl = obj.getString("download_url");
                String streamUrl = obj.getString("stream_url");
                String likesCount = obj.getString("likes_count");

                list.add(new SoundInfo(title, duration, artworkUrl, downloadUrl, streamUrl, likesCount));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}
