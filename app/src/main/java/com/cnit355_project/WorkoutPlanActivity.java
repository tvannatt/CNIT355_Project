package com.cnit355_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutPlanActivity extends AppCompatActivity {


    //TODO: I'm thinking of adding the ability to update the exercises from this activity as well, just to fill some of the space.
    // I'm not really sure how to design this tbh.

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



            str1 = new StringBuilder(0);
            str2 = new StringBuilder(0);
            str3 = new StringBuilder(0);
            str4 = new StringBuilder(0);

            str1.append("Name" + "\r\n" + "--------" + "\r\n");
            str2.append("Sets" + "\r\n" + "--------" + "\r\n");
            str3.append("Reps" + "\r\n" + "--------" + "\r\n");
            str4.append("Group" + "\r\n" + "--------" + "\r\n");

            while (c.moveToNext())
            {
                str1.append(c.getString(0)).append("\r\n\n\n\n");
                str2.append(c.getString(1)).append("\r\n\n\n\n\n");
                str3.append(c.getString(2)).append("\r\n\n\n\n\n");
                str4.append(c.getString(3)).append("\r\n\n\n\n\n");
            }

            test1.setText(str1.toString());
            test2.setText(str2.toString());
            test3.setText(str3.toString());
            test4.setText(str4.toString());


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
