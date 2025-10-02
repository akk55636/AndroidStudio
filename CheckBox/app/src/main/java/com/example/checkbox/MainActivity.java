package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox ch,ch1,ch2,ch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch=findViewById(R.id.checkBox);
        ch1=findViewById(R.id.checkBox2);
        ch2=findViewById(R.id.checkBox3);
        ch3=findViewById(R.id.checkBox4);
    }

    public void Check(View v){
        String msg="Selected Items are";

        // Checking the selection
        if(ch.isChecked())
            msg=msg+" [Painting]";
        if(ch1.isChecked())
            msg=msg+", [Reading]";
        if(ch2.isChecked())
            msg=msg+", [Singing]";
        if(ch3.isChecked())
            msg=msg+", [Cooking]";

        // Executing the Toast
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();

        // Clearing all the selection
        ch.setChecked(false);
        ch1.setChecked(false);
        ch2.setChecked(false);
        ch3.setChecked(false);
    }
}