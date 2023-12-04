package com.cnit355_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutPlanActivity extends AppCompatActivity {


    //TODO: Replace this entire activity. All that's here right now is something for me to test my changes to the database.

    TextView test1, test2, test3, test4;
    SqlDBHelper myHelper;
    SQLiteDatabase db;
    String Table_Name="workoutplan";
    StringBuilder str1, str2, str3, str4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutplan);

        myHelper = new SqlDBHelper(this);

        test1 = findViewById(R.id.textTest);
        test2 = findViewById(R.id.textTest2);
        test3 = findViewById(R.id.textTest3);
        test4 = findViewById(R.id.textTest4);


        onLoad();

    }

    public void onWPClick(View v)
    {
        finish();
    }


    public void onLoad()
    {
        try {
            db = myHelper.getReadableDatabase();
            Cursor c;
            c = db.rawQuery("SELECT * FROM "+ Table_Name, null);

            String strName = "Name" + "\r\n" + "--------" + "\r\n";
            String strSets = "Sets" + "\r\n" + "--------" + "\r\n";
            String strReps = "Reps" + "\r\n" + "--------" + "\r\n";
            String strGroup = "Group" + "\r\n" + "--------" + "\r\n";



            while (c.moveToNext())
            {
                strName += c.getString(0) + "\r\n\n\n\n";
                strSets += c.getString(1) + "\r\n\n\n\n\n";
                strReps += c.getString(2) + "\r\n\n\n\n\n";
                strGroup += c.getString(3) + "\r\n\n\n\n\n";
            }

            test1.setText(strName);
            test2.setText(strSets);
            test3.setText(strReps);
            test4.setText(strGroup);


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
