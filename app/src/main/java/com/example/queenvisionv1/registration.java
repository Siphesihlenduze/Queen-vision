package com.example.queenvisionv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {

    EditText EmailUser;
    EditText PassUser;
    TextView RegToLogin;
    Button SubmitUser;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EmailUser = findViewById(R.id.Username);
        PassUser = findViewById(R.id.Password);
        RegToLogin = findViewById(R.id.LoginFromReg);
        SubmitUser = findViewById(R.id.SubmitBtn);

        mAuth = FirebaseAuth.getInstance();
        SubmitUser.setOnClickListener(view ->{
            createUser();
        });

        RegToLogin.setOnClickListener(view ->{
            startActivity(new Intent(registration.this, MainActivity.class));
        });

    }

    private void createUser(){
        String email = EmailUser.getText().toString();
        String password = PassUser.getText().toString();

        if (TextUtils.isEmpty(email)){
            EmailUser.setError("Email cannot be empty, please enter your email");
            PassUser.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            EmailUser.setError("Password cannot be empty, please enter your password");
            PassUser.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(registration.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(registration.this, MainActivity.class));
                    }else{
                        Toast.makeText(registration.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}