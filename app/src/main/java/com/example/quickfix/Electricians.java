package com.example.quickfix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Electricians extends AppCompatActivity {
    private CardView ahmedabad;
    private CardView rajkot;
    private CardView baroda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricians);
        ahmedabad=findViewById(R.id.ahmedabad);
        rajkot=findViewById(R.id.rajkot);
        baroda=findViewById(R.id.baroda);
        ahmedabad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Electricians.this,aelectrician.class);
                startActivity(r);
            }});
        rajkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Electricians.this,relectrician.class);
                startActivity(r);
            }});
        baroda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Electricians.this,belectrician.class);
                startActivity(r);
            }});
        BottomNavigationView bottomNavigationView = findViewById(R.id.b_nav);
        bottomNavigationView.setSelectedItemId(R.id.services);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.services:
                        startActivity(new Intent(getApplicationContext(),FirstPageAfterLogin.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}