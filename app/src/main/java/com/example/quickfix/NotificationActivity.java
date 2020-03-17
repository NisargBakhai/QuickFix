package com.example.quickfix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        TextView t = findViewById(R.id.tv9);
        String message = getIntent().getStringExtra("message");
        t.setText(message);
    }
}
