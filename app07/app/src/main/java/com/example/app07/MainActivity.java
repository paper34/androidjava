package com.example.app07;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNo, edtTitle, edtContent, edtWriter, edtGender;
    Button btnInsert, btnUpdate, btnOne, btnList, delete;
    TextView result;
    SQLiteDatabase sqlDB;
    DataBaseHelper dataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("종률, 혜정, 창호 LJP!!");
        edtNo = (EditText) findViewById(R.id.edtNo);
        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtContent = (EditText) findViewById(R.id.edtContent);
        edtWriter = (EditText) findViewById(R.id.edtWriter);
        edtGender = (EditText) findViewById(R.id.edtGender);

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnList = (Button) findViewById(R.id.btnList);
        delete = (Button) findViewById(R.id.delete);

        result = (TextView) findViewById(R.id.result);

        dataBaseHelper = new DataBaseHelper(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = dataBaseHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO bbs VALUES ( '"
                        + edtNo.getText().toString() + "' , '"
                        + edtTitle.getText().toString() + "' , '"
                        + edtContent.getText().toString() + "' , '"
                        + edtWriter.getText().toString() + "' , '"
                        + edtGender.getText().toString() + "');");

                sqlDB.close();
                print("insert 성공!");
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = dataBaseHelper.getWritableDatabase();
                sqlDB.execSQL("UPDATE bbs SET content = '"+edtContent.getText().toString()+"' WHERE no = '" + edtNo.getText().toString()+ "' ");

                sqlDB.close();
                print("update 성공!");
            }
        });


        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = dataBaseHelper.getWritableDatabase();

                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM bbs WHERE no = " + edtNo.getText().toString()+ "",null);

                String no = null;
                String title = null;
                String content = null;
                String writer = null;
                String gender = null;

                while (cursor.moveToNext()) {
                    no = "번호: " + cursor.getString(0) + "\r\n";
                    title = "제목: " + cursor.getString(1) + "\r\n";
                    content = "내용: " + cursor.getString(2) + "\r\n";
                    writer = "작성자: " + cursor.getString(3) + "\r\n";
                    gender = "날짜: " + cursor.getString(4) + "\r\n";
                }

                String a = no+title+content+writer+gender;
                result.setText(a);

                cursor.close();
                sqlDB.close();

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = dataBaseHelper.getWritableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM bbs",null);

                String no = null;
                String title = null;
                String content = null;
                String writer = null;
                String gender = null;
                String a = null;

                while (cursor.moveToNext()) {
                    no = "번호: " + cursor.getString(0) + "\r\n";
                    title = "제목: " + cursor.getString(1) + "\r\n";
                    content = "내용: " + cursor.getString(2) + "\r\n";
                    writer = "작성자: " + cursor.getString(3) + "\r\n";
                    gender = "성별: " + cursor.getString(4) + "\r\n";

                    a += no+title+content+writer+gender+"\r\n";
                }

                result.setText(a);

                cursor.close();
                sqlDB.close();

                print("selectList 성공!");

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = dataBaseHelper.getWritableDatabase();
                sqlDB.execSQL("DELETE FROM bbs WHERE no = " + edtNo.getText().toString()+ "");

                sqlDB.close();
                print("update 성공!");
            }
        });

    }




    public void print(String result) {
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
    }
}
