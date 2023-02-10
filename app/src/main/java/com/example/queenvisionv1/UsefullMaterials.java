package com.example.queenvisionv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UsefullMaterials extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usefull_materials);

        Button button = findViewById(R.id.Grd1Btn);
        Button button2 = findViewById(R.id.Grd2Btn);
        Button button3 = findViewById(R.id.Grd3Btn);
        Button button4 = findViewById(R.id.Grd4Btn);
        Button button5 = findViewById(R.id.Grd5Btn);
        Button button6 = findViewById(R.id.Grd6Btn);
        Button button7 = findViewById(R.id.Grd7Btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UsefullMaterials.this, PDFactivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UsefullMaterials.this, PDFactivityGrd2.class);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UsefullMaterials.this, PDFactivityGrd3.class);
                startActivity(intent);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UsefullMaterials.this, PDFactivityGrd4.class);
                startActivity(intent);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UsefullMaterials.this, PDFactivityGrd5.class);
                startActivity(intent);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UsefullMaterials.this, PDFactivityGrd6.class);
                startActivity(intent);

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UsefullMaterials.this, PDFactivityGrd7.class);
                startActivity(intent);

            }
        });
    }
}