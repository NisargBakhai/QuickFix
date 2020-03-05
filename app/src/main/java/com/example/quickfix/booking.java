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
                String message = "Booking Confirmed";
                NotificationCompat.Builder builder= new NotificationCompat.Builder(
                        booking.this
                )
                        .setSmallIcon(R.drawable.ic_message)
                        .setContentTitle("Booking Confirmed")
                        .setContentText(message)
                        .setAutoCancel(true);
                Intent intent = new Intent(booking.this,NotificationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message",message);

                PendingIntent pendingIntent = PendingIntent.getActivity(booking.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());
            }



        });
    }
}
