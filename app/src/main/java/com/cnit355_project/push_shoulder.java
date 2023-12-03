package com.cnit355_project;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


public class push_shoulder extends Equipment_MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.push_chest);

        // Replace these IDs with the actual IDs used in your XML layout
        ImageView imageView1 = findViewById(R.id.imageView1);
        CheckBox checkBox1 = findViewById(R.id.checkBox1);

        ImageView imageView2 = findViewById(R.id.imageView2);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);

        // Set click listeners for the checkboxes
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckboxClick(checkBox1.isChecked());
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckboxClick(checkBox2.isChecked());
            }
        });

        // Add more click listeners for additional checkboxes if needed
    }
    public void onSelectAllClick(View view) {
        LinearLayout imageContainer = findViewById(R.id.imageContainer);

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

    public void onUnselectAllClick(View view) {
        LinearLayout imageContainer = findViewById(R.id.imageContainer);

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

    public void onCreateClick(View view) {
        // Handle CREATE button click
    }

    public void onBackClick(View view) {
        Intent intent = new Intent(this, Equipment_MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void handleCheckboxClick(boolean isChecked) {
        // Handle the checkbox click event
        if (isChecked) {
            // The checkbox is checked, implement your logic here
        } else {
            // The checkbox is unchecked, implement your logic here
        }
    }
}