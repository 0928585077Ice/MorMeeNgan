package com.example.mormeengan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName,btnLogout;
    LinearLayout navProfile,navHome;
    FrameLayout navAddJob;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        navHome = findViewById(R.id.navHome);
        navAddJob = findViewById(R.id.navAddJob);
        navProfile = findViewById(R.id.navProfile);
        tvName = findViewById(R.id.tvName);
        btnLogout = findViewById(R.id.btnLogout);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        tvName.setText("Welcome : "+ (user != null ? user.getEmail() : null));

        btnLogout.setOnClickListener(v -> {
            auth.signOut();
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        navProfile.setOnClickListener(v -> {});

        navAddJob.setOnClickListener(v -> {

            Intent intent = new Intent(ProfileActivity.this,CreateJobActivity.class);
            startActivity(intent);
        });

        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}