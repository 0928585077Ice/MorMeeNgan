package com.example.mormeengan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

public class CreateJobActivity extends AppCompatActivity {


    EditText etJobTitle, etJobDescription, etJobType,etSalary,etDeadline,etPeopleCount;
    MaterialCardView btnBack;

    TextView btnPostJob;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_createjob);

        etJobTitle = findViewById(R.id.etJobTitle);
        etJobDescription = findViewById(R.id.etJobDescription);
        etJobType = findViewById(R.id.etJobType);
        etSalary = findViewById(R.id.etSalary);
        etDeadline = findViewById(R.id.etDeadline);
        etPeopleCount = findViewById(R.id.etPeopleCount);
        btnBack = findViewById(R.id.btnBack);


        btnPostJob = findViewById(R.id.btnPostJob);


        databaseHelper = new DatabaseHelper(this);

        btnBack.setOnClickListener(v -> finish());

        btnPostJob.setOnClickListener(v -> saveJob());


    }

    private void saveJob() {
        String title = etJobTitle.getText().toString().trim();
        String description = etJobDescription.getText().toString().trim();
        String jopType = etJobType.getText().toString().trim();
        String peoplecount = etPeopleCount.getText().toString().trim();
        String salary = etSalary.getText().toString().trim();
        String deadline = etDeadline.getText().toString().trim();

        if(title.isEmpty()
        || description.isEmpty()
        || jopType.isEmpty()
        || peoplecount.isEmpty()
        || salary.isEmpty()
        || deadline.isEmpty()) {

            Toast.makeText(this,"กรุณากรอกข้อมูลให้ครบ",Toast.LENGTH_SHORT).show();
            return;
        }

        int peopleCount;
        try {
            peopleCount = Integer.parseInt(peoplecount);
        } catch (NumberFormatException e) {
            Toast.makeText(this,"จำนวนคนไม่ถูกต้อง",Toast.LENGTH_SHORT).show();
            return;
        }

        boolean success = databaseHelper.insertJob(
                title,description,jopType,peopleCount,salary,deadline
        );

        if(success) {
            Toast.makeText(this,"เพิ่มงานสำเร็จ",Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this,"ไม่สามารถเพื่มงานได้",Toast.LENGTH_SHORT).show();
        }
    }
}