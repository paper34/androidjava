package com.example.app05;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button start, end, calButton, timeButton, nextButton;
    CalendarView calendarView;
    TimePicker timePicker;
    int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.ch);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        calButton = findViewById(R.id.calButton);
        timeButton = findViewById(R.id.timeButton);
        nextButton = findViewById(R.id.nextButton);
        calendarView = findViewById(R.id.cal);
        nextButton = findViewById(R.id.nextButton);
        timePicker = findViewById(R.id.timer);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                Log.d("크로메터 상황: ", "시작됨!!!");
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                Log.d("크로메터 상황: ", "중지됨!!!");
                Toast.makeText(getApplicationContext(), chronometer.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year2, int month2, int day2) {
                Log.d("선택한 날짜는 ", year2 + "년" + (month2+1) + "월" + day2 + "일");
                year = year2;
                month = month2;
                day = day2;
            }
        });

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (year != 0) {
                    Toast.makeText(getApplicationContext(), year + "년" + (month+1) + "월" + day + "일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "날짜를 먼저 선택해주세요!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t = timePicker.getHour();
                int m = timePicker.getMinute();
                Toast.makeText(getApplicationContext(), t + "시" + m + "분", Toast.LENGTH_SHORT).show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });


    }
}
