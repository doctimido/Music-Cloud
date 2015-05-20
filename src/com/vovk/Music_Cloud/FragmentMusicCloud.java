package com.vovk.Music_Cloud;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.turbomanage.httpclient.AsyncCallback;
import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.ParameterMap;
import com.turbomanage.httpclient.android.AndroidHttpClient;
import com.vovk.Music_Cloud.ParseSoundInfo.GetSoundInfoList;
import com.vovk.Music_Cloud.ParseSoundInfo.SoundInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alytar on 17.05.15.
 */
public class FragmentMusicCloud extends Fragment implements Serializable {

    private ListView myListView;
    private MyAdapter adapter;
    private GetSoundInfoList soundInfoList;
    private List<SoundInfo> listSoundInfo;
    private EditText textRequestFromUser;
    //private String serverResponse;
    private String search;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_music_cloud, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        soundInfoList = new GetSoundInfoList();
        myListView = (ListView) getActivity().findViewById(R.id.myListView);
        textRequestFromUser = (EditText) getActivity().findViewById(R.id.search_music);
        listSoundInfo = new ArrayList<>();

        adapter = new MyAdapter(getActivity(), listSoundInfo);
        myListView.setAdapter(adapter);


        textRequestFromUser.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean handled = false;
                textRequestFromUser.setImeActionLabel("DONE", EditorInfo.IME_ACTION_DONE);
                if (i == EditorInfo.IME_ACTION_DONE) {
                    search = textRequestFromUser.getText().toString();
                    Log.e(Const.TAG, "search = " + search);
                    MyTask myTask = new MyTask();
                    myTask.execute(search);
                    handled = true;
                }
                return handled;
            }
        });


    }

    public class MyTask extends AsyncTask<String, Void, String> implements Serializable {


        @Override
        protected String doInBackground(String... params) {

            if (!params[0].isEmpty()) {

                AndroidHttpClient httpClient = new AndroidHttpClient(Const.URL);
                httpClient.setMaxRetries(5);
                ParameterMap param = httpClient.newParams()
                        .add("q", params[0])
                        .add("client_id", "b45b1aa10f1ac2941910a7f0d10f8e28");
                HttpResponse httpResponse = httpClient.get("/tracks.json", param);
                if (httpResponse.getBodyAsString() != null) {
                    String s=httpResponse.getBodyAsString();
                    return s;
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String serverResponse) {
            super.onPostExecute(serverResponse);
            if (!serverResponse.isEmpty() && serverResponse != null) {
                listSoundInfo = soundInfoList.getList(serverResponse);
                Log.e(Const.TAG, "Quantity of object = " + listSoundInfo.size());
                adapter.notifyDataSetChanged();
            }

        }
    }
}
