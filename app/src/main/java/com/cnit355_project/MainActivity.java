package com.cnit355_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method called when button is clicked
    public void onClick (View v)
    {
        // Start ClubActivity
        if (v.getId() == R.id.button)
        {
            Intent mIntent = new Intent(this, ClubActivity.class);
            startActivity(mIntent);
        }
        // Start Equipment_MainActivity
        if (v.getId() == R.id.button2)
        {
            Intent mIntent = new Intent(this, Equipment_MainActivity.class);
            startActivity(mIntent);
        }
        // Start WorkoutPlanActivity
        if (v.getId() == R.id.button3)
        {
            Intent mIntent = new Intent(this, WorkoutPlanActivity.class);
            startActivity(mIntent);
        }
    }
}
