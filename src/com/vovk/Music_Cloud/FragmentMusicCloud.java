package com.vovk.Music_Cloud;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.ParameterMap;
import com.turbomanage.httpclient.android.AndroidHttpClient;
import com.vovk.Music_Cloud.ParseSoundInfo.SoundInfo;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alytar on 17.05.15.
 */
public class FragmentMusicCloud extends Fragment implements Serializable {

    private ListView myListView;
    private MyAdapter adapter;
    private List<SoundInfo> listSoundInfo;
    private EditText textRequestFromUser;
    //private String serverResponse;
    private String search;
    private Button buttonOk;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_music_cloud, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myListView = (ListView) getActivity().findViewById(R.id.myListView);
        textRequestFromUser = (EditText) getActivity().findViewById(R.id.search_music);
        listSoundInfo = new ArrayList<SoundInfo>();
        buttonOk = (Button) getActivity().findViewById(R.id.buttonOk);

        adapter = new MyAdapter(getActivity());
        myListView.setAdapter(adapter);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textRequestFromUser.getText().toString().isEmpty()) {
                    search = textRequestFromUser.getText().toString();
                    Log.e(Const.TAG, "search = " + search);
                    MyTask myTask = new MyTask();
                    myTask.execute(search);
                }
            }
        });


    }

    public class MyTask extends AsyncTask<String, Void, Void> implements Serializable {


        @Override
        protected Void doInBackground(String... params) {

            if (!params[0].isEmpty()) {
                AndroidHttpClient httpClient = new AndroidHttpClient(Const.URL);
                httpClient.setMaxRetries(5);
                ParameterMap param = httpClient.newParams()
                        .add("q", params[0])
                        .add("client_id", "b45b1aa10f1ac2941910a7f0d10f8e28");
                HttpResponse httpResponse = httpClient.get("/tracks.json", param);
                if (httpResponse.getBodyAsString() != null) {
                    Type listType = new TypeToken<List<SoundInfo>>() {
                    }.getType();
                    Gson gson = new Gson();
                    listSoundInfo = gson.fromJson(httpResponse.getBodyAsString(), listType);
                    Log.e(Const.TAG, "Quantity of object = " + listSoundInfo.size());

                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.clear();
            adapter.addAll(listSoundInfo);
        }
    }
}
