package com.example.mormeengan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LinearLayout navHome, navProfile,btnlistJobs;
    FrameLayout navAddJob;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navHome = findViewById(R.id.navHome);
        navAddJob = findViewById(R.id.navAddJob);
        navProfile = findViewById(R.id.navProfile);
        btnlistJobs = findViewById(R.id.btnlistJobs);

        navHome.setOnClickListener(v -> {});


        btnlistJobs.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,ListJobActivity.class);
            startActivity(intent);
        });

        navAddJob.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,CreateJobActivity.class);
        startActivity(intent);
        });

        navProfile.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
        });
    }
}