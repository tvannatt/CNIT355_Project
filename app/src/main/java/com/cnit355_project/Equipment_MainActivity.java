package com.cnit355_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Equipment_MainActivity extends AppCompatActivity {
    Fragment Main= new MainEquip();

    /*
    FragmentA1 fragmentA1= new FragmentA1();
    FragmentA2 fragmentA2= new FragmentA2();
    FragmentA3 fragmentA3= new FragmentA3();

    FragmentB1 fragmentB1= new FragmentB1();
    FragmentB2 fragmentB2= new FragmentB2();

    FragmentB3 fragmentB3= new FragmentB3();
    FragmentC1 fragmentC1= new FragmentC1();
    FragmentD1 fragmentD1= new FragmentD1();

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_main);



        //TODO: Same applies here as below. Only the definition of the if condition below is necessary to handle the fragments. Most of it is done from MainEquip.java
        //I'm leaving them commented in case you had other plans.

        /*
        fragmentA1 = (FragmentA1) getSupportFragmentManager().findFragmentById(R.id.mainfragmentview);
        fragmentB1 = (FragmentB1) getSupportFragmentManager().findFragmentById(R.id.mainfragmentview);
        fragmentC1 = (FragmentC1) getSupportFragmentManager().findFragmentById(R.id.mainfragmentview);
        fragmentB2 = (FragmentB2) getSupportFragmentManager().findFragmentById(R.id.mainfragmentview);

         */

        if(savedInstanceState == null)
           getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.mainfragmentview, Main, null).commit();



    }


    // TODO: This block is unnecessary (I think) because this activity isn't what handles the fragment swapping.
    /*
public void onFragmentChanged(int index) {
    if (index == 0) {

        getSupportFragmentManager().beginTransaction().replace(R.id.mainfragmentview, fragmentA1).addToBackStack(null).commit();

    } else if (index == 1) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainfragmentview, fragmentA2).addToBackStack(null).commit();

    }
    else if (index == 2) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainfragmentview, fragmentA3).addToBackStack(null).commit();

    }
    else if (index == 3) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainfragmentview, fragmentB1).addToBackStack(null).commit();

    }
    else if (index == 4) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainfragmentview, fragmentB2).addToBackStack(null).commit();

    }
    else if (index == 5) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainfragmentview, fragmentB3).addToBackStack(null).commit();

    }
    else if (index == 6) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainfragmentview, fragmentC1).addToBackStack(null).commit();

    }
    else if (index == 7) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainfragmentview, fragmentD1).addToBackStack(null).commit();


    }
    else if (index == 8) {
        getSupportFragmentManager().popBackStack();


    }
}

     */
}

