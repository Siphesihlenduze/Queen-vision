package com.example.queenvisionv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.UUID;

public class Enroll extends AppCompatActivity {

    private EditText mName, mLastname, mAge, mCell, mGrade, mCity, mTopofinterest;
    private Button mSavebtn, mShowbtn;
    private FirebaseFirestore db;
    private String uName, uLastname, uAge, uCellnumber, uGrade, uCity, uTopofinterest, uId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        mName = findViewById(R.id.UserNameField);
        mLastname = findViewById(R.id.UserLastNameField);
        mAge = findViewById(R.id.UserAgeField);
        mCell = findViewById(R.id.UserCellField);
        mGrade = findViewById(R.id.UserGradeField);
        mCity = findViewById(R.id.UserCityField);
        mTopofinterest = findViewById(R.id.TopicsOfInterestField);
        mSavebtn = findViewById(R.id.UploadBtn);
        mShowbtn = findViewById(R.id.DisEnrollBtn);

        db = FirebaseFirestore.getInstance();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){

            mSavebtn.setText("Update");
            uName = bundle.getString("uName");
            uId = bundle.getString("uId");
            uLastname = bundle.getString("uLastname");
            uAge = bundle.getString("uAge");
            uCellnumber = bundle.getString("uCellnumber");
            uGrade = bundle.getString("uGrade");
            uCity = bundle.getString("uCity");
            uTopofinterest = bundle.getString("uTopofinterest");
            mName.setText(uName);
            mLastname.setText(uLastname);
            mAge.setText(uAge);
            mCell.setText(uCellnumber);
            mGrade.setText(uGrade);
            mCity.setText(uCity);
            mTopofinterest.setText(uTopofinterest);

        }else{

            mSavebtn.setText("Save");

        }

        mShowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Enroll.this, DisplayInfo.class));
            }
        });

        mSavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String lastname = mLastname.getText().toString();
                String age = mAge.getText().toString();
                String cell = mCell.getText().toString();
                String grade = mGrade.getText().toString();
                String city = mCity.getText().toString();
                String topicofinterest = mTopofinterest.getText().toString();

                Bundle bundle1 = getIntent().getExtras();
                if(bundle1 != null){
                    String id = uId;
                    updateToFirestore(id, name, lastname, age, cell, grade, city, topicofinterest);

                }else{
                    String id = UUID.randomUUID().toString();
                    saveToFireStore(id, name, lastname, age, cell, grade, city, topicofinterest);

                }

            }
        });

    }

    private void updateToFirestore(String id, String name, String lastname, String age, String cell, String grade, String city, String topicofinterest){

        db.collection("Documents").document(id).update("name", name, "lastname", lastname, "age", age, "cell", cell, "grade", grade, "city", city, "topicofinterest", topicofinterest)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Enroll.this, "Data has been updated successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Enroll.this, "Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Enroll.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void saveToFireStore(String id, String name, String lastname, String age, String cell, String grade, String city, String topicofinterest) {

        if (!name.isEmpty() && !lastname.isEmpty() && !age.isEmpty() && !cell.isEmpty() && !grade.isEmpty() && !city.isEmpty() && !topicofinterest.isEmpty()) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", id);
            map.put("name", name);
            map.put("lastname", lastname);
            map.put("age", age);
            map.put("cell", cell);
            map.put("grade", grade);
            map.put("city", city);
            map.put("topicofinterest", topicofinterest);

            db.collection("Documents").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Enroll.this, "Data has been saved successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Enroll.this, "Unfortunately data has not been stored successfully", Toast.LENGTH_SHORT).show();
                        }
                    });

        }else
            Toast.makeText(this, "Empty fields are not allowed please fill in all the fields", Toast.LENGTH_SHORT).show();


    }
}