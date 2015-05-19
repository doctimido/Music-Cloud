package com.vovk.Music_Cloud;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.turbomanage.httpclient.android.AndroidHttpClient;
import com.vovk.Music_Cloud.ParseSoundInfo.GetSoundInfoList;
import com.vovk.Music_Cloud.ParseSoundInfo.SoundInfo;
import org.apache.http.HttpResponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alytar on 17.05.15.
 */
public class FragmentMusicCloud extends Fragment implements Serializable{

    private ListView myListView;
    private MyAdapter adapter;
    private GetSoundInfoList soundInfoList;
    private List<SoundInfo>listSoundInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_music_cloud, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        soundInfoList=new GetSoundInfoList();

        /*AndroidHttpClient httpClient = new AndroidHttpClient("http://192.168.1.1:8888");
        httpClient.setMaxRetries(5);
        ParameterMap params = httpClient.newParams()
                .add("continue", "/")
                .add("email", "test@example.com")
                .add("action", "Log In");
        httpClient.post*/





        listSoundInfo=soundInfoList.getList(Const.URL);
        Log.e(Const.TAG, "Quantity of object = " + listSoundInfo.size());


        myListView = (ListView) getView().findViewById(R.id.myListView);

        adapter = new MyAdapter(getActivity(),listSoundInfo);
        myListView.setAdapter(adapter);

        //TODO create HTTP android

    }


}
