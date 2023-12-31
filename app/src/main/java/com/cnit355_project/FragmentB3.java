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


public class FragmentB3 extends Fragment implements View.OnClickListener {


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


    public FragmentB3() {
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
        view = inflater.inflate(R.layout.fragment_b3, container, false);

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

        Glide.with(getActivity()).load(R.drawable.rickshaw_carry).into(imageView1);
        Glide.with(getActivity()).load(R.drawable.wrist_curl_up).into(imageView2);
        Glide.with(getActivity()).load(R.drawable.wrist_roller).into(imageView3);
        Glide.with(getActivity()).load(R.drawable.straight_bar_wrist_roll_up).into(imageView4);

        return view;
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonBack1) {
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        }
        //Check if remove button pressed and removes selected workout
        else if (v.getId() == R.id.buttonRemove) {
            if (checkBox1.isChecked()) {
                myHelper.deleteData("Rickshaw Carry");
                Log.i("FragB3", "Rickshaw Carry Deleted");
            } else {
                Log.i("FragB3", "Rickshaw Carry Doesn't Exist");

            }
            if (checkBox2.isChecked()) {
                myHelper.deleteData("Wrist Curl Up");
                Log.i("FragB3", "Wrist Curl Up Deleted");

            } else {
                Log.i("FragB3", "Wrist Curl Up Doesn't Exist");

            }
            if (checkBox3.isChecked()) {
                myHelper.deleteData("Wrist Roller");
            } else {
                Log.i("FragB3", "Wrist Roller Doesn't Exist");

            }
            if (checkBox4.isChecked()) {
                myHelper.deleteData("Straight Bar Wrist Roll Up");
            } else {
                Log.i("FragB3", "Straight Bar Wrist Roll Up Doesn't Exist");

            }
            //TODO: Repeat the above logic for the other 3 checkboxes.

            Toast.makeText(getActivity(), "Removed selections from Workout Plan.", Toast.LENGTH_SHORT).show();
        }

        //Check if insert button pressed and insert selected workout
        else if (v.getId() == R.id.buttonInsert)
        {
            if (checkBox1.isChecked()) {

                if (checkIfAlreadyAdded("Rickshaw Carry")) {
                    Log.i("FragB3", "Rickshaw Carry Already Added");

                    error.append("\t\t\nRickshaw Carry already added to Workout Plan. ");
                } else
                    myHelper.insertData("Rickshaw Carry", et1_set.getText().toString(), et1_rep.getText().toString(), "B3");
                Log.i("FragB3", "Rickshaw Carry inserted");
                c.close();
            }
            if (checkBox2.isChecked()) {
                if (checkIfAlreadyAdded("Wrist Curl Up")) {
                    Log.i("FragB3", "Wrist Curl Up Already Added");

                    error.append("\t\t\nWrist Curl Up already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Wrist Curl Up", et2_set.getText().toString(), et2_rep.getText().toString(), "B3");
                    Log.i("FragB3", "Wrist Curl Up inserted");
                    c.close();
                }
            }

            if (checkBox3.isChecked()) {

                if (checkIfAlreadyAdded("Wrist Roller")) {
                    Log.i("FragB3", "Wrist Roller Already Added");

                    error.append("\t\t\nWrist Roller already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Wrist Roller", et3_set.getText().toString(), et3_rep.getText().toString(), "B3");
                    Log.i("FragB3", "Wrist Roller inserted");
                    c.close();
                }

            }
            if (checkBox4.isChecked()) {

                if (checkIfAlreadyAdded("Straight Bar Wrist Roll Up")) {
                    Log.i("FragB3", "Straight Bar Wrist Roll Up Already Added");

                    error.append("\t\t\nStraight Bar Wrist Roll Up already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Straight Bar Wrist Roll Up", et4_set.getText().toString(), et4_rep.getText().toString(), "B3");
                    Log.i("FragB3", "Straight Bar Wrist Roll Up");
                    c.close();
                }
            }
        }
        //Check if update button pressed and update selected workout
        else if (v.getId() == R.id.buttonUpdate) {
            if (checkBox1.isChecked()) {

                if (checkIfAlreadyAdded("Rickshaw Carry")) {
                    if (et1_set.getText() != null || et1_rep.getText() != null) {
                        myHelper.updateData("Rickshaw Carry", et1_set.getText().toString(), et1_rep.getText().toString());
                    }
                }
            }
            if (checkBox2.isChecked()) {

                if (checkIfAlreadyAdded("Wrist Curl Up")) {
                    if (et2_set.getText() != null || et2_rep.getText() != null) {
                        myHelper.updateData("Wrist Curl Up",  et2_set.getText().toString(), et2_rep.getText().toString());
                    }

                }
            }
            if (checkBox3.isChecked()) {

                if (checkIfAlreadyAdded("Wrist Roller")) {
                    if (et3_set.getText() != null || et3_rep.getText() != null) {
                        myHelper.updateData("Wrist Roller",  et3_set.getText().toString(), et3_rep.getText().toString());
                    }
                }
            }
            if (checkBox4.isChecked()) {

                if (checkIfAlreadyAdded("Straight Bar Wrist Roll Up")) {
                    if (et4_set.getText() != null || et4_rep.getText() != null) {
                        myHelper.updateData("Straight Bar Wrist Roll Up",  et4_set.getText().toString(), et4_rep.getText().toString());
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