package com.example.kimjinseop.mp_termproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class providerActivity extends Activity {
    SQLiteDatabase db;
    DBHelper helper;
    final String CompanyName = "TestCompany";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        helper = new DBHelper(this);
        try{
            db = helper.getWritableDatabase();

        }catch(SQLiteException ex){
            db = helper.getReadableDatabase();
        }
        setContentView(R.layout.activity_provider);
    }

    public void isClickSellerCheck(View view){
        Intent intent = new Intent(this,SellerCheckActivity.class);
        startActivity(intent);
    }

    public void isClickItemEnroll(View view){
        inputMenu();
    }

    public void inputMenu(){
        LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.alert_dialog, null);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("New Menu : "+CompanyName);
        alert.setMessage("제품의 이름과 가격을 입력하세요");
        alert.setView(textEntryView);

        final EditText input1 = (EditText) textEntryView.findViewById(R.id.edtMenu);
        final EditText input2 = (EditText) textEntryView.findViewById(R.id.edtPrice);

        alert.setPositiveButton("추가", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String menuNames = input1.getText().toString();
                String menuPrice = input2.getText().toString();
                String regexStr = "^[0-9]*$";

                if(input2.getText().toString().trim().matches(regexStr)) { }
                else{
                    //write code for failure
                }
                if (input2.getText().toString().matches("-?\\d+(\\.\\d+)?"))  {
                    db.execSQL("CREATE TABLE IF NOT EXISTS MENU_COMPANY( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER, name TEXT);");
                    db.execSQL("CREATE TABLE IF NOT EXISTS Show_PRODUCT( _id INTEGER PRIMARY KEY AUTOINCREMENT, menu TEXT, price INTEGER, quantity INTEGER, name TEXT);");
                    db.execSQL("INSERT INTO MENU_COMPANY VALUES(null,'" + menuNames + "','" + menuPrice + "','"+CompanyName+"');");
                    Toast.makeText(getApplicationContext(), "추가됨", Toast.LENGTH_SHORT).show();
                    db.execSQL("INSERT INTO Show_PRODUCT VALUES(null,'" + menuNames + "','" + menuPrice + "', '"+ 0 + "','"+CompanyName +"');");
                } else {
                    Toast.makeText(getApplicationContext(), "잘못된 금액입니다. 다시 시도해 주십시오.", Toast.LENGTH_SHORT).show();
                    input2.setText("");
                }
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }
}
