package com.example.quickfix;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private EditText textInputEmail;
    private EditText textInputPassword;
    private EditText textInputPassword_c;
    // ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_signup);
        super.onCreate(savedInstanceState);
        textInputEmail=findViewById(R.id.user_eid);
        textInputPassword=findViewById(R.id.ps);
        textInputPassword_c=findViewById(R.id.ps2);
        register=findViewById(R.id.register);
        firebaseAuth=FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email=textInputEmail.getText().toString().trim();
                final String password=textInputPassword.getText().toString().trim();
                String password_c=textInputPassword_c.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(signup.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(signup.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password_c))
                {
                    Toast.makeText(signup.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length()<6)
                {
                    Toast.makeText(signup.this, "Password too short", Toast.LENGTH_SHORT).show();
                }
                if(!(password.equals(password_c)))
                {
                    Toast.makeText(signup.this,"Password not match", Toast.LENGTH_SHORT).show();
                }

                if(password.equals(password_c))
                {

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //  progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {


                                        firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){

                                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                                    Toast.makeText(signup.this, "Please verify your email", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });

                                    } else {
                                        Toast.makeText(signup.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }


                                }
                            });
                }
            }
        });
    }
}
