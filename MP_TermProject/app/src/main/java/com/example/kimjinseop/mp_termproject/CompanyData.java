package com.example.kimjinseop.mp_termproject;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.TextView;

//기업 - 판매 물품관리
public class CompanyData extends Activity{
    DBHelper helper;
    SQLiteDatabase db;
    TextView table1price, table2price, table3price, table4price;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        helper = new DBHelper(this);
        try{
            db = helper.getWritableDatabase();

        }catch(SQLiteException ex){
            db = helper.getReadableDatabase();
        }
        helper.useDB(db);
        setContentView(R.layout.activity_showcompanydata);
    }
}
