package com.example.app04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button button;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        button = findViewById(R.id.b1);
        img = findViewById(R.id.img2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "어디로 떠날까?", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dlg = new AlertDialog.Builder(Main2Activity.this);
                dlg.setTitle("여행선택");

                final String[] array = {"인천", "전주", "신촌", "여수"};
                dlg.setItems(array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (i == 0) {
                            img.setImageResource(R.drawable.incheon);
                        } else if (i == 1) {
                            img.setImageResource(R.drawable.jeonju);
                        } else if (i == 2) {
                            img.setImageResource(R.drawable.sinchon);
                        } else if (i == 3) {
                            img.setImageResource(R.drawable.yeosu);
                        }

                    }
                });
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });
    }
}
