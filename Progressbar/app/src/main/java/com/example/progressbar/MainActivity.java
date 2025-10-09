package com.example.progressbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int progress = 0;
    Button buttonIncrement;
    Button buttonDecrement;
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDecrement = findViewById(R.id.button_decr);
        buttonIncrement = findViewById(R.id.button_incr);
        progressBar = findViewById(R.id.progress_bar);
        textView = findViewById(R.id.text_view_progress);

        // when clicked on buttonIncrement progress is increased by 10%
        buttonIncrement.setOnClickListener(v -> {
            // if progress is less than or equal
            // to 90% then only it can be increased
            progress += 10;
            updateProgressBar();
        });

        // when clicked on buttonIncrement progress is decreased by 10%
        buttonDecrement.setOnClickListener(v -> {
            // If progress is greater than
            // 10% then only it can be decreased
            progress -= 10;
            updateProgressBar();
        });
    }

    // updateProgressBar() method sets
    // the progress of ProgressBar in text
    private void updateProgressBar() {
        progressBar.setProgress(progress);
        textView.setText(String.valueOf(progress));
    }
}