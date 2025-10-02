package com.example.radiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Define the object for Radio Group,
    // Submit andClear buttons
    private RadioGroup radioGroup;
    Button submit, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        clear = findViewById(R.id.clear);
        radioGroup = findViewById(R.id.groupradio);

        // Uncheck or reset theradio buttons initially
        radioGroup.clearCheck();

        // Add the Listener to the RadioGroup
        radioGroup.setOnCheckedChangeListener(
                (group, checkedId) -> {
                    // Get the selected Radio Button
                    RadioButton radioButton = group.findViewById(checkedId);
                    // You can add logic here to handle the selected radio button
                });

        submit.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(MainActivity.this, "No answer has been selected",
                        Toast.LENGTH_SHORT).show();
            } else {
                RadioButton radioButton = findViewById(selectedId);
                // Now display the value of selected item
                // by the Toast message
                Toast.makeText(MainActivity.this, radioButton.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Add the Listener to the Submit Button
        clear.setOnClickListener(v -> {
            radioGroup.clearCheck();
        });
    }
}