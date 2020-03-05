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

public class acarpentersss extends AppCompatActivity {
    private Button next;
    private Button previous;
    private TextView Name;
    private TextView Address;
    private TextView Phno;
    private TextView Tmng;
    private Button book;
    ProgressDialog p;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acarpentersss);
        book=findViewById(R.id.bookb);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        Name=findViewById(R.id.name);
        Address=findViewById(R.id.address);
        Phno=findViewById(R.id.phno);
        Tmng=findViewById(R.id.tmng);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(acarpentersss.this,acarpenterssss.class);
                startActivity(r);
            }});
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(acarpentersss.this,acarpenterss.class);
                startActivity(r);
            }});
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("Ahmedabad").child("ACarpenter").child("AC4");


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
                String name=dataSnapshot.child("n").getValue().toString();
                String address=dataSnapshot.child("a").getValue().toString();
                String phno=dataSnapshot.child("c").getValue().toString();
                String tmng=dataSnapshot.child("t").getValue().toString();
                Name.setText(name);
                Address.setText(address);
                Phno.setText(phno);
                Tmng.setText(tmng);
            }
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=Name.getText().toString();
                Intent r=new Intent(acarpentersss.this,booking.class);
                r.putExtra("CARPENTER",name);
                startActivity(r);
            }});
    }
}
