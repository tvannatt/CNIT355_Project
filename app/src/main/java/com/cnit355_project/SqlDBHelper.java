package com.cnit355_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlDBHelper extends SQLiteOpenHelper {

    public SqlDBHelper(Context context)
    {
        super(context, "RecMate", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE workoutplan (eName CHAR (20) PRIMARY KEY, nSets CHAR(2), nReps CHAR(2), wGroup CHAR(2));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS workoutplan");
        onCreate(db);

    }

    public boolean insertData(String name, String sets, String reps, String group)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put ("eName", name);
        contentValues.put ("nSets", sets);
        contentValues.put ("nReps", reps);
        contentValues.put("nGroup", group);
        db.insert("workoutplan", null, contentValues);
        return true;
    }


    public boolean updateData(String name, String sets, String reps)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nSets", sets);
        cv.put("nReps", reps);
        db.update("workoutplan", cv, "eName = ?", new String[] {name});
        return true;
    }


    public Integer deleteData (String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("workoutplan", "eName = ?", new String[] {name});
    }


}
