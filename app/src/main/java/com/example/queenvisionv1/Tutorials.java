package com.example.queenvisionv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorials extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);

        Button tutbutton = findViewById(R.id.Tut1Btn);
        Button tut2button = findViewById(R.id.Tut2Btn);
        Button tut3button = findViewById(R.id.Tut3Btn);
        Button tut4button = findViewById(R.id.Tut4Btn);

        tutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Tutorials.this, Tutorial1.class);
                startActivity(intent);
            }
        });

        tut2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Tutorials.this, Tutorial2.class);
                startActivity(intent);
            }
        });

        tut3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Tutorials.this, Tutoriall3.class);
                startActivity(intent);
            }
        });

        tut4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Tutorials.this, Tutorial4.class);
                startActivity(intent);
            }
        });

    }
}