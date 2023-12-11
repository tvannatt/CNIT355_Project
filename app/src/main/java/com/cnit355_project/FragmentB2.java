package com.cnit355_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;


public class FragmentB2 extends Fragment implements View.OnClickListener {


    // Database helper and cursor
    SqlDBHelper myHelper;
    SQLiteDatabase db;
    Cursor c;
    // UI components
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    Button buttonBack, buttonRemove,buttonInsert, buttonUpdate, buttonWorkoutPlan;
    View view;
    TextView error;
    EditText et1_set, et1_rep, et2_set, et2_rep, et3_set,  et3_rep, et4_set, et4_rep;

    public FragmentB2() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_b2, container, false);

        myHelper = new SqlDBHelper(getActivity());

        // Replace these IDs with the actual IDs used in your XML layout
        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox4 = view.findViewById(R.id.checkBox4);
        buttonBack = view.findViewById(R.id.buttonBack1);
        buttonRemove = view.findViewById(R.id.buttonRemove);
        buttonInsert = view.findViewById(R.id.buttonInsert);
        buttonWorkoutPlan=view.findViewById(R.id.buttonWorkoutPlan);
        buttonUpdate  = view.findViewById(R.id.buttonUpdate);
        et1_set= view.findViewById(R.id.editText);

        et1_rep= view.findViewById(R.id.editText2);
        et2_set= view.findViewById(R.id.editText3);
        et2_rep= view.findViewById(R.id.editText4);

        et3_set= view.findViewById(R.id.editText5);
        et3_rep= view.findViewById(R.id.editText6);
        et4_set=view.findViewById(R.id.editText7);
        et4_rep=view.findViewById(R.id.editText8);

        error = view.findViewById(R.id.textError);

        // Set click listeners for the checkboxes
        checkBox1.setOnClickListener(this);
        checkBox2.setOnClickListener(this);
        checkBox3.setOnClickListener(this);
        checkBox4.setOnClickListener(this);

        buttonBack.setOnClickListener(this);
        buttonInsert.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);
        buttonRemove.setOnClickListener(this);
        buttonWorkoutPlan.setOnClickListener(this);


        error = view.findViewById(R.id.textError);
        // Load images using Glide
        ImageView imageView1= (ImageView) view.findViewById(R.id.imageView1);
        ImageView imageView2= (ImageView) view.findViewById(R.id.imageView2);
        ImageView imageView3= (ImageView) view.findViewById(R.id.imageView3);
        ImageView imageView4= (ImageView) view.findViewById(R.id.imageView4);

        Glide.with(getActivity()).load(R.drawable.hammer_curl).into(imageView1);
        Glide.with(getActivity()).load(R.drawable.concentration_curl).into(imageView2);
        Glide.with(getActivity()).load(R.drawable.incline_curl).into(imageView3);
        Glide.with(getActivity()).load(R.drawable.spider_curl).into(imageView4);


        return view;
    }



    @Override
    public void onClick(View v) {
        //Check if back button pressed
        if (v.getId() == R.id.buttonBack1) {
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        }

        //Check if remove button pressed and removes selected workout
        else if (v.getId() == R.id.buttonRemove) {
            if (checkBox1.isChecked()) {
                myHelper.deleteData("Hammer Curl");
                Log.i("FragB2", "Hammer Curl Deleted");
            } else {
                Log.i("FragB2", "Hammer Curl Doesn't Exist");

            }
            if (checkBox2.isChecked()) {
                myHelper.deleteData("Concentration Curl");
                Log.i("FragB2", "Concentration Curl Deleted");

            } else {
                Log.i("FragB2", "Concentration Curl Doesn't Exist");

            }
            if (checkBox3.isChecked()) {
                myHelper.deleteData("Incline Curl");
            } else {
                Log.i("FragB2", "Incline Curl Doesn't Exist");

            }
            if (checkBox4.isChecked()) {
                myHelper.deleteData("Spider Curl");
            } else {
                Log.i("FragB2", "Spider Curl Doesn't Exist");

            }
            //TODO: Repeat the above logic for the other 3 checkboxes.

            Toast.makeText(getActivity(), "Removed selections from Workout Plan.", Toast.LENGTH_SHORT).show();
        }

        //Check if insert button pressed and insert selected workout
        else if (v.getId() == R.id.buttonInsert)
        {
            if (checkBox1.isChecked()) {

                if (checkIfAlreadyAdded("Hammer Curl")) {
                    Log.i("FragB2", "Hammer Curl Already Added");

                    error.append("\t\t\nHammer Curl already added to Workout Plan.");
                } else
                    myHelper.insertData("Hammer Curl", et1_set.getText().toString(), et1_rep.getText().toString(), "B2");
                Log.i("FragB2", "Hammer Curl inserted");
                c.close();
            }
            if (checkBox2.isChecked()) {
                if (checkIfAlreadyAdded("Concentration Curl")) {
                    Log.i("FragB2", "Concentration Curl Already Added");

                    error.append("\t\t\nConcentration Curl already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Concentration Curl", et2_set.getText().toString(), et2_rep.getText().toString(), "B2");
                    Log.i("FragB2", "Concentration Curl inserted");
                    c.close();
                }
            }

            if (checkBox3.isChecked()) {

                if (checkIfAlreadyAdded("Incline Curl")) {
                    Log.i("FragB2", "Incline Curl Already Added");

                    error.append("\t\t\nIncline Curl already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Incline Curl", et3_set.getText().toString(), et3_rep.getText().toString(), "B2");
                    Log.i("FragB2", "Incline Curl inserted");
                    c.close();
                }

            }
            if (checkBox4.isChecked()) {

                if (checkIfAlreadyAdded("Spider Curl")) {
                    Log.i("FragB2", "Spider Curl Already Added");

                    error.append("\t\t\nSpider Curl already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Spider Curl", et4_set.getText().toString(), et4_rep.getText().toString(), "B2");
                    Log.i("FragB2", "Spider Curl");
                    c.close();
                }
            }
        }
        //Check if update button pressed and update selected workout
        else if (v.getId() == R.id.buttonUpdate) {
            if (checkBox1.isChecked()) {

                if (checkIfAlreadyAdded("Hammer Curl")) {
                    if (et1_set.getText() != null || et1_rep.getText() != null) {
                        myHelper.updateData("Hammer Curl", et1_set.getText().toString(), et1_rep.getText().toString());
                    }
                }
            }
            if (checkBox2.isChecked()) {

                if (checkIfAlreadyAdded("Concentration Curl")) {
                    if (et2_set.getText() != null || et2_rep.getText() != null) {
                        myHelper.updateData("Concentration Curl",  et2_set.getText().toString(), et2_rep.getText().toString());
                    }

                }
            }
            if (checkBox3.isChecked()) {

                if (checkIfAlreadyAdded("Incline Curl")) {
                    if (et3_set.getText() != null || et3_rep.getText() != null) {
                        myHelper.updateData("Incline Curl",  et3_set.getText().toString(), et3_rep.getText().toString());
                    }
                }
            }
            if (checkBox4.isChecked()) {

                if (checkIfAlreadyAdded("Spider Curl")) {
                    if (et4_set.getText() != null || et4_rep.getText() != null) {
                        myHelper.updateData("Spider Curl",  et4_set.getText().toString(), et4_rep.getText().toString());
                    }
                }
            }


        }
        //Check if Workout Plan button pressed and goes to Workout Plan Activity

        else if (v.getId() == R.id.buttonWorkoutPlan) {

            Intent mIntent = new Intent(v.getContext(), WorkoutPlanActivity.class);
            startActivity(mIntent);
            Log.i("Log", "Intent to WorkoutPlan Started");
        }
    }
    // Method to check if an exercise is already added to the workout plan
    public boolean checkIfAlreadyAdded(String name) {
        db = myHelper.getReadableDatabase();
        c = db.rawQuery("SELECT eName FROM workoutplan WHERE eName =?", new String[]{name});

        if (c.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}