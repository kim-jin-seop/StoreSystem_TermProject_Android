package com.example.kimjinseop.mp_termproject;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pos.db";
    private static final int DATABASE_VERSION=2;

    public DBHelper(Context context){ super(context, DATABASE_NAME,null,DATABASE_VERSION);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MENU_LIST( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER);");
        //   db.execSQL("CREATE TABLE TABLE_DETAIL( tablenum INTEGER PRIMARY KEY, menu TEXT, price INTEGER, quantity INTEGER);");
        db.execSQL("CREATE TABLE TABLE_DETAIL_1( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER, quantity INTEGER);");
        db.execSQL("CREATE TABLE TablePrice( _id INTEGER, total_price INTEGER);");
        db.execSQL("CREATE TABLE SELL_INFO( _id INTEGER PRIMARY KEY AUTOINCREMENT, tableNum INTEGER, price INTEGER, payment TEXT);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST MENU_LIST");
        onCreate(db);
    }
}

