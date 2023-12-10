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

public class FragmentC1 extends Fragment implements View.OnClickListener {

    public FragmentC1() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    SqlDBHelper myHelper;
    SQLiteDatabase db;
    Cursor c;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    Button buttonBack, buttonRemove,buttonInsert, buttonUpdate, buttonWorkoutPlan;
    View view;
    EditText et1_set, et1_rep, et2_set, et2_rep, et3_set,  et3_rep, et4_set, et4_rep;

    TextView error;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c1, container, false);

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

        et1_set= view.findViewById(R.id.editText1);

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
        buttonRemove.setOnClickListener(this);
        buttonInsert.setOnClickListener(this);
        buttonWorkoutPlan.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);

        ImageView imageView1= (ImageView) view.findViewById(R.id.imageView1);
        ImageView imageView2= (ImageView) view.findViewById(R.id.imageView2);
        ImageView imageView3= (ImageView) view.findViewById(R.id.imageView3);
        ImageView imageView4= (ImageView) view.findViewById(R.id.imageView4);

        Glide.with(getActivity()).load(R.drawable.barbellsquatbox).into(imageView1);
        Glide.with(getActivity()).load(R.drawable.exerciseballlegcurl).into(imageView2);
        Glide.with(getActivity()).load(R.drawable.singlelegpress).into(imageView3);
        Glide.with(getActivity()).load(R.drawable.tireflip).into(imageView4);



        return view;
    }




    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonBack1) {
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        }

         else if (v.getId() == R.id.buttonRemove) {
            if (checkBox1.isChecked()) {
                myHelper.deleteData("Barbell Squat Box");
                Log.i("FragC1", "Barbell Squat Box Deleted");
            } else {
                Log.i("FragC1", "Barbell Squat Box Doesn't Exist");

            }
            if (checkBox2.isChecked()) {
                myHelper.deleteData("Exercise Ball Leq Curl");
                Log.i("FragC1", "Exercise Ball Leq Curl Deleted");

            } else {
                Log.i("FragC1", "Exercise Ball Leq Curl Doesn't Exist");

            }
            if (checkBox3.isChecked()) {
                myHelper.deleteData("Single Leg Press");
            } else {
                Log.i("FragC1", "Single Leg Press Doesn't Exist");

            }
            if (checkBox4.isChecked()) {
                myHelper.deleteData("Tire Flip");
            } else {
                Log.i("FragC1", "Tire Flip Doesn't Exist");

            }

            Toast.makeText(getActivity(), "Removed selections from Workout Plan.", Toast.LENGTH_SHORT).show();
        }


        else if (v.getId() == R.id.buttonInsert)
        {
            if (checkBox1.isChecked()) {

                if (checkIfAlreadyAdded("Barbell Squat Box")) {
                    Log.i("FragC1", "Barbell Squat Box Already Added");

                    error.append("\t\t\nBarbell Squat Box already added to Workout Plan. ");
                } else
                    myHelper.insertData("Barbell Squat Box", et1_set.getText().toString(), et1_rep.getText().toString(), "C1");
                Log.i("FragC1", "Barbell Squat Box inserted");
                c.close();
            }
            if (checkBox2.isChecked()) {
                if (checkIfAlreadyAdded("Exercise Ball Leq Curl")) {
                    Log.i("FragC1", "Exercise Ball Leq Curl Already Added");

                    error.append("\t\t\nExercise Ball Leq Curl already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Exercise Ball Leq Curl", et2_set.getText().toString(), et2_rep.getText().toString(), "C1");
                    Log.i("FragC1", "Exercise Ball Leq Curl inserted");

                }
                c.close();
            }

            if (checkBox3.isChecked()) {

                if (checkIfAlreadyAdded("Single Leg Press")) {
                    Log.i("FragC1", "Single Leg Press Already Added");

                    error.append("\t\t\nSingle Leg Press already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Single Leg Press", et3_set.getText().toString(), et3_rep.getText().toString(), "C1");
                    Log.i("FragC1", "Single Leg Press inserted");

                }
                c.close();

            }
            if (checkBox4.isChecked()) {

                if (checkIfAlreadyAdded("Tire Flip")) {
                    Log.i("FragC1", "Tire Flip Already Added");

                    error.append("\t\t\nTire Flip already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Tire Flip", et4_set.getText().toString(), et4_rep.getText().toString(), "C1");
                    Log.i("FragC1", "Tire Flip");

                }
                c.close();
            }
        }
        //OnUpdate
        else if (v.getId() == R.id.buttonUpdate) {
            if (checkBox1.isChecked()) {

                if (checkIfAlreadyAdded("Barbell Squat Box")) {
                    if (et1_set.getText() != null || et1_rep.getText() != null) {
                        myHelper.updateData("Barbell Squat Box", et1_set.getText().toString(), et1_rep.getText().toString());
                    }
                }
            }
             if (checkBox2.isChecked()) {

                if (checkIfAlreadyAdded("Exercise Ball Leq Curl")) {
                    if (et2_set.getText() != null || et2_rep.getText() != null) {
                        myHelper.updateData("Exercise Ball Leq Curl",  et2_set.getText().toString(), et2_rep.getText().toString());
                    }

                }
            }  if (checkBox3.isChecked()) {

                if (checkIfAlreadyAdded("Single Leg Press")) {
                    if (et3_set.getText() != null || et3_rep.getText() != null) {
                        myHelper.updateData("Single Leg Press",  et3_set.getText().toString(), et3_rep.getText().toString());
                    }
                }
            }
            if (checkBox4.isChecked()) {

                if (checkIfAlreadyAdded("Tire Flip")) {
                    if (et4_set.getText() != null || et4_rep.getText() != null) {
                        myHelper.updateData("Tire Flip",  et4_set.getText().toString(), et4_rep.getText().toString());
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