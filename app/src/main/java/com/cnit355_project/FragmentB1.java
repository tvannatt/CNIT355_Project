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


public class FragmentB1 extends Fragment implements View.OnClickListener {



    SqlDBHelper myHelper;
    SQLiteDatabase db;
    Cursor c;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    Button buttonBack, buttonRemove,buttonInsert, buttonUpdate, buttonWorkoutPlan;
    View view;
    TextView error;
    EditText et1_set, et1_rep, et2_set, et2_rep, et3_set,  et3_rep, et4_set, et4_rep;

    public FragmentB1() {
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
        view = inflater.inflate(R.layout.fragment_b1, container, false);

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
        ImageView imageView1= (ImageView) view.findViewById(R.id.imageView1);
        ImageView imageView2= (ImageView) view.findViewById(R.id.imageView2);
        ImageView imageView3= (ImageView) view.findViewById(R.id.imageView3);
        ImageView imageView4= (ImageView) view.findViewById(R.id.imageView4);

        Glide.with(getActivity()).load(R.drawable.lat_pull_down).into(imageView1);
        Glide.with(getActivity()).load(R.drawable.weight_pull_up).into(imageView2);
        Glide.with(getActivity()).load(R.drawable.smith_back_squat).into(imageView3);
        Glide.with(getActivity()).load(R.drawable.back_extension).into(imageView4);


        return view;
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonBack1) {
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        }

        // TODO: Replace the "create" button with a "remove" button since the database gets created automatically. Remove button will remove exercises from workoutplan.
        else if (v.getId() == R.id.buttonRemove) {
            if (checkBox1.isChecked()) {
                myHelper.deleteData("Lat Pull Down");
                Log.i("FragB1", "Lat Pull Down Deleted");
            } else {
                Log.i("FragB1", "Lat Pull Down Doesn't Exist");

            }
            if (checkBox2.isChecked()) {
                myHelper.deleteData("Weighted Pull Up");
                Log.i("FragB1", "Weighted Pull Up Deleted");

            } else {
                Log.i("FragB1", "Weighted Pull Up Doesn't Exist");

            }
            if (checkBox3.isChecked()) {
                myHelper.deleteData("Smith Back Squat");
            } else {
                Log.i("FragB1", "Smith Back Squat Doesn't Exist");

            }
            if (checkBox4.isChecked()) {
                myHelper.deleteData("Back Extension");
            } else {
                Log.i("FragB1", "Back Extension Doesn't Exist");

            }
            //TODO: Repeat the above logic for the other 3 checkboxes.

            Toast.makeText(getActivity(), "Removed selections from Workout Plan.", Toast.LENGTH_SHORT).show();
        }


        else if (v.getId() == R.id.buttonInsert)
        {
            if (checkBox1.isChecked()) {

                if (checkIfAlreadyAdded("Lat Pull Down")) {
                    Log.i("FragB1", "Lat Pull Down Already Added");

                    error.append("\t\t\nLat Pull Down already added to Workout Plan. ");
                } else
                    myHelper.insertData("Lat Pull Down", et1_set.getText().toString(), et1_rep.getText().toString(), "B1");
                Log.i("FragB1", "Lat Pull Down inserted");
                c.close();
            }
            if (checkBox2.isChecked()) {
                if (checkIfAlreadyAdded("Weighted Pull Up")) {
                    Log.i("FragB1", "Weighted Pull Up Already Added");

                    error.append("\t\t\nWeighted Pull Up already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Weighted Pull Up", et2_set.getText().toString(), et2_rep.getText().toString(), "B1");
                    Log.i("FragB1", "Weighted Pull Up inserted");
                    c.close();
                }
            }

            if (checkBox3.isChecked()) {

                if (checkIfAlreadyAdded("Smith Back Squat")) {
                    Log.i("FragB1", "Smith Back Squat Already Added");

                    error.append("\t\t\nSmith Back Squat already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Smith Back Squat", et3_set.getText().toString(), et3_rep.getText().toString(), "B1");
                    Log.i("FragB1", "Smith Back Squat inserted");
                    c.close();
                }

            }
            if (checkBox4.isChecked()) {

                if (checkIfAlreadyAdded("Back Extension")) {
                    Log.i("FragB1", "Back Extension Already Added");

                    error.append("\t\t\nBack Extension already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Back Extension", et4_set.getText().toString(), et4_rep.getText().toString(), "B1");
                    Log.i("FragB1", "Back Extension");
                    c.close();
                }
            }
        }
        //OnUpdate
        else if (v.getId() == R.id.buttonUpdate) {
            if (checkBox1.isChecked()) {

                if (checkIfAlreadyAdded("Lat Pull Down")) {
                    if (et1_set.getText() != null || et1_rep.getText() != null) {
                        myHelper.updateData("Lat Pull Downs", et1_set.getText().toString(), et1_rep.getText().toString());
                    }
                }
            }
            if (checkBox2.isChecked()) {

                if (checkIfAlreadyAdded("Weighted Pull Up")) {
                    if (et2_set.getText() != null || et2_rep.getText() != null) {
                        myHelper.updateData("Weighted Pull Up",  et2_set.getText().toString(), et2_rep.getText().toString());
                    }

                }
            }
            if (checkBox3.isChecked()) {

                if (checkIfAlreadyAdded("Smith Back Squat")) {
                    if (et3_set.getText() != null || et3_rep.getText() != null) {
                        myHelper.updateData("Smith Back Squat",  et3_set.getText().toString(), et3_rep.getText().toString());
                    }
                }
            }
            if (checkBox4.isChecked()) {

                if (checkIfAlreadyAdded("Back Extension")) {
                    if (et4_set.getText() != null || et4_rep.getText() != null) {
                        myHelper.updateData("Back Extension",  et4_set.getText().toString(), et4_rep.getText().toString());
                    }
                }
            }


        }

        else if (v.getId() == R.id.buttonWorkoutPlan) {

            Intent mIntent = new Intent(v.getContext(), WorkoutPlanActivity.class);
            startActivity(mIntent);
            Log.i("Log", "Intent to WorkoutPlan Started");
        }
    }
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