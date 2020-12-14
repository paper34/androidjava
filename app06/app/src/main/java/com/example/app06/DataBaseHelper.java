package com.example.app06;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.example.app06/databases";

    public DataBaseHelper(Context context){

        super(context, "megadb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //table을 만들 때!
       sqLiteDatabase.execSQL("create table groupTBL (gName char(20) primary key, gNumber integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        //table을 삭제할 때!
        sqLiteDatabase.execSQL("drop table groupTBL");

    }
}