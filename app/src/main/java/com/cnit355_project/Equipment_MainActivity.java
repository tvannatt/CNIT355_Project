package com.cnit355_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Equipment_MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_main);

        // Accessing views from the layout
        TextView textView1 = findViewById(R.id.TextView1);
        TextView textView2 = findViewById(R.id.TextView2);
        ImageView imageView = findViewById(R.id.imageView);
        ScrollView scrollView = findViewById(R.id.ScrollView);
        Button button = findViewById(R.id.button3);

        // Set OnClickListener for TextView1
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click on TextView1
                startActivity(new Intent(Equipment_MainActivity.this, push_chest.class));
            }
        });

        // Set OnClickListener for TextView2
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click on TextView2
                startActivity(new Intent(Equipment_MainActivity.this, push_shoulder.class));
            }
        });

        // Rest of your code...

        // Set onClickListener for the button (assuming you have the 'onClick' method)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click on the button
                // You can add code here to perform any action when the button is clicked
            }
        });
    }}
