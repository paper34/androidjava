package com.example.app03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button, button2; // button: 위 , button2: 결과보기
    EditText edit1, edit2; // edit1: 입력 1   edit2: 입력2
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        textResult = findViewById(R.id.textResult);

        // 나를 눌러봐바!! 버튼처리
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"나는 토스트", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("나는 눌러봐바! 버튼 때문에 내가 떴어요!!");
                //dlg.setMessage("이곳은 내용이 나타나요..!! 신나요!! 겨울이에요!");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final String[] array = {"오레오", "파이", "큐(Q)"};
                dlg.setItems(array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Log.d("배열에서 가지고 온 값은 ", array[i]);
                        String result = "";
                        if (i == 0 ) {
                            result = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%98%A4%EB%A0%88%EC%98%A4";
                        } else if (i == 1) {
                            result = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%ED%8C%8C%EC%9D%B4&oquery=%EC%98%A4%EB%A0%88%EC%98%A4&tqi=UJ8B%2Bdprvh8ssjmr%2Fu0sssssth8-152637";
                        } else if (i == 2) {
                            result = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%ED%81%90&oquery=%ED%8C%8C%EC%9D%B4&tqi=UJ8CusprvmsssO3uRZVssssstP4-187717";
                        }
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getIntent().ACTION_VIEW, Uri.parse(result));
                        startActivity(intent);
                    }
                });

                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        //결과보기 버튼처리
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();

                int result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText(result + "");

                Toast.makeText(getApplicationContext(),"더한결과>> " + result, Toast.LENGTH_LONG).show();
            }
        });



    }



}
