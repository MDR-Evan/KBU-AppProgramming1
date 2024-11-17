package com.example.week11;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

public class Report1 extends AppCompatActivity {
    LinearLayout layout1, layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.item1);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        layout1 = findViewById(R.id.first);
        layout2 = findViewById(R.id.second);

        boolean isChecked = !item.isChecked();
        item.setChecked(isChecked);

        if (isChecked) {
            layout1.setVisibility(View.INVISIBLE);
            layout2.setVisibility(View.VISIBLE);
        } else {
            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.INVISIBLE);
        }
        return true;
    }
}