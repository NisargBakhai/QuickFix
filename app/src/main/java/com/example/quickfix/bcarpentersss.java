package com.example.quickfix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class bcarpentersss extends AppCompatActivity {
    private Button next;
    private Button previous;
    private TextView Name;
    private Button book;
    private TextView Address;
    private TextView Phno;
    private TextView Tmng;
    private Carpenter_detail carpenter;
    ProgressDialog p;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcarpentersss);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        book=findViewById(R.id.bookb);
        Name=findViewById(R.id.name);
        Address=findViewById(R.id.address);
        Phno=findViewById(R.id.phno);
        Tmng=findViewById(R.id.tmng);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(bcarpentersss.this,bcarpenterssss.class);
                startActivity(r);
            }});
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(bcarpentersss.this,bcarpenterss.class);
                startActivity(r);
            }});
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("Baroda").child("Carpenter").child("BC4");


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
                Intent r=new Intent(bcarpentersss.this,booking.class);
                r.putExtra("CARPENTER",name);
                startActivity(r);
            }});
    }
}
