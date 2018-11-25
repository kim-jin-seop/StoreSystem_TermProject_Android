package com.example.kimjinseop.mp_termproject;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class tsinfo extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    TextView idnum, tableNum, price, paymentcheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsinfo);

        idnum = (TextView) findViewById(R.id.idnum);
        tableNum = (TextView) findViewById(R.id.tableNum);
        price = (TextView) findViewById(R.id.price);
        paymentcheck = (TextView) findViewById(R.id.paymentcheck);



        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();

        } catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }


        Cursor cursor2 = db.rawQuery("SELECT * FROM SELL_INFO;",null);

        String idnumber ="번호 \r\n";
        String prices="가격 \r\n";
        String tablenum="테이블번호 \r\n";
        String payment="현금/카드 \r\n";
        while(cursor2.moveToNext()){


            idnumber += cursor2.getString(0) + "\r\n";
            tablenum += cursor2.getString(1) + "\r\n";
            prices+= cursor2.getString(2)+ "\r\n";
            payment +=cursor2.getString(3)+ "\r\n";

        }
        idnum.setText(idnumber);
        tableNum.setText(tablenum);
        price.setText(prices);
        paymentcheck.setText(payment);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tsinfo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
