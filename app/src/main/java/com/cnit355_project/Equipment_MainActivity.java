package com.cnit355_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Equipment_MainActivity extends AppCompatActivity {
    Fragment Main= new MainEquip();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_main);



        //TODO: Same applies here as below. Only the definition of the if condition below is necessary to handle the fragments. Most of it is done from MainEquip.java
        //I'm leaving them commented in case you had other plans.



        if(savedInstanceState == null)
           getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.mainfragmentview, Main, null).commit();



    }


    // TODO: This block is unnecessary (I think) because this activity isn't what handles the fragment swapping.


}

