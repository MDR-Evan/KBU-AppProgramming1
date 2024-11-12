package com.example.week10;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Report2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);

        if (savedInstanceState == null) {
            Report2_DialogFragment inputFragment = new Report2_DialogFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, inputFragment)
                    .commit();
        }
    }
}
