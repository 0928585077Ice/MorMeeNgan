package com.example.mormeengan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "mormeengan.db";
    public static final int DB_VERSION = 4;
    public static final String TABLE_NAME = "jobs";
    public static final String COL_ID = "id";
    public static final String COL_TITLE = "title";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_JOB_TYPE = "job_type";
    public static final  String COL_PEOPLE_COUNT = "people_count";
    public static final  String COL_SALARY = "salary";
    public static final  String COL_DEADLINE = "deadline";
    public DatabaseHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TITLE + " TEXT NOT NULL, " +
                COL_DESCRIPTION + " TEXT NOT NULL, " +
                COL_JOB_TYPE + " TEXT NOT NULL, " +
                COL_PEOPLE_COUNT + " INTEGER NOT NULL, " +
                COL_SALARY + " TEXT NOT NULL, " +
                COL_DEADLINE + " TEXT NOT NULL" +
                ")");
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public  boolean insertJob(
            String title,
            String description,
            String jobType,
            int peopleCount,
            String salary,
            String deadline
    )
    {
       SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COL_TITLE, title);
        values.put(COL_DESCRIPTION, description);
        values.put(COL_JOB_TYPE, jobType);
        values.put(COL_SALARY, salary);
        values.put(COL_PEOPLE_COUNT, peopleCount);
        values.put(COL_DEADLINE, deadline);

        long result = db.insert(
                TABLE_NAME,null,values
        );
            db.close();

            return result != -1;
    }
    public Cursor getAllJobs(){
        SQLiteDatabase db = getReadableDatabase();

        return db.query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                COL_ID + " DESC"
        );
    }
}

