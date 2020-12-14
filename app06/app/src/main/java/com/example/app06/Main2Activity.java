package com.example.app06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.TabHost;

public class Main2Activity extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("와리가리");

        TabHost tabHost = findViewById(R.id.tabHost2);
        tabHost.setup();

        // 탭하나씩 정의
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("HOME").setIndicator("홈");
        tabSpec1.setContent(R.id.tab1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("BEST").setIndicator("베스트");
        tabSpec2.setContent(R.id.tab2);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("SINSANG").setIndicator("신상");
        tabSpec3.setContent(R.id.tab3);
        tabHost.addTab(tabSpec3);

        tabHost.setCurrentTab(0);
    }
}
