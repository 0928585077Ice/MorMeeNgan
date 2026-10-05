package com.example.mormeengan;

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

    LinearLayout navHome, navProfile;
    FrameLayout navAddJob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navHome = findViewById(R.id.navHome);
        navAddJob = findViewById(R.id.navAddJob);
        navProfile = findViewById(R.id.navProfile);

        navHome.setOnClickListener(v -> {});

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