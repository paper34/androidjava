package com.example.app05;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;

import java.util.StringTokenizer;

public class Main2Activity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    ImageButton getBtn;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inflation: 인플레이션(java + layout)
        // java : 내부적인 처리, 이벤트 처리, 외부와의 통신 등을 담당
        // layout : view를 담당
        setContentView(R.layout.activity_main2);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        getBtn = findViewById(R.id.getBtn);

        String[] list = {"airplane", "apple", "melon", "strawberry", "watermelon", "banana", "orange"};

        //배열(data)에 들어있는 값들을 autotextview에 넣을 예정
        //adapter: 어댑터!
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, list);
        autoCompleteTextView.setAdapter(adapter);

        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(token);


        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String autoText = autoCompleteTextView.getText().toString();
                String multiText = multiAutoCompleteTextView.getText().toString();
                String total = autoText + ", " + multiText;

                Log.d("single 자동완성 : ", autoCompleteTextView.getText().toString());
                Log.d("multi 자동완성 : ", multiAutoCompleteTextView.getText().toString());
                Log.d("total 자동완성 : ", total);

                StringTokenizer tokenizer = new StringTokenizer(total);
                int count = tokenizer.countTokens();
                Log.d("token 개수 : ", count + "개");


                for (int i = 0; i < count; i++) {
                    Log.d("첫번째 토큰 : ", tokenizer.nextToken(", ").trim()); // 콤마로 꺼내줌, trim 공백제거

                    linearLayout = findViewById(R.id.linear1);
                    Button button = new Button(getApplicationContext());
                    button.setText(autoCompleteTextView.getText().toString());
                    button.setText(multiAutoCompleteTextView.getText().toString());
                    button.setWidth(100);
                    button.setTextSize(15);
                    button.setId(100);
                    linearLayout.addView(button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Button b = v.findViewById(v.getId());
                            if (v.getId() == b.getId()) {
                                Log.d("가지고온 id >>>> " + v.getId(), "~~");
                                Log.d("가지고온 텍스트 >>>> " + b.getText(), "~~");
                                b.setText("선택됨");
                                b.setBackgroundColor(Color.BLUE);
                                b.setTextColor(Color.WHITE);
                                b.setClickable(false);
                            }
                        }
                    });
                }
            }
        });
    }
}