package com.cnit355_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentB3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentB3 extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentB3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentB3.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentB3 newInstance(String param1, String param2) {
        FragmentB3 fragment = new FragmentB3();
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


    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    Button buttonBack, buttonCreate, buttonAll, buttonNone;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_b3, container, false);

        // Replace these IDs with the actual IDs used in your XML layout
        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox4 = view.findViewById(R.id.checkBox4);
        buttonBack = view.findViewById(R.id.buttonBack1);
        buttonCreate = view.findViewById(R.id.buttonCreate1);
        buttonAll = view.findViewById(R.id.buttonAll1);
        buttonNone = view.findViewById(R.id.buttonNone1);

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
        else if (v.getId() == R.id.buttonCreate1)
        {

        }
        else if (v.getId() == R.id.buttonNone1)
        {
            LinearLayout imageContainer = view.findViewById(R.id.imageContainer);

            for (int i = 0; i < imageContainer.getChildCount(); i++) {
                View child = imageContainer.getChildAt(i);
                if (child instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) child;
                    for (int j = 0; j < linearLayout.getChildCount(); j++) {
                        View innerChild = linearLayout.getChildAt(j);
                        if (innerChild instanceof CheckBox) {
                            CheckBox checkBox = (CheckBox) innerChild;
                            checkBox.setChecked(false);
                        }
                    }
                }
            }
        }
        else if (v.getId() == R.id.buttonAll1)
        {
            LinearLayout imageContainer = view.findViewById(R.id.imageContainer);

            for (int i = 0; i < imageContainer.getChildCount(); i++) {
                View child = imageContainer.getChildAt(i);
                if (child instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) child;
                    for (int j = 0; j < linearLayout.getChildCount(); j++) {
                        View innerChild = linearLayout.getChildAt(j);
                        if (innerChild instanceof CheckBox) {
                            CheckBox checkBox = (CheckBox) innerChild;
                            checkBox.setChecked(true);
                        }
                    }
                }
            }
        }

    }
}