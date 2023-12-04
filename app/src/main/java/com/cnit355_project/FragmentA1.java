package com.cnit355_project;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
    Button buttonBack, buttonRemove, buttonInsert;
    Cursor c;
    SqlDBHelper myHelper;
    SQLiteDatabase db;
    ImageView imageView1;

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
        error = view.findViewById(R.id.textError);

        // Set click listeners for the checkboxes
        checkBox1.setOnClickListener(this);
        checkBox2.setOnClickListener(this);
        checkBox3.setOnClickListener(this);
        checkBox4.setOnClickListener(this);

        buttonBack.setOnClickListener(this);
        buttonInsert.setOnClickListener(this);
        buttonRemove.setOnClickListener(this);


        buttonBack = (Button) view.findViewById(R.id.button);
        imageView1 = view.findViewById(R.id.imageView1);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.id.imageView1, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;
        return view;
    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonBack1) {
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        }

        // TODO: Replace the "create" button with a "remove" button since the database gets created automatically. Remove button will remove exercises from workoutplan.
        else if (v.getId() == R.id.buttonRemove) {
            Log.i("FragA1", "BenchPress Deleted");
            if (checkBox1.isChecked()) {
                myHelper.deleteData("Bench Press");
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
                } else
                    myHelper.insertData("Bench Press", "3", "10", "A1");
                Log.i("FragA1", "BenchPress inserted");


                c.close();


            }
            if (checkBox2.isChecked()) {
                if (checkIfAlreadyAdded("Cable Chest Fly")) {
                    Log.i("FragA1", "Cable Chest Fly Already Added");

                    error.append("\t\t\nCable Chest Fly already added to Workout Plan.");
                } else
                    myHelper.insertData("Cable Chest Fly", "3", "12", "A1");
                Log.i("FragA1", "Cable Chest Fly Inserted");

                c.close();
            }
            if (checkBox3.isChecked()) {
                if (checkIfAlreadyAdded("Machine Chest Press")) {
                    error.append("\t\t\nMachine Chest Press already added to Workout Plan.");

                } else
                    myHelper.insertData("Machine Chest Press", "3", "12", "A1");

                c.close();
            }
            if (checkBox4.isChecked()) {
                if (checkIfAlreadyAdded("Chest Dip")) {
                    error.append("\t\t\nChest Dip already added to Workout Plan.");
                    Log.i("FragA1", "Chest Dip already added to Workout Plan");

                } else
                    myHelper.insertData("Chest Dip", "3", "12", "A1");
                Log.i("FragA1", "Chest Dip inserted");

                c.close();
            }

            Equipment_MainActivity activity = (Equipment_MainActivity) getActivity();
            activity.onFragmentChanged(8);
            Toast.makeText(getActivity(), "Workout Plan Updated", Toast.LENGTH_SHORT).show();

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
