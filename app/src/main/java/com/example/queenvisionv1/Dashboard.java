package com.example.queenvisionv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    private Button mLibraries;
    private Button mUsefullMaterial;
    private Button mTutorials;
    private Button mAbout;
    private Button mContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mLibraries = findViewById(R.id.LibrariesBtn);
        mUsefullMaterial = findViewById(R.id.UsefulMaterialBtn);
        mTutorials = findViewById(R.id.Tutorials);
        mAbout = findViewById(R.id.AboutBtn);
        mContact = findViewById(R.id.ContactBtn);

        mLibraries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Libraries.class);
                startActivity(intent);
            }
        });

        mUsefullMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,UsefullMaterials.class);
                startActivity(intent);
            }
        });

        mTutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Tutorials.class);
                startActivity(intent);
            }
        });

        mAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,About.class);
                startActivity(intent);
            }
        });

        mContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Contact.class);
                startActivity(intent);
            }
        });

    }
}