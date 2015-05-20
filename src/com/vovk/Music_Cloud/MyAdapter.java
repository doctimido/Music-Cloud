package com.vovk.Music_Cloud;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.vovk.Music_Cloud.ParseSoundInfo.SoundInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 18.05.2015.
 */
public class MyAdapter extends ArrayAdapter<SoundInfo> implements Serializable {

    private LayoutInflater inflater;


    public MyAdapter(Context context) {
        super(context, 0);
        inflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_for_list_view, parent, false);
        }

        ImageView titlePicture = (ImageView) convertView.findViewById(R.id.titlePicture);
        TextView textForSoundTitle = (TextView) convertView.findViewById(R.id.textForSoundTitle);
        TextView likesQuantity = (TextView) convertView.findViewById(R.id.likesQuantity);
        TextView lengthOfTheTrack = (TextView) convertView.findViewById(R.id.lengthOfTheTrack);
        TextView artistName = (TextView) convertView.findViewById(R.id.artistName);

        SoundInfo soundInfoItem = getItem(position);

        if (soundInfoItem != null) {
            likesQuantity.setText(soundInfoItem.getLikesCount());
            textForSoundTitle.setText(soundInfoItem.getTitle());
            lengthOfTheTrack.setText(soundInfoItem.getDuration());
        }

        return convertView;
    }
}