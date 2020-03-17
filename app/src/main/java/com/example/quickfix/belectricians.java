package com.example.quickfix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class belectricians extends AppCompatActivity {
    private Button previous;
    private Button next;
    private TextView Name;
    private TextView Address;
    private TextView Phno;
    private Button book;
    private TextView Tmng;
    private Carpenter_detail carpenter;
    ProgressDialog p;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belectricians);
        next=findViewById(R.id.next);
        book=findViewById(R.id.bookb);
        previous=findViewById(R.id.previous);
        Name=findViewById(R.id.name);
        Address=findViewById(R.id.address);
        Phno=findViewById(R.id.phno);
        Tmng=findViewById(R.id.tmng);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(belectricians.this,belectricianss.class);
                startActivity(r);
            }});
        previous=findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(belectricians.this,belectrician.class);
                startActivity(r);
            }});
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("Baroda").child("Electrician").child("BE2");


        showData();
    }

    public void showData(){
        p=new ProgressDialog(this);
        p.setMessage("retriving");
        p.show();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                p.dismiss();
                String name=dataSnapshot.child("name").getValue().toString();
                String address=dataSnapshot.child("address").getValue().toString();
                String phno=dataSnapshot.child("contact number").getValue().toString();
                String tmng=dataSnapshot.child("timing").getValue().toString();
                Name.setText(name);
                Address.setText(address);
                Phno.setText(phno);
                Tmng.setText(tmng);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=Name.getText().toString();
                Intent r=new Intent(belectricians.this,bookinge.class);
                r.putExtra("CARPENTER",name);
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
