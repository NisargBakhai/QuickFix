package com.example.quickfix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class bookingp extends AppCompatActivity {
    private TextView tv1;


    private  Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingp);
        tv1=findViewById(R.id.textView3);
        confirm=findViewById(R.id.confirm);
        tv1.setText("Plumber "+getIntent().getStringExtra("CARPENTER"));
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(bookingp.this,"Successful,You Will Receive Confirmation Email",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
