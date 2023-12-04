package com.cnit355_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqlDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;


    // Simple DB helper to allow universal access to the database.

    public SqlDBHelper(Context context)
    {
        super(context, "RecMate", null, DATABASE_VERSION);
    }
String table_name="workoutplan";



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS "+ table_name +"(eName CHAR (20) PRIMARY KEY, nSets CHAR(2), nReps CHAR(2), nGroup CHAR(2));");
        Log.i("Table Created", "DB Table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS workoutplan");
        onCreate(db);

    }

    public void insertData(String name, String sets, String reps, String group)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put ("eName", name);
        contentValues.put ("nSets", sets);
        contentValues.put ("nReps", reps);
        contentValues.put("nGroup", group);
        db.insert("workoutplan", null, contentValues);
        db.close();
    }


    public void updateData(String name, String sets, String reps)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nSets", sets);
        cv.put("nReps", reps);
        db.update("workoutplan", cv, "eName = ?", new String[] {name});
        db.close();
        Log.i("DPHELP: update s: ", sets + "r " + reps);
    }


    public void deleteData (String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("workoutplan", "eName = ?", new String[]{name});
    }


}
