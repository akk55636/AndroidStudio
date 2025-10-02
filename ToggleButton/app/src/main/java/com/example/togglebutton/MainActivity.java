package com.example.togglebutton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ToggleButton togglebutton1;
    TextView textview;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the toggle button and text view
        togglebutton1 = (ToggleButton) findViewById(R.id.buttontoggle);
        textview = (TextView) findViewById(R.id.textView1);
    }

    // Method is called when the toggle button is clicked
    public void onToggleClick(View view) {
        if (togglebutton1.isChecked()) {
            textview.setText("Toggle is ON");
        } else {
            textview.setText("Toggle is OFF");
        }
    }
}