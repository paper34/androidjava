package com.example.app04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("여행을 떠나보자");

        button = findViewById(R.id.button);
        Button b2 = findViewById(R.id.b2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "어디로 떠날까?", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("여행선택");

                final String[] array = {"몰디브", "제주도", "호주", "보라카이"};
                dlg.setItems(array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String result = "";
                        if ( i == 0 ) {
                            result = "https://search.naver.com/search.naver?where=image&sm=tab_jum&query=%EB%AA%B0%EB%94%94%EB%B8%8C";
                        } else if ( i == 1) {
                            result = "https://search.naver.com/search.naver?sm=tab_hty.top&where=image&query=%EC%A0%9C%EC%A3%BC%EB%8F%84&oquery=%EB%AA%B0%EB%94%94%EB%B8%8C&tqi=UJ9S2dp0Yidss43NHlsssssstt8-384164";
                        } else if ( i == 2) {
                            result = "https://search.naver.com/search.naver?sm=tab_hty.top&where=image&query=%ED%98%B8%EC%A3%BC&oquery=%EC%A0%9C%EC%A3%BC%EB%8F%84&tqi=UJ9Ttsp0J1ZssaX4hIGssssssOK-231426";
                        } else if ( i == 3) {
                            result = "https://search.naver.com/search.naver?sm=tab_hty.top&where=image&query=%EB%B3%B4%EB%9D%BC%EC%B9%B4%EC%9D%B4&oquery=%EC%97%AC%ED%96%89&tqi=UJ9TRwp0JywssNq%2Flw8ssssstF8-131135";
                        }
                        Intent intent = new Intent(getIntent().ACTION_VIEW, Uri.parse(result));
                        startActivity(intent);
                    }

                });

                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent2);
            }
        });

    }
}
