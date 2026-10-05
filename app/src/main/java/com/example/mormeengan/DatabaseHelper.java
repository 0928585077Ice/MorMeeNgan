package com.example.mormeengan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "mormeengan.db";
    public static final int DB_VERSION = 3;
    public static final String TABLE_NAME = "jobs";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "title";
    public static final String COL_LAST_NAME = "last_name";
    public static final String COL_SCORE = "score";
    public DatabaseHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_LAST_NAME + " TEXT, " +
                COL_SCORE + " REAL)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

