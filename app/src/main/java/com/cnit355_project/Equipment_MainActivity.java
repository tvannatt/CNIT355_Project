package com.cnit355_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Equipment_MainActivity extends AppCompatActivity {

    Fragment Main;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_main);

        if(savedInstanceState == null)
           getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.mainfragmentview, MainEquip.class, null).commit();



    }

}
