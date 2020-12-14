package com.example.app06;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.DragAndDropPermissionsCompat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main6Activity extends AppCompatActivity {
    Button raw_read, sd_read, sd_write, sd_dir_mk, sd_dir_del, sd_list;
    EditText raw_data, raw_data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        raw_read = findViewById(R.id.raw_read);
        raw_data = findViewById(R.id.raw_data);
        raw_data2 = findViewById(R.id.raw_data2);
        sd_read = findViewById(R.id.sd_read);
        sd_write = findViewById(R.id.sd_write);
        sd_dir_mk = findViewById(R.id.sd_dir_mk);
        sd_dir_del = findViewById(R.id.sd_dir_del);
        sd_list = findViewById(R.id.sd_list);

        // permission 흭득!!!
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        raw_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.raw_test);
                    byte[] txt = new byte[inputStream.available()];
                    inputStream.read(txt);
                    raw_data.setText(new String(txt));
                    inputStream.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    Log.d("raw파일 존재 결과>>>", "파일이 존재하지않음");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("raw파일 읽기 결과>>>", "파일이 읽는 중 에러 발생");
                }
            }
        });

        sd_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream = null;

                try {
                    fileOutputStream = new FileOutputStream("/sdcard/out.txt");
                    String str = "i will be back!!";
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                    print("sdcard/out.txt 파일이 생성됨.");
                } catch (Exception e) {
                    print("sdcard/out.txt 파일생성에 문제가 있음.");
                    e.printStackTrace();
                }


            }
        });

        sd_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream inputStream = new FileInputStream("sdcard/out.txt");

                    byte[] txt = new byte[inputStream.available()];
                    inputStream.read(txt);
                    raw_data2.setText(new String(txt));
                    inputStream.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    print("out.txt파일 존재 결과>>> 파일이 존재하지않음");
                } catch (IOException e) {
                    e.printStackTrace();
                    print("out.txt파일 읽기 결과>>> 파일이 읽는 중 에러 발생");
                }

            }
        });




    }

    public void print(String result) {
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
    }




}
