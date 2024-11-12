package com.example.week10;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Report1 extends AppCompatActivity implements Report1_ListFragment.OnPlanetSelectedListener {
    private TextView selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        selectedItem = findViewById(R.id.selected_item);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Report1_ListFragment())
                    .commit();
        }
    }

    @Override
    public void onPlanetSelected(String planet) {
        selectedItem.setText(planet);
    }
}
