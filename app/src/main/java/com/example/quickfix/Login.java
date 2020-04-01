package com.example.quickfix;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
/*import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;*/
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
/*import com.google.android.gms.auth.api.signin.GoogleSignInResult;*/
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import android.os.Bundle;

public class Login extends AppCompatActivity  {
    private EditText eid;
    private EditText epass;
    private Button lgn;
    private FirebaseAuth firebaseAuth;
    private TextView fpass;
    private Button google1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eid =  findViewById(R.id.id);
        epass =  findViewById(R.id.pass);
        lgn =  findViewById(R.id.lgnbtn);
        firebaseAuth = FirebaseAuth.getInstance();
        google1= findViewById(R.id.gbutton);


        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = eid.getText().toString().trim();
                String password = epass.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(Login.this, "Password too short", Toast.LENGTH_SHORT).show();
                }


                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    if(firebaseAuth.getCurrentUser().isEmailVerified()){

                                        startActivity(new Intent(getApplicationContext(), FirstPageAfterLogin.class));
                                        Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Login.this,"please verify your email first",Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }

        });
        TextView fpass = (TextView) findViewById(R.id.forgotpassword);
        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Login.this,forgot_password.class);
                startActivity(r);
            }});
        google1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(Login.this,google.class);
                startActivity(r);
            }});
        BottomNavigationView bottomNavigationView = findViewById(R.id.b_nav);
        bottomNavigationView.setSelectedItemId(R.id.profile);
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
                        return true;
                }
                return false;
            }
        });
    }




}

