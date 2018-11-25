package com.example.kimjinseop.mp_termproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SellerActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller1);
    }
    public void isClick_ShowInventory(View view){
        Intent intent = new Intent(getApplicationContext(),ShowInven_SellerActivity.class);
        startActivity(intent);
    }
    public void isClick_AddProduct(View view){
        Intent intent = new Intent(getApplicationContext(),AddProduct_SellerActivity.class);
        startActivity(intent);
    }
}
