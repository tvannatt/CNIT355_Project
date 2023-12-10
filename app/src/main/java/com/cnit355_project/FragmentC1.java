package com.cnit355_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class FragmentC1 extends Fragment implements View.OnClickListener {

    public FragmentC1() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    Button buttonBack, buttonCreate, buttonAll, buttonNone;
    View view;
    ImageView im1, im2, im3, im4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c1, container, false);

        // Replace these IDs with the actual IDs used in your XML layout
        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox4 = view.findViewById(R.id.checkBox4);
        buttonBack = view.findViewById(R.id.buttonBack1);

        // Set click listeners for the checkboxes
        checkBox1.setOnClickListener(this);
        checkBox2.setOnClickListener(this);
        checkBox3.setOnClickListener(this);
        checkBox4.setOnClickListener(this);

        buttonBack.setOnClickListener(this);




        return view;
    }


    private void handleCheckboxClick(boolean isChecked) {
        // Handle the checkbox click event
        if (isChecked) {
            // The checkbox is checked, implement your logic here
        } else {
            // The checkbox is unchecked, implement your logic here
        }
    }


    @Override
    public void onClick(View v)
    {

        if (v.getId() == R.id.checkBox1)
        {
            handleCheckboxClick(checkBox1.isChecked());
        }
        else if (v.getId() == R.id.checkBox2)
        {
            handleCheckboxClick(checkBox1.isChecked());
        }
        else if (v.getId() == R.id.checkBox3)
        {
            handleCheckboxClick(checkBox1.isChecked());
        }
        else if (v.getId() == R.id.checkBox4)
        {
            handleCheckboxClick(checkBox1.isChecked());
        }
        else if (v.getId() == R.id.buttonBack1)
        {
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        }


    }


}