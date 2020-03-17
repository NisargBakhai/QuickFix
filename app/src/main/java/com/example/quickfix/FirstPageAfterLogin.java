package com.example.quickfix;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FirstPageAfterLogin extends AppCompatActivity {
    private CardView electrician;
    private CardView plumber;
    private CardView carpenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page_after_login);
        electrician=findViewById(R.id.electrician);
        plumber=findViewById(R.id.plumber);
        carpenter=findViewById(R.id.carpenter);
        electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(FirstPageAfterLogin.this,Electricians.class);
                startActivity(r);
            }});
        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(FirstPageAfterLogin.this,Plumbers.class);
                startActivity(r);
            }});
        carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(FirstPageAfterLogin.this,Carpenters.class);
                startActivity(r);
            }});
        BottomNavigationView bottomNavigationView = findViewById(R.id.b_nav);
        bottomNavigationView.setSelectedItemId(R.id.services);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.services:
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