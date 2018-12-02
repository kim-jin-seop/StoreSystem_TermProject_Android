package com.example.kimjinseop.mp_termproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//DB사용
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "System.db";
    private static final int DATABASE_VERSION=2;

    public DBHelper(Context context){ super(context, DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS MENU_COMPANY( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER, name TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS COMPANY_PRODUCT( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER, name TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS MENU_LIST( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER);");
        db.execSQL("CREATE TABLE IF NOT EXISTS TABLE_DETAIL_1( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER, quantity INTEGER);");
        db.execSQL("CREATE TABLE IF NOT EXISTS TablePrice( _id INTEGER, total_price INTEGER);");
        db.execSQL("CREATE TABLE IF NOT EXISTS SELL_INFO( _id INTEGER PRIMARY KEY AUTOINCREMENT, tradeDate TEXT, price INTEGER, payment TEXT);");    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST MENU_LIST");
        onCreate(db);
    }

    public void useDB(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS MENU_COMPANY( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER, name TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS COMPANY_PRODUCT( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER, name TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS MENU_LIST( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER);");
        db.execSQL("CREATE TABLE IF NOT EXISTS TABLE_DETAIL_1( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER, quantity INTEGER);");
        db.execSQL("CREATE TABLE IF NOT EXISTS TablePrice( _id INTEGER, total_price INTEGER);");
        db.execSQL("CREATE TABLE IF NOT EXISTS SELL_INFO( _id INTEGER PRIMARY KEY AUTOINCREMENT, tradeDate TEXT, price INTEGER, payment TEXT);");
    }
}

