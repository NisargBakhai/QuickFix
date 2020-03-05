package com.example.quickfix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_password extends AppCompatActivity {

    EditText email;
    Button send;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email=(EditText) findViewById(R.id.resetemail);
        send=(Button) findViewById(R.id.sendbutton);
        mAuth=FirebaseAuth.getInstance();


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailreset=email.getText().toString();
                mAuth.sendPasswordResetEmail(emailreset).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(forgot_password.this,"Send you password reset email check it",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(forgot_password.this,MainActivity.class));
                        }
                    }
                });
            }

        });
    }
}