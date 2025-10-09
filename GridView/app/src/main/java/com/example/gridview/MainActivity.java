package com.example.gridview;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid_view);
        ArrayList<Model> list = new ArrayList<>();

        list.add(new Model("DSA", R.drawable.gfg_logo));
        list.add(new Model("JAVA", R.drawable.gfg_logo));
        list.add(new Model("C++", R.drawable.gfg_logo));
        list.add(new Model("Python", R.drawable.gfg_logo));
        list.add(new Model("Javascript", R.drawable.gfg_logo));
        list.add(new Model("DSA", R.drawable.gfg_logo));

        GridViewAdapter adapter = new GridViewAdapter(this, list);
        gridView.setAdapter(adapter);
    }
}