package com.cnit355_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainEquip#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainEquip extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainEquip() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainEquip.
     */
    // TODO: Rename and change types and number of parameters
    public static MainEquip newInstance(String param1, String param2) {
        MainEquip fragment = new MainEquip();
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


    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;

    Button button;

   Fragment A1, A2, A3, B1, B2, B3, C1, D1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main_equip, container, false);

        // Accessing views from the layout
        textView1 = view.findViewById(R.id.TextView1);
        textView2 = view.findViewById(R.id.TextView2);
        textView3 = view.findViewById(R.id.TextView3);
        textView4 = view.findViewById(R.id.TextView4);
        textView5 = view.findViewById(R.id.TextView5);
        textView6 = view.findViewById(R.id.TextView6);
        textView7 = view.findViewById(R.id.TextView7);
        textView8 = view.findViewById(R.id.TextView8);
        button = view.findViewById(R.id.button3);

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
        textView6.setOnClickListener(this);
        textView7.setOnClickListener(this);
        textView8.setOnClickListener(this);
        button.setOnClickListener(this);


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button3)
        {
           getActivity().finish();

        }
        else if (v.getId() == R.id.TextView1)
        {
            A1 = new FragmentA1();


            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.mainfragmentview, A1);
            ft.addToBackStack(null).commit();
        }
        else if (v.getId() == R.id.TextView2) {
        // Open Fragment A2
            A2 = new FragmentA2();


            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.mainfragmentview, A2);
            ft.addToBackStack(null).commit();
        }
        else if (v.getId() == R.id.TextView3) {
            // Open Fragment A3
            A3 = new FragmentA3();


            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.mainfragmentview, A3);
            ft.addToBackStack(null).commit();
        }
        else if (v.getId() == R.id.TextView4) {
            // Open Fragment B1
            B1 = new FragmentB1();


            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.mainfragmentview, B1);
            ft.addToBackStack(null).commit();
        }
        else if (v.getId() == R.id.TextView5) {
            // Open Fragment B1
            B2 = new FragmentB2();


            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.mainfragmentview, B2);
            ft.addToBackStack(null).commit();
        }
        else if (v.getId() == R.id.TextView6) {
            // Open Fragment B3
            B3 = new FragmentB3();


            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.mainfragmentview, B3);
            ft.addToBackStack(null).commit();
        }
        else if (v.getId() == R.id.TextView7) {
            // Open Fragment C1
            C1 = new FragmentC1();


            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.mainfragmentview, C1);
            ft.addToBackStack(null).commit();
        }
        else if (v.getId() == R.id.TextView8) {
            // Open Fragment D1
            D1 = new FragmentD1();


            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.mainfragmentview, D1);
            ft.addToBackStack(null).commit();
        }

    }
}