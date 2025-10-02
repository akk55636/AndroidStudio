package com.example.imagebutton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);

        // Set a click listener on image button
        imageButton.setOnClickListener(v -> {
            // Creating a toast to display the message
            Toast.makeText(MainActivity.this, "Welcome to GeeksforGeeks", Toast.LENGTH_SHORT).show();

            // Define the URL
            String url = "https://www.coolbe.fi/en/products/66bac9b4ed782301a2b38582?currency=EUR&variant_id=66bac9b4ed7823e5a2b38585&utm_productid=66bac9b4ed782301a2b38582&gsAttrs=eyJyZWdpb24iOiJGSSJ9&utm_source=bing&utm_medium=cpc&utm_campaign=569715835&utm_term=cid-569715835%2Cagi-1179777824451783%2Cadi-%2Ctid-pla-4577335635203175%2Cdev-c%2Creg-65%2Cmd-66bac9b4ed7823e5a2b38585&msclkid=2e802b5eeb8c12949a524380f6eabfc4&utm_content=g0v0";

            // Creating an explicit intent to open the link stored in variable url
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));

            // Start the activity to handle the intent
            startActivity(intent);
        });
    }
}