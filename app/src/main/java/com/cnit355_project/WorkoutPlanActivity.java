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
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentA1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentA1 extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentA1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentA1.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentA1 newInstance(String param1, String param2) {
        FragmentA1 fragment = new FragmentA1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    TextView error;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    Button buttonBack, buttonRemove, buttonInsert, buttonUpdate, buttonWorkoutPlan;
    Cursor c;
    SqlDBHelper myHelper;
    SQLiteDatabase db;
    ImageView imageView1, imageView2, imageView3, imageView4;

    EditText et1_set, et1_rep, et2_set, et2_rep, et3_set,  et3_rep, et4_set, et4_rep;
    Intent mIntent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_a1, container, false);

        myHelper = new SqlDBHelper(getActivity());

        // Replace these IDs with the actual IDs used in your XML layout
        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox4 = view.findViewById(R.id.checkBox4);
        buttonBack = view.findViewById(R.id.buttonBack1);
        buttonRemove = view.findViewById(R.id.buttonRemove);
        buttonInsert = view.findViewById(R.id.buttonInsert);
        buttonUpdate  = view.findViewById(R.id.buttonUpdate);
        buttonWorkoutPlan=view.findViewById(R.id.buttonWorkoutPlan);
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
        buttonRemove.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);
        buttonWorkoutPlan.setOnClickListener(this);

        et1_rep.setOnClickListener(this);
        et1_set.setOnClickListener(this);

        et2_set.setOnClickListener(this);
        et2_rep.setOnClickListener(this);
        et3_rep.setOnClickListener(this);
        et3_set.setOnClickListener(this);

        et4_rep.setOnClickListener(this);
        et4_set.setOnClickListener(this);
        buttonBack = (Button) view.findViewById(R.id.button);
        imageView1 = view.findViewById(R.id.imageView1);
        imageView2 = view.findViewById(R.id.imageView2);
        imageView3 = view.findViewById(R.id.imageView3);
        imageView4 = view.findViewById(R.id.imageView4);

        Glide.with(getActivity()).load(R.drawable.bench_press).into(imageView1);
        Glide.with(getActivity()).load(R.drawable.cablechestfly).into(imageView2);
        Glide.with(getActivity()).load(R.drawable.machine_chest_press).into(imageView3);
        Glide.with(getActivity()).load(R.drawable.chest_dip).into(imageView4);

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
                myHelper.deleteData("Bench Press");
                Log.i("FragA1", "BenchPress Deleted");

            } else {
                Log.i("FragA1", "BenchPress Doesn't Exist");

            }
            if (checkBox2.isChecked()) {
                myHelper.deleteData("Cable Chest Fly");
            } else {
                Log.i("FragA1", "Cable Chest Fly Doesn't Exist");

            }

            if (checkBox3.isChecked()) {
                myHelper.deleteData("Machine Chest Press");
            } else {
                Log.i("FragA1", "Machine Chest Press Doesn't Exist");

            }
            if (checkBox4.isChecked()) {
                myHelper.deleteData("Chest Dip");
            } else {
                Log.i("FragA1", "Chest Dip Doesn't Exist");

            }
            //TODO: Repeat the above logic for the other 3 checkboxes.

            Toast.makeText(getActivity(), "Removed selections from Workout Plan.", Toast.LENGTH_SHORT).show();
        }

        // Button to add select exercises to plan (workoutplan activity itself should allow further editing options).
        else if (v.getId() == R.id.buttonInsert) {
            if (checkBox1.isChecked()) {

                if (checkIfAlreadyAdded("Bench Press")) {
                    Log.i("FragA1", "BenchPress Already Added");

                    error.append("\t\t\nBench Press already added to Workout Plan. ");
                } else {
                    myHelper.insertData("Bench Press", et1_set.getText().toString(), et1_rep.getText().toString(), "A1");
                    Log.i("FragA1", "BenchPress inserted");


                    c.close();
                }

            }
            if (checkBox2.isChecked()) {
                if (checkIfAlreadyAdded("Cable Chest Fly")) {
                    Log.i("FragA1", "Cable Chest Fly Already Added");

                    error.append("\t\t\nCable Chest Fly already added to Workout Plan.");
                } else {
                    myHelper.insertData("Cable Chest Fly", et2_set.getText().toString(), et2_rep.getText().toString(), "A1");
                    Log.i("FragA1", "Cable Chest Fly Inserted");

                    c.close();
                }
            }
            if (checkBox3.isChecked()) {
                if (checkIfAlreadyAdded("Machine Chest Press")) {
                    error.append("\t\t\nMachine Chest Press already added to Workout Plan.");

                } else {
                    myHelper.insertData("Machine Chest Press", et3_set.getText().toString(), et3_rep.getText().toString(), "A1");

                    c.close();
                }
            }
            if (checkBox4.isChecked()) {
                if (checkIfAlreadyAdded("Chest Dip")) {
                    error.append("\t\t\nChest Dip already added to Workout Plan.");
                    Log.i("FragA1", "Chest Dip already added to Workout Plan");

                } else
                    myHelper.insertData("Chest Dip", et4_set.getText().toString(), et4_rep.getText().toString(), "A1");
                Log.i("FragA1", "Chest Dip inserted");

                c.close();
            }

            // TODO: Uncomment if intentional
          //  getActivity().getSupportFragmentManager().popBackStackImmediate();
            Toast.makeText(getActivity(), "Workout Plan Updated", Toast.LENGTH_SHORT).show();

        }

        //OnUpdate
        else if (v.getId() == R.id.buttonUpdate) {
            if (checkBox1.isChecked()) {

                if (checkIfAlreadyAdded("Bench Press")) {
                    if (et1_set.getText() != null || et1_rep.getText() != null) {
                        myHelper.updateData("Bench Press", et1_set.getText().toString(), et1_rep.getText().toString());
                    }
                }
            }
            else if (checkBox2.isChecked()) {

                if (checkIfAlreadyAdded("Cable Chest Fly")) {
                    if (et2_set.getText() != null || et2_rep.getText() != null) {
                        myHelper.updateData("Cable Chest Fly",  et2_set.getText().toString(), et2_rep.getText().toString());
                    }

                }
            } else if (checkBox3.isChecked()) {

                if (checkIfAlreadyAdded("Machine Chest Press")) {
                    if (et3_set.getText() != null || et3_rep.getText() != null) {
                        myHelper.updateData("Machine Chest Press",  et3_set.getText().toString(), et3_rep.getText().toString());
                    }
                }
            }
            else if (checkBox4.isChecked()) {

                if (checkIfAlreadyAdded("Chest Dip")) {
                    if (et4_set.getText() != null || et4_rep.getText() != null) {
                        myHelper.updateData("Chest Dip",  et4_set.getText().toString(), et4_rep.getText().toString());
                    }
                }
            }
        }


        else if (v.getId() == R.id.buttonWorkoutPlan) {

             mIntent = new Intent(v.getContext(), WorkoutPlanActivity.class);
            startActivity(mIntent);
            Log.i("Log", "Intent to WorkoutPlan Started");
        }

    }

    // METHOD TO CHECK IF ITEM ALREADY ADDED

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

