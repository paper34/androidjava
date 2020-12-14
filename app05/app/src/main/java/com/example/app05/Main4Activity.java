package com.example.app05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;

public class Main4Activity extends AppCompatActivity {
    LinearLayout linearLayout;
    int index;
    String w = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void onClickShowAlert(View view) {
        print(view);

    }

    public void onClickShowDate(View view) {
        showDatePicker(view);
    }

    public void onClickLogPrint(View view) {
        Log.d("나를 부른 view에 대한 정보 >> ", view.getId() + "");
        Button button3 = view.findViewById(view.getId());
        button3.setTextColor(Color.BLUE);
    }

    public void onClickChangeText(View view) {
        Button button4 = view.findViewById(view.getId());
        Log.d("텍스트 바꾸는 버튼 >>", "id: " + view.getId() + "/ text: " + button4.getText());
        button4.setText("오늘은 월요일입니다.");
    }

    public void print(View view) { // alert용 출력 메서드 정의
        Log.d("이 메서드가 호출됨.", "나를 호출한 view는 >>" + view.getId());

        AlertDialog.Builder dlg = new AlertDialog.Builder(Main4Activity.this);
        dlg.setTitle("경고용 메세지 창");
        dlg.setMessage("오늘은 금요일입니다.!! ");
        dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "OK!!", Toast.LENGTH_SHORT).show();
            }
        });

        dlg.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "NO!!", Toast.LENGTH_SHORT).show();
            }
        });

        dlg.show();

    }

    public void showDatePicker(View view) {
        DialogFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void result(final int year, final int month, final int day) {


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("날짜를 클릭했군");
        builder.setMessage(year + "년" + month + "월" + day + "일을 선택하셨군요");
        final String s = year + "년" + month + "월" + day + "일";
        builder.setPositiveButton("전달 받는 값 확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                linearLayout = findViewById(R.id.line4);
                final Button btn = new Button(getApplicationContext());
                btn.setText(year + "년" + month + "월" + day + "일");
                btn.setTextSize(25);
                btn.setId(index);
                index++;
                linearLayout.addView(btn);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Main4Activity.this);

                        final Calendar cal = Calendar.getInstance();
                        int we = cal.get(Calendar.DAY_OF_WEEK);
                        switch (we) {
                            case 1:
                                w = "월요일";
                                break;
                            case 2:
                                w = "화요일";
                                break;
                            case 3:
                                w = "수요일";
                                break;
                            case 4:
                                w = "목요일";
                                break;
                            case 5:
                                w = "금요일";
                                break;
                            case 6:
                                w = "토요일";
                                break;
                            case 7:
                                w = "월일일";
                                break;
                        }


                        builder1.setTitle("날짜선택");
                        builder1.setMessage(btn.getText() + w);
                        builder1.show();
                    }

                });
                Toast.makeText(getApplicationContext(), year + "년" + month + "월" + day + "일", Toast.LENGTH_SHORT).show();


            }
        });
        builder.show();

    }
}
