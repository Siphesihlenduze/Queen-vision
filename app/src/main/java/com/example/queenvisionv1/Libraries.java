package com.example.queenvisionv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Libraries extends AppCompatActivity {

    private Button mQueenVisionLibraries;
    private Button mEnroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libraries);

        mQueenVisionLibraries = findViewById(R.id.QVlibrariesBtn);
        mEnroll = findViewById(R.id.EnrollBtn);

        mQueenVisionLibraries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Libraries.this, QueenVisionLibraries.class);
                startActivity(intent);
            }

        });

        mEnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Libraries.this, Enroll.class);
                startActivity(intent);
            }

        });
    }
}
