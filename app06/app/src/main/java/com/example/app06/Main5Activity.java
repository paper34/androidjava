package com.example.app06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main5Activity extends AppCompatActivity {

    Button btnRead, btnWrite, open, save;
    EditText t1, t2, t3, t4, query;
    TextView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);
        open = findViewById(R.id.open);
        save = findViewById(R.id.save);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        query = findViewById(R.id.query);
        list = findViewById(R.id.list);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput("out.txt", Context.MODE_PRIVATE);
                    String str = "내가 파일에 들어가요...!!!";
                    fileOutputStream.write(str.getBytes());
                    Toast.makeText(getApplicationContext(), "파일이 생성됨", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream inputStream = openFileInput("out.txt");
                    byte[] txt = new byte[256];
                    inputStream.read(txt);
                    String str1 = new String(txt);
                    inputStream.close();
                    Toast.makeText(getApplicationContext(), str1, Toast.LENGTH_SHORT).show();
                    Toast toast = new Toast(getApplicationContext());

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "파일없음", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        //연락처 저장
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput(t1.getText().toString() + ".txt", Context.MODE_PRIVATE);
                    String str = t1.getText().toString() + "\n" + t2.getText().toString() + "\n" + t3.getText().toString() + "\n" + t4.getText().toString();
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(), "저장됨", Toast.LENGTH_SHORT).show();
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "저장안됨", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        //연락처 가지고 오기
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = query.getText().toString().trim();
                    Toast.makeText(getApplicationContext(), "연락처 가지고오기", Toast.LENGTH_SHORT).show();
                    FileInputStream fileInputStream1 = openFileInput(name + ".txt");
                    byte[] txt = new byte[256];
                    fileInputStream1.read(txt);
                    String str = new String(txt);
                    fileInputStream1.close();
                    list.setText(str);

                }  catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),query.getText().toString()+"의 저장된 연락처가 없습니다..",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
