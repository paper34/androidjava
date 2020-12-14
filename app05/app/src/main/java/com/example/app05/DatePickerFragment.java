package com.example.app05;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //플래그먼트를 실행시켯을때 자동 호출되는 메서드
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        Log.d("캘린더 다이얼로그 생성>> ", year + "년" +
                month +"월" + day + "일" );
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        // 날짜를 클릭하면
        Main4Activity  activity4 = (Main4Activity)getActivity();
        activity4.result(i, i1, i2);

        //logPrint(i, i1, i2);
    }
    public void logPrint (int year, int month, int date) {
        Log.d("선택한 날짜는 ", year+ "년" + month + "월" + date + "일");
    }
}
