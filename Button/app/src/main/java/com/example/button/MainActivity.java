package com.example.button;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);

        if (button != null) {
            button.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View t) {
                    Toast.makeText((Context)MainActivity.this, R.string.message, Toast.LENGTH_LONG).show();
                }
            }));
        }
    }
}