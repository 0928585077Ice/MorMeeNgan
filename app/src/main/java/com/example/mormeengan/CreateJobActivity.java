package com.example.mormeengan;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateJobActivity extends AppCompatActivity {


    EditText etJobTitle, etJobDescription, etJobType,etSalary,etDeadline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_createjob);

        etJobTitle = findViewById(R.id.etJobTitle);
        etJobDescription = findViewById(R.id.etJobDescription);
        etJobType = findViewById(R.id.etJobType);
        etSalary = findViewById(R.id.etSalary);
        etDeadline = findViewById(R.id.etDeadline);


    }
}