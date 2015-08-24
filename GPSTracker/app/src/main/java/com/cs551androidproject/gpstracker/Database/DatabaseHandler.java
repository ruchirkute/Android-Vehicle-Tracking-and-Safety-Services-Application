package com.cs551androidproject.gpstracker.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "LocationDatabase";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE location " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title text, " +
                "lat double, " +
                "lng double ) ";
        db.execSQL(sql);

        String sql1 = "CREATE TABLE garage " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title text, " +
                "lat double, " +
                "lng double ) ";
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS location";
        db.execSQL(sql);

        String sql1 = "DROP TABLE IF EXISTS garage";
        db.execSQL(sql1);

        onCreate(db);
    }
}
