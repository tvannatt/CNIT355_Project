package com.cnit355_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutPlanActivity extends AppCompatActivity {


    //TODO: I'm thinking of adding the ability to update the exercises from this activity as well, just to fill some of the space.
    // I'm not really sure how to design this tbh.

    TextView test1;
    SqlDBHelper myHelper;
    SQLiteDatabase db;
    String Table_Name="workoutplan";
    ScrollView sc1;
    StringBuilder str1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutplan);

        myHelper = new SqlDBHelper(this);

        test1 = findViewById(R.id.textTest);
        sc1 = findViewById(R.id.scrollView2);



        onLoad();

    }

    public void onWPClick(View v) {
        clearScrollView();
        Toast.makeText(this, "Cleared!", Toast.LENGTH_SHORT).show();
    }

    private void clearScrollView() {
        test1.setText("");
        db = myHelper.getWritableDatabase();
        db.execSQL("DELETE FROM workoutplan");
    }

    public void onEquipClick(View v) {
        Intent mIntent = new Intent(v.getContext(), Equipment_MainActivity.class);
        startActivity(mIntent);
        Log.i("Log", "Intent to Equipment_MainActivity Started");
    }
    public void onHomeClick(View v) {
        Intent mIntent = new Intent(v.getContext(), MainActivity.class);
        startActivity(mIntent);
        Log.i("Log", "Intent to MainActivity Started");
    }
    public void onLoad()
    {
        try {
            db = myHelper.getReadableDatabase();
            Cursor c;
            c = db.rawQuery("SELECT * FROM "+ Table_Name, null);


            str1 = new StringBuilder(0);

            while (c.moveToNext())
            {

                str1.append("\n\n\nExercise Name:  ");
                str1.append(c.getString(0)).append("\n\t\t").append("Sets: ");
                str1.append(c.getString(1)).append("\n\t\t").append("Reps: ");
                str1.append(c.getString(2)).append("\n\t\t").append("Groups: ");
                str1.append(c.getString(3));


            }



            test1.setText(str1);


            c.close();
            db.close();
            Toast.makeText(getApplicationContext(), "Query Made", Toast.LENGTH_SHORT).show();

        } catch (Exception ex)
        {
            ex.printStackTrace();
            Toast.makeText(this, "Database is empty or does not exist.", Toast.LENGTH_SHORT).show();
        }
    }

}
