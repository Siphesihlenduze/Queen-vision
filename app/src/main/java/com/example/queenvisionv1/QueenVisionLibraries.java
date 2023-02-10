package com.example.queenvisionv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QueenVisionLibraries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queen_vision_libraries);

        Button locbutton = findViewById(R.id.QVLibrLocBtn);

        locbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QueenVisionLibraries.this, LibraryLocations.class);
                startActivity(intent);
            }
        });
    }
}