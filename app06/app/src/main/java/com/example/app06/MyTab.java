package com.example.app06;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MyTab extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_tab);

        TabHost tabHost = getTabHost();

        // 탭하나씩 정의
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpec1.setContent(R.id.tabsong1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpec2.setContent(R.id.tabartist1);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpec3.setContent(R.id.tabalbum1);
        tabHost.addTab(tabSpec3);

        tabHost.setCurrentTab(0);
    }
}
