package com.example.queenvisionv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText LoginEmailUser;
    EditText LoginPassUser;
    TextView LoginToReg;
    Button LoginSubmitUser;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginEmailUser = findViewById(R.id.Username);
        LoginPassUser = findViewById(R.id.Password);
        LoginToReg = findViewById(R.id.NewAccountReg);
        LoginSubmitUser = findViewById(R.id.SubmitBtn);

        mAuth = FirebaseAuth.getInstance();

        LoginSubmitUser.setOnClickListener(view -> {
            loginUser();
        });
        LoginToReg.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, registration.class));
        });
    }

    private void loginUser(){
        String email = LoginEmailUser.getText().toString();
        String password = LoginPassUser.getText().toString();

        if (TextUtils.isEmpty(email)){
            LoginEmailUser.setError("Email cannot be empty, please enter your email address");
            LoginPassUser.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            LoginEmailUser.setError("Password cannot be empty, please enter your password");
            LoginPassUser.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "successfully logged in", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,Dashboard.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}