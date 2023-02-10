package com.example.queenvisionv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ContactPDFactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_pdfactivity);

        PDFView pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("ContactQueenVision.pdf").load();
    }
}