package com.example.queenvisionv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFactivityGrd2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfgrd2);

        PDFView pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("Grade2.pdf").load();
    }
}