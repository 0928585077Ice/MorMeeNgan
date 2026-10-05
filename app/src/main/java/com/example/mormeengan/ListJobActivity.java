package com.example.mormeengan;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListJobActivity extends AppCompatActivity {

    ListView listView;
    Button btnBack;

    DatabaseHelper databaseHelper;

    ArrayList<String> jobList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listjob);

        listView = findViewById(R.id.listView);
        btnBack = findViewById(R.id.btnBack);

        databaseHelper = new DatabaseHelper(this);

        jobList = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                jobList
        );
        listView.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());

        loadJobs();
    }

    private void loadJobs() {

        jobList.clear();

        Cursor cursor = databaseHelper.getAllJobs();

        while (cursor.moveToNext()) {

            String title = cursor.getString(
                    cursor.getColumnIndexOrThrow(
                            DatabaseHelper.COL_TITLE
                    )
            );

            String description = cursor.getString(
                    cursor.getColumnIndexOrThrow(
                            DatabaseHelper.COL_DESCRIPTION
                    )
            );

            String jobType = cursor.getString(
                    cursor.getColumnIndexOrThrow(
                            DatabaseHelper.COL_JOB_TYPE
                    )
            );

            int peopleCount = cursor.getInt(
                    cursor.getColumnIndexOrThrow(
                            DatabaseHelper.COL_PEOPLE_COUNT
                    )
            );

            String salary = cursor.getString(
                    cursor.getColumnIndexOrThrow(
                            DatabaseHelper.COL_SALARY
                    )
            );

            String deadline = cursor.getString(
                    cursor.getColumnIndexOrThrow(
                            DatabaseHelper.COL_DEADLINE
                    )
            );

            String job =
                    title + "\n"
                            + description + "\n"
                            + "ประเภทงาน: " + jobType + "\n"
                            + "จำนวนคน: " + peopleCount + " คน\n"
                            + "ค่าตอบแทน: " + salary + "\n"
                            + "หมดเขต: " + deadline;

            jobList.add(job);
        }

        cursor.close();

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (databaseHelper != null) {
            loadJobs();
        }
    }

    @Override
    protected void onDestroy() {

        if (databaseHelper != null) {
            databaseHelper.close();
        }

        super.onDestroy();
    }
}