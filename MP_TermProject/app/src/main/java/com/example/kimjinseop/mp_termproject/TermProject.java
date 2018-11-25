package com.example.kimjinseop.mp_termproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TermProject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_project);
    }
    public void isClickSeller(View view){

    }

    public void isClickProvider(View view) {
    }

    public void isClickPos(View view){
        Intent intent = new Intent(getApplicationContext(),posActivity.class);
        startActivity(intent);
    }
}
