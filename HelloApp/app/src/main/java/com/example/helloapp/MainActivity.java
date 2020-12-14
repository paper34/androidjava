package com.example.helloapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, button2;
    TextView textResult;
    String num1, num2;
    Integer result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");
        edit1 = (EditText)findViewById(R.id.editText);
        edit2 = (EditText)findViewById(R.id.editText2);
        btnAdd = (Button)findViewById(R.id.button3);
        button2 = (Button)findViewById(R.id.button2);
        textResult = (TextView)findViewById(R.id.textView4);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("나를 눌러봐봐때문에 난 떴어요");
                //dlg.setMessage("이곳은 내용이 나타나요..!! 휴가 신나요..!!");
                dlg.setIcon(R.mipmap.ic_launcher);
                final String[] versionArray = new String[] {"오레오", "파이", "큐(10)"};
                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), versionArray[i], Toast.LENGTH_LONG).show();
                    }
                });

                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText(result.toString());
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
