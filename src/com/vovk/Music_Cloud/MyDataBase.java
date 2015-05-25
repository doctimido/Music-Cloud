package com.vovk.Music_Cloud;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * Created by student on 25.05.2015.
 */
public class MyDataBase extends SQLiteOpenHelper {

    public MyDataBase(Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(Const.TAG, "Create DB");

        db.execSQL("CREATE TABLE mytable ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "who INTEGER,"
                + "message TEXT" + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
