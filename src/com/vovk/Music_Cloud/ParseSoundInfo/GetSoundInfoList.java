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
                String artworkUrl = obj.getString("artworkUrl");
                String downloadUrl = obj.getString("downloadUrl");
                String streamUrl = obj.getString("streamUrl");
                String likesCount = obj.getString("likesCount");

                list.add(new SoundInfo(title, duration, artworkUrl, downloadUrl, streamUrl, likesCount));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}
