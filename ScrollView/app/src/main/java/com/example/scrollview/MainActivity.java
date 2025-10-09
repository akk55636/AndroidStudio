package com.example.scrollview;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView image1, image2, image3, image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure this matches your XML file name

        // Initialize ImageViews
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);

        // Optional: Set click listeners or manipulate images
        image1.setOnClickListener(v -> {
            // Example action
            image1.setAlpha(0.5f);
        });

        image2.setOnClickListener(v -> {
            // Reset alpha
            image1.setAlpha(1.0f);
        });
    }
}
