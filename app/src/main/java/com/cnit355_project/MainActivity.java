package com.cnit355_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick (View v)
    {

        // Setting up buttons to move to the 3 different activities for main app functions.
        if (v.getId() == R.id.button)
        {
            Intent mIntent = new Intent(this, ClubActivity.class);
            startActivity(mIntent);
        }

        if (v.getId() == R.id.button2)
        {
            Intent mIntent = new Intent(this, EquipmentActivity.class);
            startActivity(mIntent);
        }

        if (v.getId() == R.id.button3)
        {
            Intent mIntent = new Intent(this, WorkoutPlanActivity.class);
            startActivity(mIntent);
        }
    }
}
