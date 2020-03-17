package com.example.quickfix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class bookinge extends AppCompatActivity {
    TextView tv1;


    Button confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookinge);
        tv1=findViewById(R.id.textView3);
        confirm=findViewById(R.id.confirm);
        tv1.setText("Electrician "+getIntent().getStringExtra("CARPENTER"));
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(bookinge.this,"Successful,You Will Receive Confirmation Email",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
