package com.example.quickfix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Plumbers extends AppCompatActivity {
    private CardView ahmedabad;
    private CardView rajkot;
    private CardView baroda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumbers);
        ahmedabad=findViewById(R.id.ahmedabad);
        rajkot=findViewById(R.id.rajkot);
        baroda=findViewById(R.id.baroda);
        ahmedabad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Plumbers.this,aplumber.class);
                startActivity(r);
            }});
        rajkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Plumbers.this,rplumber.class);
                startActivity(r);
            }});
        baroda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Plumbers.this,bplumber.class);
                startActivity(r);
            }});
    }
}

