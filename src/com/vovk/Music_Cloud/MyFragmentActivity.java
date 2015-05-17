package com.vovk.Music_Cloud;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

public class MyFragmentActivity extends FragmentActivity {

    private FragmentTabHost fragmentTabHost;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_fragment_activity);

        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        addTab("fragment music cloud", FragmentMusicCloud.class,R.layout.tab_music_cloud);
        addTab("fragment download", FragmentDownload.class,R.layout.tab_download);




    }

    private void addTab(String tag, Class<?> fragmentClass, int numberTab) {
        View view = LayoutInflater.from(this).inflate(numberTab, fragmentTabHost.getTabWidget(), false);
        TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tag).setIndicator(view);
        fragmentTabHost.addTab(tabSpec, fragmentClass, null);
    }
}
