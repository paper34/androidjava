package com.example.app03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    ImageView img;
    Button b;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img = findViewById(R.id.img);
        b = findViewById(R.id.b);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0) {
                    flag = 1;
                    img.setImageResource(R.drawable.car1);
                } else {
                    flag = 0;
                    img.setImageResource(R.drawable.car2);
                }
            }
        });
    }
}
