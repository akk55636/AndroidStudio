package com.example.contextmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link objects with their respective IDs from the XML file
        textView = findViewById(R.id.textView);
        layout = findViewById(R.id.main);

        // Register a view for the context menu
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // Set menu header title
        menu.setHeaderTitle("Choose a color");
        // Add menu items
        menu.add(0, v.getId(), 0, "Yellow");
        menu.add(0, v.getId(), 0, "Gray");
        menu.add(0, v.getId(), 0, "Cyan");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String title = item.getTitle().toString();

        switch (title) {
            case "Yellow":
                layout.setBackgroundColor(Color.YELLOW);
                break;
            case "Gray":
                layout.setBackgroundColor(Color.GRAY);
                break;
            case "Cyan":
                layout.setBackgroundColor(Color.CYAN);
                break;
        }
        return true;
    }
}