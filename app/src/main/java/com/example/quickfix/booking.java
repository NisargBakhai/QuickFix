package com.example.quickfix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class booking extends AppCompatActivity {
    TextView tv1;


    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        tv1=findViewById(R.id.textView3);
        confirm=findViewById(R.id.confirm);
        tv1.setText("Carpenter "+getIntent().getStringExtra("CARPENTER"));
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(booking.this,"Successful,You Will Receive Confirmation Email",Toast.LENGTH_SHORT).show();

            }
        });
            }




    }

