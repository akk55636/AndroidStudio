package com.example.todolist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button shutdownButton = findViewById(R.id.shutdownButton);
        shutdownButton.setOnClickListener(v -> {
            // Try shutdown (requires root)
            try {
                Process proc = Runtime.getRuntime().exec(new String[]{ "su", "-c", "reboot -p" });
                proc.waitFor();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Shutdown failed. Root required.", Toast.LENGTH_LONG).show();
            }
        });
    }
}